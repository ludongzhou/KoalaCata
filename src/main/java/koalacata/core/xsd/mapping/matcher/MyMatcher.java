package koalacata.core.xsd.mapping.matcher;

import koalacata.core.xsd.utility.StringUtility;
import koalacata.core.xsd.mapping.matcher.entry.SimEntry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.*;

/**
 * Created by zhouludong on 2017/4/4.
 */
public class MyMatcher extends AbstractMatcher{
    private Logger logger = LogManager.getLogger();

    private ArrayList<String> results;
    private HashMap<String, TreeSet<SimEntry>> rawResults;
    private double simThreshold = 0.3;

    public MyMatcher(File source, File target) { // with default dict file
        this(source, target, new File("src/main/resources/thesaurus.dict"));
    }

    public MyMatcher(File source, File target, File dictFile) {
        this.sourceFile = source;
        this.targetFile = target;
        dict = new HashMap<>();
        rawResults = new HashMap<>();
        results = new ArrayList<>();

        loadDict(dictFile);
    }

    public MyMatcher() {
    }

    private void loadDict(File dictFile) {
        if (dictFile.exists()){
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(dictFile)));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.toLowerCase().split(",");
                    dict.put(words[0], words[1]);
                    dict.put(words[1], words[0]);
                }
                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            logger.error("dict file not found");
        }
    }

    @Override
    public void match() {
        ArrayList<String> sourceElements = getElements(this.sourceFile);
        ArrayList<String> targetElements = getElements(this.targetFile);

        for (String sourceElement: sourceElements) {
            for (String targetElement: targetElements) {
                double similarity = calcSimilarity(sourceElement, targetElement);
                addSubResult(sourceElement, targetElement, similarity);
            }
        }

        storeResult();
    }

    private void storeResult() {
        for (String sourceElement: rawResults.keySet()) {
            SimEntry headSimEntry = rawResults.get(sourceElement).last();
            if (headSimEntry.similarity >= simThreshold) {
                String subResult = String.format("- %s <-> %s: %f", sourceElement, headSimEntry.element, headSimEntry.similarity);
                results.add(subResult);
            }
        }
    }

    private void addSubResult(String sourceElement, String targetElement, double similarity) {
        SimEntry simEntry = new SimEntry();
        simEntry.element = targetElement;
        simEntry.similarity = similarity;

        if (containLayer(sourceElement) == 0 && containLayer(targetElement) != 1) {
            simEntry.similarity = 0;
        }

        if (rawResults.containsKey(sourceElement)) {
            rawResults.get(sourceElement).add(simEntry);
        }
        else {
            TComparator tc = new TComparator();
            TreeSet<SimEntry> treeSet = new TreeSet<>(tc);
            treeSet.add(simEntry);
            rawResults.put(sourceElement, treeSet);
        }
    }

    private int containLayer(String element) {
        int rtn = 0;

        if (element.toLowerCase().contains("program")) {
            rtn = 1;
        }
        else if (element.toLowerCase().contains("sequence")) {
            rtn = 2;
        }
        else if (element.toLowerCase().contains("scene")) {
            rtn = 3;
        }
        else if (element.toLowerCase().contains("shot")) {
            rtn = 4;
        }

        return rtn;
    }

    private double calcSimilarity(String sourceElement, String targetElement) {
        String[] sourceWords = sourceElement.toLowerCase().split("\\.");
        String[] targetWords = targetElement.toLowerCase().split("\\.");
        HashSet<String> uniqueWords = new HashSet<>();
        boolean lastMatch = false;

        uniqueWords.addAll(new ArrayList<>(Arrays.asList(sourceWords)));
        for (String targetWord: targetWords) {
            if (uniqueWords.contains(targetWord)
                    || (dict != null && dict.containsKey(targetWord) && uniqueWords.contains(dict.get(targetWord)))) {
                continue;
            }
            uniqueWords.add(targetWord);
        }

        if (wordMatch(sourceWords[sourceWords.length - 1], targetWords[targetWords.length - 1])) {
            lastMatch = true;
        }

        int editDistance = StringUtility.editDistDP(sourceElement, targetElement, sourceElement.length(), targetElement.length());
        int maxDistance = Math.max(sourceElement.length(), targetElement.length());
        int sourceLen = sourceWords.length, targetLen = targetWords.length, uniqueLen = uniqueWords.size();

        // TODO. words in different position should have different match weight in similarity calculation.
        // The latter, the bigger. For instance: 1. a.b.c.d; 2.b.c.d;
        double wordsSim = (sourceLen + targetLen - uniqueLen) * 1.0 / (sourceLen + targetLen);
        double editSim = (maxDistance - editDistance) * 1.0 / maxDistance;
        return 0.4 * wordsSim + 0.4 * editSim + 0.2 * (lastMatch? 1:0);
    }

    private boolean wordMatch(String sourceWord, String targetWord) {
        if (sourceWord.equals(targetWord) || sourceWord.equals(dict.get(targetWord))) {
            return true;
        }
        else {
            return false;
        }
    }

    private ArrayList<String> getElements(File file) {
        ArrayList<String> elements;
        Element root = getDocRoot(file);
        elements = inorderTree(root, new ArrayList<String>());
        return elements;
    }

    private Element getDocRoot(File file) {
        Document document = null;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            document.getDocumentElement().normalize();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        if (document != null) {
            return document.getDocumentElement();
        }
        else {
            return null;
        }
    }

    private ArrayList<String> inorderTree(Element root, ArrayList<String> ancestors) {
        ArrayList<String> elements = new ArrayList<String>();

        if (root.getNodeType() == Element.ELEMENT_NODE && root.getTagName().endsWith("element")) {
            ancestors.add(root.getAttribute("name"));
            elements.add(combinePath(ancestors));
        }

        NodeList children = root.getChildNodes();
        for (int i = 0; i< children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element)node;
                elements = combineElements(elements, inorderTree(child, ancestors));
            }
        }
        if (!ancestors.isEmpty() && root.getNodeType() == Element.ELEMENT_NODE && root.getTagName().endsWith("element")) {
            ancestors.remove(ancestors.size() - 1);
        }
        return elements;
    }

    private ArrayList<String> combineElements(ArrayList<String> arrayList, ArrayList<String> arrayList1) {
        arrayList.addAll(arrayList1);
        return arrayList;
    }

    private String combinePath(ArrayList<String> ancestors) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ancestor : ancestors)
        {
            stringBuilder.append(ancestor);
            stringBuilder.append(".");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }


    @Override
    public void match(String sourcePath, String targetPath) {
        this.sourceFile = new File(sourcePath);
        this.targetFile = new File(targetPath);
        this.dict = new HashMap<>();
        rawResults = new HashMap<>();
        results = new ArrayList<>();
        this.loadDict(new File("src/main/resources/thesaurus.dict"));
        this.match();
    }

    @Override
    public String getCorrespondence() {
        StringBuilder sb = new StringBuilder();
        for (String s: results) {
            sb.append(s + "\n");
        }
        return sb.toString();
    }

    class TComparator implements Comparator<SimEntry> {

        @Override
        public int compare(SimEntry simEntry0, SimEntry simEntry1) {
            HashSet<String> sourceWords = new HashSet<>();

            if (simEntry0.similarity > simEntry1.similarity) {
                return 1;
            }
            else if (simEntry0.similarity == simEntry1.similarity) {
                return 0;
            }
            else {
                return -1;
            }
        }
    }
}

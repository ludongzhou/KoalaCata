package koalacata.core.xsd.mapping.matcher;

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
    private ArrayList<String> results;
    private HashMap<String, PriorityQueue<Entry>> rawResults;
    private HashMap<String, String> dict;
    private double simThreshold = 0.2;

    public MyMatcher(File source, File target, File dictFile) {
        this.sourceFile = source;
        this.targetFile = target;
        dict = new HashMap<>();
        rawResults = new HashMap<>();
        results = new ArrayList<>();

        loadDict(dictFile);
    }

    private void loadDict(File dictFile) {
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

    @Override
    public void match() {
        ArrayList<String> sourceElements = getElements(this.sourceFile);
        ArrayList<String> targetElements = getElements(this.targetFile);

        System.out.println("1");
        for (String sourceElement: sourceElements) {
            for (String targetElement: targetElements) {
                double similarity = calcSimilarity(sourceElement, targetElement);
                addSubResult(sourceElement, targetElement, similarity);
            }
        }
        System.out.println("2");
        storeResult();
    }

    private void storeResult() {
        for (String sourceElement: rawResults.keySet()) {
            Entry headEntry = rawResults.get(sourceElement).peek();
            if (headEntry.similarity >= simThreshold) {
                String subResult = String.format("- %s <-> %s: %f", sourceElement, headEntry.element, headEntry.similarity);
                results.add(subResult);
            }
        }
    }

    private void addSubResult(String sourceElement, String targetElement, double similarity) {
        Entry entry = new Entry();
        entry.element = targetElement;
        entry.similarity = similarity;
        if (rawResults.containsKey(sourceElement)) {
            rawResults.get(sourceElement).add(entry);
        }
        else {
            TComparator tc = new TComparator();
            PriorityQueue<Entry> priorityQueue = new PriorityQueue<>(2, tc);
            priorityQueue.add(entry);
            rawResults.put(sourceElement, priorityQueue);
        }
    }

    private double calcSimilarity(String sourceElement, String targetElement) {
        String[] sourceWords = sourceElement.toLowerCase().split("\\.");
        String[] targetWords = targetElement.toLowerCase().split("\\.");
        HashSet<String> uniqueWords = new HashSet<>();

        uniqueWords.addAll(new ArrayList<>(Arrays.asList(sourceWords)));
        for (String targetWord: targetWords) {
            if (uniqueWords.contains(targetWord) || uniqueWords.contains(dict.get(targetWord))) {
                continue;
            }
            uniqueWords.add(targetWord);
        }

        int editDistance = EDIST.editDistDP(sourceElement, targetElement, sourceElement.length(), targetElement.length());
        int maxDistance = Math.max(sourceElement.length(), targetElement.length());
        int sourceLen = sourceWords.length, targetLen = targetWords.length, uniqueLen = uniqueWords.size();

        double wordsSim = (sourceLen + targetLen - uniqueLen) * 1.0 / (sourceLen + targetLen);
        double editSim = (maxDistance - editDistance) * 1.0 / maxDistance;
        return 0.5 * wordsSim + 0.5 * editSim;
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
        this.match();
    }

    @Override
    public String getCorrespondence() {
        StringBuilder sb = new StringBuilder();
        for (String s: results) {
            sb.append(s);
        }
        return sb.toString();
    }

    static class EDIST {
        static int min(int x, int y, int z) {
            if (x < y && x < z) return x;
            if (y < x && y < z) return y;
            else return z;
        }

        static int editDistDP(String str1, String str2, int m, int n) {
            int dp[][] = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0)
                        dp[i][j] = j;  // Min. operations = j
                    else if (j == 0)
                        dp[i][j] = i; // Min. operations = i
                    else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else
                        dp[i][j] = 1 + min(dp[i][j - 1],  // Insert
                                dp[i - 1][j],  // Remove
                                dp[i - 1][j - 1]); // Replace
                }
            }

            return dp[m][n];
        }
    }

    class Entry {
        public String element;
        public double similarity;
    }

    class TComparator implements Comparator<Entry> {

        @Override
        public int compare(Entry entry0, Entry entry1) {
            if (entry0.similarity > entry1.similarity) {
                return 1;
            }
            else if (entry0.similarity == entry1.similarity) {
                return 0;
            }
            else {
                return -1;
            }
        }
    }
}

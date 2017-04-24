package koalacata.metric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouludong on 2017/4/23.
 */

public class Metric {
    private String sourceXMLsPath;
    private String answerXMLsPath;
    private String resultXMLsPath;
    private static Logger logger = LogManager.getLogger();

    Metric(String sourceXMLsPath, String answerXMLsPath, String resultXMLsPath) {
        init(sourceXMLsPath, answerXMLsPath, resultXMLsPath);
    }

    void init(String sourceXMLsPath, String answerXMLsPath, String resultXMLsPath) {
        logger.info("initializing files");

        this.sourceXMLsPath = sourceXMLsPath;
        this.answerXMLsPath = answerXMLsPath;
        this.resultXMLsPath = resultXMLsPath;

        logger.info("initialize done");
    }

    Metric() {

    }

    public HashMap<String, Double> calc(String sourceXMLsPath, String answerXMLsPath, String resultXMLsPath) {
        init(sourceXMLsPath, answerXMLsPath, resultXMLsPath);
        return calc();
    }

    public HashMap<String, Double> calc() {
        logger.info("start calculate metric");

        HashMap<String, Double> result = new HashMap<>();
        result.put("precision", (double) 0);
        result.put("recall", (double) 0);
        result.put("f_measure", (double) 0);
        result.put("fallout", (double) 0);

        int fileCount = 0;

        for (File sourceFile: getAllFile(new File(this.sourceXMLsPath))) {
            logger.info("calculating metric for file: " + sourceFile.getName());
            fileCount += 1;

            File answerFile = getAnserFile(sourceFile, answerXMLsPath);
            File resultFile = getResultFile(sourceFile, resultXMLsPath);

            if (answerFile == null || resultFile == null) {
                logger.error("can't find answer or result for source file: " + sourceFile.getName());
                System.exit(1);
            }

            HashMap<String, Integer> sourceElements = getElements(sourceFile);
            HashMap<String, Integer> answerElements = getElements(answerFile);
            HashMap<String, Integer> resultElements = getElements(resultFile);

            logger.info("source elements count: " + sourceElements.size());
            logger.info("answer elements count: " + answerElements.size());
            logger.info("result elements count: " + resultElements.size());

            HashMap<String, Double> singleResult = calcSingle(sourceElements, answerElements, resultElements);

            logger.info("updating metric");
            mergeReuslt(result, singleResult, fileCount);
        }

        logger.info("metric calculation done");
        return result;
    }

    private void mergeReuslt(HashMap<String, Double> result, HashMap<String, Double> singleResult, int fileCount) {
        double precision = (result.get("precision") * (fileCount - 1) + singleResult.get("precision")) / fileCount;
        double recall    = (result.get("recall") * (fileCount - 1) + singleResult.get("recall")) / fileCount;
        double f_measure = (result.get("f_measure") * (fileCount - 1) + singleResult.get("f_measure")) / fileCount;
        double fallout   = (result.get("fallout") * (fileCount - 1) + singleResult.get("fallout")) / fileCount;

        result.put("precision", precision);
        result.put("recall", recall);
        result.put("f_measure", f_measure);
        result.put("fallout", fallout);
    }

    /**
    A-FN, False Negatives :     in answer , not in result
    B-TP, True  Positives :     in answer ,     in result
    C-FP, False Positives : not in answer ,     in result
    D-TN, True  Negatives : not in answer , not in result

    precision = TP / (TP + FP)
    recall    = TP / (TP + FN)
    f_measure = (2 * precision * recall) / (precision + recall)
    fallout   = FP / (FP + TN)
     */
    private HashMap<String,Double> calcSingle(HashMap<String, Integer> sourceElements, HashMap<String, Integer> answerElements, HashMap<String, Integer> resultElements) {
        HashMap<String, Double> result = new HashMap<>();
        result.put("precision", (double) 0);
        result.put("recall", (double) 0);
        result.put("f_measure", (double) 0);
        result.put("fallout", (double) 0);

        int FN, TP, FP, TN;
        FN = calcFN(sourceElements, answerElements, resultElements);
        TP = calcTP(sourceElements, answerElements, resultElements);
        FP = calcFP(sourceElements, answerElements, resultElements);
        TN = calcTN(sourceElements, answerElements, resultElements);

        double precision = (TP + FP) == 0? 0 : TP * 1.0 / (TP + FP);
        double recall    = (TP + FN) == 0? 0 : TP * 1.0 / (TP + FN);
        double f_measure = (precision + recall) == 0? 0 : (2.0 * precision * recall) / (precision + recall);
        double fallout   = (FP + TN) == 0? 0 : FP * 1.0 / (FP + TN);

        result.put("precision", precision);
        result.put("recall", recall);
        result.put("f_measure", f_measure);
        result.put("fallout", fallout);
        return result;
    }

    private int calcTP(HashMap<String, Integer> sourceElements, HashMap<String, Integer> answerElements, HashMap<String, Integer> resultElements) {
        int TP = 0;

        for (String key: answerElements.keySet()) {
            if (resultElements.containsKey(key)) {
                int answerCount = answerElements.get(key);
                int resultCount = resultElements.get(key);

                if (answerCount >= resultCount) {
                    TP += resultCount;
                } else { // if resultCount > answerCount, then,
                    TP += answerCount;
                }
            }
        }

        return TP;
    }

    private int calcFN(HashMap<String, Integer> sourceElements, HashMap<String, Integer> answerElements, HashMap<String, Integer> resultElements) {
        int FN = 0;

        for (String key: answerElements.keySet()) {
            if (resultElements.containsKey(key)) {
                int answerCount = answerElements.get(key);
                int resultCount = resultElements.get(key);

                if (answerCount >= resultCount) {
                    FN += answerCount - resultCount;
                }
            }
            else {
                FN += answerElements.get(key);
            }
        }

        return FN;
    }

    private int calcTN(HashMap<String, Integer> sourceElements, HashMap<String, Integer> answerElements, HashMap<String, Integer> resultElements) {
        int TN = 0;

        for (String key: sourceElements.keySet()) {
            if (answerElements.containsKey(key) && resultElements.containsKey(key)) {
                TN += sourceElements.get(key) - Math.max(answerElements.get(key), resultElements.get(key));
            }
            else if (answerElements.containsKey(key)) {
                TN += sourceElements.get(key) - answerElements.get(key);
            }
            else if (resultElements.containsKey(key)) {
                TN += sourceElements.get(key) - resultElements.get(key);
            }
            else {
                TN += sourceElements.get(key);
            }
        }

        return TN;
    }

    private int calcFP(HashMap<String, Integer> sourceElements, HashMap<String, Integer> answerElements, HashMap<String, Integer> resultElements) {
        int FP = 0;

        for (String key: resultElements.keySet()) {
            if (answerElements.containsKey(key)) {
                int answerCount = answerElements.get(key);
                int resultCount = resultElements.get(key);

                if (answerCount < resultCount) {
                    FP += resultCount - answerCount;
                }
            }
            else {
                FP += resultElements.get(key);
            }
        }
        return FP;
    }

    private HashMap<String, Integer> getElements(File file) {
        HashMap<String, Integer> elements = new HashMap<>();

        if (file.isFile() && file.getName().endsWith(".xml")) {
            Element root = getDocRoot(file);

            elements = inorderTree(root, new ArrayList<String>());
        }
        else if (file.isDirectory() && !file.isHidden()) {
            for (File subFile: file.listFiles()) {
                combineElements(elements, getElements(subFile));
            }
        }

        return elements;
    }

    private HashMap<String, Integer> inorderTree(Element root, ArrayList<String> ancestors) {
        HashMap<String, Integer> elements = new HashMap<>();

        // it's a leaf node
        if (isLeafNotEmpty(root)) {
            String path = combinePath(ancestors);
            if (path.isEmpty())
                elements.put(root.getTagName(), 1);
            else
                elements.put(path + '.' + root.getTagName(), 1);
        }

        ancestors.add(root.getTagName());

        NodeList children = root.getChildNodes();
        for (int i = 0; i< children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element)node;
                combineElements(elements, inorderTree(child, ancestors));
            }
        }
        if (!ancestors.isEmpty() && root.getNodeType() == Element.ELEMENT_NODE ) {
            ancestors.remove(ancestors.size() - 1);
        }
        return elements;
    }

    private boolean isLeafNotEmpty(Element root) {
        if (root.getTagName().equals("Metadata")) {
            return false;
        }

        if (root.getNodeType() == Element.ELEMENT_NODE) {
            if (!root.hasChildNodes() && !root.getTextContent().isEmpty()) {
                return true;
            }
            else if(root.getChildNodes().getLength() == 1 && root.getFirstChild().getNodeType() == Element.TEXT_NODE){
                if (!root.getFirstChild().getTextContent().trim().equals("\n")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void combineElements(HashMap<String, Integer> eA, HashMap<String, Integer> eB) {
        for (String key: eB.keySet()) {
            if (eA.containsKey(key)) {
                eA.put(key, eA.get(key) + 1);
            }
            else {
                eA.put(key, 1);
            }
        }
    }

    private String combinePath(ArrayList<String> ancestors) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ancestor : ancestors)
        {
            stringBuilder.append(ancestor);
            stringBuilder.append(".");
        }

        if (stringBuilder.length() != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
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

    private Set<File> getAllFile(File rootFile) {
        HashSet<File> allFiles = new HashSet<>();

        if (rootFile.isFile()) {
            allFiles.add(rootFile);
        }
        else {
            for (File file: rootFile.listFiles()) {
                if (!file.isHidden()) {
                    allFiles.addAll(getAllFile(file));
                }
            }
        }
        return allFiles;
    }

    // maybe returned file is a directory containing all answers
    private File getAnserFile(File sourceFile, String answerPath) {
        return getSameNameFile(sourceFile, answerPath);
    }

    private File getResultFile(File sourceFile, String resultPath) {
        return getSameNameFile(sourceFile, resultPath);
    }

    private File getSameNameFile(File originalFile, String dstPath) {
        File resultFile = new File(dstPath);

        for (File file: resultFile.listFiles()) {
            if (file.getName().equals(originalFile.getName())) {
                resultFile = file;
                break;
            }
        }

        if (resultFile.getName().equals(originalFile.getName())) {
            for (File file: resultFile.listFiles()) {
                if (file.getName().startsWith("Video")) {
                    return file;
                }
            }
        }

        return null;
    }
}
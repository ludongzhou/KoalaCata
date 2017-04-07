package koalacata.core.xsd.template;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhouludong on 2017/3/9.
 */
public class XSLTGenerator {
    private String xsltDir = "resource/xslt/template/";
    private TreeMap<String, String> sortedMap;
    private HashSet<String> xsltSet;

    public XSLTGenerator(String correspondencePath) {
        sortedMap = getSortedCorrespondence(correspondencePath);
        xsltSet = getAllXSL(xsltDir);
        // printMap(sortedMap);
    }

    public void generateXLST() {
        try {
            for (String xsltPath : xsltSet) {
                // get XSLTTemplate document
                File xsltFile = new File(xsltPath);
                Document xsltDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xsltFile);
                xsltDocument.getDocumentElement().normalize();

                // for every correspondence, match it
                for (String key : sortedMap.keySet()) {
                    Element element = getMatchedElement(key, xsltDocument);
                    updateSelect(element);
                }

                writeXSLT(xsltDocument, xsltFile);
            }
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    private void updateSelect(Element element) {
        boolean ancestorMatched = false;

        if (element != null) { // element is for-each or value-of
            Element ancestor = (Element) element.getParentNode();
            while (!isDocRoot(ancestor)) {
                if (ancestor.hasAttribute("select")) { // ancestor must be a for-each node

                    // if ancestor has a correspondence
                    if (matched(ancestor)) {
                        element.setAttribute("select", getTargetPath(element, ancestor));
                        ancestorMatched = true;
                        break;
                    }
                    else { // not correspondence found, then upgrade for-each's children and delete current node (for-each)
                        Node parent = ancestor.getParentNode();
                        deleteFor_Each(ancestor);
                        ancestor = (Element) parent;
                    }
                }
                else {
                    ancestor = (Element) ancestor.getParentNode();
                }
            }
            if (!ancestorMatched) {
                element.setAttribute("select", getTargetPath(element, null));
            }
        }
    }

    private void deleteFor_Each(Element element) {
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);
                upgradeNode(child);
            }
        }
        deleteNode(element);
    }

    // select a node in template which node's select == key
    private Element getMatchedElement(String selectValue, Document xsltTemplate) {
        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression;
        NodeList nodeList;
        String xPath = "//*[@select='" + selectValue + "']";
        try {
            xPathExpression = xpath.compile(xPath);
            nodeList = (NodeList) xPathExpression.evaluate(xsltTemplate, XPathConstants.NODESET);
            if (nodeList != null && nodeList.getLength() != 0) {
                return (Element) nodeList.item(0);
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeXSLT(Document xsltDocument, File xsltFile) {
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(xsltDocument);
            StreamResult result = new StreamResult(new File("resource/xslt/result/" + xsltFile.getName()));
            transformer.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        // Output to console for testing
        // StreamResult consoleResult = new StreamResult(System.out);
        // transformer.transform(source, consoleResult);

    }

    private void deleteNode(Element element) {
        Element parent = (Element) element.getParentNode();
        parent.removeChild(element);
    }

    private void upgradeNode(Element element) {
        if (!isDocRoot(element)) {
            Element grandpa = (Element)element.getParentNode().getParentNode();
            grandpa.appendChild(element.cloneNode(true));
        }
    }

    private String getTargetPath(Element current, Element ancestor) {
        String targetPath = sortedMap.get(current.getAttribute("select")).replace('.', '/');
        if (ancestor == null) {
            return targetPath;
        }
        else {
            String ancestorPath = ancestor.getAttribute("select");
            return targetPath.substring(targetPath.lastIndexOf(ancestorPath + "/") + ancestorPath.length() + 1);
        }
    }

    private boolean matched(Element element) {
        String selectValue = element.getAttribute("select");
        if (!selectValue.isEmpty() && !selectValue.contains(".")) {
            return true;
        }
        return false;
    }

    private boolean isDocRoot(Element e) {
        return e.getTagName().equals("xsl:stylesheet");
    }

    //pretty print a map
    public <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    public HashSet<String> getAllXSL(String dirPath) {
        HashSet<String> hashSet = new HashSet<>();

        File dir = new File(dirPath);
        for (File file : dir.listFiles()) {
            if (file.isFile() && file.getName().endsWith("XSLTTemplate")) {
                hashSet.add(file.getAbsolutePath());
            }
        }
        return hashSet;
    }

    public TreeMap<String, String> getSortedCorrespondence(String correspondencePath) {
        String sourceRE = "(?<=\\-\\s)[\\w|.]*(?=\\s\\<)";
        String targetRE = "(?<=\\>\\s)[\\w|.]*(?=\\:\\s)";
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> sortedMap;

        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(correspondencePath)), StandardCharsets.UTF_8);
            Pattern sourcePattern = Pattern.compile(sourceRE);
            Pattern targetPattern = Pattern.compile(targetRE);
            Matcher sourceMatcher = sourcePattern.matcher(content);
            Matcher targetMatcher = targetPattern.matcher(content);
            while (sourceMatcher.find() && targetMatcher.find())
                hashMap.put(targetMatcher.group(), sourceMatcher.group());
            sortedMap = new TreeMap<>(hashMap);
            return sortedMap;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

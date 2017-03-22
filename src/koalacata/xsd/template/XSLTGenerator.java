package koalacata.xsd.template;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhouludong on 2017/3/9.
 */
public class XSLTGenerator {
    public static void generateXLST(String correspondencePath) {
        String sourceRE = "(?<=\\-\\s)[\\w|.]*(?=\\s\\<)";
        String targetRE = "(?<=\\>\\s)[\\w|.]*(?=\\:\\s)";
        HashMap<String, String> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("xslt/template/shot.xslt");
        hashSet.add("xslt/template/scene.xslt");
        hashSet.add("xslt/template/sequence.xslt");
        hashSet.add("xslt/template/program.xslt");

        try {
            String content = new String(Files.readAllBytes(Paths.get(correspondencePath)), StandardCharsets.UTF_8);
            Pattern sourcePattern = Pattern.compile(sourceRE);
            Pattern targetPattern = Pattern.compile(targetRE);
            Matcher sourceMatcher = sourcePattern.matcher(content);
            Matcher targetMatcher = targetPattern.matcher(content);
            while (sourceMatcher.find() && targetMatcher.find())
                hashMap.put(targetMatcher.group(), sourceMatcher.group());

            for (String filePath : hashSet) {
                File file = new File(filePath);
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                document.getDocumentElement().normalize();
                XPath xpath = XPathFactory.newInstance().newXPath();
                XPathExpression xPathExpression;

                for (String key : hashMap.keySet()) {
                    // System.out.println(hashMap.get(key));
                    String xpathExpresion = "//*[name()='xsl:value-of'][@select='" + key + "']"; // MetaData.Program.Language.AudioChannel.AudioChannelLanguage']";
                    xPathExpression = xpath.compile(xpathExpresion);
                    NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
                    if (nodeList.getLength() != 0) {
                        Element element = (Element) nodeList.item(0);
                        String targetPath = hashMap.get(key).replace('.', '/');
                        element.setAttribute("select", targetPath);
                        // System.out.println(element.getTagName() + " select=" + element.getAttribute("select"));
                        // element.setAttribute("select", "f**k");
                    }
                }

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(new File("xslt/result/" + filePath.split("/")[2]));
                transformer.transform(source, result);
                // Output to console for testing
                // StreamResult consoleResult = new StreamResult(System.out);
                // transformer.transform(source, consoleResult);
            }
        } catch (IOException | ParserConfigurationException | XPathExpressionException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

}

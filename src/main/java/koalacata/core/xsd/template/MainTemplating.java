package koalacata.core.xsd.template;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
import java.io.File;
import java.io.IOException;

/**
 * Created by zhouludong on 2017/3/9.
 */
public class MainTemplating {

    public static void main(String[] args) {
        try {
            File dir = new File("resource/xslt/template/original");
            for (File file: dir.listFiles()) {
                if (file.isFile() && file.getName().endsWith("XSLTTemplate")) {
                    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                    document.getDocumentElement().normalize();
                    Element root = (Element) document.getDocumentElement().getElementsByTagName("MetaData").item(0);
                    DFS(root, root.getTagName());
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    DOMSource source = new DOMSource(document);
                    StreamResult result =
                            new StreamResult(new File("resource/xslt/template/" + file.getName()));
                    transformer.transform(source, result);
                    // Output to console for testing
                    // StreamResult consoleResult = new StreamResult(System.out);
                    // transformer.transform(source, consoleResult);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void DFS(Element root, String path) {
        NodeList nodeList = root.getChildNodes();

        // add select to value-of
        if (nodeList.getLength() == 0) {
            // if this is a leaf node and can repeat
            if (((Element)root.getParentNode().getParentNode()).getTagName().contains("each")) {
                root.setAttribute("select", "current()");
            }
            else { // leaf node and can't repeat
                root.setAttribute("select", path);
            }
        } else {

            // add select to for-each
            if (root.getTagName().endsWith("each")) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element child = (Element) node;
                        root.setAttribute("select", path + "." + child.getTagName());
                        break;
                    }
                }
            }

            // recursive
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) node;

                    // current is for-each node
                    if (child.getTagName().endsWith("each") || child.getTagName().endsWith("value-of")) {
                        DFS(child, path);
                    }
                    else {
                        DFS(child, path + '.' + child.getTagName());
                    }
                }
            }
        }
    }
}

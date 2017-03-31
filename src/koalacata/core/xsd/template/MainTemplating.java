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
        System.setProperty("log4j.configurationFile", "log4j2.xml");
        Logger logger = LogManager.getLogger(MainTemplating.class);
        try {
            File file = new File("template/sequence.resource.xslt");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            document.getDocumentElement().normalize();
            Element root = (Element) document.getDocumentElement().getElementsByTagName("MetaData").item(0);
            DFS(root, "");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result =
                    new StreamResult(new File("template/sequence_new.resource.xslt"));
            transformer.transform(source, result);
            // Output to console for testing
//            StreamResult consoleResult = new StreamResult(System.out);
//            transformer.transform(source, consoleResult);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private static void DFS(Element root, String path) {
        NodeList nodeList = root.getChildNodes();
        if (nodeList.getLength() == 0) {
//            System.out.println(path.substring(0, path.length() - 1));
            root.setAttribute("select", path.substring(0, path.length() - 1));
        } else {
            if (root.getTagName().equalsIgnoreCase("xsl:for-each")) {
//                System.out.println(path.substring(0, path.length() - 1));
//                root.setAttribute("select", path.substring(0, path.length() - 1));
            }
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) node;
                    if (root.getTagName().endsWith("each")) {
                        DFS(child, path);
                    } else {
                        DFS(child, path + root.getTagName() + '.');
                    }
                }
            }
        }
    }
}

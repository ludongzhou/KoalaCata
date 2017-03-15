package koalacata.template.address;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
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

/**
 * Created by zhouludong on 2017/3/12.
 */
public class test {
    public static void main(String[] args) {
        try {
            File file = new File("xslt/template/program.xslt");
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            document.getDocumentElement().normalize();
            XPath xpath = XPathFactory.newInstance().newXPath();
            XPathExpression xPathExpression;
            String key = "//xsl:value-of[@select=\'MetaData.Program.Language.AudioChannel.AudioChannelLanguage\']";
            String key = "//xsl:value-of[@select=\'MetaData.Program.Language.AudioChannel.AudioChannelLanguage\']";
            xPathExpression = xpath.compile(key);
            NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
            if (nodeList.getLength() != 0) {
                System.out.println(key);
                Element element = (Element) nodeList.item(0);
                element.setAttribute("select", "shit");
                System.out.println("shit");
            }
            System.out.println(key);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (IOException | TransformerException | ParserConfigurationException | SAXException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}

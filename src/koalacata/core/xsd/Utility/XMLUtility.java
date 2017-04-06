package koalacata.core.xsd.Utility;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by zhouludong on 2017/4/6.
 */
public class XMLUtility {

    // private static XMLUtility ourInstance = new XMLUtility();
    //
    // public static XMLUtility getInstance() {
    //     return ourInstance;
    // }
    //
    // private XMLUtility() { }

    public static void prettyPrint(Document xml) {
        Transformer tf = null;
        try {
            tf = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        try {
            tf.transform(new DOMSource(xml), new StreamResult(out));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println(out.toString());
    }

    public static Document getCopiedDoc(Document doc) {
        Document resultDoc = null;
        try {
            resultDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Node root = resultDoc.importNode(doc.getDocumentElement(), true);
        resultDoc.appendChild(root);
        XMLUtility.prettyPrint(resultDoc);
        return resultDoc;
    }
}

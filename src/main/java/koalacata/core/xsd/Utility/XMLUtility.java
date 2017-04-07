package koalacata.core.xsd.Utility;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

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

    /**
     * given a doc, prettyprint the doc content
     */
    public static void prettyPrint(Document xml) {
        System.out.println(getPrettyDocContent(xml));
    }

    public static String getPrettyDocContent(Document doc) {

        Transformer tf = null;
        try {
            tf = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty("{http://xml.apache.org/XSLTTemplate}indent-amount", "4");
        Writer out = new StringWriter();
        try {
            tf.transform(new DOMSource(doc), new StreamResult(out));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return format(out.toString(), false);

    }

    public static String format(String xml, Boolean ommitXmlDeclaration) {

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xml)));

            OutputFormat format = new OutputFormat(doc);
            format.setIndenting(true);
            format.setIndent(4);
            format.setOmitXMLDeclaration(ommitXmlDeclaration);
            format.setLineWidth(Integer.MAX_VALUE);
            Writer outxml = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(outxml, format);
            serializer.serialize(doc);

            return outxml.toString();
        }
        catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
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
        return resultDoc;
    }

    public static String removeNS(String docString) {
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("main/resources/removeNS.xsl"));
            Transformer transformer = factory.newTransformer(xslt);

            StringWriter outWriter = new StringWriter();
            StreamResult result = new StreamResult( outWriter );

            Source text = new StreamSource(new ByteArrayInputStream(docString.getBytes()));
            transformer.transform(text, result);
            StringBuffer sb = outWriter.getBuffer();
            return sb.toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return null;
    }
}

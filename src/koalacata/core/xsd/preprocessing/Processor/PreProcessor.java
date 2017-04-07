package koalacata.core.xsd.preprocessing.Processor;

import koalacata.core.xsd.Utility.XMLUtility;
import koalacata.core.xsd.preprocessing.Straightor.AbstractStraightor;
import koalacata.core.xsd.preprocessing.Straightor.TagNameEnrichor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Created by zhouludong on 2017/4/5.
 */
public class PreProcessor {
    private File sourceFile;
    private Document sourceDoc;
    private Document resultDoc;

    private String resultString;

    private ArrayList<AbstractStraightor> straightors;

    public PreProcessor(File sourceFile) {
        if (!sourceFile.exists()) {
            System.out.println("file not found");
            exit(1);
        }
        this.sourceFile = sourceFile;
        readFileContent();
        straightors = new ArrayList<>();

        straightors.add(new TagNameEnrichor());
    }

    private void readFileContent() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.sourceDoc = documentBuilder.parse(this.sourceFile);
            this.sourceDoc.getDocumentElement().normalize();
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        resultDoc = XMLUtility.getCopiedDoc(sourceDoc);
        for (AbstractStraightor straightor: straightors) {
            resultDoc = straightor.run(resultDoc);
        }
        convertDoc2String();
    }

    private void convertDoc2String() {
        this.resultString = XMLUtility.getPrettyDocContent(this.resultDoc);
    }

    public String toString() {
        return resultString;
    }
}

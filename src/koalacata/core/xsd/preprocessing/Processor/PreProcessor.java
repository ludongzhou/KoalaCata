package koalacata.core.xsd.preprocessing.Processor;

import koalacata.core.xsd.Utility.XMLUtility;
import koalacata.core.xsd.preprocessing.Straightor.AbstractStraightor;
import koalacata.core.xsd.preprocessing.Straightor.TagNameEnrichor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Logger logger = LogManager.getLogger();

    public PreProcessor(File sourceFile) {
        this.sourceFile = sourceFile;
        init();
    }

    public PreProcessor() {

    }

    private void init() {
        if (!sourceFile.exists()) {
            System.out.println("file not found");
            exit(1);
        }
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

    public void process(File file) {
        this.sourceFile = file;
        init();
        process();
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
        // logger.info(resultString);
    }

    public String getDocString() {
        return resultString;
    }

    public Document getResultDoc() {
        return this.resultDoc;
    }
}

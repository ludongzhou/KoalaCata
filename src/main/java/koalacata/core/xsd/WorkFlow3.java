package koalacata.core.xsd;

import koalacata.core.xsd.mapping.matcher.ComaMatcher;
import koalacata.core.xsd.utility.XMLUtility;
import koalacata.core.xsd.infer.extractor.AbstractExtractor;
import koalacata.core.xsd.infer.extractor.XSDGenExtractor;
import koalacata.core.xsd.infer.extractor.XMLSchemaLearner;
import koalacata.core.xsd.mapping.matcher.AbstractMatcher;
import koalacata.core.xsd.mapping.matcher.MyMatcher;
import koalacata.core.xsd.preprocessing.Processor.PreProcessor;
import koalacata.core.xsd.template.XSLTGenerator;
import koalacata.core.xsd.transfer.Transfer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

import static koalacata.core.xsd.utility.FileUtility.write2File;

/**
 * Created by zhouludong on 2017/4/8.
 */
public class WorkFlow3 {

    public static Logger logger = LogManager.getLogger();

    public void run(String xmlPath, String dstFolder) {
        String tempFilePath = "tmp/source.xml";

        PreProcessor preprocessor = new PreProcessor();
        AbstractExtractor xsdExtractor = new XMLSchemaLearner();
        // AbstractExtractor xsdExtractor = new XSDGenExtractor();
        AbstractMatcher matcher = new ComaMatcher();
        // AbstractMatcher matcher = new MyMatcher();
        Transfer transfer = new Transfer();

        preprocessor.process(new File(xmlPath));
        String docString = XMLUtility.removeNS(preprocessor.getDocString());
        write2File(docString, tempFilePath);

        if (xsdExtractor instanceof XMLSchemaLearner) {
            write2File(preprocessor.getDocString(), tempFilePath);
            xsdExtractor.extract(new File(tempFilePath));
        }
        else {
            xsdExtractor.extract(docString);
        }
        String sourceXSD = xsdExtractor.getXSD();
        write2File(sourceXSD, "tmp/source.xsd");

        matcher.match("tmp/source.xsd", "src/main/resources/standard.xsd");

        String correspondences = matcher.getCorrespondence();
        String crspdsPath = "tmp/correspondences.txt";
        write2File(correspondences, crspdsPath);

        XSLTGenerator generator = new XSLTGenerator(crspdsPath);
        generator.generateXLST();
        transfer.start(tempFilePath, dstFolder);
    }
}

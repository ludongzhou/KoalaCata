package koalacata.xsd.infer;

/**
 * Created by zhouludong on 2017/1/18.
 */

import koalacata.xsd.infer.extractor.XMLSchemaLearner;
import koalacata.xsd.infer.extractor.XSDGenExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile","log4j2.xml");
        Logger logger = LogManager.getLogger(Main.class);
//        XSDGenExtractor extractor = new XSDGenExtractor();
        XMLSchemaLearner extractor = new XMLSchemaLearner();
        extractor.extract(new File("src/koalacata/xsd/infer/test/test.xml"));
        logger.info(extractor.toString());
    }
}

package koalacata.xsd;

/**
 * Created by zhouludong on 2017/1/18.
 */

import koalacata.xsd.extractor.XSDGenExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile","log4j2.xml");
        Logger logger = LogManager.getLogger(Main.class);
        XSDGenExtractor extractor = new XSDGenExtractor();
        extractor.extract(new File("src/koalacata/xsd/test/test.xml"));
        System.out.print(extractor.toString());
    }
}

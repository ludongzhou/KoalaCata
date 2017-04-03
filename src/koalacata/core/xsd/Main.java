package koalacata.core.xsd;

import koalacata.core.xsd.infer.extractor.AbstractExtractor;
import koalacata.core.xsd.infer.extractor.XMLSchemaLearner;
import koalacata.core.xsd.mapping.matcher.AbstractMatcher;
import koalacata.core.xsd.mapping.matcher.ComaMatcher;
import koalacata.core.xsd.template.XSLTGenerator;
import koalacata.core.xsd.transfer.Transfer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhouludong on 2017/3/15.
 */
public class Main {
    public static void main(String[] args) {
        String xmlPath = args[0];
        AbstractExtractor xsdExtractor = new XMLSchemaLearner();
        // AbstractExtractor xsdExtractor = new XSDGenExtractor();
        AbstractMatcher matcher = new ComaMatcher();
        Transfer transfer = new Transfer();

        xsdExtractor.extract(new File(xmlPath));
        String sourceXSD = xsdExtractor.getXSD();
        write2File(sourceXSD, "resource/xsd/source.xsd");

        matcher.match("resource/xsd/source.xsd", "resource/xsd/standard.xsd");

        String correspondences = matcher.getCorrespondence();
        String crspdsPath = "sample/correspondences.txt";
        write2File(correspondences, crspdsPath);

        XSLTGenerator generator = new XSLTGenerator(crspdsPath);
        generator.generateXLST();
        transfer.start(xmlPath);
    }

    private static void write2File(String content, String path) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            bw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

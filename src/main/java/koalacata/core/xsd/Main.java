package koalacata.core.xsd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Created by zhouludong on 2017/3/15.
 */
public class Main {
    public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        String xmlPath = args[0];
        WorkFlow workFlow = new WorkFlow();
        File sourceXMLFolders = new File("source_xmls");
        String dstFolder = "result/实验4/";

        for (File file: sourceXMLFolders.listFiles()) {
            if (file.isDirectory() && !file.isHidden()) {
                for (File xmlFile: file.listFiles()) {
                    if (xmlFile.isFile() && xmlFile.getName().endsWith(".xml")) {
                        workFlow.run(xmlFile.getAbsolutePath(), dstFolder + file.getName() + '/' + xmlFile.getName());
                    }
                }
            }
        }
    }

}

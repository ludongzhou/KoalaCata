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
        WorkFlow6 workFlow = new WorkFlow6();
        File sourceXMLFolders = new File("source_xmls");
        String dstFolder = "result/实验6/";
        double step = 0.02, startThreshhold = 0.1, endThreshhold = 0.9;

        for (double threshhold = startThreshhold; threshhold <= endThreshhold; threshhold += step) {

            for (File file: sourceXMLFolders.listFiles()) {
                if (file.isDirectory() && !file.isHidden()) {
                    for (File xmlFile: file.listFiles()) {
                        if (xmlFile.isFile() && xmlFile.getName().endsWith(".xml")) {
                            workFlow.run(xmlFile.getAbsolutePath(), dstFolder + String.valueOf(threshhold) + "/" + file.getName() + '/' + xmlFile.getName(), threshhold);
                        }
                    }
                }
            }
        }

        // for (File file: sourceXMLFolders.listFiles()) {
        //     if (file.isDirectory() && !file.isHidden()) {
        //         for (File xmlFile: file.listFiles()) {
        //             if (xmlFile.isFile() && xmlFile.getName().endsWith(".xml")) {
        //                 workFlow.run(xmlFile.getAbsolutePath(), dstFolder + String.valueOf(threshhold) + "/" + file.getName() + '/' + xmlFile.getName());
        //             }
        //         }
        //     }
        // }
    }

}

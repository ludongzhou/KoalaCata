package koalacata.core.xsd.utility;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhouludong on 2017/4/8.
 */
public class FileUtility {

    public static void write2File(String content, String path) {
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

    public static String read2String(File file) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document sourceDoc = documentBuilder.parse(file);
            sourceDoc.getDocumentElement().normalize();

            return XMLUtility.getPrettyDocContent(sourceDoc);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        return null;
    }
}

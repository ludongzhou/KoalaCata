package koalacata.xsd.infer.extractor;

import nu.xom.Document;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

/**
 * Created by zhouludong on 2017/1/18.
 */
public abstract class AbstractExtractor {
    private Document doc;
    public Logger logger = LogManager.getLogger(this);
    public abstract String toString();
    public abstract void extract(InputStream inputStream);
    public void extract(String xml) {
        ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
        extract(stream);
    }

    public void extract(File f) {
        try {
            InputStream inputStream = new FileInputStream(f);
            extract(inputStream);
        }
        catch (FileNotFoundException e) {
            logger.error("file: %s not found", f.getAbsolutePath());
        }
    }

}

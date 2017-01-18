package koalacata.xsd.extractor;

/**
 * Created by zhouludong on 2017/1/18.
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wiztools.xsdgen.ParseException;
import org.wiztools.xsdgen.XsdGen;

import java.io.*;

public class XSDGenExtractor extends AbstractExtractor{
    private XsdGen gen = new XsdGen();
    public Logger logger = LogManager.getLogger(this);

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

    public void extract(InputStream inputStream) {
        try {
            gen.parse(inputStream);
        }
        catch (IOException|ParseException e) {
            logger.error("XSDGen failed");
        }
    }

    @Override
    public String toString() {
        return  gen.toString();
    }
}

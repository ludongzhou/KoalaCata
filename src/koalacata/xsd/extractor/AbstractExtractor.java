package koalacata.xsd.extractor;

import nu.xom.Document;

import java.io.InputStream;

/**
 * Created by zhouludong on 2017/1/18.
 */
public abstract class AbstractExtractor {
    private Document doc;
    public abstract void extract(InputStream inputStream);
    public abstract String toString();
}

package koalacata.core.xsd.preprocessing.Processor;

import koalacata.core.xsd.preprocessing.Straightor.AbstractStraightor;
import koalacata.core.xsd.preprocessing.Straightor.TagNameEnrichor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by zhouludong on 2017/4/5.
 */
public class PreProcessor {
    private File sourceFile;
    private Document sourceDoc;
    private Document resultDoc;

    private String resultString;

    private ArrayList<AbstractStraightor> straightors;

    public PreProcessor(File sourceFile) {
        this.sourceFile = sourceFile;
        this.sourceDoc = readFileContent();
        straightors = new ArrayList<>();

        straightors.add(new TagNameEnrichor());
    }

    public void process() {

        for (AbstractStraightor straightor: straightors) {
            resultDoc = straightor.run(resultDoc);
        }
        convertDoc2String();
    }

    public String toString() {
        return resultString;
    }
}

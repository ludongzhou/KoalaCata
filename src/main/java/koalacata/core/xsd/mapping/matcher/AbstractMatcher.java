package koalacata.core.xsd.mapping.matcher;

import java.io.File;
import java.util.HashMap;

/**
 * Created by zhouludong on 2017/3/14.
 */
public abstract class AbstractMatcher {
    protected File sourceFile, targetFile;
    protected HashMap<String, String> dict;
    public abstract void match();
    public abstract void match(String sourcePath, String targetPath);
    public abstract String getCorrespondence();
}

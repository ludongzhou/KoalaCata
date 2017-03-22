package koalacata.xsd.mapping.matcher;

import java.io.File;

/**
 * Created by zhouludong on 2017/3/14.
 */
public abstract class AbstractMatcher {
    protected File sourceFile, targetFile;
    public abstract void match();
    public abstract void match(String sourcePath, String targetPath);
    public abstract String getCorrespondence();
}

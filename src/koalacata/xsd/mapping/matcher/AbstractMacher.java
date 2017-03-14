package koalacata.xsd.mapping.matcher;

import java.io.File;

/**
 * Created by zhouludong on 2017/3/14.
 */
public abstract class AbstractMacher {
    protected File sourceFile, targetFile;
    public abstract void match();
    public abstract String getCorrespondence();
}

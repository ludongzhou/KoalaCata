package koalacata.core.xsd.Utility;

/**
 * Created by zhouludong on 2017/4/7.
 */
public class Logger {
    private static Logger ourInstance = new Logger();

    public static Logger getInstance() {
        return ourInstance;
    }

    private Logger() {
    }
}

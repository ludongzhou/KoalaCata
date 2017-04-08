package koalacata.core.xsd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by zhouludong on 2017/3/15.
 */
public class Main {
    public static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        String xmlPath = args[0];
        WorkFlow workFlow = new WorkFlow();

        workFlow.run(xmlPath);
    }

}

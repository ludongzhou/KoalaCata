package koalacata.core.xsd.infer.test;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Created by zhouludong on 2017/1/18.
 */
public class JunitTestSuite {
    public static void main(String[] a) {
        // add the Main's in the suite
        TestSuite suite = new TestSuite(TestJunit.class);
        TestResult result = new TestResult();
        suite.run(result);
        System.out.println("Number of Main cases = " + result.runCount());
    }
}

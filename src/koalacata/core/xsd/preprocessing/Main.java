package koalacata.core.xsd.preprocessing;

import koalacata.core.xsd.preprocessing.Processor.PreProcessor;

import java.io.File;

/**
 * Created by zhouludong on 2017/4/6.
 */
public class Main {
    public static void main(String[] args) {
        PreProcessor preProcessor = new PreProcessor(new File("sample/preprocess.xml"));
        preProcessor.process();
        System.out.println(preProcessor.toString());
    }
}

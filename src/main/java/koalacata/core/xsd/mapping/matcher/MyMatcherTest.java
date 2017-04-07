package koalacata.core.xsd.mapping.matcher;

import java.io.File;

/**
 * Created by zhouludong on 2017/4/4.
 */
public class MyMatcherTest {
    public static void main(String[] args) {
        MyMatcher myMatcher = new MyMatcher(
                new File("resource/xsd/source.xsd"),
                new File("main/resources/standard.xsd"),
                new File("main/resources/thesaurus.dict"));
        myMatcher.match();
        System.out.println(myMatcher.getCorrespondence());
    }
}

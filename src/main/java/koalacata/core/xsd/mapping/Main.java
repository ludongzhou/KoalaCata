package koalacata.core.xsd.mapping;

import koalacata.core.xsd.mapping.matcher.ComaMatcher;

import java.io.File;

/**
 * Created by zhouludong on 2017/2/4.
 */
public class Main {
    public static void main(String[] args) {
        File sourceFile = new File("test/resources/XMLSample/flatten_valide.xsd");
        File targetFile = new File("main/resources/standard.xsd");

        ComaMatcher comaMatcher = new ComaMatcher(sourceFile, targetFile);
        comaMatcher.match();
        System.out.println(comaMatcher.getCorrespondence());
    }
}

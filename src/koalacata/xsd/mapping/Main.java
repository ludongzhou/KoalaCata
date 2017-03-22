package koalacata.xsd.mapping;

import koalacata.xsd.mapping.matcher.ComaMatcher;

import java.io.File;

/**
 * Created by zhouludong on 2017/2/4.
 */
public class Main {
    public static void main(String[] args) {
        File sourceFile = new File("sample/flatten_valide.xsd");
        File targetFile = new File("XSD/standard.xsd");

        ComaMatcher comaMatcher = new ComaMatcher(sourceFile, targetFile);
        comaMatcher.match();
        System.out.println(comaMatcher.getCorrespondence());
    }
}

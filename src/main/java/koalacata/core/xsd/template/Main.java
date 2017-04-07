package koalacata.core.xsd.template;

/**
 * Created by zhouludong on 2017/3/12.
 */
public class Main {
    public static void main(String[] args) {
        XSLTGenerator generator = new XSLTGenerator("sample/correspondences.txt");
        generator.generateXLST();
    }
}

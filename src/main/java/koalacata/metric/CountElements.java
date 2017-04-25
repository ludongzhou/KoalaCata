package koalacata.metric;

import koalacata.core.xsd.utility.XMLUtility;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by zhouludong on 2017/4/25.
 */
public class CountElements {
    public static void main(String[] args) {
        File directory = new File(args[0]);
        int sumupElement = 0;
        int sumupFile    = 0;

        for (File subFile: directory.listFiles()) {
            String fileName = subFile.getName();

            if (!subFile.isHidden() && fileName.endsWith(".xml")) {
                sumupElement += countSingle(subFile);
                sumupFile += 1;
            }
        }

        System.out.println(sumupElement / sumupFile);

    }

    private static int countSingle(File subFile) {
        Element root = XMLUtility.getDocRoot(subFile);
        return BFS(root);
    }

    private static int BFS(Element root) {
        LinkedList<Element> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Element head = queue.pop();
            count += 1;

            NodeList nodes = head.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Element.ELEMENT_NODE) {
                    queue.push((Element)node);
                }
            }
        }

        return count;
    }
}

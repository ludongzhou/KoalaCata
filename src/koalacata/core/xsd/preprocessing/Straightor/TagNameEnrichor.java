package koalacata.core.xsd.preprocessing.Straightor;

import koalacata.core.xsd.Utility.XMLUtility;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by zhouludong on 2017/4/5.
 */
public class TagNameEnrichor extends AbstractStraightor {

    private Document resultDoc;

    // given a doc, return resultDoc
    @Override
    public Document run(Document doc) {
        resultDoc = XMLUtility.getCopiedDoc(doc);
        Element resultRoot = resultDoc.getDocumentElement();
        simplifyAttrItem(resultRoot);
        return resultDoc;
    }

    private void simplifyAttrItem(Element root) {
        NodeList nodeList = root.getChildNodes();
        ArrayList<Element> elements2Add = new ArrayList<>();
        ArrayList<Element> elements2Delete = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Element.ELEMENT_NODE) {
                Element child = (Element) node;

                String tagName = child.getTagName();
                if (tagName.equals("AttributeItem") && child.hasChildNodes()) {
                    elements2Add.add(flatten(child));
                    elements2Delete.add(child);
                }
                else {
                    simplifyAttrItem(child);
                }
            }
        }

        for (Element element: elements2Add) {
            root.appendChild(element);
            simplifyAttrItem(element);
        }

        for (Element element: elements2Delete) {
            root.removeChild(element);
        }
    }

    // the element is attributeItem, should create a new item
    private Element flatten(Element element) {
        String newTagName = getItemCode(element);

        if (!newTagName.isEmpty()) {
            newTagName = newTagName.replaceAll(" ", "");
            Element newElement = resultDoc.createElement(newTagName);
            String newValue = getValue(element);

            // if this is leaf element
            if (!newValue.isEmpty()) {
                newElement.setTextContent(newValue);
            }
            else { // this is not a leaf, it's a inner node
                adoptUsefulChildren(newElement, element);
            }

            return newElement;
        }
        else {
            return null;
        }
    }

    private void adoptUsefulChildren(Element newElement, Element element) {

        /*
          element is a inner node, not leaf so adopt all children except "ItemCode" and "ItemName"
         */
        HashSet<String> uselessNodeName = new HashSet<>();
        uselessNodeName.add("ItemCode");
        uselessNodeName.add("ItemName");

        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Element.ELEMENT_NODE && !uselessNodeName.contains(node.getNodeName())) {
                newElement.appendChild(node.cloneNode(true));
            }
        }
    }

    private String getValue(Element element) {
        return getChildElementValue(element, "Value");
    }

    private String getItemCode(Element element) {
        return getChildElementValue(element, "ItemCode");
    }

    private String getChildElementValue(Element element, String tagName) {
        NodeList nodeList = element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Element.ELEMENT_NODE) {
                Element child = (Element) node;
                if (child.getTagName().equals(tagName)) {
                    return child.getTextContent();
                }
            }
        }
        return "";
    }

}

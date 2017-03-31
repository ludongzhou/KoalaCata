package koalacata.core.xsd.template;

/**
 * Created by zhouludong on 2017/3/12.
 */
public class Main {
    public static void main(String[] args) {
        //     try {
        //         File file = new File("resource.xslt/template/program.resource.xslt");
        //         Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        //         // document.getDocumentElement().normalize();
        //         XPath xpath = XPathFactory.newInstance().newXPath();
        //         XPathExpression xPathExpression;
        //         String key = "//*[name()='xsl:value-of'][@select='MetaData.Program.Language.AudioChannel.AudioChannelLanguage']";
        //         // String key = "//xsl:value-of[@select=\'MetaData.Program.Language.AudioChannel.AudioChannelLanguage\']";
        //         xPathExpression = xpath.compile(key);
        //
        //         NodeList nodeList = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);
        //         if (nodeList.getLength() != 0) {
        //             System.out.println(key);
        //             Element element = (Element) nodeList.item(0);
        //             element.setAttribute("select", "shit");
        //             System.out.println("shit");
        //         }
        //
        //         System.out.println(key);
        //         Transformer transformer = TransformerFactory.newInstance().newTransformer();
        //         DOMSource source = new DOMSource(document);
        //         // StreamResult consoleResult = new StreamResult(System.out);
        //         // transformer.transform(source, consoleResult);
        //     } catch (IOException | TransformerException | ParserConfigurationException | SAXException | XPathExpressionException e) {
        //         e.printStackTrace();
        //     }
        // }
        XSLTGenerator generator = new XSLTGenerator();
        generator.generateXLST("sample/correspondence.txt");
    }
}

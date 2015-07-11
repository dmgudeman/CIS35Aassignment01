/**
 * Created by davidgudeman on 7/9/15.
 */
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

import java.io.IOException;
public class XMLReader2 {

    public Document doc;
    public String sfile;

    public XMLReader2(String sfile) throws ParserConfigurationException, IOException, SAXException {
        this.sfile = sfile;
    }

    public Document ReadXML() throws ParserConfigurationException, IOException, SAXException
    {
        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(sfile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Location");
            System.out.println(nList.getLength());
            Element root = doc.getDocumentElement();
            System.out.println("root = " + root);
            System.out.println("root.getTagName()   " + root.getTagName());
            System.out.println("root.getAttributes()   " + root.getAttributes());
            NodeList childNodeList = root.getChildNodes();
            for (int i = 0; i < childNodeList.getLength(); i++)
            {
                Node child = childNodeList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;

                    System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    System.out.println(child);
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public NodeList GetNodes(Document opendoc, String selement) {
        opendoc.getDocumentElement().normalize();
        NodeList nodelist = opendoc.getElementsByTagName(selement);
        System.out.println("GetNodes list length = " + nodelist.getLength());
        return nodelist;
    }

    public void showNodeList(Document doc, String sElement)
    {
        try {
            Element root = doc.getDocumentElement();
            System.out.println("root = " + root);
            System.out.println("root.getTagName()   " + root.getTagName());
            System.out.println("root.getAttributes()   " + root.getAttributes());
            NodeList childNodeList = root.getChildNodes();
            for (int i = 0; i < childNodeList.getLength(); i++)
            {
                Node child = childNodeList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;

                    System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    System.out.println("Longitude : " + eElement.getElementsByTagName("Longitude").item(0).getTextContent());
                    System.out.println("City : " + eElement.getElementsByTagName("City").item(0).getTextContent());
                    System.out.println("State : " + eElement.getElementsByTagName("State").item(0).getTextContent());
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

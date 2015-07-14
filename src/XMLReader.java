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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLReader
{

    public Document doc;
    public String sfile;

    public XMLReader(String sfile) throws ParserConfigurationException, IOException, SAXException
    {
        this.sfile = sfile;
    }

    public Document ReadXML() throws ParserConfigurationException, IOException, SAXException
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(sfile);

            doc.getDocumentElement().normalize();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return doc;
    }

    public NodeList GetNodes(Document doc)
    {
        NodeList nList = doc.getElementsByTagName("Location");
        Element root = doc.getDocumentElement();
        for (int i = 0; i < nList.getLength(); i++)
        {
            Node child = nList.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;

            }
        }
        return nList;
    }

    public void showNodeList(NodeList nodeList)
    {
        try
        {
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node child = nodeList.item(i);
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


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void showArrayList(ArrayList<Node> list)
    {
        try
        {
            for (int i = 0; i < list.size(); i++)
            {
                Node child = list.get(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;

                    System.out.println("Latitude : " + eElement.getElementsByTagName("Latitude").item(0).getTextContent());
                    System.out.println("Longitude : " + eElement.getElementsByTagName("Longitude").item(0).getTextContent());
                    System.out.println("City : " + eElement.getElementsByTagName("City").item(0).getTextContent());
                    System.out.println("State : " + eElement.getElementsByTagName("State").item(0).getTextContent());
                    System.out.println("\n");
                }
            }

            System.out.println("----------------------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void showNode(NodeList nodeList, int index, String tagname)
    {
        try
        {
            Node child = nodeList.item(index);
            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;
                if (eElement.getElementsByTagName(tagname) != null)

                    System.out.println(tagname + " : " + eElement.getElementsByTagName(tagname).item(0).getTextContent());
            }

            System.out.println("------------*****************----------------");


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }


}

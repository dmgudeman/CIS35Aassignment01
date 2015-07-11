import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.*;
/**
 * Created by davidgudeman on 7/8/15.
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        System.out.println("Hello World");

        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_temp/Coordinates.xml";
        XMLReader2 xmlReader2 = new XMLReader2(sfile);
        Document doc = xmlReader2.ReadXML();
        NodeList nodeList = xmlReader2.GetNodes(doc);
        xmlReader2.showNodeList(nodeList);
        Node node = null;
        Store<Node> store = new Store<Node>();
       for (int i = 0; i<nodeList.getLength(); i++)
       {
           Node l = nodeList.item(i);
           if (l.getNodeType()==Node.ELEMENT_NODE)
           {
               Element location = (Element) l;
               NodeList dataList = location.getChildNodes();
               for (int j=0; j<dataList.getLength(); j++)
               {
                   Node n = dataList.item(j);
                   if(n.getNodeType()==Node.ELEMENT_NODE)
                   {
                       Element place = (Element) n;
                       System.out.println(place.getTagName() + " = " +place.getTextContent());
                       store.storage.add(n);
                       System.out.println("store length = " + store.storage.size());
                   }
               }
           }
       }


    }
}

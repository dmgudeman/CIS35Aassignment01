import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidgudeman on 7/8/15.
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        System.out.println("Hello World");

        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_temp/Coordinates.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);       // extract the nodes into a NodeList
        xmlReader.showNodeList(nodeList);
        System.out.println("xmlReader.showNodeList(nodeList)");
        Search search = new Search(nodeList);
        search.template(nodeList, "City");
        System.out.println("search.template(nodeList, \"City\");");

        search.sortedNodes(nodeList, search.template(nodeList, "City"));

        xmlReader.showArrayList(search.sortedNodes(nodeList, search.template(nodeList, "City")));

     //   xmlReader.showNodeList(finalNodeList);

       /* Node node = null;
        Store<Node> store = new Store<Node>(nodeList);
        System.out.println(store.toString());
        store.process();
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

       */
    }
}

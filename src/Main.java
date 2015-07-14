import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by davidgudeman on 7/8/15.
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        String city1, city2;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter first City");
        city1 =in.nextLine();

        System.out.println("Enter second City");
        city2 = in.nextLine();


        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_temp/Coordinates.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);       // extract the nodes into a NodeList
        Search search = new Search(nodeList);
       // xmlReader.obtainSpecificData(search.sortedNodes(nodeList, search.template(nodeList, "City")), 1, "Lattitude");
        xmlReader.showArrayList(search.sortedNodes(nodeList, search.template(nodeList, "City")));



     //   System.out.println(Math.round(Calculate.haversine(44.38, 46.6, 100.28, 94.32)) + " miles");
     //   xmlReader.showNode(nodeList, 1088, "Latitude");
        Calculate.getDistance(nodeList, city1, city2);
    }
}

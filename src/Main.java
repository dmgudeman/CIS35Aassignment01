import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.*;
/**
 * CIS35A assignment01
 * Created by davidgudeman on 7/8/15.
 */
public class Main
{

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
// String to be scanned to find the pattern.
  /*      String line = "Wichita/KS";
        String pattern = "(.*)(/)([A-Z]{2})";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
       } */

        String city1, city2;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter first City");
        city1 = in.nextLine();
       String city11 = city1.trim();
       System.out.println(city11);

  //      System.out.println("Enter second City");
     //   city2 = in.nextLine();


        String pattern2 = "(.*)(/)([A-Z]{2})";

        // Create a Pattern object
        Pattern s = Pattern.compile(pattern2);

        // Now create matcher object.
        Matcher k = s.matcher(city11);
        if (k.find( )) {
            System.out.println("Found value: " + k.group(0));
            System.out.println("Found value: " + k.group(1));
            System.out.println("Found value: " + k.group(2));
            System.out.println("Found value: " + k.group(3));
        } else {
            System.out.println("NO MATCH");
        }

   /*
        String pattern = "(.*)(/)([A-Z]{2})";
        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(city1);
        System.out.println(m.group(1));
        System.out.println(m.group(3));

        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_temp/Coordinates.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);       // extract the nodes into a NodeList

        Calculate calculate = new Calculate();
        calculate.getDistance(nodeList, city1, city2);
        */

    }
}

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
        Search searcher = new Search();
        String city1, city2;

        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("Enter first City in the format:   City/ST");
        city1 = in.nextLine();
        city1 = searcher.parseInput(city1);

        System.out.println("");
        System.out.println("Enter second City in the format:   City/ST");
        city2 = in.nextLine();
        city2 = searcher.parseInput(city2);


        String sfile = "/Users/davidgudeman/Documents/workspace/CIS35A_temp/Coordinates.xml";
        XMLReader xmlReader = new XMLReader(sfile);
        Document doc = xmlReader.ReadXML();
        NodeList nodeList = xmlReader.GetNodes(doc);

        Gen<Double> iOb;
        Calculate calculate = new Calculate();
        calculate.getDistance(nodeList, city1, city2);

        in.close();

    }
}

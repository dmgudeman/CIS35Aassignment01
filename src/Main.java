import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.Element;
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
       // NodeList nodeList = xmlReader2.GetNodes(doc, "Latitude");
        xmlReader2.showNodeList(doc, "Latitude");


    }
}

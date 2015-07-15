import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by davidgudeman on 7/12/15.
 */
public class Search
{

    //anonymous class that my IDE provided to implement NodeList
    NodeList nodeLists;
    {
        nodeLists = new NodeList()
        {
            @Override
            public Node item(int index)
            {
                return null;
            }

            @Override
            public int getLength()
            {
                return 0;
            }
        };
    }

    // Constructors
    public <T extends Comparable> Search(NodeList nodeList)
    {
        this.nodeLists = nodeList;
    }

    public <T extends Comparable> Search(){}

    /**
     * Used to create a string of city names to use to get the sorted index.
     * It takes in a unsorted NodeList and returns a sorted Arraylist of strings.
     * @param nodeList
     * @param pattern
     * @return String Arraylist
     */

    public ArrayList<String> template(NodeList nodeList, String pattern)
    {
        // Map is used in this method to facilitate sorting
        Map<String, String> items = new HashMap<>();

        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node nl = nodeList.item(i); // iterate through the node list
            if (nl.getNodeType() == Node.ELEMENT_NODE) // Element nodes only
            {
                // iterate through the child nodes
                Element cn = (Element) nl;
                NodeList dataList = cn.getChildNodes();
                for (int j = 0; j < dataList.getLength(); j++)
                {
                    // collect the nodes into NodeList
                    Node n = dataList.item(j);
                    if (n.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element place = (Element) n;
                        // filter to see if matches the sorted arraylist node
                        // at that location
                        if (place.getTagName() == pattern)
                            // if so put it into the Hashmap as key value pair
                            items.put(place.getTextContent(), place.getTagName());
                    }
                }
            }
        }
        // collect the output of the sored Hashmap in a new ArrayList
        ArrayList<String> sortedCityStrings = new ArrayList(items.keySet());
        Collections.sort(sortedCityStrings);
        return sortedCityStrings;
    }

    // binary search function to look up values by city name
    // uses Java native lexographic comparator
    public int binarySearch(ArrayList arrayList, String city)
    {
        int index;
        index = Collections.binarySearch(arrayList, city);
        return index;
    }

    /**
     * This returns a string latitude or longitude of known city.
     *
     * Takes in an unsorted nodelist, a sorted String arraylist for a template, a known index to determine
     * city to focus on, and a string to specify lat or long.
     * @param: nodeList usnorted
     * @param: String sortedStringList
     * @param: int index
     * @param: String latOrLong
     * @return: String latitude or longitude
     */
   public String specificDataString(NodeList nodeList, ArrayList<String> sortedStringList, int index, String latOrLong)
    {
        // collect city name from sorted string list
        String cityName = sortedStringList.get(index);
        String answer = "";
        try
        {
            // iterate through the nodelist
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                // iterate through the child nodes of the node
                Node child = nodeList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;
                    // compare the the template city with childnode city
                    if (cityName == eElement.getElementsByTagName("City").item(0).getTextContent())
                    {
                        // return the lat or long for that city
                        answer = eElement.getElementsByTagName(latOrLong).item(0).getTextContent();

                    }
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return answer;
    }

    // method to parse the input into two groups defined by a / seperator
    // This extracts the city to be used in sord functions
    public String parseInput(String line)
    {
        String answer = "";
        String pattern = "(.*)(/)([A-Z]{2})";
        line = line.trim();

        // Create a Pattern object
        Pattern s = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher k = s.matcher(line);
        if (k.find())
        {
            answer = k.group(1);
        }
        else
        {
            System.out.println("NO MATCH");
        }
        return answer;
    }

}


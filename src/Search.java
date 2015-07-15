import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by davidgudeman on 7/12/15.
 */
public class Search
{
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
        myNodeList<Node> store = new myNodeList<Node>(nodeList);
        Map<String, String> items = new HashMap<>();

        int k = 0;
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node l = nodeList.item(i);
            if (l.getNodeType() == Node.ELEMENT_NODE)
            {

                Element location = (Element) l;
                NodeList dataList = location.getChildNodes();
                for (int j = 0; j < dataList.getLength(); j++)
                {
                    Node n = dataList.item(j);
                    if (n.getNodeType() == Node.ELEMENT_NODE)
                    {

                        Element place = (Element) n;
                        if (place.getTagName() == pattern)

                            items.put(place.getTextContent(), place.getTagName());
                    }
                }
            }
        }
        ArrayList<String> sortedCityStrings = new ArrayList(items.keySet());
        Collections.sort(sortedCityStrings);
        return sortedCityStrings;
    }

    public int binarySearch(ArrayList arrayList, String city)
    {
        int index;
        index = Collections.binarySearch(arrayList, city);
        return index;
    }

    public String specificDataString(NodeList nodeList, ArrayList<String> arraylist, int index, String latOrLong)
    {
        String cityName = arraylist.get(index);
        String answer = "";
        try
        {
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node child = nodeList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) child;
                    if (cityName == eElement.getElementsByTagName("City").item(0).getTextContent())
                    {
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
    // This extracts the city to be used in sord funcitons
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


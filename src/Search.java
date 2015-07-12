import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.*;

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

    public <T extends Comparable>Search(NodeList nodeList)
    {
        this.nodeLists = nodeList;
    }

    public void template(NodeList nodeList, String pattern)
    {
        Store<Node> store = new Store<Node>(nodeList);
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
                           // System.out.println(place.getTagName() + " = " + place.getTextContent());
                            items.put( place.getTextContent(), place.getTagName());

                    }
                }




            }
        }
        List<String> keys = new ArrayList(items.keySet());
        Collections.sort(keys);

        for (String key : keys){
            System.out.println(key);
            k++;
          //  System.out.println("type : " + items.get(key));
        }
        System.out.println("Total : " + k);
    }
}


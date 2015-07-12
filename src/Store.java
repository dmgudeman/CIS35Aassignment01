import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidgudeman on 7/10/15.
 */
public class Store<T>
{
    List<Node> storage = new ArrayList<>();
    Node node = null;


    NodeList nodeList = new NodeList()
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

    public Store(NodeList nodeList)
    {
        this.nodeList = nodeList;
    }

    public Store()
    {
    }

    public NodeList process()
    {
        Store <NodeList> store = new Store();
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
        return null;
    }

}

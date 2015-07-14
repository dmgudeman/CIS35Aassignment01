/**
 * Created by davidgudeman on 7/13/15.
 */

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Calculate
{
    static double RADIUS = 3959;
    // make this a member function of some class


    public static double haversine(double dlatitude1, double dlongitude1, double dlatitude2, double dlongitude2)
    {
        dlongitude1 = -dlongitude1;
        dlongitude2 = -dlongitude2;

        double dLatitude = Math.toRadians(dlatitude2 - dlatitude1);
        double dLongitude = Math.toRadians(dlongitude2 - dlongitude1);
        dlatitude1 = Math.toRadians(dlatitude1);
        dlatitude2 = Math.toRadians(dlatitude2);

        double nA = pow(sin(dLatitude / 2.0), 2.0) + cos(dlatitude1) * cos(dlatitude2) * pow(sin(dLongitude / 2.0), 2.0);
        double nC = 2.0 * atan2(sqrt(nA), sqrt(1.0 - nA));
        double distance = RADIUS * nC;
        return distance;
    }

    public static double getNodeValue(NodeList nodeList, int index, String tagname)
    {
        double value = 0.0;
        try
        {
            Node child = nodeList.item(index);

            if (child.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) child;
                if (eElement.getElementsByTagName(tagname) != null)

                    value = Double.parseDouble(eElement.getElementsByTagName(tagname).item(0).getTextContent());
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return value;
    }

    public static String  getDistance(NodeList nodelist, String city1, String city2)
   {
      Search search = new Search(nodelist);
       String lat1, lat2, long1, long2;
       double latitude1, latitude2, longitude1, longitude2;
       double answer = 0;

       int city1Index = search.binarySearch(search.template(nodelist, "City"), city1);
       System.out.println(search.binarySearch(search.template(nodelist, "City"), city1)+"XXXXXXXXXXXXXXXXXXXXXXXXXXX");

         System.out.println((search.specificDataString(nodelist, search.template(nodelist, "City"), city1Index, "Latitude"))+ "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         lat1 = search.specificDataString(nodelist, search.template(nodelist, "City"), city1Index, "Latitude");
         long1 = search.specificDataString(nodelist, search.template(nodelist, "City"), city1Index, "Longitude");

          int city2Index = search.binarySearch(search.template(nodelist,"City"), city2);

         lat2 = search.specificDataString(nodelist, search.template(nodelist, "City"), city2Index, "Latitude");
         long2 = search.specificDataString(nodelist, search.template(nodelist, "City"), city2Index, "Longitude");

          latitude1 = Double.parseDouble(lat1);
           longitude1 = Double.parseDouble(long1);

       latitude2 = Double.parseDouble(lat2);
       longitude2 = Double.parseDouble(long2);

     //   latitude1 = getNodeValue(nodelist, index1, "Latitude");
    //    latitude2 = getNodeValue(nodelist, index2, "Latitude");
     //   longitude1 = getNodeValue(nodelist, index1, "Longitude");
      //  longitude2 = getNodeValue(nodelist, index2, "Longitude");

      answer = haversine(latitude1, longitude1, latitude2, longitude2);
      DecimalFormat df = new DecimalFormat("#");
       String distance  = (df.format(answer));


      System.out.println("\n");
      System.out.println("The distance from " + city1 + " to " + city2 + " is " +  distance + " miles.");
       System.out.println("\n");
       System.out.println("\n");
      return null;
   }
}

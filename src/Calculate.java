/**
 * Created by davidgudeman on 7/13/15.
 */

import org.w3c.dom.NodeList;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Calculate
{
    Double RADIUS = 3959.0;



    public Calculate()
    {
    }

    public String haversine(Gen<Double> dlatitude1, Gen<Double>  dlongitude1, Gen<Double>  dlatitude2, Gen<Double>  dlongitude2)
    {
        String answer;
        double lat1 = dlatitude1.getob().doubleValue();
        double lat2 = dlatitude2.getob().doubleValue();
        double long1 = dlongitude1.getob().doubleValue();
        double long2 = dlongitude2.getob().doubleValue();


        double dLatitude = Math.toRadians(lat2 - lat1);
        double dLongitude = Math.toRadians(long1 - long2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double nA = pow(sin(dLatitude / 2.0), 2.0) + cos(lat1) * cos(lat2) * pow(sin(dLongitude / 2.0), 2.0);
        double nC = 2.0 * atan2(sqrt(nA), sqrt(1.0 - nA));
        double distance = RADIUS * nC;
        int distance1 = (int)Math.round(distance);
        return answer = ""+ distance1;
    }

    public  String getDistance(NodeList nodelist, String city1, String city2)
    {
        Search search = new Search(nodelist);
        String lat1, lat2, long1, long2;
        Gen<Double> latitude1, latitude2, longitude1, longitude2;

        String answer;

        int city1Index = search.binarySearch(search.template(nodelist, "City"), city1);

        lat1 = search.specificDataString(nodelist, search.template(nodelist, "City"), city1Index, "Latitude");
        long1 = search.specificDataString(nodelist, search.template(nodelist, "City"), city1Index, "Longitude");

        int city2Index = search.binarySearch(search.template(nodelist, "City"), city2);

        lat2 = search.specificDataString(nodelist, search.template(nodelist, "City"), city2Index, "Latitude");
        long2 = search.specificDataString(nodelist, search.template(nodelist, "City"), city2Index, "Longitude");

        latitude1 = new Gen<>(Double.parseDouble(lat1));
        longitude1 = new Gen<>(Double.parseDouble(long1));
        latitude2= new Gen<>(Double.parseDouble(lat2));
        longitude2 = new Gen<>(Double.parseDouble(long2));

        answer = haversine(latitude1, longitude1, latitude2, longitude2);
        //DecimalFormat df = new DecimalFormat("#");
        //String distance = (df.format(answer));


        System.out.println("\n");
        System.out.println("The distance from " + city1 + " to " + city2 + " is " + answer + " miles.");
        System.out.println("\n");
        System.out.println("\n");

        return null;
    }
}

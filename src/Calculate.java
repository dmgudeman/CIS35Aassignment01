/**
 * Created by davidgudeman on 7/13/15.
 */

import static java.lang.Math.*;

public class Calculate
{
    double RADIUS = 3959;
    // make this a member function of some class
    double Haversine( double dlatitude1, double dlongitude1, double dlatitude2, double dlongitude2)
    {


        double dLatitude = toRadians(dlatitude2 - dlatitude1);
        double dLongitude = toRadians( dlongitude2-dlongitude1 );
        double nA = pow ( sin( dLatitude/2.0 ), 2.0 ) + cos( toRadians(dlatitude1) ) * cos( toRadians(dlatitude2) ) * pow ( sin( dLongitude/2.0), 2.0 );
        double nC = 2.0 * atan2( sqrt(nA), sqrt( 1.0 - nA ));
        double distance = RADIUS * nC;
        return distance;
    }
}

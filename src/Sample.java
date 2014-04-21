import com.google.protobuf.ExtensionRegistry;
import com.google.transit.realtime.GtfsRealtime;

import java.io.IOException;
import java.net.URL;

import static com.google.transit.realtime.GtfsRealtime.registerAllExtensions;

public class Sample {
    public static void main(String[] args)  {

        try {

            ExtensionRegistry registry = ExtensionRegistry.newInstance();
            registerAllExtensions(registry);
            GtfsRealtime.FeedMessage positions = GtfsRealtime.FeedMessage.parseFrom(
                    new URL("http://gtfs.ovapi.nl/nl/vehiclePositions.pb").openStream(), registry);
            //System.out.println(positions);

            GtfsRealtime.FeedMessage alerts = GtfsRealtime.FeedMessage.parseFrom(
                    new URL("http://gtfs.ovapi.nl/nl/alerts.pb").openStream(), registry);
            System.out.println(alerts.getHeader());
            System.out.println(alerts);

            Object updates = GtfsRealtime.FeedMessage.parseFrom(
                    new URL("http://gtfs.ovapi.nl/nl/tripUpdates.pb").openStream(), registry);
            //System.out.println(updates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

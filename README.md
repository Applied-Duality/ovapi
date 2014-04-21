ovapi
=====

Procompiled Java code for accessing `GtfsRealtime` and `ovapi`. 

```java
public static void main(String[] args)  {
      try {

            ExtensionRegistry registry = ExtensionRegistry.newInstance();
            registerAllExtensions(registry);
            
            GtfsRealtime.FeedMessage positions = GtfsRealtime.FeedMessage.parseFrom(
                    new URL("http://gtfs.ovapi.nl/nl/vehiclePositions.pb").openStream(), registry);
            System.out.println(positions);

            GtfsRealtime.FeedMessage alerts = GtfsRealtime.FeedMessage.parseFrom(
                    new URL("http://gtfs.ovapi.nl/nl/alerts.pb").openStream(), registry);
            System.out.println(alerts.getHeader());
            System.out.println(alerts);

            Object updates = GtfsRealtime.FeedMessage.parseFrom(
                    new URL("http://gtfs.ovapi.nl/nl/tripUpdates.pb").openStream(), registry);
            System.out.println(updates);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

*  https://developers.google.com/transit/gtfs-realtime/
*  http://ovapi.nl/
        

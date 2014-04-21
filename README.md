ovapi
=====

Procompiled Java code for accessing `GtfsRealtime` and `ovapi`.

This is an *extreme programming* style hack to do the mininal thing that appears to work.
It is sad that the documentation at https://developers.google.com/transit/gtfs-realtime/
does not contain any information on how to consume the data from Java,
and instead assumes that the developer digs through the protobuf docs https://developers.google.com/protocol-buffers/docs/javatutorial by herself.

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

* https://developers.google.com/transit/gtfs-realtime/
* https://developers.google.com/protocol-buffers/docs/javatutorial
* http://ovapi.nl/
* https://groups.google.com/forum/#!forum/openov
        

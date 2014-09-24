package us.pdavidson.jersey;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("resources")
public class MyApplication  extends ResourceConfig {
    public MyApplication() {
        packages("us.pdavidson.jersey");
    }
}

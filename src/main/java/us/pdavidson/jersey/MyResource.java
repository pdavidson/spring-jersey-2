package us.pdavidson.jersey;

import us.pdavidson.jersey.spring.MySpringBean;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
@Singleton
public class MyResource {
    private final MySpringBean springBean;

    @Inject
    public MyResource(MySpringBean springBean){
        this.springBean = springBean;
    }

    @GET
    @Path("{name}")
    public String hello(@PathParam("name")String name){
        return springBean.sayHello(name);
    }
}

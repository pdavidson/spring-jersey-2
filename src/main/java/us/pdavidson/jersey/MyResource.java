package us.pdavidson.jersey;

import rx.functions.Action1;
import us.pdavidson.jersey.spring.MySpringBean;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.List;

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
        String first = springBean.friends().toBlocking().first();
        return first;
    }

    @GET
    @Path("{name}/friends")
    public void asynch(@Suspended final AsyncResponse asyncResponse){
        springBean.friends().buffer(3).subscribe(new Action1<List<String>>() {
            @Override
            public void call(List<String> s) {
                System.out.println("s = [" + s + "]");
                asyncResponse.resume(s.toString());
            }
        });
    }

}

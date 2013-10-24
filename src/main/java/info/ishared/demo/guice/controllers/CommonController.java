package info.ishared.demo.guice.controllers;

import com.google.inject.Inject;
import com.google.inject.servlet.RequestScoped;
import com.sun.jersey.api.view.Viewable;
import info.ishared.demo.guice.services.HelloWorld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Seven
 * Date: 13-10-23
 * Time: PM4:30
 */
@RequestScoped

@Path("/")
public class CommonController {

    @Inject private HelloWorld helloWorld;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String index(){
        return "I am Index page";
    }

    @GET
    @Path("user/{userId}/{userName}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("userId") String userId,
                          @PathParam("userName") String userName) {
        helloWorld.sayHello(userName);
        return "User ID: " + userId + ", user name: " + userName;
    }

    @GET
    @Path("jsp")
    @Produces(MediaType.TEXT_HTML)
    public Response getJsp() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("msg", "Hello World!");
        return Response.ok(new Viewable("/views/test.jsp", model))
                .build();
    }
}
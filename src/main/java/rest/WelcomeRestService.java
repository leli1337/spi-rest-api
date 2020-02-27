package rest;


import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.HashMap;

@Path("welcome")
public class WelcomeRestService {
    @Context
    private HttpServletRequest request;

    @GET
    @Produces("text/plain")
    public Response getWelcomeMessage() {
        try {
            return Response.status(Response.Status.OK).entity("Hello rest is ready and DB Conncetion OK!").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getCause().toString()).build();
        }
    }

}
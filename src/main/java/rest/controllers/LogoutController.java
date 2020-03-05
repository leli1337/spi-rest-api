package rest.controllers;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import DB.UserDAO;

@Path("logout")
public class LogoutController {

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@HeaderParam("Authorization") String token) {

        try {
            UserDAO.logout(token);
            return Response.status(Response.Status.OK).entity("").build();
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getCause().toString()).build();
        }
    }
}

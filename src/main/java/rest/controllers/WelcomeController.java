package rest.controllers;


import com.google.gson.GsonBuilder;
import rest.entities.User;
import rest.entities.resource.UserResource;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

@Path("welcome")
public class WelcomeController {

    @Context
    private HttpServletRequest request;

    @GET
    @Produces("application/json")
    public Response getUsers() throws Exception {


            return Response.status(Response.Status.OK).entity("ok").build();

    }
}
package rest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import DB.UserDAO;
import com.google.gson.Gson;
import models.UserModel;

import java.io.IOException;
import java.util.ArrayList;

@Path("login")
public class LoginController {
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodo() {
        return Response.status(Response.Status.CONFLICT).entity("test").build();
    }

    @Path("/user")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("username") String username, @QueryParam("password") String password) {

        try {
            if(UserDAO.login(username, password)){
                UserModel user = UserDAO.getUser();

                Gson gson = new Gson();
                String userJson = gson.toJson(user);
                return Response.status(Response.Status.OK).entity(userJson).build();
            }else{
                return Response.status(Response.Status.UNAUTHORIZED).entity("Username or password wrong!").build();
            }
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.CONFLICT).entity(e.getCause().toString()).build();
        }
    }
}

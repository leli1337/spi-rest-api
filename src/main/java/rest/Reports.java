package rest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import DB.ReportDAO;
import org.codehaus.jettison.json.JSONArray;

@Path("report")
public class Reports {
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@QueryParam("category") String category, @QueryParam("product") String product) {

        try {
            JSONArray data = ReportDAO.getReportData();
            return Response.status(Response.Status.OK).entity(data).build();
        }catch (Exception e){
            return Response.status(Response.Status.CONFLICT).entity(e.getCause().toString()).build();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AntrianHelper;
import helper.LocationHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Antrian;
import pojos.Location;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("location")
public class LocationResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LocationResource
     */
    public LocationResource() {
    }

    /**
     * Retrieves representation of an instance of service.LocationResource
     * @return an instance of java.lang.String
     */
    @GET   
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        LocationHelper test = new LocationHelper();
        List<Location> list = test.getAllLocation();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of LocationResource
     * @param content representation for the resource
     */
    @POST
    @Path("addLocation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewLocation(String data){
        Gson gson = new Gson();                 
        Location location = gson.fromJson(data, Location.class);
        LocationHelper helper = new LocationHelper();
        helper.addNewLocation(location.getLat(),
                location.getLng(),
                location.getName());
        return Response
                .status(200)
                .entity(location)
                .build();
    }
}

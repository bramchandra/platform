/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AntrianHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Antrian;


/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("antrian")
public class AntrianResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AntrianResource
     */
    public AntrianResource() {
    }

    /**
     * Retrieves representation of an instance of service.AntrianResource
     * @return an instance of java.lang.String
     */
    @GET   
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        AntrianHelper test = new AntrianHelper();
        List<Antrian> list = test.getAllAntrian();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of AntrianResource
     * @param content representation for the resource
     */
    @POST
    @Path("addAntrian")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewAntrian(String data){
        Gson gson = new Gson();
        Antrian antrian = gson.fromJson(data, Antrian.class);            
        AntrianHelper helper = new AntrianHelper();
        helper.addNewAntrian(antrian.getTanggal(),
                antrian.getNoRm(),
                antrian.getNama(),
                antrian.getAlamat(),
                antrian.getNamaKlinik());
        return Response
                .status(200)
                .entity(antrian)
                .build();
    }
}

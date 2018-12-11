/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.DokterHelper;
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
import pojos.Dokter;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("dokter")
public class DoktorResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DoktorResource
     */
    public DoktorResource() {
    }

    /**
     * Retrieves representation of an instance of service.DoktorResource
     * @return an instance of java.lang.String
     */
    @GET   
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        DokterHelper test = new DokterHelper();
        List<Dokter> list = test.getAllDokter();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of DoktorResource
     * @param content representation for the resource
     */
    @POST
    @Path("addDokter")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewDokter(String data){
        Gson gson = new Gson();
        Dokter dokter = gson.fromJson(data, Dokter.class);            
        DokterHelper helper = new DokterHelper();
        helper.addNewDokter(dokter.getNama(),
                dokter.getSpesialis());
        return Response
                .status(200)
                .entity(dokter)
                .build();
    }
}

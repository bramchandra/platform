/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.DokterHelper;
import helper.KlinikHelper;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pojos.Dokter;
import pojos.Klinik;

/**
 * REST Web Service
 *
 * @author danielbram
 */
   @Path("klinik")

public class DokterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DokterResource
     */
    public DokterResource() {
    }

    /**
     * Retrieves representation of an instance of service.DokterResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonKlinik() {
        //TODO return proper representation object
        KlinikHelper test = new KlinikHelper();
        List<Klinik> list = test.getAllPasien();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of DokterResource
     * @param content representation for the resource
     */
    @GET
    @Path("dokter")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    
    public Response getJson() {
        //TODO return proper representation object
        DokterHelper test = new DokterHelper();
        List<Dokter> list = test.getAllPasien();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }
}

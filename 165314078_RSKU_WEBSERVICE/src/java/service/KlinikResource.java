/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import helper.AntrianHelper;
import helper.KlinikHelper;
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
import pojos.Klinik;

/**
 * REST Web Service
 *
 * @author danielbram
 */
@Path("klinik")
public class KlinikResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of KlinikResource
     */
    public KlinikResource() {
    }

    /**
     * Retrieves representation of an instance of service.KlinikResource
     * @return an instance of java.lang.String
     */
    @GET   
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        KlinikHelper test = new KlinikHelper();
        List<Klinik> list = test.getAllKlinik();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return Response
                .status(200)
                .entity(json)
                .build();
    }

    /**
     * PUT method for updating or creating an instance of KlinikResource
     * @param content representation for the resource
     */
    @POST
    @Path("addKlinik")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewKlinik(String data){
        Gson gson = new Gson();
        Antrian antrian = gson.fromJson(data, Antrian.class);            
        Klinik klinik = gson.fromJson(data, Klinik.class);        
        KlinikHelper helper = new KlinikHelper();
        helper.addNewKlinik(klinik.getIdKlinik(),
                klinik.getNama(),
                klinik.getSpesialis());
        return Response
                .status(200)
                .entity(klinik)
                .build();
    }
}

package com.example.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.example.controller.dao.services.Familiaservices;
import com.google.gson.Gson;

import java.util.HashMap;

@Path("censo")
public class CensoService {
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCenso() {
        HashMap<String, Object> map = new HashMap<>();
        Familiaservices ps = new Familiaservices();
        map.put("msg", "OK");
        map.put("data", ps.listAll().toArray());
        if(ps.listAll().isEmpty()){
           map.put("data", new Object[]{});
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }
        return Response.ok(map).build();
    }


  


    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFamilias(@PathParam("id") Integer id){
        HashMap<String, Object>  map = new HashMap<>();
        Familiaservices ps = new Familiaservices();
        try {

        ps.setFamilia(ps.get(id));
        } catch (Exception e) {

        }
        map.put("msg", "OK");
        map.put("data", ps.getFamilia());

        if(ps.getFamilia().getId() == null){
            map.put("data", "Familia no encontrada o no existe");
            return Response.status(Status.BAD_REQUEST).entity(map).build();
        }

        return Response.ok(map).build();    
    }




    @Path("/listCombustible")
    @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getType() {
        HashMap<String, Object>  map = new HashMap<>();
         Familiaservices ps = new Familiaservices();
         map.put("msg","OK");
         map.put("data", ps.getCombustibles());
         return Response.ok(map).build();
         
     }
     

         @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(HashMap<String, Object> map){
        // todo
        //VALIDATIONS -- bad request
        HashMap<String, Object>  res = new HashMap<>();
        Gson g = new Gson();
        String a =  g.toJson(map);
        System.out.println("**********" + a);

    try {
        Familiaservices ps = new Familiaservices();
        ps.getFamilia().setApellido(map.get("apellido").toString());
        ps.getFamilia().setDireccion(map.get("direccion").toString());
        ps.getFamilia().setTelefono(map.get("telefono").toString());
        ps.getFamilia().setUso(map.get("uso").toString());
        ps.getFamilia().setCombustible(ps.getCombustibles(map.get("combustible").toString()));
        ps.getFamilia().setConsumo((Float.parseFloat(map.get("consumo").toString())));
        ps.getFamilia().setCosto((Float.parseFloat(map.get("costo").toString())));
        ps.getFamilia().setEnergiagenerada_KW((Float.parseFloat(map.get("energia_generada_KW").toString())));
    
        
            ps.save();
            res.put("msg", "OK");
            res.put("data", "Familia  guardada correctamente");
            return Response.ok(res).build();


        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
            res.put("msg", "ERROR");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }

    }




       @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(HashMap<String, Object> map){
        // todo
        //VALIDATIONS -- bad request
        HashMap<String, Object>  res = new HashMap<>();
      

    try {
        Familiaservices ps = new Familiaservices();
        ps.getFamilia().setId(Integer.parseInt(map.get("id").toString()));
        ps.getFamilia().setApellido(map.get("apellido").toString());
        ps.getFamilia().setDireccion(map.get("direccion").toString());
        ps.getFamilia().setTelefono(map.get("telefono").toString());
        ps.getFamilia().setUso(map.get("uso").toString());
        ps.getFamilia().setCombustible(ps.getCombustibles(map.get("combustible").toString()));
        ps.getFamilia().setConsumo((Float.parseFloat(map.get("consumo").toString())));
        ps.getFamilia().setCosto((Float.parseFloat(map.get("costo").toString())));
        ps.getFamilia().setEnergiagenerada_KW((Float.parseFloat(map.get("energia_generada_KW").toString())));
        
            ps.update();
            res.put("msg", "OK");
            res.put("data", "Familia  guardada correctamente");
            return Response.ok(res).build();


        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
            res.put("msg", "ERROR");
            res.put("data", e.toString());
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(res).build();
        }

    }



}


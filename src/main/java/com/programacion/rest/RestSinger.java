package com.programacion.rest;

import com.programacion.db.Singer;
import com.programacion.servicios.ServicioSinger;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.Getter;

import java.util.List;


@Path("/singers")
@ApplicationScoped
public class RestSinger {

    //DI
    @Inject private ServicioSinger servicio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Singer> findAll(){
        return servicio.findAll();
    }
}

package com.guaxinim.nature.api;

import com.guaxinim.nature.domain.Object;
import com.guaxinim.nature.service.ObjectService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/")
public class ObjectRest {

    Logger log = Logger.getLogger(ActionRest.class.getName());

    @EJB
    ObjectService objectService;

    @GET
    @Path("object/{id}")
    @Produces("application/json")
    public Object getObject(@PathParam("id") String id) {
        Integer param = Integer.valueOf(id);
        //Object object = objectService.getObject(param);
        return null;
    }

    @GET
    @Path("objects")
    @Produces("application/json")
    public Iterable<Object> getObjects() {
        return objectService.getObjects();
    }

    @POST
    @Path("object")
    @Consumes("application/json")
    public Response insertObject(Object object) {
        objectService.insertObject(object);
        return Response.status(Response.Status.CREATED).entity("Object created").build();
    }

    @DELETE
    @Path("object/{id}")
    @Produces("application/json")
    public Response removeObject(@PathParam("id") String id) {
        Integer param = Integer.valueOf(id);
        //objectService.removeObject(param);
        return Response.status(Response.Status.OK).entity("Object removed").build();
    }
}

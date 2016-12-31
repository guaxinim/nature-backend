package com.guaxinim.nature.api;

import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.service.ActionService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/rest")
public class ActionRest {

    Logger log = Logger.getLogger(ActionRest.class.getName());

    @EJB
    ActionService actionService;

    @GET
    @Path("action/{id}")
    @Produces("application/json")
    public Action getAction(@PathParam("id") String id) {
        return actionService.getAction("id", Long.parseLong(id));
    }

    @GET
    @Path("actions")
    @Produces("application/json")
    public List<Action> getActions() {
        return (List<Action>) actionService.getActions();
    }

    @POST
    @Path("action")
    @Consumes("application/json")
    public Response insertAction(Action action) {
        actionService.insertAction(action);
        return Response.status(Response.Status.CREATED).entity("Action created").build();
    }

    @DELETE
    @Path("action/{id}")
    @Produces("application/json")
    public Response removeAction(@PathParam("id") String id) {
        actionService.deleteAction(Long.parseLong(id));
        return Response.status(Response.Status.OK).entity("Action removed").build();
    }
}

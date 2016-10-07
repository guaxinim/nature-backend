package com.guaxinim.nature.api;

import com.guaxinim.nature.domain.Action;
import com.guaxinim.nature.service.ActionService;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/")
public class ActionRest {

    Logger log = Logger.getLogger(ActionRest.class.getName());

    @EJB
    ActionService actionService;

    @GET
    @Path("action/{id}")
    @Produces("application/json")
    public Action getAction(@PathParam("id") String id) {
        Integer param = Integer.valueOf(id);
        //Action action = actionService.getAction(param);
        return null;
    }

    @GET
    @Path("actions")
    @Produces("application/json")
    public List<Action> getActions() {
        //List<Action> actions = actionService.getActions();
        return null;
    }

    @POST
    @Path("action")
    @Consumes("application/json")
    public Response insertAction(Action action) {
        //actionService.insertAction(action);
        return Response.status(Response.Status.CREATED).entity("Action created").build();
    }

    @DELETE
    @Path("action/{id}")
    @Produces("application/json")
    public Response removeAction(@PathParam("id") String id) {
        Integer param = Integer.valueOf(id);
        //actionService.removeAction(param);
        return Response.status(Response.Status.OK).entity("Action removed").build();
    }
}

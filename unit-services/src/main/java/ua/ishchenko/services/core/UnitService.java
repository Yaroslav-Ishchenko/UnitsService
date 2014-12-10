package ua.ishchenko.services.core;

import ua.ishchenko.common.UnitServiceCommon;
import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.services.core.units.Grenadier;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public interface UnitService extends UnitServiceCommon{

    @POST
    @Path("/add")
    @Produces("application/json")
    Response addUnit(@QueryParam("unit")Grenadier unit);/*add single user*/

    @GET
    @Produces("application/json")
    Response getUnits();/*get the whole list of users*/

    @GET
    @Produces("application/json")
    @Path("/{id}")
    Response getUnit(@PathParam("id")String id);/*get the user*/

    @PUT
    @Produces("application/json")
    @Path("/{id}")
    Response updateUnit(@PathParam("id") String id, @QueryParam("unit")Grenadier unit);/*if exists update the user if not just error*/

    @DELETE
    @Produces("application/json")
    Response deleteUnits();/*delete all units*/

    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    Response deleteUnit(@PathParam("id")String id);/*delete the user*/
}

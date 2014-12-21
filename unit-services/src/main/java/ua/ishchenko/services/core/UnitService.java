package ua.ishchenko.services.core;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ua.ishchenko.common.UnitServiceCommon;
import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.services.core.units.Grenadier;

@Path("/")
public interface UnitService extends UnitServiceCommon{

    /**
     * Add single user
     * @param unit
     * @return
     */
    @PUT
    @Path("items/")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    Response addUnit(Unit unit);

    @GET
    @Path("items/")
    @Produces({ MediaType.APPLICATION_JSON })
    Response getUnits();/*get the whole list of users*/

    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("items/{id}/")
    Response getUnit(@PathParam("id")String id);/*get the user*/

    @POST
    @Path("items/")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    Response updateUnit(Unit unit);/*if exists update the user if not just error*/

    @DELETE
    @Path("items/")
    @Produces({ MediaType.APPLICATION_JSON })
    Response deleteUnits();/*delete all units*/

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("items/{id}/")
    Response deleteUnit(@PathParam("id")String id);/*delete the user*/
}

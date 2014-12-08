package ua.ishchenko.services.core;

import ua.ishchenko.common.UnitServiceCommon;
import ua.ishchenko.common.jaxb.converters.JaxbList;
import ua.ishchenko.common.unit.Unit;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public interface UnitService extends UnitServiceCommon{

    @POST
    @Path("/add/{unit}")
    @Produces("application/xml")
    Response addUnit(@PathParam("unit")Unit unit);/*add single user*/

    @GET
    @Produces("application/xml")
    JaxbList getUnits();/*get the whole list of users*/
    @GET
    @Produces("application/xml")
    @Path("/{id}")
    Unit getUnit(@PathParam("id")String id);/*get the user*/

    @PUT
    @Produces("application/xml")
    @Path("/{unit}")
    Response updateUnit(@PathParam("unit")Unit unit);/*if exists update the user if not just error*/

    @DELETE
    @Produces("application/xml")
    Response deleteUnits();/*delete all units*/

    @DELETE
    @Produces("application/xml")
    @Path("/{id}")
    Response deleteUnit(@PathParam("id")String name);/*delete the user*/
}

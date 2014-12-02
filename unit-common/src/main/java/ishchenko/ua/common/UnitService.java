package ishchenko.ua.common;

import ishchenko.ua.common.unit.Unit;

import javax.ws.rs.*;
import javax.xml.ws.Response;
import java.util.List;

@Path("/units/v1")
public interface UnitService {

    @POST
    @Path("/add/{unit}")
    @Produces("application/xml")
    Response addUnit(@PathParam("unit")Unit unit);/*add single user*/

    @GET
    @Produces("application/xml")
    List getUnits();/*get the whole list of users*/
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

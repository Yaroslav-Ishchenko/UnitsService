package ua.units.services.impl.interfaces;

import ua.ishchenko.unit.Unit;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Yaroslav on 11/26/2014.
 */

@Path("/units/v1")
public class UnitServiceImpl implements UnitService {
    @Override
    @POST
    @Path("/add")
    public void addUnits(@PathParam("list")List<Unit> list) {
        return Response.status(200)
                .entity("addUnits is called").build();

    }

    @Override
    public void addUnit(Unit unit) {

    }

    @Override
    public List getUnits() {
        return null;
    }

    @Override
    public Unit getUnit(String s) {
        return null;
    }

    @Override
    public void updateUnit(Unit unit) {

    }

    @Override
    public void deleteUnits() {

    }

    @Override
    public void deleteUnit(String s) {

    }
}

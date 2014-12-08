package ua.ishchenko.services.core;

import ua.ishchenko.common.jaxb.converters.JaxbList;
import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.services.core.units.Grenader;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 11/26/2014.
 */


public class UnitServiceImpl implements UnitService {

    @Override
    public Response addUnit(Unit unit) {
        return null;
    }

    @Override
    public JaxbList getUnits() {

        ArrayList <Unit> str = new ArrayList<Unit>();
        Unit unit= new Grenader();
        str.add(unit);
        //return Response.ok(new GenericEntity<ArrayList<Unit>>(str) {}).build();
        return new JaxbList(str);
    }

    @Override
    public Unit getUnit(String id) {
        return null;
    }

    @Override
    public Response updateUnit(Unit unit) {
        return null;
    }

    @Override
    public Response deleteUnits() {
        return null;
    }

    @Override
    public Response deleteUnit(String name) {
        return null;
    }
}

package ua.ishchenko.services.core;

import ua.ishchenko.common.unit.Unit;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 11/26/2014.
 */


public class UnitServiceImpl implements UnitService {

    @Override
    public Response addUnit(Unit unit) {
        return null;
    }

    @Override
    public List getUnits() {
        List <String> str = new ArrayList<String>();
        str.add("adasd");
        return str;
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

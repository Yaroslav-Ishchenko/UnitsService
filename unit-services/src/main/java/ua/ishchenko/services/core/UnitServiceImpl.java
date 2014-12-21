package ua.ishchenko.services.core;

import com.mongodb.DBCollection;
import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.services.core.units.Grenadier;
import ua.ishchenko.services.core.weapons.Scythe;
import ua.ishchenko.services.mongo.db.MongoOperational;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 11/26/2014.
 */


public class UnitServiceImpl implements UnitService {

    List<Unit> unitList;
    MongoOperational mongo;
    DBCollection collection;

    public UnitServiceImpl() {
       mongo = new MongoOperational();
        collection = mongo.getMongoDb().getDb().getCollection("Units");

        unitList = new ArrayList<Unit>();
     /*   unitList.add(new Grenadier());
        unitList.add(new Grenadier("Vasya", new Scythe()));
        unitList.add(new Grenadier("Lancelot", new Scythe()));
        unitList.add(new Grenadier("Artur", new Scythe()));
        mongo.removeAll(collection);*/
        unitList = mongo.toUnitList(collection.find());
        //collection = mongo.fromUnitList(unitList, collection);
    }

    @Override
    public Response addUnit(Unit unit) {
        Grenadier grn = null;
        if (unit instanceof Grenadier)
            grn = (Grenadier) unit;

        try {
            unitList.add(unit);
        } catch (Exception ex) {
            return Response.notModified(ex.getMessage()).build();
        }
        return Response.ok(new GenericEntity<Grenadier>(grn) {
        }).build();
    }

    @Override
    public Response getUnits() {

        List<Grenadier> list = new ArrayList<>();
        for (Unit unit : unitList) {
            if (unit instanceof Grenadier)
                list.add((Grenadier) unit);
        }
        return Response.ok(new GenericEntity<List<Grenadier>>(list) {
        }).build();
    }

    @Override
    public Response getUnit(String id) {
        Grenadier tmp = null;
        for (Unit gr : unitList) {
            if (gr.getName().equals(id) && gr instanceof Grenadier) {
                tmp = (Grenadier)gr;
            }
        }
        return Response.ok(new GenericEntity<Grenadier>(tmp) {
        }).build();
    }

    @Override
    public Response updateUnit(Unit unit) {

        for (Unit gr : unitList) {
            if (gr.getName().equals(unit.getName())) {
                unitList.remove(gr);
                unitList.add(unit);
                return Response.ok().build();
            }
        }
        return Response.notModified().build();
    }

    @Override
    public Response deleteUnits() {
        unitList.clear();
        if (unitList.size() == 0)
            return Response.ok(new GenericEntity<String>("All are deleted") {
            }).build();
        else
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }

    @Override
    public Response deleteUnit(String id) {
        for (Unit gr : unitList) {
            if (gr.getName().equals(id)) {
                unitList.remove(gr);
                return Response.ok(new GenericEntity<String>("deleted") {
                }).build();
            }
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}

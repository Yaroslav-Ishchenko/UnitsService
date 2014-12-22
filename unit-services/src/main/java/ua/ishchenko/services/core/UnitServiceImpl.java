package ua.ishchenko.services.core;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.services.core.units.Grenadier;
import ua.ishchenko.services.core.weapons.Scythe;
import ua.ishchenko.services.mongo.db.MongoDB;
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
    MongoOperational mongoOperational;
    MongoDB db;
   public UnitServiceImpl(MongoDB db){
       this.db = db;
       mongoOperational = new MongoOperational();
       DBCollection collection = db.getDb().getCollection("Units");
       unitList = new ArrayList<Unit>();
        collection = mongoOperational.fromUnitList(unitList, collection);
         DBCursor dbCur = collection.find();
       unitList = mongoOperational.toUnitList(dbCur);
    }
    @Override
    public Response addUnit(Unit unit) {
        return null;
    }
    @Override
    public Response updateUnit(Unit unit) {
        return null;
    }
    @Override
    public Response addUnit(Grenadier unit) {
        try {
            unitList.add(unit);
        }catch (Exception ex){
            return Response.notModified(ex.getMessage()).build();
        }
        return Response.ok(new GenericEntity<Grenadier>(unit) {}).build();
    }

    @Override
    public Response getUnits() {
        ArrayList<Grenadier> list = new ArrayList<Grenadier>();
        for(Unit unit : unitList)
        {
            if(unit instanceof Grenadier)
            {
                list.add((Grenadier)unit);
            }
        }

        return Response.ok(new GenericEntity<ArrayList<Grenadier>>(list) {}).build();
    }

    @Override
    public Response getUnit(String id) {
        Grenadier tmp = null;
        for(Unit gr: unitList){
            if(gr instanceof Grenadier && ((Grenadier)gr).getName().equals(id))
                tmp= (Grenadier)gr;
        }
        return Response.ok(new GenericEntity<Grenadier>(tmp) {}).build();
    }

    @Override
    public Response updateUnit(Grenadier unit) {
        for(Unit gr: unitList){
            if(gr instanceof Grenadier && ((Grenadier)gr).getName().equals(unit.getName())) {
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
        if(unitList.size()==0)
            return Response.ok(new GenericEntity<String>("All are deleted") {
            }).build();
        else
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }

    @Override
    public Response deleteUnit(String id) {
        for(Unit gr: unitList){
            if(gr instanceof Grenadier && ((Grenadier)gr).getName().equals(id))
            {
                unitList.remove(gr);
                return Response.ok(new GenericEntity<String>("deleted") {
                }).build();
            }
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}

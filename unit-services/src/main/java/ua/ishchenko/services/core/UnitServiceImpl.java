package ua.ishchenko.services.core;

import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.common.weapon.Weapon;
import ua.ishchenko.services.core.units.Grenadier;
import ua.ishchenko.services.core.weapons.Scythe;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by Yaroslav on 11/26/2014.
 */


public class UnitServiceImpl implements UnitService {

    ArrayList <Grenadier> str;

   public UnitServiceImpl(){

        str = new ArrayList<Grenadier>();
        str.add(new Grenadier());
        str.add(new Grenadier("Vasya", new Scythe()));
        str.add(new Grenadier("Lancelot", new Scythe()));
        str.add(new Grenadier("Artur", new Scythe()));
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
            str.add(unit);
        }catch (Exception ex){
            return Response.notModified(ex.getMessage()).build();
        }
        return Response.ok(new GenericEntity<Grenadier>(unit) {}).build();
    }

    @Override
    public Response getUnits() {


        return Response.ok(new GenericEntity<ArrayList<Grenadier>>(str) {}).build();
    }

    @Override
    public Response getUnit(String id) {
        Grenadier tmp = null;
        for(Grenadier gr: str){
            if(gr.getName().equals(id))
                tmp= gr;
        }
        return Response.ok(new GenericEntity<Grenadier>(tmp) {}).build();
    }

    @Override
    public Response updateUnit(String id, Grenadier unit) {
        for(Grenadier gr: str){
            if(gr.getName().equals(id)) {
                gr = unit;
                return Response.ok().build();
            }
        }
        return Response.notModified().build();
    }

    @Override
    public Response deleteUnits() {
        str.clear();
        if(str.size()==0)
            return Response.ok(new GenericEntity<String>("All are deleted") {
            }).build();
        else
            return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }

    @Override
    public Response deleteUnit(String id) {
        for(Grenadier gr: str){
            if(gr.getName().equals(id))
            {
                str.remove(gr);
                return Response.ok(new GenericEntity<String>("deleted") {
                }).build();
            }
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).build();
    }
}

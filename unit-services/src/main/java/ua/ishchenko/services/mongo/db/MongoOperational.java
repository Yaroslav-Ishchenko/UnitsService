package ua.ishchenko.services.mongo.db;

import com.mongodb.*;
import ua.ishchenko.common.unit.Unit;
import ua.ishchenko.common.weapon.Weapon;
import ua.ishchenko.services.core.units.Grenadier;
import ua.ishchenko.services.core.weapons.Scythe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Jaros on 12/20/2014.
 */
public class MongoOperational {
    MongoDB db;
    MongoOperational() {
        db = MongoDB.getMongoDBInstance("warriors");
      // Set<String> set = db.getDb().getCollectionNames();
      //  db.getDb().getMongo().getDatabaseNames();
//        System.out.println(db.getDb().);
    }
    public DBCollection fromUnitList(List<Unit> units, DBCollection collection)
    {
        for(Unit unit : units)
        {
            collection.insert(fromUnit(unit));
        }
        return collection;
    }
    public DBObject fromUnit(Unit unit)
    {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("unitname", unit.getName());

        DBObject weapon = new BasicDBObject();
        weapon.put("weaponname", unit.getWeapon().getName());
        weapon.put("weaponsharpness", unit.getWeapon().isSharp());
        dbObject.put("weapon", weapon);
        return dbObject;
    }
    public Unit toUnit(DBObject dbo)
    {
        Unit unit = new Grenadier();
        Weapon wep = new Scythe();
        unit.setName((String)dbo.get("unitname"));
        wep.setName((String) dbo.get("weaponname"));
        wep.setSharp((boolean) dbo.get("weaponsharpness"));
        unit.setWeapon(wep);
        return unit;
    }
    public List<Unit> toUnitList(DBCursor dbc) {
        List<Unit> answer = new LinkedList<>();

        while (dbc.hasNext()) {
            answer.add(toUnit(dbc.next()));
        }
        return answer;
    }
    public MongoDB getDb() {
        return db;
    }

    public void setDb(MongoDB db) {
        this.db = db;
    }
    public static void main(String []args)
    {
       /* List<Unit> units = new LinkedList<Unit>();*/
       /* Scythe wep = new Scythe();
        wep.setName("Izolda");
        units.add(new Grenadier("Yarik", wep));
        units.add(new Grenadier("Oslo", wep));
        units.add(new Grenadier("Bolek", wep));*/

        MongoOperational mongo = new MongoOperational();
        DBCollection collection = mongo.db.getDb().getCollection("units");
        DBCursor cursorDoc = collection.find();
    }
}

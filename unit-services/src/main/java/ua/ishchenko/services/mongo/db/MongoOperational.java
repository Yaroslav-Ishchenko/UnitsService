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
    MongoDB mongoDb;

   public MongoOperational() {
        mongoDb = MongoDB.getMongoDBInstance("warriors");
        // Set<String> set = db.getDb().getCollectionNames();
        //  db.getDb().getMongo().getDatabaseNames();
//        System.out.println(db.getDb().);
    }

    /*public static void main(String[] args) {
        List<Unit> units = new LinkedList<Unit>();
        Scythe wep = new Scythe();
        wep.setName("Izolda");
        units.add(new Grenadier("Yarik", wep));
        units.add(new Grenadier("Oslo", wep));
        units.add(new Grenadier("Bolek", wep));

        MongoOperational mongo = new MongoOperational();
        DBCollection collection = mongo.mongoDb.getDb().getCollection("Units");
        mongo.removeAll(collection);
        collection = mongo.fromUnitList(units, collection);
        *//*mongo.remove(collection);*//*
        DBCursor cursorDoc = collection.find();
        System.out.println("before update");
        while (cursorDoc.hasNext()) {
            DBObject obj = cursorDoc.next();
            System.out.println(obj);
            *//*collection.remove(obj);*//*
        }

    }*/

    public void removeAll(DBCollection collection) {
        collection.remove(new BasicDBObject());//removes all the records from the collection
//        collection.drop();//It deletes the entire documents and drop the collection.
    }

    public void removeUnit(Unit unit, DBCollection collection) {
        DBObject document = new BasicDBObject();
        document.put("unitId", unit.getUnitId());
        WriteResult result = collection.remove(document);
        System.out.println("Number of documents are deleted : " + result.getN());//shouldn't reach more than 1 because the ID must be unique
    }

    public void updateUnit(Unit unit, DBCollection collection) {
        DBObject query = new BasicDBObject().append("unitId", unit.getUnitId());
        DBObject dbObj = fromUnit(unit);
        collection.update(query, dbObj);
    }

    public DBCollection fromUnitList(List<Unit> units, DBCollection collection) {
        for (Unit unit : units) {
            collection.insert(fromUnit(unit));
        }
        return collection;
    }

    public DBObject fromUnit(Unit unit) {

        DBObject dbObject = new BasicDBObject();
        dbObject.put("unitId", unit.getUnitId());
        dbObject.put("unitname", unit.getName());

        DBObject weapon = new BasicDBObject();
        weapon.put("weaponname", unit.getWeapon().getName());
        weapon.put("weaponsharpness", unit.getWeapon().isSharp());
        dbObject.put("weapon", weapon);
        return dbObject;
    }

    public Unit toUnit(DBObject dbo) {
        Unit unit = new Grenadier();
        Weapon wep = new Scythe();
        unit.setUnitId((long) dbo.get("unitId"));
        unit.setName((String) dbo.get("unitname"));

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

    public MongoDB getMongoDb() {
        return mongoDb;
    }

    public void setMongoDb(MongoDB db) {
        this.mongoDb = db;
    }


}

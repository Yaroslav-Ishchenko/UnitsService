package ua.ishchenko.services.mongo.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Jaros on 12/20/2014.
 */
public class MongoDB {

    private MongoClient mongo;
    private DB db;
    private static String HOST="localhost";
    private static int PORT= 27017;
    private static String DB_NAME="warriors";
/*    private static String userName;
    private static String password;*/

    private MongoDB() {
        try {
            mongo = new MongoClient(Arrays.asList(new ServerAddress(HOST, PORT)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        db = mongo.getDB(DB_NAME);

    }
    static class InnerInitializer {
        private static MongoDB instance = new MongoDB();
    }
    public static MongoDB getMongoDBInstance(String dbName){
        if(dbName!=null&& !dbName.isEmpty())
        {
            DB_NAME = dbName;
        }
        return InnerInitializer.instance;
    }

    public String getDB_NAME() {
        return DB_NAME;
    }

    public void setDB_NAME(String DB_NAME) {
        this.DB_NAME = DB_NAME;
    }

    public DB getDb() {
        return db;
    }

/*    public void setDb(DB db) {
        this.db = db;
    }

    public MongoClient getMongoClient() {
        return mongo;
    }

    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }*/
    public void cleanUpMongoClient()
    {
        mongo.close();
    }
}

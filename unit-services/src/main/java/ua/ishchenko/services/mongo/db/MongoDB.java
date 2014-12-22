package ua.ishchenko.services.mongo.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Creates a connection to database server.
 *
 * Created by Jaros on 12/20/2014.
 */

public class MongoDB {

    private MongoClient mongo;
    private DB db;
    private static String HOST;
    private static int PORT;
    private static String DB_NAME;
    private static Map<String, DB> cash;
    private static Properties properties;

    static {
        cash = new HashMap<>();
        try{


        InputStream inputStream  = MongoDB.class.getClassLoader().getResourceAsStream("mongo.properties");
        properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HOST = properties.getProperty("host", "localhost");
        PORT = Integer.parseInt(properties.getProperty("port", "27017"));
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     *Construct a new DB object if it hasn't been constructed during the worktime, so for every db there should be only one object,
     *starts from the second call to the db with the same name an object will be constructed but with db from the CASHE.
     * @param DB_NAME name of DB that is requested for access, starts from the second call to the db
     *                with <br>the same name</br> an object will be constructed but with db instance from the CASHE.
     */
    public MongoDB(String DB_NAME) {
        try {
            if (mongo == null)
                mongo = new MongoClient(Arrays.asList(new ServerAddress(HOST, PORT)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        if (cash.get(DB_NAME) == null) {
            db = mongo.getDB(DB_NAME);
            cash.put(DB_NAME, db);
        }
        else
        {
            db = cash.get(DB_NAME);
        }

    }
    /*static class InnerInitializer {
        private static MongoDB instance = new MongoDB();
    }
    public static MongoDB getMongoDBInstance(String dbName){
        if(dbName!=null&& !dbName.isEmpty())
        {
            DB_NAME = dbName;
        }
        return InnerInitializer.instance;
    }*/

    public String getDB_NAME() {
        return DB_NAME;
    }

    public void setDB_NAME(String DB_NAME) {
        this.DB_NAME = DB_NAME;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public MongoClient getMongoClient() {
        return mongo;
    }

    public void setMongo(MongoClient mongo) {
        this.mongo = mongo;
    }

    public void cleanUpMongoClient() {
        mongo.close();
    }
    public static String getHOST() {
        return HOST;
    }

    public static void setHOST(String HOST) {
        MongoDB.HOST = HOST;
    }

    public static int getPORT() {
        return PORT;
    }

    public static void setPORT(int PORT) {
        MongoDB.PORT = PORT;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public static void setDbName(String dbName) {
        DB_NAME = dbName;
    }
}

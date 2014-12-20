package ua.ishchenko.services.mongo.db;

import com.mongodb.DB;
import com.mongodb.Mongo;
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
    private String HOST="localhost";
    private int PORT= 27107;
    private String DB_NAME="wariors";
    private static String userName;
    private static String password;

    private MongoDB(String userName, String pass) {
        try {
            mongo = new MongoClient(Arrays.asList(new ServerAddress(HOST, PORT)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        db = mongo.getDB("warriors");

    }
    static class InnerInitializator
    {
        static MongoDB instance = new MongoDB(userName, password);
    }
    public MongoDB getMongoDBInstance()
    {
        return InnerInitializator.instance;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        MongoDB.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        MongoDB.password = password;
    }
}

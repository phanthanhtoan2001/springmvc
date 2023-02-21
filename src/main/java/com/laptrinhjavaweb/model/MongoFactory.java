package com.laptrinhjavaweb.model;

import org.apache.log4j.Logger;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

@SuppressWarnings("deprecation")
public class MongoFactory {

	private static Logger log = Logger.getLogger(MongoFactory.class);

	private static Mongo mongo;

	private MongoFactory() {
	}

	// Returns a mongo instance.
	/*public static Mongo getMongo() {
		int port_no = 27017;
		String hostname = "localhost";
		if (mongo == null) {
			try {
				mongo = new Mongo(hostname, port_no);
			} catch (MongoException ex) {
				log.error(ex);
			}
		}
		return mongo;
	}*/
	
	public static MongoClient getMongoClient() {
		MongoClient mongoClient = null;
		String hostname = "mongodb+srv://phantoan045:123123asD@dbwebflower.cxvlwuj.mongodb.net/?retryWrites=true&w=majority";
		try {
		    MongoClientURI uri = new MongoClientURI(hostname);
		    mongoClient = new MongoClient(uri);
		} catch (MongoException ex) {
		    log.error("Failed to create MongoClient", ex);
		}
		return mongoClient;
	}
	// Fetches the mongo database.
	public static DB getDB(String db_name) {
		return getMongoClient().getDB(db_name);
	}

	// Fetches the collection from the mongo database. mongodb+srv://phantoan045:123123asD@dbwebflower.cxvlwuj.mongodb.net/?retryWrites=true&w=majority
	public static DBCollection getCollection(String db_name, String db_collection) {
		return getDB(db_name).getCollection(db_collection);
	}
}
package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opensymphony.module.sitemesh.Page;

@Service("flowersService")
@Transactional
public class FlowersService {
	static String db_name = "dbwebflower", db_collection = "Flowers";
	private static Logger log = Logger.getLogger(UserService.class);


	@Autowired
	// private Repository flowerRepository;
	// Fetch all users from the mongo database.
	public static List getAll() {
		List flower_list = new ArrayList();
		DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

		// Fetching cursor object for iterating on the database records.
		DBCursor cursor = coll.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();

			Flowers flower = new Flowers();
			flower.setflowerid(dbObject.get("flowerid").toString());
			flower.setname(dbObject.get("name").toString());
			flower.setdescription(dbObject.get("description").toString());
			flower.setimage(dbObject.get("image").toString());
			flower.setstock(((Integer) dbObject.get("stock")).intValue());
			flower.setprice((double) dbObject.get("price"));
	

			flower_list.add(flower);
		}
		log.debug("Total records fetched from the mongo database are= " + flower_list.size());
		return flower_list;
	}


	
	public static Flowers find(String id) {
		List<Flowers> flowerList = getAll();
		for (Flowers flower : flowerList) {
			if (flower.getflowerid().equalsIgnoreCase(id)) {
				return flower;
			}
		}
		return null; // or throw an exception if you prefer
	}

	public static List<Flowers> search(String keyword) {

		List<Flowers> flowers = getAll();
		List<Flowers> result = new ArrayList<>();
		for (Flowers flower : flowers) {
			if (flower.getname().contains(keyword.toLowerCase()) || flower.getname().toLowerCase().contains(keyword)) {
				result.add(flower);
			}
		}
		return result;
	}

}

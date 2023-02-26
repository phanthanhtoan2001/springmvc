package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


@Service("flowerService")
@Transactional
public class FlowerService {
	
	  static String db_name = "dbwebflower", db_collection = "Flowers";
	   private static Logger log = Logger.getLogger(UserService.class);
	
	
	
	
	public static List getAll() {
        List<Flower> flower_list = new ArrayList();
        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
 
        // Fetching cursor object for iterating on the database records.
        DBCursor cursor = coll.find();  
        while(cursor.hasNext()) {           
            DBObject dbObject = cursor.next();
 
            Flower flower = new Flower();
            flower.setFlowerid(dbObject.get("flowerid").toString());
            flower.setName(dbObject.get("name").toString());
            flower.setPrice((double)dbObject.get("price"));
            flower.setDescription(dbObject.get("description").toString());
            flower.setUrl(dbObject.get("image").toString());
            flower.setStock((int)dbObject.get("stock"));
 
            // Adding the user details to the list.
            flower_list.add(flower);
        }
        log.debug("Total records fetched from the mongo database are= " + flower_list.size());
        return flower_list;
    }
	
	
	
	
	
	
	public static Flower find(String id) {
		 List<Flower> flower_list = getAll();
		
		for (Flower flower : flower_list) {
			if (flower.getFlowerid().equalsIgnoreCase(id)) {
				return flower;
			}
		}
		return null;
	}
}

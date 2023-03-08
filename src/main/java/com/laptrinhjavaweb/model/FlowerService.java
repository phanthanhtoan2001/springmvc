package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


@Service("flowerService")
@Transactional
public class FlowerService {
	
	  static String db_name = "dbwebflower", db_collection = "Flowers";
	   private static Logger log = Logger.getLogger(FlowerService.class);
	
	public static List getAll(int pageNum, int pageSize) {
		List flower_list = new ArrayList();
		 int skip = (pageNum - 1) * pageSize; // tính vị trí bắt đầu của trang hiện tại
		DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
	    DBCursor cursor = coll.find().skip(skip).limit(pageSize);

		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();

			Flower flower = new Flower();
			flower.setFlowerid(dbObject.get("flowerid").toString());
			flower.setName(dbObject.get("name").toString());
			flower.setDescription(dbObject.get("description").toString());
			flower.setUrl(dbObject.get("url").toString());
			flower.setStock(((Integer) dbObject.get("stock")).intValue());
			flower.setPrice((double) dbObject.get("price"));
	

			flower_list.add(flower);
		}
		log.debug("Total records fetched from the mongo database are= " + flower_list.size());
		return flower_list;
	}


	// Đếm tổng số sản phẩm có trong bảng
    public static int getFlowerCount() {
        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
        return (int) coll.count();
    }
	//-------------------------------------------------------------------------------------------------
	// Tìm kiếm hoa có trong db
	public static List<Flower> search(String keyword) {

		List<Flower> flowers = getAll();
		List<Flower> result = new ArrayList<>();
		for (Flower flower : flowers) {
			if (flower.getname().contains(keyword.toLowerCase()) || flower.getname().toLowerCase().contains(keyword)) {
				result.add(flower);
			}
		}
		return result;
	}
	//------------------------------------------------------------------------------------------
	//Services chi tiết sản phẩm có rồi nên không copy vô
	
	//---------------------------------------------------------------------------------------------------
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
	
	   public static Boolean add(Flower flower) {
	        boolean output = false;
	        try {
	            DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

	            // Create a new object and add the new user details to this object.
	            BasicDBObject doc = new BasicDBObject();
	            doc.put("flowerid", flower.getFlowerid());
	            doc.put("name", flower.getName());
	            doc.put("description", flower.getDescription().toString());
	            doc.put("price", flower.getPrice());
	            doc.put("image", flower.getUrl());    
	            //
	            //
	            
	            doc.put("stock", flower.getStock());    
	            coll.insert(doc);
	            output = true;
	        } catch (Exception e) {
	            output = false;
	            log.error("An error occurred while saving a new user to the mongo database", e);
	        }
	        return output;
	    }
	
	  public static String generatemaxid() {
			 List<Flower> flower_list = getAll();


			int max =0;
			for (Flower flower : flower_list) {
				String temp = flower.getFlowerid().substring(2);
				
				if (Integer.parseInt(temp) > max) {
					max = Integer.parseInt(temp);
				}
			}
			max++;
			if(max < 10) {
				return "FL00"+max;
			}else {
				if(max > 9 && max <100) {
					return "FL0"+max;
				}else return "FL"+max;
			}
	
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

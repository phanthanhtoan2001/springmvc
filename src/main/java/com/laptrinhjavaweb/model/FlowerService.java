package com.laptrinhjavaweb.model;

import java.io.UnsupportedEncodingException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

@Service("flowerService")
@Transactional
public class FlowerService {

	static String db_name = "dbwebflower", db_collection = "Flowers";
	private static Logger log = Logger.getLogger(FlowerService.class);
	public static DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

	public static List getAll(int pageNum, int pageSize) {
		List flower_list = new ArrayList();
		int skip = (pageNum - 1) * pageSize; // tính vị trí bắt đầu của trang hiện tại

		DBCursor cursor = coll.find().skip(skip).limit(pageSize);

		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();

			Flower flower = new Flower();
			flower.setFlowerid(dbObject.get("flowerid").toString());
			flower.setName(dbObject.get("name").toString());
			flower.setDescription(dbObject.get("description").toString());
			flower.setUrl(dbObject.get("image").toString());
			flower.setStock(((Integer) dbObject.get("stock")).intValue());
			flower.setPrice((double) dbObject.get("price"));

			flower_list.add(flower);
		}
		log.debug("Total records fetched from the mongo database are= " + flower_list.size());
		return flower_list;
	}

	// Đếm tổng số sản phẩm có trong bảng
	public static int getFlowerCount() {
		// DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
		return (int) coll.count();
	}

	// -------------------------------------------------------------------------------------------------
	// Tìm kiếm hoa có trong db
<<<<<<< HEAD
	/*
	 * public static List<Flower> search(String keyword) {
	 * 
	 * List<Flower> flowers = getAll(); List<Flower> result = new ArrayList<>(); for
	 * (Flower flower : flowers) { if
	 * (flower.getName().contains(keyword.toLowerCase()) ||
	 * flower.getName().toLowerCase().contains(keyword)) { result.add(flower); } }
	 * return result; }
	 */
    
    public static List<Flower> search(String keyword) {
        List<Flower> flowers = getAll();
        return flowers.stream()
                .filter(flower -> flower.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
	//------------------------------------------------------------------------------------------
	//Services chi tiết sản phẩm có rồi nên không copy vô
	
	//---------------------------------------------------------------------------------------------------
=======
	public static List<Flower> search(String keyword) {

		List<Flower> flowers = getAll();
		List<Flower> result = new ArrayList<>();
		for (Flower flower : flowers) {
			if (flower.getName().contains(keyword.toLowerCase()) || flower.getName().toLowerCase().contains(keyword)) {
				result.add(flower);
			}
		}
		return result;
	}
	// ------------------------------------------------------------------------------------------
	// Services chi tiết sản phẩm có rồi nên không copy vô

	// ---------------------------------------------------------------------------------------------------
>>>>>>> cadd5eb7c76cacd07bbb239b62c55db7b95b4b3c
	public static List getAll() {
		List<Flower> flower_list = new ArrayList();
		// DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

		// Fetching cursor object for iterating on the database records.
		DBCursor cursor = coll.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();
				Flower flower = new Flower();
				flower.setFlowerid(dbObject.get("flowerid").toString());
				flower.setName(dbObject.get("name").toString());
				flower.setPrice((double) dbObject.get("price"));
				flower.setDescription(dbObject.get("description").toString());
				flower.setUrl(dbObject.get("image").toString());
				flower.setStock((int) dbObject.get("stock"));
				flower_list.add(flower);
			
			// Adding the user details to the list.

		}

		log.debug("Total records fetched from the mongo database are= " + flower_list.size());
		return flower_list;
	}


	public static String utf8(String temp) throws UnsupportedEncodingException {

		String utf8Description = new String(temp.getBytes("ISO-8859-1"), "UTF-8");
		return utf8Description;
	}

	public static Boolean add(Flower flower) {
		boolean output = false;
		try {
			// DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

			// Create a new object and add the new user details to this object.
			DBObject doc = new BasicDBObject();
			doc.put("flowerid", flower.getFlowerid());
			doc.put("name", utf8(flower.getName()));
			doc.put("description", utf8(flower.getDescription()));
			doc.put("price", flower.getPrice());
			doc.put("image", flower.getUrl());
			//

			// System.out.print(flower.getName());
			//

			doc.put("stock", flower.getStock());
			System.out.print(doc);
			coll.insert(doc);
			output = true;
		} catch (Exception e) {
			output = false;
			log.error("An error occurred while saving a new user to the mongo database", e);
		}
		return output;
	}
	
	
	public static Boolean update(Flower flower) {
		boolean output = false;
		try {
			// DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

			// Create a new object and add the new user details to this object.
			DBObject doc = new BasicDBObject();
			doc.put("flowerid", flower.getFlowerid());
			doc.put("name", utf8(flower.getName()));
			doc.put("description", utf8(flower.getDescription()));
			doc.put("price", flower.getPrice());
			doc.put("image", flower.getUrl());
			//

			// System.out.print(flower.getName());
			//

			doc.put("stock", flower.getStock());
			System.out.print(doc);
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

		int max = 0;
		for (Flower flower : flower_list) {
			String temp = flower.getFlowerid().substring(2);

			if (Integer.parseInt(temp) > max) {
				max = Integer.parseInt(temp);
			}
		}
		max++;
		if (max < 10) {
			return "FL00" + max;
		} else {
			if (max > 9 && max < 100) {
				return "FL0" + max;
			} else
				return "FL" + max;
		}

	}

	public static Flower quantityreduce(String id, int reduce) {
		List<Flower> flower_list = getAll();

		for (Flower flower : flower_list) {
			if (flower.getFlowerid().equals(id)) {
				flower.setStock(flower.getStock() - reduce);								
					DBObject where_query = new BasicDBObject();
					where_query.put("flowerid", id);
					DBObject dbfindupdate = coll.findOne(where_query);
					DBObject edited = new BasicDBObject();
					edited.put("flowerid", flower.getFlowerid());
					edited.put("name", flower.getName());
					edited.put("description", flower.getDescription());
					edited.put("price", flower.getPrice());
					edited.put("image", flower.getUrl());
					edited.put("stock", flower.stock); 
					coll.update(dbfindupdate, edited);
					return flower;					
			}
		}
		return null;
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

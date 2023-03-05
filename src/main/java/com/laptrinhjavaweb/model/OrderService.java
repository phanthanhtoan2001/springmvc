package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service("orderService")
@Transactional
public class OrderService {

	
	static String db_name = "dbwebflower", db_collection = "Order";
	   private static Logger log = Logger.getLogger(UserService.class);
	
	   public static List getAll() {
	        List<Order> order_list = new ArrayList();
	        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
	 
	        // Fetching cursor object for iterating on the database records.
	        DBCursor cursor = coll.find();  
	        while(cursor.hasNext()) {           
	            DBObject dbObject = cursor.next();
	 
	            Order order = new Order();
	            order.setOrderid(dbObject.get("orderid").toString());
	            order.setFlowerid(dbObject.get("flowerid").toString());
	            order.setUserid(dbObject.get("userid").toString());
	            order.setShipaddress(dbObject.get("shipping_address").toString());
	            order.setQuantity(((int) dbObject.get("quantity")));
	 
	            // Adding the user details to the list.
	            order_list.add(order);
	        }
	        log.debug("Total records fetched from the mongo database are= " + order_list.size());
	        return order_list;
	    }
	   
	   
	   public static Boolean add(Order order) {
	        boolean output = false;
	        Random ran = new Random();
	        try {
	            DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

	            // Create a new object and add the new user details to this object.
	            BasicDBObject doc = new BasicDBObject();
	            doc.put("orderid", order.getOrderid());
	            doc.put("flowerid", order.getFlowerid());
	            doc.put("userid", order.getUserid());
	            doc.put("shipping_address", order.getShipaddress());
	            doc.put("quantity", order.getQuantity());            
	            coll.insert(doc);
	            output = true;
	        } catch (Exception e) {
	            output = false;
	            log.error("An error occurred while saving a new user to the mongo database", e);
	        }
	        return output;
	    }
	   
	   
	   public static String generatemaxid() {
			 List<Order> order_list = getAll();
			int max =0;
			for (Order order : order_list) {
				if (Integer.parseInt(order.getOrderid()) > max) {
					max = Integer.parseInt(order.getOrderid());
				}
			}
			max++;
			return max+"";
		}
	   
	   
	   public static Order find(String id) {
			 List<Order> order_list = getAll();
			
			for (Order order : order_list) {
				if (order.getOrderid().equalsIgnoreCase(id)) {
					return order;
				}
			}
			return null;
		}


	
}

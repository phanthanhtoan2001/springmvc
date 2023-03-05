package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service("billService")
@Transactional
public class BillService {

	  static String db_name = "dbwebflower", db_collection = "Flowers";
	   private static Logger log = Logger.getLogger(UserService.class);
	
	   public static List getAll() {
	        List<Bill> bill_list = new ArrayList();
	        DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
	 
	        // Fetching cursor object for iterating on the database records.
	        DBCursor cursor = coll.find();  
	        while(cursor.hasNext()) {           
	            DBObject dbObject = cursor.next();
	 
	            Bill Bill = new Bill();
	            Bill.setBillid(dbObject.get("billid").toString());
	            Bill.setMethod(dbObject.get("payment_method").toString());
	            Bill.setOrderid(dbObject.get("orderid").toString());
	            Bill.setNote(dbObject.get("note").toString());
	            Bill.setDate((Date)dbObject.get("datebuy"));
	 
	            // Adding the user details to the list.
	            bill_list.add(Bill);
	        }
	        log.debug("Total records fetched from the mongo database are= " + bill_list.size());
	        return bill_list;
	    }
	
	   public static Bill find(String id) {
			 List<Bill> bill_list = getAll();
			
			for (Bill bill : bill_list) {
				if (bill.getBillid().equalsIgnoreCase(id)) {
					return bill;
				}
			}
			return null;
		}
	   
	   
}

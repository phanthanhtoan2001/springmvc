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

@Service("billService")
@Transactional
public class BillService {

	static String db_name = "dbwebflower", db_collection = "Bill";
	private static Logger log = Logger.getLogger(UserService.class);
	public static DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

	public static List getAll() {
		List<Bill> bill_list = new ArrayList();

		// Fetching cursor object for iterating on the database records.
		DBCursor cursor = coll.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();

			Bill Bill = new Bill();
			Bill.setBillid(dbObject.get("billid").toString());
			Bill.setMethod(dbObject.get("payment_method").toString());
			Bill.setOrderid(dbObject.get("orderid").toString());
			Bill.setNote(dbObject.get("note").toString());
			Bill.setDate((Date) dbObject.get("datebuy"));

			// Adding the user details to the list.
			bill_list.add(Bill);
		}
		log.debug("Total records fetched from the mongo database are= " + bill_list.size());
		return bill_list;
	}

	public static Boolean add(Bill bill) {
		boolean output = false;
		try {
			// DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

			// Create a new object and add the new user details to this object.
			BasicDBObject doc = new BasicDBObject();
			doc.put("billid", bill.getBillid());
			doc.put("payment_method", bill.getMethod());
			doc.put("orderid", bill.getOrderid());
			doc.put("note", bill.getNote());
			doc.put("datebuy", bill.getDate());
			coll.insert(doc);
			output = true;
		} catch (Exception e) {
			output = false;
			log.error("An error occurred while saving a new user to the mongo database", e);
		}
		return output;
	}

	public static String generatemaxid() {
		List<Bill> bill_list = getAll();

		int max = 0;
		for (Bill bill : bill_list) {
			String temp = bill.getBillid().substring(1);

			if (Integer.parseInt(temp) > max) {
				max = Integer.parseInt(temp);
			}
		}
		max++;

		return "B" + max;
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

	public static Bill findorderid(String id) {
		List<Bill> bill_list = getAll();

		for (Bill bill : bill_list) {
			if (bill.getOrderid().equalsIgnoreCase(id)) {
				return bill;
			}
		}
		return null;
	}

}

package com.laptrinhjavaweb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Service("couponService")
@Transactional
public class CouponService {
	static String db_name = "dbwebflower", db_collection = "coupon";
	private static Logger log = Logger.getLogger(UserService.class);
	public static DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
	
	public static List getAll() {
		List<Coupon> coupon_list = new ArrayList();

		// Fetching cursor object for iterating on the database records.
		DBCursor cursor = coll.find();
		while (cursor.hasNext()) {
			DBObject dbObject = cursor.next();

			Coupon coupon = new Coupon();
			coupon.setCoupon(dbObject.get("Coupon").toString());
			coupon.setDiscount((int)dbObject.get("discount"));
			coupon.setDateexp((Date) dbObject.get("DateExp"));

			// Adding the user details to the list.
			coupon_list.add(coupon);
		}
		log.debug("Total records fetched from the mongo database are= " + coupon_list.size());
		return coupon_list;
	}

	public static Boolean add(Coupon coupon) {
		boolean output = false;
		try {
			// DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

			// Create a new object and add the new user details to this object.
			BasicDBObject doc = new BasicDBObject();
			doc.put("Coupon", coupon.getCoupon());
			doc.put("discount", coupon.getDiscount());
			doc.put("DateExp", coupon.getDateexp());
			coll.insert(doc);	
			output = true;
		} catch (Exception e) {
			output = false;
			log.error("An error occurred while saving a new user to the mongo database", e);
		}
		return output;
	}

}

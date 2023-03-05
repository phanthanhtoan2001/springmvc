package com.laptrinhjavaweb.controller.Admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.controller.Admin.*;
import com.laptrinhjavaweb.model.MongoFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private static Logger log = Logger.getLogger(AdminController.class);
	static String db_name = "dbwebflower", db_collection = "Bill";

	// Displaying the initial users list.
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getPersons(Model model) {
		try {
			DBCollection colls = MongoFactory.getCollection(db_name, db_collection);
			Integer billcount = colls.find().count();

			DBCollection coll = MongoFactory.getCollection("dbwebflower", "User");
			Integer customercount = coll.find().count();
			model.addAttribute("bill_count", billcount);
			model.addAttribute("customer_count", customercount);
		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
			model.addAttribute("bill_count", 0);
			model.addAttribute("customer_count", 0);
			return "login";
		}

		return "/admin/Layout_Admin/index_admin";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getcustomer(Model model) {
//		try {
//			DBCollection colls = MongoFactory.getCollection(db_name, db_collection);
//			Integer billcount = colls.find().count();
//			
//			DBCollection coll = MongoFactory.getCollection("dbwebflower", "User");
//			Integer customercount = coll.find().count();
//			model.addAttribute("bill_count", billcount);
//			model.addAttribute("customer_count", customercount);X
//		} catch (Exception e) {
//			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
//			model.addAttribute("bill_count", 0);
//			model.addAttribute("customer_count", 0);
//			return "login";
//		} 
//		
		//return "/admin/Layout_Admin/index_admin";
		return "/admin/Layout_Admin/cusomter_index";
	}
}
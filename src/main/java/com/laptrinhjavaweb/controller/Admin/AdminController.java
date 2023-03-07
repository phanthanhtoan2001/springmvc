package com.laptrinhjavaweb.controller.Admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.controller.Admin.*;
import com.laptrinhjavaweb.model.Bill;
import com.laptrinhjavaweb.model.BillService;
import com.laptrinhjavaweb.model.Flower;
import com.laptrinhjavaweb.model.FlowerService;
import com.laptrinhjavaweb.model.Item;
import com.laptrinhjavaweb.model.MongoFactory;
import com.laptrinhjavaweb.model.Order;
import com.laptrinhjavaweb.model.OrderService;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.model.UserService;
import com.mongodb.AggregationOutput;
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
		setModelLoad(model);

		return "/admin/Layout_Admin/index_admin";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getcustomer(Model model) {

		try {
			setModelLoad(model);
			List user_list = new ArrayList();
			DBCollection coll = MongoFactory.getCollection("dbwebflower", "User");

			DBCursor cursor = coll.find();
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();

				User user = new User();
				user.setId(dbObject.get("id").toString());
				user.setName(dbObject.get("name").toString());
				user.setAddress(dbObject.get("address").toString());
				if (dbObject.get("roles").toString() == "customer") {
					user.setRoles("Khách hàng");
				} else {
					user.setRoles("Quản lý");
					user.setRoles(dbObject.get("roles").toString());
					user.setEmail(dbObject.get("email").toString());
					user.setAddress(dbObject.get("address").toString());
					user.setPhonenum(dbObject.get("phonenum").toString());
					// Adding the user details to the list.
					user_list.add(user);

				}
			}
			model.addAttribute("list_customer", user_list);
		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
			model.addAttribute("list_customer", null);

			return "login";
		}

		return "/admin/Layout_Admin/cusomter_index";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String getcustomer(Model model, @RequestParam("searchemail") String searchemail) {
		setModelLoad(model);
		List user_list = new ArrayList();
		try {
			DBCollection coll = MongoFactory.getCollection("dbwebflower", "User");
			DBObject where_query = new BasicDBObject();
			where_query.put("email", Pattern.compile(searchemail.toString()));
			DBCursor cursor = coll.find(where_query);
			System.out.print(cursor);
			if (cursor == null) {

				User user = new User();
				user.setId("Không tìm thấy");
				user.setName("Không tìm thấy");
				user.setAddress("Không tìm thấy");
				user.setRoles("Không tìm thấy");
				user.setRoles("Không tìm thấy");
				user.setEmail("Không tìm thấy");
				user.setAddress("Không tìm thấy");
				user.setPhonenum("Không tìm thấy");
				// Adding the user details to the list.
				user_list.add(user);

			} else {
				while (cursor.hasNext()) {
					DBObject dbObject = cursor.next();

					User user = new User();
					user.setId(dbObject.get("id").toString());
					user.setName(dbObject.get("name").toString());
					user.setAddress(dbObject.get("address").toString());
					if (dbObject.get("roles").toString() == "customer") {
						user.setRoles("Khách hàng");
					} else {
						user.setRoles("Quản lý");
						user.setRoles(dbObject.get("roles").toString());
						user.setEmail(dbObject.get("email").toString());
						user.setAddress(dbObject.get("address").toString());
						user.setPhonenum(dbObject.get("phonenum").toString());
						// Adding the user details to the list.
						user_list.add(user);
					}

				}
			}
			model.addAttribute("list_customer", user_list);
		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */

		}

		return "/admin/Layout_Admin/cusomter_index";
	}

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public String getbill(Model model) {

		try {
			setModelLoad(model);
			List bill_list = new ArrayList();
			DBCollection coll = MongoFactory.getCollection("dbwebflower", "Bill");

			DBCursor cursor = coll.find();
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();

				Bill bill = new Bill();
				bill.setBillid(dbObject.get("billid").toString());
				bill.setMethod(dbObject.get("payment_method").toString());
				bill.setOrderid(dbObject.get("orderid").toString());
				bill.setNote(dbObject.get("note").toString());
				bill.setDate((Date) dbObject.get("datebuy"));
				bill_list.add(bill);
			}
			model.addAttribute("list_bill", bill_list);
		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
			model.addAttribute("list_bill", null);

			return "login";
		}
		return "/admin/Layout_Admin/Bill_index";
	}

	@RequestMapping(value = "/bill", method = RequestMethod.POST)
	public String getbill(Model model, @RequestParam("searchemail") String searchemail) {
		setModelLoad(model);
		List bill_list = new ArrayList();
		try {
			DBCollection coll = MongoFactory.getCollection("dbwebflower", "Bill");
			DBObject where_query = new BasicDBObject();
			where_query.put("billid", Pattern.compile(searchemail.toString()));
			DBCursor cursor = coll.find(where_query);
			if (cursor == null) {
				Bill bill = new Bill();
				bill.setBillid("Không tìm thấy");
				bill.setMethod("Không tìm thấy");
				bill.setNote("Không tìm thấy");
				bill.setOrderid("Không tìm thấy");
				bill.setDate(null);
				// Adding the user details to the list.
				bill_list.add(bill);
			} else {
				while (cursor.hasNext()) {
					DBObject dbObject = cursor.next();

					Bill bill = new Bill();
					bill.setBillid(dbObject.get("billid").toString());
					bill.setMethod(dbObject.get("payment_method").toString());
					bill.setOrderid(dbObject.get("orderid").toString());
					bill.setNote(dbObject.get("note").toString());
					bill.setDate((Date) dbObject.get("datebuy"));
					bill_list.add(bill);
				}
			}

			model.addAttribute("list_bill", bill_list);
		} catch (

		Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */

		}

		return "/admin/Layout_Admin/Bill_index";
	}

	@RequestMapping(value = "/bill/detail", method = RequestMethod.GET)
	public String billdetail(Model model, HttpSession session, @RequestParam(value = "id") String id) {
		List<Order> order_list = OrderService.getAll();
		List<Order> Billorder_list = new ArrayList<Order>();
		List<Flower> flower_list = FlowerService.getAll();
		List<Item> cart = new ArrayList<Item>();
		Bill bill = BillService.find(id);

		for (Order order : order_list) {
			if (bill.getOrderid().equals(order.getOrderid())) {
				Billorder_list.add(order);
			}
		}
		for(Flower flower: flower_list) {
			for (Order order : Billorder_list) {
				if (flower.getFlowerid().equals(order.getFlowerid())) {
					cart.add(new Item(FlowerService.find(flower.getFlowerid()), order.getQuantity()));
				}
			}
		}
		
		User user = UserService.find(Billorder_list.get(0).getUserid().toString());
		session.setAttribute("cart", cart);
		model.addAttribute("user", user);
		model.addAttribute("flower", flower_list);
		model.addAttribute("bill", bill);
		model.addAttribute("billorder", Billorder_list);
		return "/admin/Layout_Admin/Bill_detail";
	}

	public void setModelLoad(Model model) {
		try {

			DBCollection colls = MongoFactory.getCollection(db_name, db_collection);
			Integer billcount = colls.find().count();
//////////////////////////////////////////////////////////////////////////
			DBCollection coll = MongoFactory.getCollection("dbwebflower", "User");
			Integer customercount = coll.find().count();
//////////////////////////////////////////////////////////////////////////
			Date today = new Date(); // get the current date
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = dateFormat.format(today); // convert the date to a string in the desired format

			DBCollection newordertoday = MongoFactory.getCollection("dbwebflower", "Bill");

			// Set the fromDate.
			Date fromDate = dateFormat.parse(currentDate);
			// where_query.put("datebuy", new BasicDBObject("$gte", fromDate));

			// Set the toDate - 1 days after the fromDate.
			Calendar cal = Calendar.getInstance();
			cal.setTime(fromDate);
			cal.add(Calendar.DATE, 1);
			Date toDate = cal.getTime();
			DBObject where_query = new BasicDBObject();
			where_query.put("datebuy", new BasicDBObject("$gte", fromDate).append("$lte", toDate));
			// where_query.put("datebuy", new BasicDBObject("$lte", toDate));
			System.out.print(fromDate.toString() + "/" + toDate.toString());
			Integer newordertodaycount = newordertoday.find(where_query).count();
			// System.out.print("sads"+newordertodaycount);
//////////////////////////////////////////////////////////////////////////
			// todate
			Calendar call = Calendar.getInstance();
			Date endDate = call.getTime();

			// fromfirstdateofweek
			call.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
			Date startDate = call.getTime();
			DBCollection newOrders = MongoFactory.getCollection("dbwebflower", "Bill");

			DBObject query = new BasicDBObject();
			query.put("datebuy", new BasicDBObject("$gte", startDate).append("$lte", endDate));

			Integer orderCountFirstWeekEndWeek = newOrders.find(query).count();
			// System.out.println(orderCount + endDate.toString() + startDate.toString());

			// best seller top 5

			DBObject groupFields = new BasicDBObject("_id", "$flowerid");
			groupFields.put("total_quantity", new BasicDBObject("$sum", "$quantity"));

			DBObject group = new BasicDBObject("$group", groupFields);

			DBObject sort = new BasicDBObject("$sort", new BasicDBObject("total_quantity", -1));

			DBObject limit = new BasicDBObject("$limit", 5);

			// get the 'Order' collection from 'dbwebflower'
			DBCollection orderCollection = MongoFactory.getCollection("dbwebflower", "Order");

			AggregationOutput output = orderCollection.aggregate(group, sort, limit);
			int idflower = 1;
			for (DBObject result : output.results()) {
				if (result != null) {
					DBCollection findNameflower = MongoFactory.getCollection("dbwebflower", "Flowers");
					BasicDBObject whereQuery = new BasicDBObject();
					whereQuery.put("flowerid", result.get("_id"));
					DBCursor cursor = findNameflower.find(whereQuery);
					if (cursor.hasNext()) {
						DBObject flowerObject = cursor.next();
						String name = (String) flowerObject.get("name");
						model.addAttribute("bestsellername" + idflower, name);
						model.addAttribute("bestsellerquantity" + idflower, result.get("total_quantity"));
						idflower++;
					}

				}
			}
//////////////////////////////////////////////////////////////////////////
			DBCollection flowerCollection = MongoFactory.getCollection("dbwebflower", "Flowers");

			DBObject querys = new BasicDBObject("stock", new BasicDBObject("$lte", 10));
			Integer countoutstock = flowerCollection.find(querys).count();
			// System.out.print(count+"/");

			//
			model.addAttribute("countoutstock", countoutstock);
			model.addAttribute("orderCountFirstWeekEndWeek_count", orderCountFirstWeekEndWeek);
			model.addAttribute("neworderbill_count", newordertodaycount);
			model.addAttribute("bill_count", billcount);
			model.addAttribute("customer_count", customercount);

		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */

		}
	}

}
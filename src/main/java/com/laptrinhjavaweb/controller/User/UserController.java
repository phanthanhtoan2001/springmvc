package com.laptrinhjavaweb.controller.User;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.model.Flower;
import com.laptrinhjavaweb.model.FlowerService;
import com.laptrinhjavaweb.model.MongoFactory;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.model.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.controller.User.mservice.enums.RequestType;
import com.laptrinhjavaweb.controller.User.mservice.models.PaymentResponse;
import com.laptrinhjavaweb.controller.User.mservice.processor.CreateOrderMoMo;
import com.laptrinhjavaweb.controller.User.mservice.shared.utils.LogUtils;
import com.laptrinhjavaweb.controller.User.mservice.Utils;
import com.laptrinhjavaweb.controller.User.mservice.config.Environment;

@Controller
@RequestMapping("/user")
public class UserController {

	static String db_name = "dbwebflower", db_collection = "User";
	private static Logger log = Logger.getLogger(UserController.class);

	@Resource(name = "userService")
	private UserService userService;

	// Displaying the initial users list.
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getPersons(Model model) {
		log.debug("Request to fetch all users from the mongo database");
		List user_list = userService.getAll();
		model.addAttribute("users", user_list);
		return "welcome";
	}

	// Opening the add new user form page.
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		log.debug("Request to open the new user form page");
		model.addAttribute("userAttr", new User());
		return "form";
	}

///--------------------------------------------------------------------------
	// Opening the edit user form page.
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam(value = "id", required = true) String id, Model model) {
		log.debug("Request to open the edit user form page");
		model.addAttribute("userAttr", userService.findUserId(id));
		return "edit";
	}
//--------------------------------------------------------------------------
	// Deleting the specified user.
	/*
	 * @RequestMapping(value = "/delete", method = RequestMethod.GET) public String
	 * delete(@RequestParam(value = "id", required = true) String id, Model model) {
	 * userService.delete(id); return "redirect:/user/list"; }
	 */

	// Adding a new user or updating an existing user.
	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * save(@ModelAttribute("userAttr") User user) {
	 * 
	 * userService.edit(user);
	 * 
	 * return "loginsucces"; }
	 */

	// test login
	@RequestMapping(value = "/loginsucces", method = RequestMethod.GET)
	public String loginsucces() {

		return "loginsucces";
	}
	/// ----------------------------------------------------------------
	DBCollection coll_user = MongoFactory.getCollection("dbwebflower", "User");
	@RequestMapping(value = "/updateinfor", method = RequestMethod.GET)
	public String update(@RequestParam("id") String id, Model model, HttpSession session) {
		try {
			 User u = new User();
		      //  DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

		        // Fetching the record object from the mongo database.
		        DBObject where_query = new BasicDBObject();
		        where_query.put("id", id);

		        DBObject dbo = coll_user.findOne(where_query);
		        u.setId(dbo.get("id").toString());
		        u.setName(dbo.get("name").toString());
		        u.setPhonenum(dbo.get("phonenum").toString());
		        u.setAddress(dbo.get("address").toString());
		        u.setEmail(dbo.get("email").toString());
		        u.setPassword(dbo.get("password").toString());

		       
		        
			model.addAttribute("edituser", u);
		} catch (Exception ex) {
		}

		return "edituser";
	}
	

	@RequestMapping(value = "/updateinfor", method = RequestMethod.POST)
	public String updateuser(Model model, HttpServletRequest request,
	  HttpSession session) 
	{ try {
		String id =request.getParameter("id"); 
		String name =request.getParameter("name"); 
		String email =request.getParameter("email"); 
		String address =request.getParameter("address"); 
		String phonenum = request.getParameter("phonenum");
		String password = request.getParameter("password");
		// System.out.print(flowerid + flowername +flowerstock+flowersdecrip+image); 
		DBObject where_query = new BasicDBObject(); 
		where_query.put("id", id); 
		DBObject dbfindupdate = coll_user.findOne(where_query); 
		BasicDBObject edited = new  BasicDBObject(); 
		edited.put("id", id); 
		edited.put("name",FlowerService.utf8(name)); 
		edited.put("email",email);
		edited.put("address", FlowerService.utf8(address)); 
		edited.put("phonenum", phonenum);
		edited.put("password", password);
		
		coll_user.update(dbfindupdate, edited);
		
	  } catch (Exception ex) { }
	  
	  return "redirect:/user/updateinfor?id"; }

}
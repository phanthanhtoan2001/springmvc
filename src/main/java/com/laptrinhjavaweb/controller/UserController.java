package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.model.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	// Opening the edit user form page.
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam(value = "id", required = true) String id, Model model) {
		log.debug("Request to open the edit user form page");
		model.addAttribute("userAttr", userService.findUserId(id));
		return "form";
	}

	// Deleting the specified user.
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "id", required = true) String id, Model model) {
		userService.delete(id);
		return "redirect:list";
	}

	// Adding a new user or updating an existing user.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("userAttr") User user) {
		if (user.getId() != null && !user.getId().trim().equals("")) {
			userService.edit(user);
		} else {
			userService.add(user);
		}
		return "redirect:list";
	}

	// test login
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		User u = new User();
		try {
			DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
			
			DBObject where_query = new BasicDBObject();
			where_query.put("name", username.toString());
			where_query.put("password", password);
			
			DBObject dbo = coll.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setPassword(dbo.get("password").toString());
			
		} catch (Exception e) {
			modelMap.put("error", "Invalid Account");
			return "login";
		}
		if (username.equalsIgnoreCase(u.getName()) && password.equalsIgnoreCase(u.getPassword())) {
			session.setAttribute("username", u.getName());
			modelMap.put("error", session.getValue("username"));
			return "loginsucces";
		} else {
			modelMap.put("error", "Invalid Account");
			return "login";
		}
	}
	@RequestMapping(value = "regis", method = RequestMethod.GET)
	public String regis(Map<String, Object> model) {
		   User userForm = new User();    
	        model.put("userForm", userForm);
		return "Register";
	}
	@RequestMapping(value = "regis", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("userForm") User user,
            Map<String, Object> model) {
         
        // implement your own registration logic here...
		try {           
            DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
            //get id add
            String id ="";
            DBCursor cursor = coll.find();  
            while(cursor.hasNext()) {           
                DBObject dbObject = cursor.next();
                id =dbObject.get("id").toString();
            }
            // Create a new object and add the new user details to this object.
            Integer temp = Integer.parseInt(id)+1;
            BasicDBObject doc = new BasicDBObject();
            doc.put("id", Integer.toString(temp)); 
            doc.put("name", user.getName());   
            doc.put("password", user.getPassword());
            doc.put("idrole", 2);
            doc.put("role", "customer");
            // Save a new user to the mongo collection.
            coll.insert(doc);
           
        } catch (Exception e) {
           
            log.error("An error occurred while saving a new user to the mongo database", e);            
        }
        // for testing purpose:
       
         
        return "welcome";
    }
}
package com.laptrinhjavaweb.controller.User;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.controller.UserController;
import com.laptrinhjavaweb.model.MongoFactory;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.model.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Controller
@RequestMapping("/user")
public class LoginController {
	static String db_name = "dbwebflower", db_collection = "User";
	private static Logger log = Logger.getLogger(UserController.class);

	@Resource(name = "userService")
	private UserService userService;
	
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
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
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
	@RequestMapping(value = "forgot", method = RequestMethod.GET)
	public String forgot() {
		
		return "forgotpassword";
	}
	@RequestMapping(value = "forgot", method = RequestMethod.POST)
	public String forgot(@RequestParam("email") String email,
			HttpSession session, ModelMap modelMap) {
		User u = new User();
		try {
			DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
			
			DBObject where_query = new BasicDBObject();
			where_query.put("Email", email.toString());
			
			
			DBObject dbo = coll.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setPassword(dbo.get("password").toString());
			
			
		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
			
		}
		if (email.equalsIgnoreCase(u.getEmail())) {
			// xu ly email
			return "login";
		} else {
			modelMap.put("error", "Invalid Account");
			
			return "forgotpassword";
		}
	}
}

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
	
}
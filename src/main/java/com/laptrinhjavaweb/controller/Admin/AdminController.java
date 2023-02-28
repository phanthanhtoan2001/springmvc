package com.laptrinhjavaweb.controller.Admin;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.controller.Admin.*;


@Controller
@RequestMapping("/admin")
public class AdminController {
	private static Logger log = Logger.getLogger(AdminController.class);

	// Displaying the initial users list.
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getPersons(Model model) {
		//log.debug("Request to fetch all users from the mongo database");
		//List user_list = userService.getAll();
		//model.addAttribute("users", user_list);
		return "/admin/Layout_Admin/layoutadmin";
	}
}
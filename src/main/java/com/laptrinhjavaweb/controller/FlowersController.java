package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.model.FlowersService;
import com.laptrinhjavaweb.model.Flowers;

@Controller
@RequestMapping("/home")
public class FlowersController {
	private static final String DB_NAME = "dbwebflower";
	private static final String DB_COLLECTION = "Flowers";
	private static final Logger LOG = Logger.getLogger(FlowersController.class);

	@Resource(name = "flowersService")
	private FlowersService flowersService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAllFlowers(Model model) {
		LOG.debug("Request to fetch all flowers from the mongo database");
		List<Flowers> flowerList = flowersService.getAll();
		model.addAttribute("flowers", flowerList);
		return "listflower";
	}
}

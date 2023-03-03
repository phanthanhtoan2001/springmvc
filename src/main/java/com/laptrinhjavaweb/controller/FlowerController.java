package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.model.FlowerService;

@Controller
@RequestMapping("/flower")
public class FlowerController {

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		List flower_list = FlowerService.getAll();
		modelMap.put("products", flower_list);
		return "flower";
	}
}

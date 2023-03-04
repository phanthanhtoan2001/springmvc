package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.model.FlowerService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		List flower_list = FlowerService.getAll();
		modelMap.put("products", flower_list);
		return "payment/payment";
	}
	
	
	@RequestMapping(value = "checkout",method = RequestMethod.GET)
	public String checkout(ModelMap modelMap) {
		return "payment/checkout";
	}
	
	
}

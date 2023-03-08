package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laptrinhjavaweb.model.FlowerService;

/////////////////////////////////////
import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.model.Flower;
import com.laptrinhjavaweb.model.FlowerService;

@Controller
@RequestMapping("/flower")
public class FlowerController {

	private static final String DB_NAME = "dbwebflower";
	private static final String DB_COLLECTION = "Flowers";
	private static final Logger LOG = Logger.getLogger(FlowerController.class);

	@Resource(name = "flowersService")
	public FlowersService flowersService;
	@GetMapping("/list")
	public String getAllFlowers(Model model, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "12") int pageSize) {
		LOG.debug("Request to fetch all flowers from the mongo database");
		List<Flower> flowerList = FlowersService.getAll(pageNum, pageSize);
		int flowerCount = flowersService.getFlowerCount();
		int totalPages = (int) Math.ceil((double) flowerCount/ pageSize);

        List<Integer> pages = new ArrayList<>();
        for (int i = 1; i <= totalPages; i++) {
            pages.add(i);
        }
		model.addAttribute("flowers", flowerList);
		 model.addAttribute("currentPage", pageNum);
	     model.addAttribute("pages", pages);
	     model.addAttribute("totalPages", totalPages);

		return "listflower";

	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String DetailFlower(@RequestParam(value = "id", required = true) String id, Model model) {
		LOG.debug("Request to open the edit user form page");
		model.addAttribute("userAttr", FlowersService.find(id));
		return "details";
	}

	@GetMapping("/search")
	public String searchFlowers(@RequestParam("keyword") String keyword, Model model) {
		List<Flower> result = FlowersService.search(keyword);
		model.addAttribute("result", result);
		return "search-result";
	}
	
	///////////////////////////////////////////////////////////////////
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		List flower_list = FlowerService.getAll();
		modelMap.put("products", flower_list);
		return "flower";
	}
}

package com.laptrinhjavaweb.controller.User;

import java.util.ArrayList;
import java.util.List;
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

import com.laptrinhjavaweb.model.Flowers;
import com.laptrinhjavaweb.model.FlowersService;


@Controller
@RequestMapping("/home")
public class FlowersController {
	private static final String DB_NAME = "dbwebflower";
	private static final String DB_COLLECTION = "Flowers";
	private static final Logger LOG = Logger.getLogger(FlowersController.class);

	@Resource(name = "flowersService")
	public FlowersService flowersService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAllFlowers(Model model) {
		LOG.debug("Request to fetch all flowers from the mongo database");
		List<Flowers> flowerList = FlowersService.getAll();
		

		model.addAttribute("flowers", flowerList);

	
				return "listflower";
		
	
	}
	/*@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String getAllFlowers(Model model, @RequestParam(value = "name", required = true) String name) {
	    LOG.debug("Request to fetch all flowers from the mongo database");
	    List<Flowers> flowerList = flowersService.getAll();
	    List<Flowers> filteredList = new ArrayList<>();
	    for (Flowers flower : flowerList) {
	        if (flower.getname().contains(name)) {
	            filteredList.add(flower);
	        }
	    }
	    if (filteredList.isEmpty()) {
	        // Nếu không tìm thấy hoa nào thỏa mãn điều kiện, trả về trang listflower với danh sách trống
	        model.addAttribute("flowers", filteredList);
	        return "listflower";
	    } else {
	        // Nếu tìm thấy hoa thỏa mãn điều kiện, trả về trang listflower với danh sách hoa tìm được
	        model.addAttribute("flowers", filteredList);
	        return "listflower";
	    }
	}*/


	
	/*
	 * @RequestMapping(value="/detail/{id}",method = RequestMethod.GET) public
	 * String FindFlowers(@PathVariable("id") String id , Model model) {
	 * LOG.debug("Request to fetch all flowers from the mongo database"); Flowers
	 * flower = FlowersService.find(id); model.addAttribute("flower", flower);
	 * return "details"; }
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String DetailFlower(@RequestParam(value = "id", required = true) String id, Model model) {
		LOG.debug("Request to open the edit user form page");
		model.addAttribute("userAttr", FlowersService.find(id));
		return "details";
	}
	 @GetMapping("/search")
	    public String searchFlowers(@RequestParam("keyword") String keyword, Model model) {
	        List<Flowers> result = FlowersService.search(keyword);
	        model.addAttribute("result", result);
	        return "search-result";
	    }
}

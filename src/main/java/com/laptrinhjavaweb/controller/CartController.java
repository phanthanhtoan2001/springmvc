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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/cart")
public class CartController {
	static String db_name = "dbwebflower", db_collection = "User";
	

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		return "cart/cartindex";
	}

	@RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
	public String buy(@PathVariable("id") String id, HttpSession session) {
		List flower_list = FlowerService.getAll();
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(FlowerService.find(id), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = this.exists(id, cart);
			if (index == -1) {
				cart.add(new Item(FlowerService.find(id), 1));
			} else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/cart/index";
	}

	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	public String remove(@PathVariable("id") String id, HttpSession session) {
		List flower_list = FlowerService.getAll();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.exists(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	
	
	
	
	@RequestMapping(value = "update/{id}/{ss}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id,@PathVariable("ss") String ss ,HttpSession session) {
		List flower_list = FlowerService.getAll();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		int index = this.exists(id, cart);
		int quantity = cart.get(index).getQuantity();
		Flower flower = FlowerService.find(id);
		int stock = flower.getStock();
		if(ss.equals("MINUS") ) quantity -= 1;
		else quantity += 1;
		if(quantity <= 0 ) quantity = 1;
		else if (quantity > stock) quantity = stock;
		
		cart.get(index).setQuantity(quantity);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}

	private int exists(String id, List<Item> cart) {
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getFlower().getFlowerid().equalsIgnoreCase(id)) {
				return i;
			}
		}
		return -1;
	}

	
	
	@RequestMapping(value = "remove/all}", method = RequestMethod.GET)
	public String removeall(HttpSession session) {
//		List flower_list = FlowerService.getAll();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.removeAll(cart);
		session.setAttribute("cart", cart);
		return "redirect:/cart/index";
	}
	
	
	@RequestMapping(value = "/coupon}", method = RequestMethod.GET)
	public String coupon(HttpSession session, HttpServletRequest request, Model model) {
//		List flower_list = FlowerService.getAll();
		List<Coupon> coupon_list = CouponService.getAll();
		String code = request.getParameter("code");
		if(!code.equals("")) {
			for(Coupon coupon: coupon_list ) {
				if(code == coupon.getCoupon()) {
					session.setAttribute("coupon", coupon);
					return "payment/checkout";
				}
			}
		}
		
		 model.addAttribute("message", "bạn đã nhập sai mã giảm giá");
		return "redirect:/cart/index";
	}
}

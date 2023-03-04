package com.laptrinhjavaweb.controller.User;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.model.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.controller.User.mservice.enums.RequestType;
import com.laptrinhjavaweb.controller.User.mservice.models.PaymentResponse;
import com.laptrinhjavaweb.controller.User.mservice.processor.CreateOrderMoMo;
import com.laptrinhjavaweb.controller.User.mservice.shared.utils.LogUtils;
import com.laptrinhjavaweb.controller.User.mservice.Utils;
import com.laptrinhjavaweb.controller.User.mservice.config.Environment;

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

//public String payment(Model model, @RequestBody WeddingPartyOrders order, HttpSession session) throws Exception {
	// @PostMapping("/payment")
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String payment(Model model, HttpSession session,HttpServletRequest request) throws Exception {
		//
		LogUtils.init();
		String requestId = String.valueOf(System.currentTimeMillis());
		String orderId = String.valueOf(System.currentTimeMillis());
		Long transId = 2L;
		long amount = 2000;

		String partnerClientId = "partnerClientId";
		String orderInfo = "Pay Withasdasdasd MoMo";
		String returnURL = "https://localhost:8088/java-web/user/ConfirmPaymentClient";
		String notifyURL = "https://localhost:8088/java-web/user/ConfirmPaymentClient";
		String callbackToken = "callbackToken";
		String token = "";

		Environment environment = Environment.selectEnv("dev");
		PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId,
				Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
		return "redirect:" + captureWalletMoMoResponse.getPayUrl();

	}
	@RequestMapping(value = "/ConfirmPaymentClient", method = RequestMethod.GET)
	public String ConfirmPaymentClient() {
		
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n");
		
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n");	
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n");
		return "welcome";
	}
	@RequestMapping(value = "/ConfirmPaymentClient", method = RequestMethod.POST)
	public String ConfirmPaymentClient1() {
		
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n");
		
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n");	
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n")	;
		System.out.print("hahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaahahahahaa\n");
		return "welcome";
	}
	// test login
	@RequestMapping(value = "/loginsucces", method = RequestMethod.GET)
	public String loginsucces() {

		return "loginsucces";
	}
}
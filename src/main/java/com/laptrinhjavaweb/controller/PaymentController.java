package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.controller.User.mservice.config.Environment;
import com.laptrinhjavaweb.controller.User.mservice.enums.RequestType;
import com.laptrinhjavaweb.controller.User.mservice.models.PaymentResponse;
import com.laptrinhjavaweb.controller.User.mservice.processor.CreateOrderMoMo;
import com.laptrinhjavaweb.controller.User.mservice.shared.utils.LogUtils;
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

	@RequestMapping(value = "/paymentmomo", method = RequestMethod.GET)
	public String payment(Model model, HttpSession session, HttpServletRequest request) throws Exception {
		//
		LogUtils.init();
		String requestId = String.valueOf(System.currentTimeMillis());
		String orderId = String.valueOf(System.currentTimeMillis());
		Long transId = 2L;
		long amount = 2000;

		String partnerClientId = "partnerClientId";
		String orderInfo = "Pay Withasdasdasd MoMo";
		String returnURL = "http://localhost:8088/java-web/payment/confirmmomo";
		String notifyURL = "http://localhost:8088/java-web/payment/confirmmomo";
		String callbackToken = "callbackToken";
		String token = "";

		Environment environment = Environment.selectEnv("dev");
		PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId,
				Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
		return "redirect:" + captureWalletMoMoResponse.getPayUrl();

	}



	@RequestMapping(value = "/confirmmomo", method = RequestMethod.GET)
	public String ConfirmPaymentClient12() {
		//save bill
		
		//
		return "payment/checkout";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public String checkout(ModelMap modelMap) {
		return "payment/checkout";
	}

}

package com.laptrinhjavaweb.controller.User;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.model.MongoFactory;
import com.laptrinhjavaweb.model.User;
import com.laptrinhjavaweb.model.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Controller
@RequestMapping("/user")
public class LoginController {

	static String db_name = "dbwebflower", db_collection = "User";
	private static Logger log = Logger.getLogger(UserController.class);

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		User u = new User();
		try {
			DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

			DBObject where_query = new BasicDBObject();
			where_query.put("name", username.toString());
			where_query.put("password", password);

			DBObject dbo = coll.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setPassword(dbo.get("password").toString());

		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */
			return "login";
		}
		if (username.equalsIgnoreCase(u.getName()) && password.equalsIgnoreCase(u.getPassword())) {
			session.setAttribute("username", u.getName());

			modelMap.put("error", session.getValue("username"));

			return "loginsucces";
		} else {
			modelMap.put("error", "Invalid Account");

			return "login";
		}
	}

	@RequestMapping(value = "regis", method = RequestMethod.GET)
	public String regis(Map<String, Object> model) {
		User userForm = new User();
		model.put("userForm", userForm);
		return "Register";
	}

	@RequestMapping(value = "regis", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") User user, Map<String, Object> model) {

		// implement your own registration logic here...
		try {
			DBCollection coll = MongoFactory.getCollection(db_name, db_collection);
			// get id add
			String id = "";
			DBCursor cursor = coll.find();
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				id = dbObject.get("id").toString();
			}
			// Create a new object and add the new user details to this object.
			Integer temp = Integer.parseInt(id) + 1;
			BasicDBObject doc = new BasicDBObject();
			doc.put("id", Integer.toString(temp));
			doc.put("name", user.getName());
			doc.put("password", user.getPassword());
			doc.put("idrole", 2);
			doc.put("role", "customer");
			// Save a new user to the mongo collection.
			coll.insert(doc);

		} catch (Exception e) {

			log.error("An error occurred while saving a new user to the mongo database", e);
		}
		// for testing purpose:
		return "welcome";
	}

	@RequestMapping(value = "forgot", method = RequestMethod.GET)
	public String forgot() {

		return "forgotpassword";
	}

	@RequestMapping(value = "forgot", method = RequestMethod.POST)
	public String forgot(@RequestParam("email") String email, HttpSession session, ModelMap modelMap) {
		User u = new User();
		try {
			DBCollection coll = MongoFactory.getCollection(db_name, db_collection);

			DBObject where_query = new BasicDBObject();
			where_query.put("email", email.toString());

			DBObject dbo = coll.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setPassword(dbo.get("password").toString());
			u.setEmail(dbo.get("email").toString());

		} catch (Exception e) {
			/* modelMap.put("toastshow", "Đăng nhập không thành công!"); */

		}
		if (email.equalsIgnoreCase(u.getEmail())) {
			// xu ly email
			String pass = generatePassword(12);
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

			MailService mailService = context.getBean("mailService", MailServiceImpl.class);

			String senderEmailId = "tiennguyennaraka@gmail.com";
			String receiverEmailId = email;
			String subject = "[Quên Mật Khẩu] Thư gửi mật khẩu mới của bạn.";
			String message = "<div id=':33' class='ii gt' jslog='20277; u014N:xr6bB; 4:W251bGwsbnVsbCxbXV0.'>"
					+ "<div id=':32' class='a3s aiL '>" + "<u>" + "</u>" + "<div>"
					+ "<div style='width:800px;text-align:center;margin:0 auto'>"
					+ "<table align='center' width='800' height='1000' cellpadding='0' cellspacing='0' border='0' style='background:#A77979'>"
					+ "<tbody>" + "<tr>"
					+ "<td align='center' valign='top' style='background:url(https://wallpapercave.com/uwp/uwp2052576.jpeg)'>"
					+ "<table width='576' cellpadding='0' cellspacing='0' border='0'>" + "<tbody>" + "<tr>"
					+ "<td height='250'>" + "</td>" + "</tr>" + "<tr>"
					+ "<td align='left' valign='top' style='color:#fff'>"
					+ "<font color='#e35b5b' style='font-size:26px'>" + "<strong>" + "Gửi khách hàng:" + "<br>"
					+ "Đây đây là mật khẩu của bạn, vui lòng nhập vào:" + "</strong>" + "</font>" + "</td>" + "</tr>"
					+ "<tr>" + "<td height='40' valign='top'>" + "</td>" + "</tr>" + "<tr>"
					+ "<td align='center' height='54' style='background:#202121;letter-spacing:15px;color:#ffffff'>"
					+ "<font size='6' color='#FFFFFF'>" +
					// code here
					pass +

					"</font>" + "</td>" + "</tr>" + "<tr>" + "<td height='40' valign='top'>" + "</td>" + "</tr>"
					+ "<tr>" + "<td valign='top' style='color:#e35b5b'>" + "<font size='4' color='#e35b5b'>"
					+ "Mọi thắc mắc vui lòng gửi email " + "<a href='mailto:longan04111@gmail.com ' target='_blank'>"
					+ "longan04111@gmail.com" + "</a>" + "để biết thêm thông tin." +

					"Nếu bạn không có thắc mắc nào, vui lòng đừng gửi thư rác!." + "</font>" + "</td>" + "</tr>"
					+ "<tr>" + "<td height='40' valign='top'>" + "</td>" + "</tr>" + "<tr>"
					+ "<td height='60' valign='top' style='color:#e35b5b'>" + "<font size='4' color='#e35b5b'>"
					+ "Một ngày tốt lành！" + "</font>" + "</td>" + "</tr>" + "<tr>"
					+ "<td height='50' valign='top' style='color:#e35b5b'>" + "<font size='5' color='#e35b5b'>"
					+ "<strong>" + "TN" + "</strong>" + "</font>" + "</td>" + "</tr>" + "<tr>" + "<td height='100%'>"
					+ "</td>" + "</tr>" + "</tbody>" + "</table>" + "</td>" + "</tr>" + "</tbody>" + "</table>"
					+ "</div>" + "</div>" + "</div>" + "<div class='yj6qo'>" + "</div>" + "</div>";

			mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
			context.close();
			return "login";
		} else {
			modelMap.put("error", "Không tìm thấy Email trong hệ thống!");

			return "forgotpassword";
		}

	}

	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBERS = "0123456789";
	private static final String SYMBOLS = "!@#$%^&*_=+-/";

	private static final String PASSWORD_CHARS = LOWER_CASE + UPPER_CASE + NUMBERS + SYMBOLS;

	public static String generatePassword(int length) {
		List<String> chars = Arrays.asList(PASSWORD_CHARS.split(""));
		Collections.shuffle(chars, new SecureRandom());
		String password = "";
		for (int i = 0; i < length; i++) {
			password += chars.get(i);
		}
		return password;
	}
}

package com.laptrinhjavaweb.controller.User;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest.DigestUtils;
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
	DBCollection coll_user = MongoFactory.getCollection(db_name, db_collection);
	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping(value = "checklogingoogle", method = RequestMethod.GET)
	public String checklogingoogle(HttpSession session) {
		User u = new User();
		User googleu = (User) session.getAttribute("loginsession");
		try {

			DBObject where_query = new BasicDBObject();
			where_query.put("email", googleu.getEmail());

			DBObject dbo = coll_user.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setEmail(dbo.get("email").toString());
			u.setRoles(dbo.get("roles").toString());
			u.setAddress(dbo.get("address").toString());
			u.setPhonenum(dbo.get("phonenum").toString());
			session.setAttribute("loginsession", u);

			if (u.getRoles().contains("customer")) {

				return "redirect:/flower/list";
			} else {

				return "redirect:/admin/welcome";
			}

		} catch (Exception e) {

			String id = "";
			DBCursor cursor = coll_user.find();
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				id = dbObject.get("id").toString();
			}
			// Create a new object and add the new user details to this object.
			Integer temp = Integer.parseInt(id) + 1;
			BasicDBObject doc = new BasicDBObject();
			doc.put("id", Integer.toString(temp));
			doc.put("name", googleu.getEmail());
			//
			String md5Hex = DigestUtils.md5Hex("$!#@^#$%^#$%#$%DoBaN^&%Bi@tDuoc@P^S$D0").toUpperCase();
			doc.put("password", md5Hex);
			doc.put("roles", "customer");
			doc.put("email", googleu.getEmail());
			doc.put("address", "Cap nhat");
			doc.put("phonenum", "0123456789");
			User tempus = new User();
			tempus.setEmail(googleu.getEmail());
			tempus.setId(Integer.toString(temp));
			tempus.setName(googleu.getEmail());
			tempus.setRoles("customercustomer");
			tempus.setAddress("Cap nhat");
			tempus.setPhonenum("0123456789");
			// Save a new user to the mongo collection.
			coll_user.insert(doc);
			session.setAttribute("loginsession", tempus);
			return "redirect:/flower/list";

		}

	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		try {
			User checklogin = (User) session.getAttribute("loginsession");
			if (!checklogin.getName().isEmpty()) {
				if (checklogin.getRoles().contains("customer")) {

					return "redirect:/flower/list";
				} else {

					return "redirect:/admin/welcome";
				}
			} else
				return "login";

		} catch (Exception ex) {
			return "login";
		}

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.setAttribute("loginsession", null);
		return "login";

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session, ModelMap modelMap) {
		User u = new User();
		String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
		try {

			DBObject where_query = new BasicDBObject();
			where_query.put("password", md5Hex);
			where_query.put("email", username.toString());

			DBObject dbo = coll_user.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setEmail(dbo.get("email").toString());
			u.setRoles(dbo.get("roles").toString());
			u.setPassword(dbo.get("password").toString());
			u.setAddress(dbo.get("address").toString());
			u.setPhonenum(dbo.get("phonenum").toString());

		} catch (Exception e) {
			/* modelMap.put("toastshow", "????ng nh???p kh??ng th??nh c??ng!"); */
			modelMap.put("error", "Kh??ng t???n t???i Email n??y trong h??? th???ng ho???c Sai t??i kho???n ho???c m???t kh???u !");
			return "login";
		}
		if (username.equals(u.getEmail()) && md5Hex.equals(u.getPassword())) {
			session.setAttribute("loginsession", u);
			if (u.getRoles().contains("customer")) {

				return "redirect:/flower/list";
			} else {

				return "redirect:/admin/welcome";
			}
		} else {
			modelMap.put("error", "Sai t??i kho???n ho???c m???t kh???u !");

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
	public String processRegistration(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email,
			@RequestParam("address") String address, Map<String, Object> model,
			@RequestParam("phonenum") String phonenum, ModelMap modelMap) {
		User u = new User();

		// implement your own registration logic here...
		try {

			DBObject where_query = new BasicDBObject();
			where_query.put("email", email.toString());

			DBObject dbo = coll_user.findOne(where_query);
			u.setId(dbo.get("id").toString());
			u.setName(dbo.get("name").toString());
			u.setEmail(dbo.get("email").toString());
			u.setRoles(dbo.get("roles").toString());
			u.setPassword(dbo.get("password").toString());
			u.setAddress(dbo.get("address").toString());
			u.setPhonenum(dbo.get("phonenum").toString());
			// get id add
			modelMap.put("error", "???? t???n t???i email ho???c t??i kho???n n??y trong h??? th???ng!");
		} catch (Exception e) {
			if (!username.toString().isEmpty() || !password.toString().isEmpty() || !email.toString().isEmpty()
					|| !address.toString().isEmpty() || !phonenum.toString().isEmpty()) {

				String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
				String id = "";
				DBCursor cursor = coll_user.find();
				while (cursor.hasNext()) {
					DBObject dbObject = cursor.next();
					id = dbObject.get("id").toString();
				}
				// Create a new object and add the new user details to this object.
				Integer temp = Integer.parseInt(id) + 1;
				BasicDBObject doc = new BasicDBObject();
				doc.put("id", Integer.toString(temp));
				doc.put("name", username.toString());
				doc.put("password", md5Hex);
				doc.put("roles", "customer");
				doc.put("email", email.toString());
				doc.put("address", address.toString());
				doc.put("phonenum", phonenum.toString());
				// Save a new user to the mongo collection.
				coll_user.insert(doc);
				return "login";
			} else {
				modelMap.put("error", "Vui l??ng nh???p ?????y ????? th??ng tin!");
				return "Register";
			}
		}
		// for testing purpose:
		return "Register";
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
			u.setRoles(dbo.get("roles").toString());
			u.setEmail(dbo.get("email").toString());
			u.setPassword(dbo.get("password").toString());
			u.setAddress(dbo.get("address").toString());
			u.setPhonenum(dbo.get("phonenum").toString());

			if (email.equals(u.getEmail())) {

				// xu ly email
				String pass = generatePassword(12);
				// save
				String md5Hex = DigestUtils.md5Hex(pass).toUpperCase();
				BasicDBObject edited = new BasicDBObject();
				edited.put("id", u.getId());
				edited.put("name", u.getName());
				edited.put("password", md5Hex);
				edited.put("roles", u.getRoles());
				edited.put("email", u.getEmail());
				edited.put("address", u.getAddress());
				edited.put("phonenum", u.getPhonenum());
				coll.update(dbo, edited);
				//
				AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

				MailService mailService = context.getBean("mailService", MailServiceImpl.class);

				String senderEmailId = "tiennguyennaraka@gmail.com";
				String receiverEmailId = email;
				String subject = "[Qu??n M???t Kh???u] Th?? g???i m???t kh???u m???i c???a b???n.";
				String message = "<div id=':33' class='ii gt' jslog='20277; u014N:xr6bB; 4:W251bGwsbnVsbCxbXV0.'>"
						+ "<div id=':32' class='a3s aiL '>" + "<u>" + "</u>" + "<div>"
						+ "<div style='width:800px;text-align:center;margin:0 auto'>"
						+ "<table align='center' width='800' height='1000' cellpadding='0' cellspacing='0' border='0' style='background:#A77979'>"
						+ "<tbody>" + "<tr>"
						+ "<td align='center' valign='top' style='background:url(https://wallpapercave.com/uwp/uwp2052576.jpeg)'>"
						+ "<table width='576' cellpadding='0' cellspacing='0' border='0'>" + "<tbody>" + "<tr>"
						+ "<td height='250'>" + "</td>" + "</tr>" + "<tr>"
						+ "<td align='left' valign='top' style='color:#fff'>"
						+ "<font color='#e35b5b' style='font-size:26px'>" + "<strong>" + "G???i kh??ch h??ng:" + "<br>"
						+ "????y ????y l?? m???t kh???u c???a b???n, vui l??ng nh???p v??o:" + "</strong>" + "</font>" + "</td>"
						+ "</tr>" + "<tr>" + "<td height='40' valign='top'>" + "</td>" + "</tr>" + "<tr>"
						+ "<td align='center' height='54' style='background:#202121;letter-spacing:15px;color:#ffffff'>"
						+ "<font size='6' color='#FFFFFF'>" +
						// code here
						pass +

						"</font>" + "</td>" + "</tr>" + "<tr>" + "<td height='40' valign='top'>" + "</td>" + "</tr>"
						+ "<tr>" + "<td valign='top' style='color:#e35b5b'>" + "<font size='4' color='#e35b5b'>"
						+ "M???i th???c m???c vui l??ng g???i email "
						+ "<a href='mailto:longan04111@gmail.com ' target='_blank'>" + "longan04111@gmail.com" + "</a>"
						+ "????? bi???t th??m th??ng tin." +

						"N???u b???n kh??ng c?? th???c m???c n??o, vui l??ng ?????ng g???i th?? r??c!." + "</font>" + "</td>" + "</tr>"
						+ "<tr>" + "<td height='40' valign='top'>" + "</td>" + "</tr>" + "<tr>"
						+ "<td height='60' valign='top' style='color:#e35b5b'>" + "<font size='4' color='#e35b5b'>"
						+ "M???t ng??y t???t l??nh???" + "</font>" + "</td>" + "</tr>" + "<tr>"
						+ "<td height='50' valign='top' style='color:#e35b5b'>" + "<font size='5' color='#e35b5b'>"
						+ "<strong>" + "TN" + "</strong>" + "</font>" + "</td>" + "</tr>" + "<tr>"
						+ "<td height='100%'>" + "</td>" + "</tr>" + "</tbody>" + "</table>" + "</td>" + "</tr>"
						+ "</tbody>" + "</table>" + "</div>" + "</div>" + "</div>" + "<div class='yj6qo'>" + "</div>"
						+ "</div>";

				mailService.sendEmail(senderEmailId, receiverEmailId, subject, message);
				context.close();
				return "login";
			} else {
				modelMap.put("error", "Kh??ng t??m th???y Email trong h??? th???ng!");

				return "forgotpassword";
			}
		} catch (Exception e) {
			/* modelMap.put("toastshow", "????ng nh???p kh??ng th??nh c??ng!"); */
			modelMap.put("error", "Kh??ng t??m th???y Email trong h??? th???ng!");
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
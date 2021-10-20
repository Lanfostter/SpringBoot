package com.trungtamjava.hellospringboot.com.trungtamjava.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.trungtamjava.hellospringboot.com.trungtamjava.dao.IDCardDao;
import com.trungtamjava.hellospringboot.com.trungtamjava.dao.UserDao;
import com.trungtamjava.hellospringboot.com.trungtamjava.model.IDCard;
import com.trungtamjava.hellospringboot.com.trungtamjava.model.User;

@Controller
public class UserController {
	public static List<User> users = new ArrayList<User>();
	@Autowired
	UserDao userDao;
	@Autowired
	IDCardDao idCardDao;

	@RequestMapping("/hello")
	public String sayHello(ModelMap map) {
		map.addAttribute("msg", "Controller");
		return "hello";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String addController(Model model) {
		model.addAttribute("user", new User());
		return "userview/adduser";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public String addController(@ModelAttribute("user") User user, @RequestParam("idNumber") String idNumber,
			BindingResult bindingResult, @RequestParam("begindate") String bdate, @RequestParam("enddate") String edate)
			throws ParseException {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "userview/adduser";
		} else {
			IDCard idCard = new IDCard();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			idCard.setIdNumber(idNumber);
			idCard.setIssuedon(simpleDateFormat.parse(bdate));
			idCard.setExpiredate(simpleDateFormat.parse(edate));
			idCard.setUser(user);
			userDao.save(user);
			idCardDao.save(idCard);
			return "redirect:/list-user";
		}
	}

	@RequestMapping("/list-user")
	public String listController(Model model) {
		List<User> users = userDao.findAll();
		model.addAttribute("users", users);
		return "userview/list";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String updateController(Model model, @RequestParam(name = "id", required = true) int id) {
		model.addAttribute("newuser", userDao.findById(id).get());
		return "userview/update";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateController(@ModelAttribute User user,
			@RequestParam("begindate") String bdate,
			@RequestParam("enddate") String edate) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		user.getIdCard().setIssuedon(simpleDateFormat.parse(bdate));
		user.getIdCard().setExpiredate(simpleDateFormat.parse(edate));
		user.getIdCard().setUser(user);
		userDao.save(user);
		return "redirect:/list-user";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteController(@RequestParam(name = "id", required = true) int id) {
		userDao.deleteById(id);
		return "redirect:/list-user";
	}

	@RequestMapping(value = "/search-user", method = RequestMethod.GET)
	public String searchController(HttpServletRequest request, @RequestParam(name = "id", required = true) int id) {
		User user = userDao.findById(id).orElse(null);
		if (user == null) {
			return "redirect:/list-user";
		} else {
			request.setAttribute("users", user);
			return "list";
		}

	}

	@RequestMapping(value = "/upload-file", method = RequestMethod.GET)
	public String upload(HttpServletRequest request) {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam(name = "file") MultipartFile file) {
		// lưu file xuống ổ cứng
		try {
			File newFile = new File(
					"D:\\hellospringboot\\src\\main\\resources\\static\\img\\" + file.getOriginalFilename());
			FileOutputStream fileOutputStream = new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("file", file);
		return "viewFile";
	}
//	@RequestMapping(value = "/download-file", method = RequestMethod.GET)
//	public String download(HttpServletRequest request, HttpServletResponse response) {
//		String dataDirectory = ("C:\\Users\\Tom\\Downloads\\");
//		Path file = Paths.get(dataDirectory, "1.jpeg");
//		
//	}
}

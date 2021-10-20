package com.trungtamjava.hellospringboot.com.trungtamjava.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.com.trungtamjava.dao.UserDao;
import com.trungtamjava.hellospringboot.com.trungtamjava.model.User;

@Controller
public class LoginController {
	@Autowired
	UserDao userDao;

	@GetMapping("/Sign-in")
	public String login() {
		return "login";
	}

	@PostMapping("/Sign-in")
	public String login(HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		User user = userDao.getlogin(username, password);
		if (user.getUsername().equals("admin") && user.getPassword().equals("12345")) {
			return "redirect:/list-user";
		} else {
			return "login";
		}
	}

}

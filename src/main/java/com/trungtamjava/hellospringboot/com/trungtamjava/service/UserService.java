package com.trungtamjava.hellospringboot.com.trungtamjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtamjava.hellospringboot.com.trungtamjava.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	

}

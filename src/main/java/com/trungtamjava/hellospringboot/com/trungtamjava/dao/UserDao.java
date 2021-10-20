package com.trungtamjava.hellospringboot.com.trungtamjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;//chon jpa k fai jdbc
import org.springframework.data.repository.query.Param;

import com.trungtamjava.hellospringboot.com.trungtamjava.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.username = :uname and u.password = :upass")//ten class ten entiy
	User getlogin(@Param("uname") String username, @Param("upass") String password);
}

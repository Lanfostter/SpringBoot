
package com.trungtamjava.hellospringboot.com.trungtamjava.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.trungtamjava.hellospringboot.com.trungtamjava.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> { 
	// tim theo tên thuộc tính // dùng câu lệnh JPQL
//
//	@Query("Select p from product p where p.username = :uname")
//
//	Product getBuyUsername(@Param("uname") String username);
//
//	public List<Product> findByName(String name);
}

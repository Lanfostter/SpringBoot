package com.trungtamjava.hellospringboot.com.trungtamjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.com.trungtamjava.model.IDCard;

public interface IDCardDao extends JpaRepository<IDCard, Integer>{

}

package com.trungtamjava.hellospringboot.com.trungtamjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trungtamjava.hellospringboot.com.trungtamjava.model.Manufacturer;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer>{

}

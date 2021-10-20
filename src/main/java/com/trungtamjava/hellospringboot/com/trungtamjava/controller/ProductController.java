package com.trungtamjava.hellospringboot.com.trungtamjava.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.trungtamjava.hellospringboot.com.trungtamjava.dao.ManufacturerDao;
import com.trungtamjava.hellospringboot.com.trungtamjava.dao.ProductDao;
import com.trungtamjava.hellospringboot.com.trungtamjava.model.Manufacturer;
import com.trungtamjava.hellospringboot.com.trungtamjava.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;//code theo quy tac di em ak
	@Autowired
	ManufacturerDao manufacturerDao;
	
	@GetMapping("/list-product")
	public String listController(Model model) {
		List<Product> products = productDao.findAll();
		model.addAttribute("products", products);
		return "productview/listproduct";
	}

	@GetMapping("/add-product")
	public String addController(HttpServletRequest request, Model model) {
		model.addAttribute("product", new Product());
		return "productview/addproduct";
	}

	@PostMapping("/add-product")
	public String addController(@ModelAttribute("product") Product product,
			@RequestParam("m_name") String name,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "productview/addproduct";
		} else {
			Manufacturer manufacturer = new Manufacturer();
			manufacturer.setName(name); 
			manufacturer.setProduct(product);
			productDao.save(product);
			manufacturerDao.save(manufacturer);
			return "redirect:/list-product";
		}
	}

	@GetMapping("/update-product")
	public String updateController(Model model, 
			@RequestParam(name = "id", required = true) int id) {
		Product product = productDao.findById(id).get();
		model.addAttribute("newproduct",product);
		return "productview/updateproduct";
	}

	@PostMapping("/update-product")
	public String updateController(@ModelAttribute Product product) {
		product.getManufacturer().setProduct(product);
		productDao.save(product);
		return "redirect:/list-product";
	}
	@GetMapping("/delete-product")
	public String deleteController(@RequestParam(name = "id", required = true) int id) {
		productDao.deleteById(id);
		return "redirect:/list-product";
	}

	@RequestMapping("/search-product")
	public String searchController(HttpServletRequest request, @RequestParam("id") int id) {
		Product product = productDao.findById(id).orElse(null);//return optional Object
		if (product == null) {
			return "redirect:/list-product";//redirect den url mapping 
		} else {
			//tim theo id no
			request.setAttribute("products", Arrays.asList(product)); //?
			return "productview/listproduct";
		}

	}
}

package com.myeshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@RequestMapping("/order")
public class OrderController {
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(){
		System.out.println("Order->Create");
		return "checkout";
	}

}

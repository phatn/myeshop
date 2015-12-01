package com.myeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("")
	public String dashboard() {
		return "dashboard";
	}
}

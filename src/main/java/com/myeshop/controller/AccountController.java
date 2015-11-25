package com.myeshop.controller;

import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
public class AccountController {
	
	/*@Inject
	@Qualifier("customerAuthenticationManager")*/
	private AuthenticationManager authenticationManager;
	
	
}

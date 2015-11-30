package com.myeshop.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myeshop.domain.Billing;
import com.myeshop.domain.Customer;
import com.myeshop.domain.Gender;
import com.myeshop.domain.Role;
import com.myeshop.service.CustomerService;
import com.myeshop.service.RoleService;
import com.myeshop.web.contants.RoleConstant;
import com.myeshop.web.entity.CustomerForm;
import com.myeshop.web.validator.CustomerValidator;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RoleService roleService;
	
	@Inject
	@Qualifier("customerAuthenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Inject
	@Qualifier("customerValidator")
	@Lazy
	private CustomerValidator customerValidator;
	
	@InitBinder
	public void initializeBinder(WebDataBinder binder) {
		binder.setValidator(customerValidator);
	}
	
	/*
	 * Handle Get request customer registration
	 * */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterForm(Model model) {
		model.addAttribute("customer", new CustomerForm());
		return "register";
	}
	
	/*
	 * Handle customer registration
	 * */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegisterForm(@ModelAttribute("customer") @Valid CustomerForm	form, 
			BindingResult result, Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			return "register";
		}
		
		String captcha = (String)session.getAttribute("CAPTCHA");
		if(captcha == null || (captcha != null && !captcha.equals(form.getCaptcha()))) {
			form.setCaptcha("");
			model.addAttribute("captchaMsg", "notmatch.customer.captcha");
			return "register";
		}
		
		Role roleCustomer = roleService.getRoleByName(RoleConstant.ROLE_CUSTOMER);
		Customer customer = toCustomer(form);
		customer.getRoles().add(roleCustomer);
		customerService.register(customer);
		Authentication authenticationRequest = new UsernamePasswordAuthenticationToken
				(form.getUserName(), form.getPassword());
		Authentication authenticationResult = authenticationManager.authenticate(authenticationRequest);
		SecurityContextHolder.getContext().setAuthentication(authenticationResult);
		return	"redirect:/";
	}
	
	@RequestMapping(value = "/checkout/step1", method = RequestMethod.GET)
	public String checkOutStep1(HttpSession session) {
		return "step1";
	}
	
	/*
	 * Convert from backing form to domain
	 * */
	private static Customer toCustomer(CustomerForm form) {
		Customer customer = new Customer();
		customer.setUserName(form.getUserName());
		customer.setPassword(form.getPassword());
		customer.setEmailAddress(form.getEmail());
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		if(!StringUtils.isEmpty(form.getGender())) {
			customer.setGender(Gender.valueOf(form.getGender()));
		}
		customer.setEnable(true);
		Billing billing = new Billing();
		billing.setFirstName(form.getFirstName());
		billing.setLastName(form.getLastName());
		billing.setCompanyAddress(form.getCompany());
		billing.setPhone(form.getPhone());
		billing.setAddress(form.getAddress());
		customer.setBilling(billing);
		return customer;
	}
	
}

package com.myeshop.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.myeshop.domain.Customer;
import com.myeshop.domain.Delivery;
import com.myeshop.domain.Order;
import com.myeshop.domain.OrderStatus;
import com.myeshop.service.CustomerService;
import com.myeshop.web.entity.DeliveryForm;
import com.myeshop.web.utils.UserUtils;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
	
	public enum CheckoutAddressType {
		CUSTOMER, DELIVERY
	}
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/step1", method = RequestMethod.GET)
	public String checkOutStep1(Model model) {
		model.addAttribute("delivery", new DeliveryForm());
		return "step1";
	}
	
	@RequestMapping(value = "/step1/delivery", method = RequestMethod.POST)
	public String checkOutStep2Delivery(@ModelAttribute("delivery") @Valid DeliveryForm	form, 
			BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "step1";
		}
		Customer customer = UserUtils.getLoggedInCustomer();
		customer.setDelivery(toDelivery(form));
		customerService.update(customer);
		model.addAttribute("deliveryAddress", CheckoutAddressType.DELIVERY.toString());
		return "redirect:/checkout/step2";
	}
	
	@RequestMapping(value = "/step1/billing", method = RequestMethod.POST)
	public String checkOutStep2Billing(Model model) {
		model.addAttribute("deliveryAddress", CheckoutAddressType.CUSTOMER.toString());
		return "redirect:/checkout/step2";
	}
	
	@RequestMapping(value = "/step2", method = RequestMethod.GET)
	public String checkOutStep2() {
		return "step2";
	}
	
	@RequestMapping(value = "/paypal", method = RequestMethod.POST)
	public String checkPaypal(HttpSession session) {
		Order order = (Order)session.getAttribute("order");
		order.setOrderStatus(OrderStatus.DELIVERED);
		session.removeAttribute("order");
		session.removeAttribute("scopedTarget.cart");
		return "redirect:/checkout/orderSuccess";
	}
	
	@RequestMapping(value = "/orderSuccess", method = RequestMethod.GET)
	public String checkOutSuccess() {
		return "orderSuccess";
	}
	
	private Delivery toDelivery(DeliveryForm form) {
		Delivery delivery = new Delivery();
		delivery.setFirstName(form.getFirstName());
		delivery.setLastName(form.getLastName());
		delivery.setAddress(form.getAddress());
		delivery.setPhone(form.getPhone());
		return delivery;
	}
}

package com.myeshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.myeshop.domain.Product;
import com.myeshop.service.ProductService;
import com.myeshop.web.entity.Cart;
import com.myeshop.web.entity.CartItem;

/**
 *  
 * @author Phat Nguyen
 * 
 */

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductService productService;
	@RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.POST)
	public String addToCart(@PathVariable("productId") Long productId, 
			@RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity, Model model) {
		Product product = productService.getById(productId);
		cart.add(product, quantity);
		return "redirect:/cart/shoppingCart";
	}
	
	@RequestMapping(value = "/clear", method = RequestMethod.GET)
	public String clear(HttpServletRequest request) {
		cart.clear();
		return "redirect:/cart/shoppingCart";
	}
	
	@RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
	public String remove(@PathVariable("productId") Long productId, HttpServletRequest request, Model model) {
		Product product = productService.getById(productId);
		cart.remove(product);
		return "redirect:/cart/shoppingCart";
	}
	
	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public String shoppingCart(Model model) {
		model.addAttribute("cart", cart);
		return "shoppingCart";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("productIds") List<Long> productIds, @RequestParam("quantities") List<Integer> quantities) {
		Map<Long, Integer> productIdMap = new HashMap<>();
		for(int i = 0; i < productIds.size(); i++) {
			productIdMap.put(productIds.get(i), quantities.get(i));
		}
		List<CartItem> cartItems = new ArrayList<>();
		CartItem item = null;
		List<Product> products = productService.getByIds(productIds);
		for(int i = 0; i < productIds.size(); i++) {
			item = new CartItem(productIdMap.get(products.get(i).getId()), products.get(i));
			cartItems.add(item);
		}
		cart.update(cartItems);
		return "redirect:/cart/shoppingCart";
	}
}

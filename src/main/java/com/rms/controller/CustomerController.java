package com.rms.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rms.model.CustomUser;
import com.rms.model.Order;

@Controller
public class CustomerController {
	

	@RequestMapping(value="/customer/home", method = RequestMethod.GET)
    public String customerHome(ModelMap model) {
 
        return "customerHome";
 
    }
	
	
	
	@RequestMapping("/customer/viewAllOrders")
	public String viewOpenOrders(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String name = user.getUser_id();
		System.out.println("the reason"+name);
//		List<Order> openOrders = orderService.getOpenOrders();
//		model.addAttribute("openOrders", openOrders);
		return "viewAllOrders";
	}

}

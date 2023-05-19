package com.rms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rms.model.CustomUser;
import com.rms.model.Order;
import com.rms.model.ReturnOrder;
import com.rms.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@RequestMapping("/csp/openorders")
	public String viewOpenOrders(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String name = user.getUser_id();
		System.out.println("the reason"+name);
		List<Order> openOrders = orderService.getOpenOrders();
		model.addAttribute("openOrders", openOrders);
		return "open-orders";
	}
	@RequestMapping("/csp/assignorder")
	public String assignOrder(@RequestParam("orderId") String orderId,Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String agent_id = user.getUser_id();
		orderService.assignOrderToCustomerSupportAgent(orderId, agent_id);
		System.out.println("This is "+orderId);
		List<Order> openOrders = orderService.getOpenOrders();
	    model.addAttribute("openOrders", openOrders);
	    return "open-orders";
	}
	
	
	
	@RequestMapping("/csp/viewassignedorders")
	public String viewAssignedOrders(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
//		System.out.println("In viewAssignedOrders"+orderId);
		String agent_id = user.getUser_id();
	  
		List<Map<String, Object>> assignedOrders = orderService.getAssignedOrders(agent_id);
	    model.addAttribute("assignedOrders", assignedOrders);
	    return "assigned-orders";
	}

}

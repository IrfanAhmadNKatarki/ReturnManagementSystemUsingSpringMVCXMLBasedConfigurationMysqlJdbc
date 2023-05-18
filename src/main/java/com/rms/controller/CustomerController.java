package com.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rms.model.CustomUser;
import com.rms.model.Order;
import com.rms.service.CustomerService;
import com.rms.service.OrderService;

@Controller
public class CustomerController {

	@Autowired
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value = "/customer/customerHome", method = RequestMethod.GET)
	public String customerHome(ModelMap model) {

		return "customerHome";

	}

	@RequestMapping(value = "/customer/viewAllOrders", method = RequestMethod.GET)
	public String viewOpenOrders(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String customer_id = user.getUser_id();
		System.out.println("the reason" + customer_id);
//		List<Order> openOrders = orderService.getOpenOrders();
//		model.addAttribute("openOrders", openOrders);
		List<Order> orders = customerService.getCustomerOrders(customer_id);
		model.addAttribute("orders", orders);
		System.out.println(orders);

		return "viewAllOrders";
	}

	@RequestMapping("/customer/createorupdateform")
	public String selectReturnRequestForms(@RequestParam("orderId") String orderId, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String customer_id = user.getUser_id();

		System.out.println("This is " + orderId);

		boolean checkReturnIdExistUpdateReason = customerService.getReturnIdForUpdateReason(orderId);
		System.out.println(checkReturnIdExistUpdateReason);
		if (checkReturnIdExistUpdateReason) {
			return "UpdateReasonForm";
		} else {

			return "createOrUpdateForm";
		}

	}

	/* This below method is for updating only reason and return id already exist */
	@PostMapping("/customer/returnForm")
	public String setReturnRequestForms(@RequestParam("returnReason") String returnReason,
			@RequestParam("orderId") String orderId, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String customer_id = user.getUser_id();
		customerService.updateAfterReturnIdExist(returnReason, orderId);
		System.out.println("This is " + orderId);

		return "redirect:/customer/home";

	}

	/* This below method is for updating only reason and for fresh return id */

	@PostMapping("/customer/freshReturn")
	public String setReturnRequestFormsFresh(@RequestParam("returnReason") String returnReason,
			@RequestParam("orderId") String orderId, @RequestParam("returnId") String returnId, Model model) {

		customerService.createNewReturnRequest(returnReason, orderId, returnId);
		System.out.println("This is " + orderId);

		return "redirect:/customer/home";

	}

	@GetMapping("/customer/checkreturnstatus")
	public String customerCheckReturnStatus(@RequestParam("orderId") String orderId, Model model) {

		String returnStatus = customerService.customerCheckingReturnStatus(orderId);
		model.addAttribute("returnStatus",returnStatus);
		System.out.println("This is " + orderId);

		return "returnStatusView";

	}

	@GetMapping("/customer/checkrefundstatus")
	public String customerCheckRefundStatus(@RequestParam("orderId") String orderId, Model model) {

		 String refundStatus = customerService.customerCheckingRefundStatus(orderId);
		System.out.println("This is " + orderId);

		model.addAttribute("refundStatus", refundStatus);
        return "refundStatusView";

	}

}

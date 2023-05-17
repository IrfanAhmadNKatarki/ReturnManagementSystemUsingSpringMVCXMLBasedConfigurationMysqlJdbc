package com.rms.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rms.model.CustomUser;
import com.rms.service.ReturnRefundService;

@Controller
public class ReturnRefundController {

	private ReturnRefundService returnRefundService;

//		private OrderService orderService;

	public void setReturnRefundService(ReturnRefundService returnRefundService) {
		this.returnRefundService = returnRefundService;
	}

	@RequestMapping("/csp/selectstatus")
	public String selectReturnStatus(@RequestParam("orderId") String orderId, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String agent_id = user.getUser_id();

		System.out.println("This is " + orderId);

		return "selectstatus";
	}

	@PostMapping("/csp/setReturnStatus")
	public String setReturnStatus(@RequestParam("orderId") String orderId,
			@RequestParam("returnStatus") String returnStatus) {
		// Update the return status in the returnorder table
		returnRefundService.updateReturnStatus(orderId, returnStatus);

		return "redirect:/csp/viewassignedorders";
	}

	@RequestMapping("/csp/selectrefundstatus")
	public String selectRefundStatus(@RequestParam("orderId") String orderId, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		String agent_id = user.getUser_id();

		System.out.println("This is " + orderId);
		boolean isReturnExistandCompleted = returnRefundService.checkReturnExistForrefund(orderId);
		System.out.println(isReturnExistandCompleted);
		if (isReturnExistandCompleted) {
	        return "selectrefundstatus";
	    } else {
	        model.addAttribute("errorMessage", "Return is still in process");
	        return "redirect:/csp/viewassignedorders";
	    }
	}

	@PostMapping("/csp/setRefundStatus")
	public String setRefundStatus(@RequestParam("orderId") String orderId,
			@RequestParam("refundStatus") String refundStatus) {
		// Update the return status in the returnorder table
		returnRefundService.updateRefundstatus(orderId, refundStatus);

		return "redirect:/csp/viewassignedorders";
	}

}

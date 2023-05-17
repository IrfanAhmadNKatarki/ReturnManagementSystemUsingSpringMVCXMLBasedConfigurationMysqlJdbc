package com.rms.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rms.model.CustomUser;

@Controller
public class HomeController {

	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String helloWorld(ModelMap model) {

		/*
		 * Object principal =
		 * SecurityContextHolder.getContext().getAuthentication().getPrincipal(); User
		 * user=null; if (principal instanceof User) { user = ((User)principal); }
		 */
		// String name = user.getUsername();
		// model.addAttribute("username", name);
		model.addAttribute("message", "Welcome to the Hello World page");
		return "helloworld";

	}

	@RequestMapping(value = "/csp/example", method = RequestMethod.GET)
	public String securedHome(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CustomUser user = null;
//		principal.getName();
//		System.out.println(principal.getName();
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}

		String name = user.getUser_id();
		System.out.println("the reason"+name);
		model.addAttribute("user_id", name);
		model.addAttribute("message", "Welcome to the secured page");
		return "home";

	}

	 @RequestMapping(value="/login", method = RequestMethod.GET)
	    public String login(ModelMap model) {
	 
	        return "login";
	 
	    }
	 
	 
	 @RequestMapping(value="/csp/cspHome", method = RequestMethod.GET)
	    public String backToHome(ModelMap model) {
	 
	        return "cspHome";
	 
	    }
	 @RequestMapping(value="/csp/logout", method = RequestMethod.GET)
	    public String logOut(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		 HttpSession session = request.getSession(false);
		    SecurityContextHolder.clearContext();
		    if (session != null) {
		        session.invalidate();
		    }
	        return "redirect:/";
	 
	    }
	 
}
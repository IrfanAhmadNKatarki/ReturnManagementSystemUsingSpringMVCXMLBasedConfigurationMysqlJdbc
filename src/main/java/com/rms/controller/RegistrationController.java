package com.rms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rms.model.CustomUser;

import com.rms.service.UserServiceInt;

@Controller
public class RegistrationController {
	@Autowired
	public UserServiceInt userServiceInt;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("customUser", new CustomUser());
		
		

		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") CustomUser customUser) {
//		ModelAndView mav = new ModelAndView("register");
//		if (result.hasErrors()) {
//	            return mav;
//	        }
		String role = request.getParameter("role");
		customUser.setRole(role);
		userServiceInt.register(customUser);

		return new ModelAndView("login", "firstname", customUser.getFirstName());
		
	}

}
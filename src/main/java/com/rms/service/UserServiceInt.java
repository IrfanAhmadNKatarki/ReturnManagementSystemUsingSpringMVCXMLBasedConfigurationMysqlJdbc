package com.rms.service;

import org.springframework.stereotype.Component;

import com.rms.model.CustomUser;


public interface UserServiceInt {
	
	int register(CustomUser customUser);
}

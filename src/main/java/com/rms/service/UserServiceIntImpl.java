package com.rms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dao.UserDaoRegInt;
import com.rms.model.CustomUser;

public class UserServiceIntImpl implements UserServiceInt {

	@Autowired
	public UserDaoRegInt userDaoRegInt;

	@Override
	public int register(CustomUser customUser) {
		// TODO Auto-generated method stub
		return userDaoRegInt.register(customUser);
	}

}

package com.rms.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rms.model.CustomUser;

public class UserDaoRegImpl implements UserDaoRegInt {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public int register(CustomUser customUser) {

		String sql = "insert into users values(?,?,COALESCE(?, true),?,?,?)";

		String userRoleSql = "INSERT INTO authorities (user_id, authority) VALUES (?, ?)";

		int noOfRows = jdbcTemplate.update(sql, new Object[] { customUser.getUser_id(), customUser.getPassword(),
				customUser.isEnabled(),customUser.getEmail(),  customUser.getFirstName(), customUser.getLastName() });

		jdbcTemplate.update(userRoleSql, new Object[] { customUser.getUser_id(), customUser.getRole() });

		return noOfRows;
	}
}

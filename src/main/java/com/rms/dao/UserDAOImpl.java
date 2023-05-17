package com.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import com.rms.model.CustomUserOrderWrapper;
import com.rms.model.CustomUser;
import com.rms.model.Role;

@Repository
public class UserDAOImpl {

	private String agent_id = "";
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public CustomUser loadUserByUsername(String user_id) throws UsernameNotFoundException {
		String sql = "SELECT\r\n" + "    u.user_id,\r\n" + "    u.password,\r\n" + "    a.authority,\r\n"
				+ "    CASE\r\n" + "        WHEN a.authority = 'ROLE_ADMIN' THEN u.user_id\r\n"
				+ "        ELSE NULL\r\n" + "    END AS agent_id\r\n" + "FROM\r\n" + "    users u\r\n"
				+ "    JOIN authorities a ON u.user_id = a.user_id\r\n" + "WHERE\r\n" + "    u.user_id = ?";
		try {
			List<CustomUser> users = jdbcTemplate.query(sql, new Object[] { user_id }, new UserMapper());
			if (!users.isEmpty()) {
				return users.get(0);
			} else {
				throw new UsernameNotFoundException("User not found");
			}
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found");
		}
	}

	public String getAgent_id() {
		return agent_id;
	}

	public String setAgent_id(String agent_id) {
		return this.agent_id = agent_id;
	}

	private class UserMapper implements RowMapper<CustomUser> {
		@Override
		public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
			String user_id = rs.getString("user_id");
			String password = rs.getString("password");
			String authority = rs.getString("authority");
			String agentId = rs.getString("agent_id");
			System.out.println("Inside UserDAOIMPl" + agentId);
			Role role = new Role();
			role.setName(authority);
			String ss = setAgent_id(agentId);
			System.out.println("the devoe" + ss);
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(authority));

			CustomUser customUser = new CustomUser();
			customUser.setUser_id(user_id);
			customUser.setPassword(password);
			customUser.setAuthorities(authorities);
			customUser.setAgentId(agentId); // Set the agentId property

			return customUser;
		}
	}

}

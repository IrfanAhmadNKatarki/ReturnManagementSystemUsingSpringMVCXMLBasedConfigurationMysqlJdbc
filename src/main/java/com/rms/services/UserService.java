package com.rms.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String sql = "SELECT username, password, enabled FROM users WHERE username = ?";
        System.out.println("In userDetail now");
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{username}, getUserRowMapper());
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private RowMapper<UserDetails> getUserRowMapper() {
        return new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String fetchedUsername = rs.getString("username");
                String fetchedPassword = rs.getString("password");
                boolean enabled = rs.getBoolean("enabled");
                System.out.println("In userDetail now 2");
                System.out.println(fetchedUsername);
                System.out.println("In userDetail now 2");
                // Retrieve the user's authorities/roles from the database
                List<GrantedAuthority> authorities = getAuthoritiesByUsername(fetchedUsername);
                System.out.println("The Irfan"+authorities);
                // Create and return a UserDetails object based on the retrieved user data
                return new User(fetchedUsername, fetchedPassword, enabled, true, true, true, authorities);
            }
        };
    }

    @SuppressWarnings("deprecation")
	private List<GrantedAuthority> getAuthoritiesByUsername(String username) {
//        String sql = "SELECT r.name FROM roles r INNER JOIN user_roles ur ON r.id = ur.role_id " +
//                "INNER JOIN users u ON u.id = ur.user_id WHERE u.username = ?";
    	String sql = "SELECT authority FROM role where username = ? ";
        return jdbcTemplate.query(sql, new Object[]{username}, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = rs.getString("authority");
                return new SimpleGrantedAuthority(roleName);
            }
        });
    }
}
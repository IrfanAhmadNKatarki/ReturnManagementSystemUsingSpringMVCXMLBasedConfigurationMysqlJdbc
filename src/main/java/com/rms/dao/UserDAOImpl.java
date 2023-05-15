package com.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.rms.model.CustomUser;
import com.rms.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.rms.model.CustomUser;
import com.rms.model.Role;

@Repository
public class UserDAOImpl {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public CustomUser loadUserByUsername(String user_id) throws UsernameNotFoundException {
        String sql = "SELECT u.user_id, u.password, a.authority " +
                     "FROM users u " +
                     "JOIN authorities a ON u.user_id = a.user_id " +
                     "WHERE u.user_id = ?";
        try {
            List<CustomUser> users = jdbcTemplate.query(sql, new Object[]{user_id}, new UserMapper());
            if (!users.isEmpty()) {
                return users.get(0);
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }

    private class UserMapper implements RowMapper<CustomUser> {
        @Override
        public CustomUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            String user_id = rs.getString("user_id");
            String password = rs.getString("password");
            String authority = rs.getString("authority");
            System.out.println("------------------------");

            System.out.println(user_id);
            System.out.println(password);
            System.out.println(authority);
            Role role = new Role();
            role.setName(authority);

            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(authority));

            CustomUser customUser = new CustomUser();
            customUser.setUser_id(user_id);
            customUser.setPassword(password);
            customUser.setAuthorities(authorities);

            return customUser;
        }
    }
}
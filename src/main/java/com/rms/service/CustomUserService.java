package com.rms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rms.dao.UserDAOImpl;
import com.rms.model.CustomUser;

@Service
public class CustomUserService implements UserDetailsService {
	 
    @Autowired
    private UserDAOImpl userDao;
    
  
    
   public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
       System.out.println("In CustomUserService");
       return userDao.loadUserByUsername(username);
   }
   
   

}






























//	@Autowired
//    private UserDAOImpl userDao;
//    
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
//        String sql = "SELECT username, password, enabled FROM users WHERE username = ?";
//        
//        try {
//            return (CustomUser) jdbcTemplate.queryForObject(sql, new Object[]{username}, getUserRowMapper());
//        } catch (EmptyResultDataAccessException e) {
//            throw new UsernameNotFoundException("User not found");
//        }
//    }
//
//    private RowMapper<UserDetails> getUserRowMapper() {
//        return new RowMapper<UserDetails>() {
//            @Override
//            public UserDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//                String fetchedUsername = resultSet.getString("username");
//                String fetchedPassword = resultSet.getString("password");
//                boolean enabled = resultSet.getBoolean("enabled");
////                System.out.println(fetchedUsername);
////                System.out.println(fetchedPassword);
////                System.out.println(enabled);
//                CustomUser customUser = new CustomUser();
//                customUser.setUsername(fetchedUsername);
//                customUser.setPassword(fetchedPassword);
//                customUser.setEnabled(enabled);
//                System.out.println("full customUser"+customUser);
//                return customUser;
//            }
//        };
//    }
//}
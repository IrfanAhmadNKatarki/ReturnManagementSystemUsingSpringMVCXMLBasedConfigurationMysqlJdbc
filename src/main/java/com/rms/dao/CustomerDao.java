package com.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rms.model.Order;

public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@SuppressWarnings("deprecation")
	public List<Order> getOrdersByCustomer(String customerId) {
	    String sql = "SELECT * FROM orders WHERE customer_id = ?";
	    return jdbcTemplate.query(sql, new Object[]{customerId}, new RowMapper<Order>() {
	        @Override
	        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Order order = new Order();
	            order.setOrderId(rs.getString("order_id"));
	            order.setOrderDate(rs.getDate("order_date"));
	            order.setProductName(rs.getString("product_name"));
	           
	            // Map other properties of the Order entity
	            System.out.println(order.getOrderId());
	            System.out.println(order.getOrderDate());
	            
	            return order;
	        }
	    });
	}

	public boolean isReturnEligiblePolicy(String orderId) {
		// TODO Auto-generated method stub
		
		return false;
	}


	public boolean isReturnExistOnlyUpdateReason(String orderId) {
	    String sql = "SELECT COUNT(*) FROM returnorder WHERE order_id = ? AND return_id IS NOT NULL";
	    int count = jdbcTemplate.queryForObject(sql, Integer.class, orderId);
	    System.out.println("isReturnExistOnlyUpdateReason: " + count);
	    return count > 0;
	}


	public void updateReason(String returnReason, String orderId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE returnorder SET return_reason = ?, return_date = CURDATE() WHERE order_id = ?";
	    jdbcTemplate.update(sql, returnReason, orderId);
	}

	public void createReturnRequest(String returnReason, String orderId, String returnId) {
	    String sql = "INSERT INTO returnorder (return_id, order_id, return_date, return_reason) VALUES (?, ?, CURDATE(), ?)";
	    jdbcTemplate.update(sql, returnId, orderId, returnReason);
	}

	public String customerCheckReturnStatus(String orderId) {
		// TODO Auto-generated method stub
		String sql = "select return_status from returnorder where order_id = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, String.class);

	}


	public String customerCheckRefundStatus(String orderId) {
	    String sql = "SELECT refund_status FROM refund WHERE return_id = (SELECT return_id FROM returnorder WHERE order_id = ?)";
	    try {
	        return jdbcTemplate.queryForObject(sql, new Object[]{orderId}, String.class);
	    } catch (EmptyResultDataAccessException e) {
	        return "No refund status available";
	    }
	}

	
	
	
	
}

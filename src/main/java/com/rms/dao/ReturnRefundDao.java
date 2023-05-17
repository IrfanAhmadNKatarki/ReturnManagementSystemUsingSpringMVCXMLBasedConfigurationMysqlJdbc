package com.rms.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class ReturnRefundDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void updateReturnStatus(String orderId, String returnStatus) {
		// TODO Auto-generated method stub
		String sql = "UPDATE returnorder SET return_status = ? WHERE order_id = ?";
        jdbcTemplate.update(sql, returnStatus, orderId);
	}

	public void updateRefundStatus(String orderId, String refundStatus) {
		// TODO Auto-generated method stub
	    String sql = "UPDATE refund SET refund_status = ? WHERE return_id = (SELECT return_id FROM returnorder WHERE order_id = ?)";
        jdbcTemplate.update(sql, refundStatus, orderId);
	}

	public boolean checkReturnExist(String orderId) {
	    String sql = "SELECT COUNT(*) FROM returnorder WHERE order_id = ? AND return_status = 'completed'";
	    int count = jdbcTemplate.queryForObject(sql, Integer.class, orderId);
	    System.out.println("coutn"+count);
	    return count > 0;
	}
	
	

}

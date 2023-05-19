package com.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rms.model.Order;
import com.rms.model.ReturnOrder;

public class OrderDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Order> getOpenOrders() {
//		String query = "SELECT * FROM orders WHERE status = 'Delivered' AND eligible_for_return = 1";
		String query = "SELECT o.customer_id, o.order_id, o.order_date FROM orders o JOIN returnorder r ON o.order_id = r.order_id\r\n"
				+ "WHERE (r.admin_approval = false OR r.admin_approval = 0) AND (r.assigned_agent_id IS NULL OR r.assigned_agent_id = 0)";
//		String query = "SELECT * FROM orders WHERE status = 'Delivered' AND eligible_for_return = 1 AND assigned_agent_id = 'NULL'";

		return jdbcTemplate.query(query, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
				Order order = new Order();
				order.setCustomerId(rs.getString("customer_id"));
				order.setOrderId(rs.getString("order_id"));
				order.setOrderDate(rs.getDate("order_date"));
				// Set other properties of the order
				return order;
			}

		});
	}

	public Order getOrderById(String orderId) {
		String query = "SELECT * FROM orders WHERE order_id = ?";
		RowMapper<Order> rowMapper = new BeanPropertyRowMapper<>(Order.class);
		Order order = jdbcTemplate.queryForObject(query, rowMapper, orderId);
		return order;
	}


	
	public void assignOrderToCustomerSupportAgent(String orderId, String agentId) {
		String query = "UPDATE returnorder SET assigned_agent_id = ?, admin_approval = 1 WHERE order_id = ?";
		jdbcTemplate.update(query, agentId, orderId);
	}
	

	
	public List<Map<String, Object>> getAssignedOrders(String agent_id) {
		// TODO Auto-generated method stub
		System.out.println("In assigned orders"+agent_id);
		String sql = "SELECT o.order_id, o.customer_id, r.return_id, r.return_date, r.return_reason FROM orders o JOIN returnorder r ON r.order_id = o.order_id WHERE r.assigned_agent_id = ?";
		 return jdbcTemplate.queryForList(sql, agent_id);
	}
	
	




}
package com.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.rms.model.Order;

public class OrderDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Order> getOpenOrders() {
		String query = "SELECT * FROM orders WHERE status = 'Delivered' AND eligible_for_return = 1";
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

	public void updateOrder(Order order) {
		String query = "UPDATE orders SET assigned_agent_id = ? WHERE order_id = ?";
		jdbcTemplate.update(query, order.getAgentId(), order.getOrderId());
	}

	public Order getOrderById(String orderId) {
		String query = "SELECT * FROM orders WHERE order_id = ?";
		RowMapper<Order> rowMapper = new BeanPropertyRowMapper<>(Order.class);
		Order order = jdbcTemplate.queryForObject(query, rowMapper, orderId);
		return order;
	}

	public void assignOrderToCustomerSupportAgent(String orderId, String agentId) {
		String query = "UPDATE orders SET assigned_agent_id = ? WHERE order_id = ?";
		jdbcTemplate.update(query, agentId, orderId);
	}

	public List<Order> getAssignedOrders(String agent_id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM orders WHERE assigned_agent_id = ?";
		return jdbcTemplate.query(sql, new Object[] { agent_id }, new BeanPropertyRowMapper<>(Order.class));
	}

}
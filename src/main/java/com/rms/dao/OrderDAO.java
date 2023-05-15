package com.rms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rms.model.Order;

public class OrderDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Order> getOpenOrders() {
        String query = "SELECT * FROM orders WHERE status = 'open' AND eligible_for_return = true";
        return jdbcTemplate.query(query, new RowMapper<Order>() {
			@Override
			public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			    Order order = new Order();
			    order.setOrderId(rs.getInt("order_id"));
			    order.setCustomerName(rs.getString("customer_name"));
			    // Set other properties of the order
			    return order;
			}
		});
    }
}
package com.rms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReportDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int getMonthlyProcessedReturnCount() {
		String sql = "SELECT COUNT(*) FROM returnorder WHERE MONTH(return_date) = MONTH(CURRENT_DATE())";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getAnnualProcessedReturnCount() {
		String sql = "SELECT COUNT(*) FROM returnorder WHERE YEAR(return_date) = YEAR(CURRENT_DATE())";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getQuarterlyProcessedReturnCount() {
		String sql = "SELECT COUNT(*) FROM returnorder WHERE QUARTER(return_date) = QUARTER(CURRENT_DATE())";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getMonthlyProcessedRefundCount() {
		String sql = "SELECT COUNT(*) FROM refund WHERE MONTH(refund_date) = MONTH(CURRENT_DATE())";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getAnnualProcessedRefundCount() {
		String sql = "SELECT COUNT(*) FROM refund WHERE YEAR(refund_date) = YEAR(CURRENT_DATE())";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public int getQuarterlyProcessedRefundCount() {
		String sql = "SELECT COUNT(*) FROM refund WHERE QUARTER(refund_date) = QUARTER(CURRENT_DATE())";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	
}

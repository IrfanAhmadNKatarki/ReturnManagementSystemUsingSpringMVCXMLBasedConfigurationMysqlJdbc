package com.rms.model;

import java.sql.Date;

public class Order {
    private String orderId;
    private String customerId;
    private Date orderDate;
    private String status;
    private boolean eligibleForReturn;
    private String agentId;
    // Constructor
    public Order(String orderId, String customerId, Date orderDate, String status, boolean eligibleForReturn) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
        this.eligibleForReturn = eligibleForReturn;
    }

    // Getters and Setters

    public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date date) {
        this.orderDate = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isEligibleForReturn() {
        return eligibleForReturn;
    }

    public void setEligibleForReturn(boolean eligibleForReturn) {
        this.eligibleForReturn = eligibleForReturn;
    }

    // toString method

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", eligibleForReturn=" + eligibleForReturn +
                '}';
    }

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
}

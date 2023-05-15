package com.rms.model;

import java.sql.Date;

public class Order {
    private int orderId;
    private String customerName;
    private Date orderDate;

    // Constructors, getters, and setters

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(int orderId, String customerName, Date orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    // Getters and setters

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}


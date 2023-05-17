package com.rms.model;

import java.sql.Date;

public class ReturnOrder {
    private String returnId;
    private String orderId;
    private Date returnDate;
    private String returnStatus;

    public ReturnOrder() {
    }

    public ReturnOrder(String returnId, String orderId, Date returnDate, String returnStatus) {
        this.returnId = returnId;
        this.orderId = orderId;
        this.returnDate = returnDate;
        this.returnStatus = returnStatus;
    }

    // Getters and Setters

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }
}


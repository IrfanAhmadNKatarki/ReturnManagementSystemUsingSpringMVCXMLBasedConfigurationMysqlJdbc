package com.rms.model;

import java.sql.Date;

public class Refund {
    private String refundId;
    private String returnId;
    private Date refundDate;
    private String refundStatus;

    public Refund() {
    }

    public Refund(String refundId, String returnId, Date refundDate, String refundStatus) {
        this.refundId = refundId;
        this.returnId = returnId;
        this.refundDate = refundDate;
        this.refundStatus = refundStatus;
    }

    // Getters and Setters

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
}


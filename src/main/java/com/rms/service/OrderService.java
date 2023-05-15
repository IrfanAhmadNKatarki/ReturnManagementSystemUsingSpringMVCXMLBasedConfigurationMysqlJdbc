package com.rms.service;

import java.util.List;

import com.rms.dao.OrderDAO;
import com.rms.model.Order;

public class OrderService {

    private OrderDAO orderDAO;

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<Order> getOpenOrders() {
        return orderDAO.getOpenOrders();
    }
}
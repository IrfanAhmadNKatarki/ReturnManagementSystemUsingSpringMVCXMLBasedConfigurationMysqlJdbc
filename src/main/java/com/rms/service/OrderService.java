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
    
    public void assignOrderToCustomerSupportAgent(String orderId, String agentId) {
        orderDAO.assignOrderToCustomerSupportAgent(orderId, agentId);
    }

	public void assignOrder(String orderId, String agent_id) {
		// TODO Auto-generated method stub
		Order order = orderDAO.getOrderById(orderId);
        if (order != null) {
            order.setAgentId(agent_id);
            orderDAO.updateOrder(order);
        }
    }


	public List<Order> getAssignedOrders(String agent_id) {
		// TODO Auto-generated method stub
		return orderDAO.getAssignedOrders(agent_id);
	}
	
}
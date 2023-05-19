package com.rms.service;

import java.util.List;
import java.util.Map;

import com.rms.dao.OrderDAO;
import com.rms.model.Order;
import com.rms.model.ReturnOrder;

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




	public List<Map<String, Object>> getAssignedOrders(String agent_id) {
		// TODO Auto-generated method stub
		return orderDAO.getAssignedOrders(agent_id);
	}


//	public List<Order> getCustomerOrders(String customer_id) {
//		// TODO Auto-generated method stub
//		System.out.println("In getCustomerOrders "+customer_id);
//		return orderDAO.getOrdersByCustomer(customer_id);
//
//	}
	
}
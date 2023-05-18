package com.rms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dao.CustomerDao;
import com.rms.model.Order;

public class CustomerService {

		@Autowired
		private CustomerDao customerDao;

		public void setCustomerDao(CustomerDao customerDao) {
			this.customerDao = customerDao;
		}
		
		public List<Order> getCustomerOrders(String customer_id) {
			// TODO Auto-generated method stub
			System.out.println("In getCustomerOrders "+customer_id);
			return customerDao.getOrdersByCustomer(customer_id);
		}


	
		public boolean getReturnIdForUpdateReason(String orderId) {
			// TODO Auto-generated method stub
			return customerDao.isReturnExistOnlyUpdateReason(orderId);
		}

		
		public void updateAfterReturnIdExist(String returnReason, String orderId) {
			// TODO Auto-generated method stub
			customerDao.updateReason(returnReason,orderId);
		}

		public void createNewReturnRequest(String returnReason, String orderId, String returnId) {
			// TODO Auto-generated method stub
			customerDao.createReturnRequest(returnReason,orderId, returnId);
		}

		public String customerCheckingReturnStatus(String orderId) {
			// TODO Auto-generated method stub
			return customerDao.customerCheckReturnStatus(orderId);
		}

		public String customerCheckingRefundStatus(String orderId) {
			// TODO Auto-generated method stub
			return customerDao.customerCheckRefundStatus(orderId);
		}

		
		
}

package com.rms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dao.ReturnRefundDao;

public class ReturnRefundService {

	@Autowired
	private ReturnRefundDao returnRefundDao;

	public void setReturnRefundDao(ReturnRefundDao returnRefundDao) {
		this.returnRefundDao = returnRefundDao;
	}

	public void updateReturnStatus(String orderId, String returnStatus) {
		// TODO Auto-generated method stub
		returnRefundDao.updateReturnStatus(orderId, returnStatus);
	}

	public void updateRefundstatus(String orderId, String refundStatus) {
		// TODO Auto-generated method stub
		returnRefundDao.updateRefundStatus(orderId, refundStatus);
	}

	public boolean checkReturnExistForrefund(String orderId) {
		return returnRefundDao.checkReturnExist(orderId);
	}

	
	
	
	
	
}

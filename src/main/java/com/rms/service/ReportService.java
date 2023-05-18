package com.rms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dao.ReportDao;

public class ReportService {


	private ReportDao reportDao;

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	public int getMonthlyProcessedReturnCount() {
        // TODO: Implement logic to retrieve the monthly processed return count from the database
        return reportDao.getMonthlyProcessedReturnCount();
    }

    public int getAnnualProcessedReturnCount() {
        // TODO: Implement logic to retrieve the annual processed return count from the database
        return reportDao.getAnnualProcessedReturnCount();
    }

    public int getQuarterlyProcessedReturnCount() {
        // TODO: Implement logic to retrieve the quarterly processed return count from the database
        return reportDao.getQuarterlyProcessedReturnCount();
    }
    
    
    public int getMonthlyProcessedRefundCount() {
        // TODO: Implement logic to retrieve the monthly processed return count from the database
        return reportDao.getMonthlyProcessedRefundCount();
    }

    public int getAnnualProcessedRefundCount() {
        // TODO: Implement logic to retrieve the annual processed return count from the database
        return reportDao.getAnnualProcessedRefundCount();
    }

    public int getQuarterlyProcessedRefundCount() {
        // TODO: Implement logic to retrieve the quarterly processed return count from the database
        return reportDao.getQuarterlyProcessedRefundCount();
    }

	
}

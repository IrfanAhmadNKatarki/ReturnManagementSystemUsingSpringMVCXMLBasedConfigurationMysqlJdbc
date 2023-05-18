package com.rms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rms.service.ReportService;

@Controller
public class ReportController {

	private ReportService reportService;

	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}

	@RequestMapping("/csp/reportgenerated")
	public String viewReport(Model model) {
		// TODO: Retrieve the counts of returns and refunds processed monthly, annually,
		// and quarterly
		int monthlyReturnCount = reportService.getMonthlyProcessedReturnCount();
		int annualReturnCount = reportService.getAnnualProcessedReturnCount();
		int quarterlyReturnCount = reportService.getQuarterlyProcessedReturnCount();
		int monthlyRefundCount = reportService.getMonthlyProcessedRefundCount();
		int annualRefundCount = reportService.getAnnualProcessedRefundCount();
		int quarterlyRefundCount = reportService.getQuarterlyProcessedRefundCount();

		// Pass the counts to the view
		model.addAttribute("monthlyReturnCount", monthlyReturnCount);
		model.addAttribute("annualReturnCount", annualReturnCount);
		model.addAttribute("quarterlyReturnCount", quarterlyReturnCount);
		model.addAttribute("monthlyRefundCount", monthlyRefundCount);
		model.addAttribute("annualRefundCount", annualRefundCount);
		model.addAttribute("quarterlyRefundCount", quarterlyRefundCount);

		// Return the view name
		return "reportgenerated";
	}

}

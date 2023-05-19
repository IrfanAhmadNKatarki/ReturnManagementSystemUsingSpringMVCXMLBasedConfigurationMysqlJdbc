<!-- selectstatus.jsp -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select Return Status</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3 class="text-center">Select Return Status</h3>

		<form action="setRefundStatus" method="post">
			<div class="form-group">
				<label for="refundStatusSelect">Select Refund Status:</label> <select
					class="form-control" id="refundStatusSelect" name="refundStatus">
					<option value="pending">Pending</option>
					<option value="initiated">Initiated</option>
					<option value="verifying">Verifying</option>
					<option value="rejected">Rejected</option>
					<option value="completed_check_for_refund">Completed - Check for refund</option>
					
					<!-- Add more options as needed -->
				</select>
			</div>

		<input type="hidden" name="orderId" value="${param.orderId}">

			<div class="text-center">
				<button type="submit" class="btn btn-primary">Save</button>
				
				<a href="viewassignedorders" class="btn btn-default">Cancel</a>
			</div>
		</form>
			
	</div>
</body>
</html>

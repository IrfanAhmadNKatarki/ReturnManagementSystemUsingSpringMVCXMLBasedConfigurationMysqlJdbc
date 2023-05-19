<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assigned Orders</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.logout-link {
	position: absolute;
	top: 15px;
	right: 15px;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">Assigned Orders</h3>
		<a href="logout" class="btn btn-default logout-link">Logout</a>
		<h1>Assigned Orders</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Customer ID</th>
					<th>Return ID</th>
					<th>Return Date</th>
					<th>Return Reason</th>
					<th>Order Id</th>
					<th>&nbsp;&nbsp;&nbsp;&nbsp;Actions</th> 
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assignedOrders}" var="order">
					<tr>
						<td>${order.customer_id}</td>
						<td>${order.return_id}</td>
						<td>${order.return_date}</td>
						<td>${order.return_reason}</td>
						<td>${order.order_id}</td> 
						

						<td><a href="selectstatus?orderId=${order.order_id}" class="btn btn-primary">Return Status</a>
						&nbsp;&nbsp; 
						<a href="selectrefundstatus?orderId=${order.order_id}"  class="btn btn-primary">Refund Status</a></td>
								
					</tr>
				</c:forEach>
			</tbody>
		</table>
 	<input type="hidden" name="orderId" value="${param.orderId}"> 
		<div class="text-center">
			<a href="cspHome" class="btn btn-default">Back to Homepage</a>
		</div>
	</div>
</body>
</html>

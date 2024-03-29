<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Orders</title>
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
		<h3 class="text-center">Open Orders Eligible for Return and
			Refund</h3>
			        <a href="logout" class="btn btn-default logout-link">Logout</a>
			
		<h1>Open Orders</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Order ID</th>
					<th>Customer ID</th>
					<th>Order Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${openOrders}" var="order">
					<tr>
						<td>${order.orderId}</td>
						<td>${order.customerId}</td>
						<td>${order.orderDate}</td>
						<td><%-- <a href="<c:url value='/return/${order.orderId}' />">Return</a>
							<a href="<c:url value='/refund/${order.orderId}' />">Refund</a> --%> 
							<a href="assignorder?orderId=${order.orderId}" class="btn btn-primary">Assign</a>
							<%-- <form action="assignorder" method="post">
								<input type="hidden" name="_csrf" value="${_csrf.token}" /> <input
									type="submit" value="Assign" class="btn btn-primary" />
							</form> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="text-center">
			<a href="cspHome" class="btn btn-default">Back to Homepage</a>
			<a href="viewassignedorders" class="btn btn-default">Handle Your Assigned Orders</a>
		</div>
	</div>
</body>
</html>

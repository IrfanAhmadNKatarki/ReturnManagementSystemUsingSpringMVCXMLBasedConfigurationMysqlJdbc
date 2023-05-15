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
</head>
<body>
	<div class="container">
		<h3 class="text-center">Open Orders Eligible for Return and
			Refund</h3>
<h1>Open Orders</h1>
    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Customer Name</th>
                <th>Order Date</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${openOrders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.customerName}</td>
                    <td>${order.orderDate}</td>
                    <td>
                        <a href="<c:url value="/return/${order.orderId}" />">Return</a>
                        <a href="<c:url value="/refund/${order.orderId}" />">Refund</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
		
		<div class="text-center">
			<a href="/csp-home" class="btn btn-default">Back to Homepage</a>
		</div>
	</div>
</body>
</html>

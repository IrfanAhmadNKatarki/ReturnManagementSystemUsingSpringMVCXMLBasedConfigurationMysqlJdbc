<html>
<head>
    <title>Customer Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .btn-link {
            color: #007bff;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to the Customer Home!</h2>
<%--          <a href="${pageContext.request.contextPath}/customer/createReturnOrder" class="btn btn-link">Create and Update Return Order Request</a>
    	    
 		<a href="${pageContext.request.contextPath}/customer/viewReturnOrderStatus" class="btn btn-link">View Return Order Status</a>
        <a href="${pageContext.request.contextPath}/customer/viewRefundStatus" class="btn btn-link">View Refund Status</a>  --%>
        <a href="${pageContext.request.contextPath}/customer/viewAllOrders" class="btn btn-link">Your Orders</a>
    
    </div>
</body>
</html>

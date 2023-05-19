<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Report Generated</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.logout-link {
	position: absolute;
	top: 15px;
	right: 15px;
}
</style>
</head>
<body>
<a href="logout" class="btn btn-default logout-link">Logout</a>
    <div class="container">
        <h3 class="text-center">Report Generated</h3>
        
        <div class="row">
            <div class="col-md-6">
                <h4>Number of Returns Processed</h4>
                <p>Monthly: ${monthlyReturnCount}</p>
                <p>Annually: ${annualReturnCount}</p>
                <p>Quarterly: ${quarterlyReturnCount}</p>
            </div>
            <div class="col-md-6">
                <h4>Number of Refunds Processed</h4>
                <p>Monthly: ${monthlyRefundCount}</p>
                <p>Annually: ${annualRefundCount}</p>
                <p>Quarterly: ${quarterlyRefundCount}</p>
            </div>
        </div>
        
        <div class="text-center">
            <a href="csp Home" class="btn btn-primary">Back to Homepage</a>
        </div>
    </div>
</body>
</html>

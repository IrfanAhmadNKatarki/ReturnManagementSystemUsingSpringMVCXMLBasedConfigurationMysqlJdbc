<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CSP Homepage</title>
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
    <div class="container">
        <h3 class="text-center">Customer Support Agent Homepage</h3>
        		<a href="logout" class="btn btn-default logout-link">Logout</a>
        
        <div class="text-center">
            <h4>Welcome, ${customUser.username}!</h4>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-6">
                <h4>Customer Inquiries</h4>
                <ul class="list-group">
                    <c:forEach var="inquiry" items="${customerInquiries}">
                        <li class="list-group-item">${inquiry}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-md-6">
                <h4>Terms and Conditions</h4>
                <p>This page contains confidential information and is intended solely for authorized users. Unauthorized access, use, or dissemination is strictly prohibited.</p>
                <p>By accessing and using this page, you agree to maintain the confidentiality of the information presented and adhere to all applicable policies and guidelines.</p>
                <p>For any assistance or inquiries, please contact the system administrator.</p>
            </div>
        </div>
        <div class="text-center">
        	<a href="reportgenerated" class="btn btn-primary">View Report</a>
            <a href="openorders" class="btn btn-primary">Check Open Orders</a>
        </div>
    </div>
</body>
</html>

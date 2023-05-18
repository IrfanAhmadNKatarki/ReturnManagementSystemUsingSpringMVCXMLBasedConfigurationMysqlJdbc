<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Refund Status</title>
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
    <h2>Refund Status</h2>
    <p>${refundStatus}</p>
        <a href="customerHome" class="btn btn-primary">Back to Homepage</a>
</body>
</html>
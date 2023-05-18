<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Return Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add your custom styles here */
        body {
            padding: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        button {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h2>Update Form</h2>
    <form action="returnForm" method="post">
      
        <div class="form-group">
            <label for="returnReason">Return Reason:</label>
            <textarea id="returnReason" name="returnReason" rows="4" required></textarea>
        </div>
       <input type="hidden" name="orderId" value="${param.orderId}">
           <a href="customerHome" class="btn btn-primary">Back to Homepage</a>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</body>
</html>

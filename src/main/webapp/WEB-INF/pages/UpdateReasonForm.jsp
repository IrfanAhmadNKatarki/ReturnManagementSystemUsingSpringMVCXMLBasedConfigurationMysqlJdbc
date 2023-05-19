<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Return Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom Styles */
        body {
            padding: 20px;
            font-family: Arial, sans-serif;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            font-weight: bold;
        }
        textarea {
            width: 100%;
            resize: vertical;
        }
        button {
            margin-top: 20px;
        }
        .btn-back {
            display: block;
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Return Form</h2>
        <form action="returnForm" method="post">
            <div class="form-group">
                <label for="returnReason">Return Reason:</label>
                <textarea id="returnReason" name="returnReason" rows="4" required></textarea>
            </div>
            <input type="hidden" name="orderId" value="${param.orderId}">
            <div class="text-center">
                <a href="customerHome" class="btn btn-primary btn-back">Back to Homepage</a>
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>

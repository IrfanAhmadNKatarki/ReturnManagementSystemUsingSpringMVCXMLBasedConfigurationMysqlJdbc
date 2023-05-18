<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    // Generate a random alphanumeric value of length 6 (numbers and capital letters)
    String randomValue = generateRandomValue(6);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Return Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom Styles */
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
    <div class="container">
        <h2 class="text-center">Return Form</h2>
        <form action="freshReturn" method="post">
            <div class="form-group">
                <label for="returnId">Return ID:</label>
                <input type="text" id="returnId" name="returnId" value="<%= randomValue %>" readonly class="form-control">
            </div>
            <div class="form-group">
                <label for="returnReason">Return Reason:</label>
                <textarea id="returnReason" name="returnReason" rows="4" required class="form-control"></textarea>
            </div>
            <input type="hidden" name="orderId" value="${param.orderId}">
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <a href="customerHome" class="btn btn-primary mt-3">Back to Homepage</a>
    </div>

    <%!
        // Method to generate a random alphanumeric value of specified length (numbers and capital letters)
        public String generateRandomValue(int length) {
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int randomIndex = (int) (Math.random() * chars.length());
                sb.append(chars.charAt(randomIndex));
            }
            return sb.toString();
        }
    %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <title>Refund Status</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom styles for the popup */
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            padding-top: 20px;
        }
        .popup-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: rgba(0, 0, 0, 0.5);
        }
        .popup {
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }
        .logout-link {
            position: absolute;
            top: 15px;
            right: 15px;
            z-index: 1;
            background-color: transparent;
            color: #007bff;
            border: none;
        }
        .logout-link:hover {
            color: #0056b3;
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="popup-container">
        <div class="popup">
            <a href="logout" class="btn btn-default logout-link">Logout</a>
            <h2>Refund Status</h2>
            <p>${refundStatus}</p>
            <a href="customerHome" class="btn btn-primary">Back to Homepage</a>
        </div>
    </div>
</body>
</html>

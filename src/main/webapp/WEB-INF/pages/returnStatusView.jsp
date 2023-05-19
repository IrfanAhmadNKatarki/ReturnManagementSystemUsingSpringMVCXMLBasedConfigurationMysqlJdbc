<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Return Status</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Custom Styles */
        body {
            padding: 20px;
            font-family: Arial, sans-serif;
        }
        .popup-container {
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        p {
            margin-bottom: 20px;
        }
        .btn {
            display: block;
            margin: 0 auto;
            text-align: center;
        }
        .logout-link {
            position: absolute;
            top: 15px;
            right: 15px;
            z-index: 1;
        }
    </style>
</head>
<body>
    <a href="logout" class="btn btn-default logout-link">Logout</a>
    <div class="popup-container">
        <h2>Return Status</h2>
        <p>${returnStatus}</p>
        <a href="customerHome" class="btn btn-primary">Back to Homepage</a>
    </div>
</body>
</html>

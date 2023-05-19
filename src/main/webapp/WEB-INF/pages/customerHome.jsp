<!DOCTYPE html>
<html>
<head>
    <title>Customer Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            padding-top: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            text-align: center;
        }
        .btn-default {
            background-color: #f8f9fa;
            color: #007bff;
            border-color: #007bff;
        }
        .btn-default:hover {
            background-color: #007bff;
            color: #fff;
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
    <div class="container">
        <h2>Every Return excites you!</h2>
        <div class="mt-4">
            <a href="${pageContext.request.contextPath}/customer/viewAllOrders" class="btn btn-primary">Your Orders</a>
        </div>
    </div>
</body>
</html>

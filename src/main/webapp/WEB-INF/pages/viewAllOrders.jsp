<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Orders</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Add your custom styles here */
        body {
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: center; /* Center-align the data */
            border-bottom: 1px solid #ddd;
            font-weight: bold;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
    <style>
        .logout-link {
            position: absolute;
            top: 15px;
            right: 15px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            font-weight: bold;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
    <a href="logout" class="btn btn-primary logout-link">Logout</a>
    <h2>Your Orders</h2>
    <table class="table">
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Order Date</th>
                <th>Product Name</th>
                <th>Actions</th>
                <!-- Add more table headers as needed -->
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.orderDate}</td>
                    <td>${order.productName}</td> <!-- Update the property name to productName -->
                    <!-- Add more table cells as needed -->
                    <td>
                        <c:set var="currentDate" value="<%= new java.util.Date() %>"/>
                        <c:set var="timeDiff" value="${currentDate.time - order.orderDate.time}"/>
                        <c:choose>
                            <c:when test="${timeDiff > 7 * 24 * 60 * 60 * 1000}">
                                <a href="#" onclick="alert('You can\'t return the item. The 7-day policy has expired.');">Create/Update</a>
                            </c:when>
                            <c:otherwise>
                                <a href="createorupdateform?orderId=${order.orderId}">Create/Update</a>
                            </c:otherwise>
                        </c:choose>
                        &nbsp;&nbsp;
                        <a href="checkreturnstatus?orderId=${order.orderId}">Return Status</a>
                        &nbsp;&nbsp;
                        <a href="checkrefundstatus?orderId=${order.orderId}">Refund Status</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="customerHome" class="btn btn-primary">Back to Homepage</a>
</body>
</html>

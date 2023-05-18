<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>

    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- Add your custom CSS if needed -->
    <style>
        /* Add your custom styles here */
    </style>
</head>

<body>
    <div class="container">
     <h3 class="text-center">Be a part of Eco-friendly returns</h3>
        <form:form id="regForm" modelAttribute="customUser" action="registerProcess" method="post">

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="role">Select Role:</label>
                        <select class="form-control" name="role" id="role">
                            <option value="ROLE_ADMIN">Customer Support Agent</option>
                            <option value="ROLE_USER">Customer</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="user_id">Username:</label>
                        <form:input class="form-control" path="user_id" name="user_id" id="user_id" />
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <form:password class="form-control" path="password" name="password" id="password" />
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <form:input class="form-control" path="email" name="email" id="email" />
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <form:input class="form-control" path="firstName" name="firstName" id="firstName" />
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <form:input class="form-control" path="lastName" name="lastName" id="lastName" />
                    </div>
                </div>
            </div>

            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <button type="submit" class="btn btn-primary">Register</button>
                    <a href="login" class="btn btn-secondary">Home</a>
                </div>
            </div>

        </form:form>
   

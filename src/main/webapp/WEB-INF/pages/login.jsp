<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Return Management System - Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            margin: 0;
            padding: 0;
        }
        .login-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .banner-image {
            width: 100%;
            max-height: 50vh; /* Adjust the value to reduce the height of the banner */
            object-fit: cover;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>
    <div class="container-fluid p-0">
        <img src="https://cdn.shopify.com/app-store/listing_images/b49c003869d1d99c7a3d5709a3f84680/banner/CL+kqrP0lu8CEAE=.png" alt="Banner Image" class="banner-image">
        <div class="container login-container">
            <div class="card">
                <h3 class="card-header">Return Management System - Login</h3>
        
                <% 
                String errorString = (String) request.getAttribute("error");
                if (errorString != null && errorString.trim().equals("true")) { 
                %>
                <div class="alert alert-danger mt-3">Incorrect login name or password. Please try again</div>
                <% 
                } 
                %>
        
                <div class="card-body">
                    <form name='loginForm' action="login"  method='POST'>
                        <div class="form-group">
                            <label for="username">Username:</label>
                            <input type='text' name='username' id="username" class="form-control" value='' autocomplete="off">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type='password' name='password' id="password" class="form-control" autocomplete="off">
                        </div>
                        <div class="form-group">
                            <input name="submit" type="submit" value="Sign in" class="btn btn-primary">
                            <a href="register" class="btn btn-link">Register</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Custom Login Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body onload='document.loginForm.j_username.focus();'>
    <div class="container">
        <h3 class="mt-5">Custom Login Page</h3>
        
        <% 
        String errorString = (String) request.getAttribute("error");
        if (errorString != null && errorString.trim().equals("true")) { 
        %>
        <div class="alert alert-danger mt-3">Incorrect login name or password. Please try again</div>
        <% 
        } 
        %>
        
        <form name='loginForm' action="login"  method='POST' class="mt-3">
            <div class="form-group">
                <label for="username">User:</label>
                <input type='text' name='username' id="username" class="form-control" value=''>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type='password' name='password' id="password" class="form-control">
            </div>
            <div class="form-group">
                <input name="submit" type="submit" value="Sign in" class="btn btn-primary">
                <a href="register" class="btn btn-link">Register</a>
            </div>
        </form>
    </div>
</body>
</html>

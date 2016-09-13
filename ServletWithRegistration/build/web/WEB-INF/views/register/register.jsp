<%-- 
    Document   : register
    Created on : Sep 13, 2016, 2:36:27 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body style="font-family: cursive;font-size: 15px;">
        <h1>Sign Up</h1>
        <form method="post" action="">
            <div>
                <label> First Name </label>
                <input type="text" required="required" name="firstName" style="width: 100%"/>
            </div>
            <div>
                <label> Last Name </label>
                <input type="text" required="required" name="lastName" style="width: 100%"/>
            </div>
            <div>
                <label> Username </label>
                <input type="text" required="required" name="username" style="width: 100%"/>
            </div>
            <div>
                <label> Email </label>
                <input type="email" required="required" name="email" style="width: 100%"/>
            </div>
            <div>
                <label> Password </label>
                <input type="password" required="required" name="password" style="width: 100%"/>
            </div>
            <br>
            <div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
                <a href="${pageContext.request.contextPath}/login"><button>Login</button></a>
            </div>

        </form>
    </body>
</html>

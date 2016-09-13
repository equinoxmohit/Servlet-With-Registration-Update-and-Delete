<%-- 
    Document   : login
    Created on : Sep 13, 2016, 3:37:50 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="font-family: cursive;font-size: 15px;">
        <h1>Login</h1>
        <form method="post" action="">
            <div>
                <label>Username</label>
                <input type="text" required="required" name="username" style="width: 100%"/>
            </div>
            <div>
                <label>Password</label>
                <input type="password" required="required" name="password" style="width: 100%"/>
            </div>
            <br>
            <div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>

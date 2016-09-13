<%-- 
    Document   : update
    Created on : Sep 13, 2016, 5:55:26 PM
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
        <h1>Update Information</h1>
        <form method="post" action="">
            <div>
                <label>First Name</label>
                <input type="text" name="firstName" required="required" value="${requestScope.user.firstName}" style="width:100%;"/>
            </div>
            <div>
                <label>Last Name</label>
                <input type="text" name="lastName" required="required" value="${requestScope.user.lastName}" style="width:100%;"/>
            </div>
            <div>
                <label>Username</label>
                <input type="text" name="username" required="required" value="${requestScope.user.username}" style="width:100%;"/>
            </div>
            <div>
                <label>Email</label>
                <input type="email" name="email" required="required" value="${requestScope.user.email}" style="width:100%;"/>
            </div>
            <br>
            <div>
                <button type="submit">Submit</button>
                <button type="reset">Reset</button>
            </div>

        </form>
    </body>
</html>

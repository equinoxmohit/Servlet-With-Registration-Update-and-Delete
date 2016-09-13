<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="userDao" class="com.mohit.servlet.program.dao.impl.UserDAOImpl"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body style="font-family: cursive;font-size: 15px;">
            <h1>Edit Panel</h1>
            <table>
                <thead>
                    <tr>
                        <td>First Name</td>
                        <td>Last Name</td>
                        <td>Username</td>
                        <td>Email</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <c:forEach var="user" items="${userDao.all}">
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td><a href="${pageContext.request.contextPath}/update?id=${user.id}"><button>Update</button></a></td>
                        <td> <a href="${pageContext.request.contextPath}/delete?id=${user.id}"><button>Delete</button></a></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

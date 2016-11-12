<%-- 
    Document   : viewPost
    Created on : Nov 10, 2016, 10:10:08 AM
    Author     : Elgalad
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Posts Page</title>
    </head>
    <body>
        <h1>Posts</h1>
        <a href="newPost.jsp"> Create new post </a><br />
        <div> 
            <c:forEach var="Post" items="${list}">
                <div>
                    ${Post.getUsername()}<br />
                    ${Post.getDate()}<br /><br />
                    ${Post.getPost()}<br /><br /><br />
                </div>
            </c:forEach>

       </div>
    </body>
</html>

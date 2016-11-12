<%-- 
    Document   : newPost
    Created on : Nov 10, 2016, 10:09:09 AM
    Author     : Elgalad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Post</title>
    </head>
    <body>
        <h1>Welcome ${user}</h1>
        <a href="loadPost"> View current posts </a>
        <form action="createPost" method="POST">
            New Post<br>
            <textarea rows="20" cols="20" name="newPost"></textarea><br><br>
            <input type="submit" value="Submit" /> 
        </form>
    </body>
</html>

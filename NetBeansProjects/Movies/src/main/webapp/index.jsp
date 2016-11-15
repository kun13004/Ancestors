<%-- 
    Document   : index
    Created on : Nov 14, 2016, 8:30:31 PM
    Author     : Elgalad
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Search</title>
    </head>
    <body>
        <h1>Movie Search!</h1>
        <form method="post" action="MovieSearch">
            <label for="searchParam">Search: </label>
            <input type="text" id="searchParam" name="searchParam"/>
            <input type="submit" value="Search"/>
            <br/>
            <br/>
        </form>
        
        <h2>Movies</h2>
        <c:forEach var="movie" items="${movies}">
            <p>${movie.Title} (${movie.Year})</p>
        </c:forEach>
    </body>
</html>

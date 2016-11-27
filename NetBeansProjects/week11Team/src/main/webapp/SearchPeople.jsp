<%-- 
    Document   : SearchPeople
    Created on : Nov 23, 2016, 5:08:22 PM
    Author     : Elgalad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Database</title>
    </head>
    <body>
        <h1>People in Database</h1>
        <c:forEach var="person" items="${person}">
            <p>${person.first_name} ${person.last_name}</p>
        </c:forEach>
    </body>
</html>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<h2>Users</h2>

    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Action</th>
        </tr>

        <c:forEach var="map" items="${userMap}">

        <tr>
            <td>${map.key}</td>
            <td>${map.value['firstName']}</td>
            <td>${map.value['lastName']}</td>
            <td>
                <a href="user/${map.key}" type="button" class="btn btn-large btn-warning">Edit</a>
                <a href="user/${map.key}/delete" type="button" class="btn btn-large btn-danger">Delete</a>
            </td>
        </tr>

        </c:forEach>
    </table>



<br>

<a href="${pageContext.request.contextPath}/user-detail" class="btn btn-large btn-primary" type="button"role="button">New User</a>
</div>
</body>
</html>

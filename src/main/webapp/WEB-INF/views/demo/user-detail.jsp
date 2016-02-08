<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <style>

        div.errors {
            background-color: #ff767e;
            padding-left: 10px;
        }

    </style>
</head>
<body>

<div class="container">
    <h2>Add / Update</h2>

    <script>

        function goSubmit(key) {
            if (key != '') {
                $("#user").attr('action', "${pageContext.request.contextPath}/demo/users/${key}/edit" );
//                $("#user").attr('method', "post");
                $("#user").submit();
            } else {
                $("#user").submit();
            }
        }

        function goCancel() {
            $("#user").attr('method', 'post');
            $("#user").attr('action', '${pageContext.request.contextPath}/demo/users');
            $("#user").submit();

        }
    </script>

    <form:form commandName="user" method="post" action="demo/save-user">
        <form:errors path="*" cssClass="errors" element="div"/>
        User Name : <form:input path="userName" cssClass="form-control"/><br>
        Last Name : <form:input path="password" cssClass="form-control" /><br>


        <input type="button" class="btn btn-large btn-success" onclick="goSubmit('${user.id}')" value="Save">
        <input type="button" class="btn btn-large btn-danger" onclick="goCancel();" value="Cancel">
    </form:form>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add User</title>

</head>
<body>
<style>
    span.errors {
        color: red;
    }
    div.errors {
        background-color: #ffcccc;
        border: 2px solid red;
    }

</style>

    <h1><spring:message code="page.user.label.add"/> </h1>

    <form:form commandName="user" method="POST">
        <form:hidden path="id"/>
        <%--<form:errors path="*" cssClass="errors" element="div"/>--%>
        <table>
            <tr>
                <td>User Name:</td>
                <td><form:input path="userName" /></td>
                <td><form:errors path="userName" cssClass="errors"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:input path="password" /></td>
                <td><form:errors path="password" cssClass="errors"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><form:select path="gender">
                    <form:option value="" label="--- Select ---"/>
                    <form:options items="${genders}"></form:options>
                    <%--<form:option value=""></form:option>--%>
                    <%--<form:option value="Male"></form:option>--%>
                    <%--<form:option value="Female"></form:option>--%>
                </form:select></td>
                <td><form:errors path="gender" cssClass="errors"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id ="btnSave" type="button" class="btn btn-info" value="Save" />
                    <input id = "btnCancel" type="reset" class="btn btn-danger" value="Cancel" />
                </td>
            </tr>
        </table>
    </form:form>


    <script>

        $(function() {


            $(":input#btnSave").on('click', function() {
                var id = $("#id").val();
                if (id == "") {
                    console.log("mode add");
                    $("#user").attr("action", "${pageContext.request.contextPath}/users/add");
                    $("#user").submit();
                } else {
                    console.log("mode edit");
                    $("#user").attr("action", "${pageContext.request.contextPath}/users/update");
                    $("#user").submit();
                }
            });


            $(":input#btnCancel").on('click', function() {
                window.location = "${pageContext.request.contextPath}/users";
            });


        });
    </script>

</body>
</html>

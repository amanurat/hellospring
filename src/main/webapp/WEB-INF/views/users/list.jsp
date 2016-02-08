<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add List</title>
</head>
<body>

<script !src="">

    function edit(id) {
        var $form = $('#userForm');
        $form.attr("method", "get");
        $form.attr("action", "${pageContext.request.contextPath}/users/" + id);
        $form.submit();
    }

    function add() {
        var $form = $('#userForm');
        $form.attr("action", "${pageContext.request.contextPath}/users/init");
        $form.submit();
    }

    function goDelete(id) {
        var $form = $('#userForm');
        $form.attr("method", "post");
        $form.attr("action", "${pageContext.request.contextPath}/users/remove/" + id);
        $form.submit();
    }

</script>
    <h1>User List</h1>

<form id="userForm" method="post">
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="model" items="${users}">
            <tr>
                <td>${model.id}</td>
                <td>${model.userName}</td>
                <td colspan="2">
                    <input type="button" value="Edit" class="btn btn-info" onclick="edit('${model.id}');"/>
                    <input type="button" value="Delete" class="btn btn-danger" onclick="goDelete('${model.id}');"/>
                </td>

            </tr>

        </c:forEach>
    </table>
    <input type="button" id="addBtn" value="New Users" class="btn btn-info" onclick="add();">
</form>



</body>
</html>

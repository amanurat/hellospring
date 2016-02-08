<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

    <title>Login | Spring-Mvc-Practices</title>


    <%--<sitemesh:write property="head"/>--%>
</head>
<body>
<div class="page">
    <%--<div class="navbar navbar-default" role="navigation" style="display:none">--%>

    <div id="view-holder">

        <div class="main-content">
            <div class="box-wrapper">
                <%--<img src="${pageContext.request.contextPath}/static/images/logo.png" class="logo">--%>

                <div class="or-line"><span>LOGIN</span></div>
                <div class="login-error" style="display:none"></div>
                <form name='f' action="login/authenticated" method='POST'>
                    <div class="form-group">
                        <input type="text" name="j_username" class="form-contorl" placeholder="User name" required="Should not be empty">
                    </div>
                    <div class="form-group">
                        <input type='password' name='j_password'  class="form-contorl" placeholder="Password" required="Should not be empty" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-block btn-brand">Login</button>
                    </div>
                    <div style="color: red">
                        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                    </div>
                </form>
            </div>
        </div>
    </div>



</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/script.js"></script>
<script>
</script>
</body>
</html>
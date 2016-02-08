<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
    <h1>Private Page</h1>
    <hr/>

    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <div>
            <h2><spring:message code="section.admin"/> </h2>
        </div>
    </sec:authorize>

    <sec:authorize ifAnyGranted="ROLE_USER">
        <div>
            <h2><spring:message code="section.user"/> </h2>
        </div>
    </sec:authorize>


</body>
</html>

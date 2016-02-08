<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Index Page | Spring-Mvc-Practices</title>
</head>
<body>

<div>
    Language : <a href="?lang=en">English</a>|<a href="?lang=th">Thai</a>
    <p>Current Locale : ${pageContext.response.locale}</p>
    <h2>
        <spring:message code="welcome" text="default text" />
    </h2>

</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="static/js/bootstrap.min.js"></script>

</body>
</html>
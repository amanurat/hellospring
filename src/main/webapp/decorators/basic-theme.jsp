<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Dashboard | Spring MVC Practices</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>

    <!--
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    -->
    <![endif]-->
</head>
<body>

<spring:url value="${pageContext.request.contextPath}" var="context"/>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="active navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
            <a class="active navbar-brand" href="${pageContext.request.contextPath}/users">Users</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/public">Public Page</a></li>
                <li><a href="${pageContext.request.contextPath}/private">Private Page <span class="sr-only">(current)</span></a></li>
                <li><a href="${pageContext.request.contextPath}/admin">Administrator</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Errors <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/errors/403">403</a></li>
                        <li><a href="${pageContext.request.contextPath}/errors/404">404</a></li>
                        <li><a href="${pageContext.request.contextPath}/errors/500">500</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">505</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <sec:authorize access="isAuthenticated()">

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Languages <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="?lang=en">English</a> </li>
                            <li><a href="?lang=th">Thai</a></li>
                        </ul>
                    </li>

                    <li><a href="${pageContext.request.contextPath}/logout">[<sec:authentication property="principal.username" />] Logout</a></span> </li>
                </sec:authorize>
            </ul>

        </div><!-- /.navbar-collapse -->



    </div><!-- /.container-fluid -->
</nav>

<decorator:body/>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>--%>

<%--<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>--%>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<%--<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>--%>

</body>
</html>
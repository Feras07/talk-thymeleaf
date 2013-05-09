<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %> 
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Thymeleaf Demo</title>
    <meta name="description" content="Spring MVC Demo comparing Thymeleaf and JSP" />
    <meta name="author" content="Justin Munn" />

    <meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' />
    <link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>" />
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet" />
    <link href="<c:url value="/css/datepicker.css"/>" rel="stylesheet" />
    <link href="<c:url value="/css/demo.css"/>" rel="stylesheet" />
    <script src="<c:url value="/js/jquery-1.9.1.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/bootstrap-datepicker.js"/>" type="text/javascript"></script>
    <script src="<c:url value="/js/demo.js"/>" type="text/javascript"></script>

</head>

<body>
    <header class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container-fluid">
                <a class="brand" href="<c:url value="/"/>" >Thymeleaf Demo</a>
                <div class="nav-collapse collapse">
                    <p class="navbar-text pull-right">
                        Current Template: index.jsp
                    </p>
                </div>
            </div>
        </div>
    </header>
    <div class="container-fluid" style="margin-top: 60px;">
        <div class="row-fluid">
            <div class="span3">
                <div class="well sidebar-nav">
                    <ul class="nav nav-list">
                        <li class="nav-header">Navigation</li>
                        <li><a href="<c:url value="/basics"/>" >Basics</a></li>
                        <li><a href="<c:url value="/iteration"/>" >Iteration</a></li>
                        <li><a href="<c:url value="/inlining"/>" >Inlining</a></li>
                        <li><a href="<c:url value="/custom-dialects"/>" >Custom Dialects</a></li>
                        <li><a href="<c:url value="/forms"/>" >Spring Forms</a></li>
                        <li><a href="<c:url value="/controls"/>" >Controls</a></li>
                    </ul>
                </div>
                <!--/.well -->
            </div>
            <!--/span-->
            <div class="span9">
                <h2><fmt:message key="home.message"></fmt:message> <c:out value="${message}"/></h2>
            </div>
            <!--/span-->
        </div>
        <!--/row-->
    </div>
    <footer>
        <hr />
        <p class="container-fluid">&copy; Credera 2013</p>
        <div class="container-fluid" xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/" about="http://www.thymeleaf.org/documentation.html"><span property="dct:title">The Thymeleaf Artwork</span> (<a rel="cc:attributionURL" property="cc:attributionName" href="http://www.thymeleaf.org">The Thymeleaf Project</a>) / <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a></div>
    </footer>
</body>
</html>
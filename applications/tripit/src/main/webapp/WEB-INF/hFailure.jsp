<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>
<html>
<head>
<title>Uh-Oh!</title>
    <link href="../assests/css/tripit.css" rel="stylesheet">
</head>
<body>
<div class=nav>
    <h1 style="padding-top :10px; padding-left: 30px ; color:white; font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif">Tripit</h1>
</div>
<img src="../assests/img/bird.png" width="300px" height="300px"  style="padding-left:40%; padding-top:10%">
<h1 style="padding-top :5px;margin-top:40px ;padding-left: 600px ; color:cornflowerblue ;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif">Sorry! The hotel is full</h1>
</body>
</html>
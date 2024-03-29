<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>
<html>
<head>
<title>Confirmation</title>
    <link href="../assests/css/tripit.css" rel="stylesheet">
</head>
<body>
<div class=nav>

    <h1 style="padding-top :10px; padding-left: 30px ; color:white; font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif">Tripit</h1>
</div>

<h1 style="padding-top :40px;margin-top:150px ;padding-left: 600px ; color:cornflowerblue ;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif">Booking confirmed</h1>
<div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td><c:out value="${hotel.name}"/></td>
                <td><c:out value="${hotel.address}"/></td>
                <td><c:out value="${hotel.city}"/></td>
                <td><c:out value="${hotel.price}"/></td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
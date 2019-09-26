<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>
<html>
<head>
<title>Confirmation</title>
</head>
<body>
<h1>Booking confirmed</h1>
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
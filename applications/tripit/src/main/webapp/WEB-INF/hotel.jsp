<%--
  Created by IntelliJ IDEA.
  User: sayali.khare
  Date: 9/23/2019
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel</title>
    <link href="../../assests/css/tripit.css" rel="stylesheet">
    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
        }

        .button2 {
            background-color: white;
            color: black;
            border: 2px solid #008CBA;
        }

        .button2:hover {
            background-color: #008CBA;
            color: white;
        }

    </style>
</head>
<body>
<div class=nav>

    <h1 style="padding-top :10px; padding-left: 30px ; color:white; font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif">Tripit</h1>
    <h1 style="padding-top :40px; padding-left: 600px ; color:cornflowerblue ;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif"> Book Your Hotel Now</h1>
</div>
<div>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Address</th>
            <th>City</th>
            <th>Cost</th>
            <th>Select</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${hotels}" var="hotels">
            <tr>
                <td><c:out value="${hotels.name}"/></td>
                <td><c:out value="${hotels.address}"/></td>
                <td><c:out value="${hotels.city}"/></td>
                <td><c:out value="${hotels.price}"/></td>
                <td><c:out value="${hotels.cost}"/></td>
                <td><button class="button button2">Book</button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <c:if test="${count > 0}">
        <c:if test="${page > 1}">
            <a href="<c:url value="hotels"><c:param name="page" value="${page - 1}"/><c:param name="field" value="${field}"/><c:param name="key" value="${key}"/></c:url>">&lt; Prev</a>&nbsp;
        </c:if>
        Showing records ${start} to ${end} of ${count}
        <c:if test="${page < pageCount}">
            &nbsp;<a href="<c:url value="hotels"><c:param name="page" value="${page + 1}"/><c:param name="field" value="${field}"/><c:param name="key"
                                                                                                                                             value="${key}"/></c:url>">Next &gt;</a>
        </c:if>
    </c:if>

</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: sayali.khare
  Date: 9/23/2019
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="language" value="${pageContext.request.locale}"/>
<fmt:setLocale value="${language}"/>
<html>
<head>
    <title>Hotel</title>
    <link href="../../assests/css/tripit.css" rel="stylesheet">
    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;

        }

        .button2 {
            background-color: white;
            color: black;
            border: 1px solid #008CBA;
        }

        .button2:hover {
            background-color: #008CBA;
            color: white;
        }

        .go {
            background-color: #4CAF50; /* Green */
            border: none;
            border-radius: 20px;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            margin: 4px 2px;
            cursor: pointer;
            margin-left: 120px;
        }

    </style>

    <meta charset = "utf-8">
    <title>Hotels</title>

</head>
<body>
<div class=nav>

    <h1 style="padding-top :10px; padding-left: 30px ; color:white; font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif">Tripit</h1>
    <h1 style="padding-top :40px; padding-left: 600px ; color:cornflowerblue ;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif"> Book Your Hotel Now</h1>
</div>


<div  style="padding-top:100px;margin-left: 630px">

    <form action="/hotels/filter" method="get">
    <p>Enter Start Date: <input  name="begin" type = "date"></p>
    <p>Enter End Date: <input  name="end" type = "date"></p>
    <button type ="submit" class="go">Go</button>
    </form>

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
        <c:forEach items="${hotels}" var="hotel">
            <tr>
                <td><c:out value="${hotel.name}"/></td>
                <td><c:out value="${hotel.address}"/></td>
                <td><c:out value="${hotel.city}"/></td>
                <td><c:out value="${hotel.price}"/></td>
                <td><button onclick="window.location.href = '/book?${hotel.date}';" class="button button2">Book</button></td>
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

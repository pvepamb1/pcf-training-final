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
    <title>Filter Flights</title>
    <link href="../assests/css/tripit.css" rel="stylesheet">
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
    <h1 style="padding-top :40px;margin-top:150px ;padding-left: 600px ; color:cornflowerblue ;font-family:-apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif"> Book Your Flight Now</h1>
</div>


<div  style="padding-top:250px;margin-left: 630px" >

    <form action="/flights/filter" method="get">
        <p>Enter Start Date: <input  name="date" type = "date"></p>
        <p style="margin-left:65px">From: <input  type="text" name="from" size="18"></p>
        <p style="margin-left:80px">To: <input  type="text" name="to" size="19" ></p>
        <button type ="submit" class="go">Go</button>
    </form>

</div>
</body>
</html>

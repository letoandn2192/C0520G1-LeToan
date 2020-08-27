<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/27/2020
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current Exchange</title>
</head>
<body>
    <form method="get" action="exchange.jsp">
        <h2>Current Exchange</h2>
        <label for="rate">Rate</label>
        <input type="text" id="rate" name="rate" value="23000">
        <label for="USD">USD</label>
        <input type="text" id="USD" name="usd" value="0.0">
        <input type="submit" value="Exchange">
    </form>
</body>
</html>

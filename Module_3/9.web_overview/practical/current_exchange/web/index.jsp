<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/25/2020
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current Exchange</title>
</head>
<body>
<form method="get" action="convert">
    <div>
        <h1>Current Exchange</h1>
        <label for="rate">Rate</label>
        <input id="rate" name="rate" type="text" value="23000">
        <label for="usd">USD</label>
        <input id="usd" name="usd" type="text" value="0">
        <input type="submit" value="Convert">
    </div>
</form>
</body>
</html>

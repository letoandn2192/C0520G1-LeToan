<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/27/2020
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
  <form action="dictionary.jsp" method="post">
    <h2>Dictionary</h2>
    <label for="search">Search:</label>
    <input type="text" id="search" placeholder="Enter your word" name="search">
    <input type="submit" value="Search">
    <br>
    <br>
    <label for="result">Result</label>
    <p id="result">${result}</p>
  </form>
</body>
</html>

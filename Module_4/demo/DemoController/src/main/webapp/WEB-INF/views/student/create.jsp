<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 9/17/2020
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/create" method="post">
    <label>ID:</label>
    <input type="text" name="id">
    <br/>
    <label>Name:</label>
    <input type="text" name="name">
    <br/>
    <label>Address:</label>
    <input type="text" name="address">
    <br/>
    <label>Age:</label>
    <input type="text" name="age">
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>

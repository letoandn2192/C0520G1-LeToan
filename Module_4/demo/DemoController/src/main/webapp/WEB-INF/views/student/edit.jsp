<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 9/17/2020
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/edit" method="post">
    <input type="hidden" name="id" value="${student.id}">

    <label>Name:</label>
    <input type="text" name="name"  value="${student.name}">
    <br/>
    <label>Address:</label>
    <input type="text" name="address"  value="${student.address}">
    <br/>
    <label>Age:</label>
    <input type="text" name="age"  value="${student.age}">
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>

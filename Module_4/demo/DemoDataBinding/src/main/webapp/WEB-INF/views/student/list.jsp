<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 9/17/2020
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>address</th>
        <th>age</th>
        <th>Gender</th>
        <th>Language</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td scope="row">${student.id}</td>
            <td>${student.name}</td>
            <td>${student.address}</td>
            <td>${student.age}</td>
            <td>${student.gender}</td>
            <td>
                <c:forEach var="lang" items="${student.language}">${lang}</c:forEach>
            </td>
            <td><a href="/student/edit/${student.id}">edit</a></td>
            <td><a href="/student?action=delete&id=${student.id}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>

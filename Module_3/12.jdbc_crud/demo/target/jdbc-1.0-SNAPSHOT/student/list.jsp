<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 8/28/2020
  Time: 7:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-between mb-2 mt-2">
            <h3>Student List</h3>
            <a href="/student?action=create" class="btn btn-success" role="button">Create New</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>address</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="student" items="${studentListServlet}">
            <tr>
                <td scope="row">${student.id}</td>
                <td>${student.name}</td>
                <td>${student.address}</td>
                <td><a href="/student?action=edit&id=${student.id}">edit</a></td>
                <td><a href="/student?action=delete&id=${student.id}">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>

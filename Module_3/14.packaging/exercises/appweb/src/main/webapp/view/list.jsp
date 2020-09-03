<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/30/2020
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List</title>
    <link type="text/css" rel="stylesheet" href="../bootstrap_4/css/bootstrap.min.css">
    <link href="../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<h2>List of Users</h2>
<div style="margin-bottom: 10px" class="row">
    <div class="col-md-6">
        <a href="/user?action=create" role="button" class="btn btn-outline-dark">Create New User</a>
    </div>
    <div class="col-md-4">
        <form class="form-inline" action="/user">
            <div class="form-group">
                <select class="form-control" name="findBy">
                    <option value="byId">Id</option>
                    <option value="byName">Name</option>
                    <option value="byAddress">Address</option>
                </select>
            </div>
            <input class="form-control mr-3" type="text" placeholder="Search" aria-label="Search" name="search">
            <input type="submit" value="search" name="action" class="btn btn-outline-dark">
        </form>
    </div>
    <div class="col-md-2">
        <form class="form-inline" action="/user">
            <label for="sortBy">Sort By: </label>
            <div class="form-group">
                <select class="form-control" name="sortBy" id="sortBy">
                    <option value="sortId">Id</option>
                    <option value="sortName">Name</option>
                </select>
            </div>
            <input type="submit" value="sort" name="action" class="btn btn-outline-dark">
        </form>
    </div>
</div>
<table class="table table-sm table-bordered table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td scope="row" >${user.id}</td>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>${user.address}</td>
            <td><a href="/user?action=update&id=${user.id}">Edit</a></td>
            <td><a href="/user?action=delete&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${message != null}">
    <div class="alert alert-success col-md-4" role="alert">
        ${message}
    </div>
    <script>
        window.setTimeout(function() {
            $(".alert").fadeTo(500, 0).slideUp(500, function(){
                $(this).remove();
            });
        }, 2000);
    </script>
</c:if>
<script src="../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

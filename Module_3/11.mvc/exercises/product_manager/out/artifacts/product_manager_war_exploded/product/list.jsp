<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/28/2020
  Time: 8:45 PM
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
    <h2>List of Products</h2>
    <div style="margin-bottom: 10px" class="row">
        <div class="col-md-6">
            <a href="/product?action=create" role="button" class="btn btn-outline-dark">Create New Product</a>
        </div>
        <div class="col-md-6">
            <form class="form-inline" action="/product">
                <input class="form-control mr-3" type="text" placeholder="Search" aria-label="Search" name="search">
                <input type="submit" value="search" name="action" class="btn btn-outline-dark">
            </form>
        </div>
    </div>
    <table class="table table-sm table-bordered table-hover ">
        <thead class="thead-dark">
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Producer</th>
                <th scope="col">Detail</th>
                <th scope="col">Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td scope="row" >${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.producer}</td>
                    <td><a href="/product?action=view&id=${product.id}">Detail</a></td>
                    <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<%--    <c:if test="${message != null}">--%>
<%--        <div class="alert alert-warning alert-dismissible fade show col-md-4" role="alert">--%>
<%--            ${message}--%>
<%--            <button type="button" class="close" data-dismiss="alert" aria-label="Close">--%>
<%--                <span aria-hidden="true">&times;</span>--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </c:if>--%>
<script src="../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

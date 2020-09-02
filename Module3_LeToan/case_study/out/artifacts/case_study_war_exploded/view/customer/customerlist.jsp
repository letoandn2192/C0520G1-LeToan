<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/2/2020
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="col-12 row bg-info m-0 fixed-top" style="height: 100px">
        <div class="col-2 p-0">
            <img src="../../image/codegym.png" class="img-thumbnail" alt="logo" height="100" width="100">
        </div>
        <h2 style="margin-top: 30px">FURAMA RESORT</h2>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top col-12" style="top: 100px">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-home"></span> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-people-arrows"></span> Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="/customer"><span
                            class="fas fa-user"></span> Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-list"></span> Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-success" href="#"><span class="fas fa-phone"></span> Contract</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="#" role="button" class="btn btn-outline-dark float-left">Create New Customer</a>
            <h2>List of Customer</h2>
        </div>
        <table class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Gender</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td scope="row">${customer.customerId}</td>
                    <td>${customer.customerName}</td>
                    <td>${customer.customerGender}</td>
                    <td>${customer.customerEmail}</td>
                    <td>${customer.customerAddress}</td>
                    <td>
                        <a href="/customer?action=view&id=${customer.customerId}"><span class="fas fa-info mr-3"></span></a>
                        <a href="/customer?action=edit&id=${customer.customerId}"><span class="fas fa-edit mr-3"></span></a>
                        <a href="/customer?action=delete&id=${customer.customerId}"><span class="fas fa-eraser"></span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="footer col-12 bg-dark text-center fixed-bottom" style="height: 60px">
        <p class="text-light">@CopyRight</p>
    </div>

</div>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

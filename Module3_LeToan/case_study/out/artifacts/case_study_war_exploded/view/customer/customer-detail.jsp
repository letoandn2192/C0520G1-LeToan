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
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <h2>Customer's Information Detail</h2>
        </div>
        <table class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">#</th>
                <th scope="col">Information</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td scope="row">ID</td>
                <td>${customer.customerId}</td>
            </tr>
            <tr>
                <td scope="row">Name</td>
                <td>${customer.customerName}</td>
            </tr>
            <tr>
                <td scope="row">Birthday</td>
                <td>${customer.customerBirthday}</td>
            </tr>
            <tr>
                <td scope="row">Gender</td>
                <c:if test='${customer.customerGender == 0}'>
                    <td>Female</td>
                </c:if>
                <c:if test='${customer.customerGender == 1}'>
                    <td>Male</td>
                </c:if>
            </tr>
            <tr>
                <td scope="row">Identify Number</td>
                <td>${customer.customerIdCard}</td>
            </tr>
            <tr>
                <td scope="row">Phone</td>
                <td>${customer.customerPhone}</td>
            </tr>
            <tr>
                <td scope="row">Email</td>
                <td>${customer.customerEmail}</td>
            </tr>
            <tr>
                <td scope="row">Address</td>
                <td>${customer.customerAddress}</td>
            </tr>
            <tr>
                <td scope="row">Type Customer</td>
                <c:if test='${customer.customerTypeId == 1}'>
                    <td>Diamond</td>
                </c:if>
                <c:if test='${customer.customerTypeId == 2}'>
                    <td>Platinum</td>
                </c:if>
                <c:if test='${customer.customerTypeId == 3}'>
                    <td>Gold</td>
                </c:if>
                <c:if test='${customer.customerTypeId == 4}'>
                    <td>Silver</td>
                </c:if>
                <c:if test='${customer.customerTypeId == 5}'>
                    <td>Member</td>
                </c:if>
            </tr>
            </tbody>
        </table>
        <div class="row text-center col-12">
            <a href="/customer?action=edit&id=${customer.customerId}" role="button" class="btn btn-outline-dark mr-2">Edit <span class="fas fa-edit"></span></a>
            <a href="/customer?action=delete&id=${customer.customerId}" role="button" class="btn btn-outline-dark mr-2">Delete <span class="fas fa-eraser"></span></a>
            <a href="/customer" role="button" class="btn btn-outline-dark float-left">Back</a>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

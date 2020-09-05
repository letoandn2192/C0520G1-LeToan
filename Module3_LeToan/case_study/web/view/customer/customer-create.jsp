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
    <div class="body position-relative" style="top: 160px">
        <form method="post" action="/customer">
            <fieldset>
                <legend class="text-center">Create New Customer</legend>
                <div class="form-group form-inline">
                    <label for="id" class="col-2 d-flex justify-content-start">Id</label>
                    <input type="text" class="col-8 form-control" id="id" name="id" pattern="KH-\\d{4}" title="Format KH-XXXX (X is number)">
                </div>
                <div class="form-group form-inline">
                    <label for="name" class="col-2 d-flex justify-content-start">Name</label>
                    <input type="text" class="col-8 form-control" id="name" name="name">
                </div>
                <div class="form-group form-inline">
                    <label for="birthday" class="col-2 d-flex justify-content-start">Birthday</label>
                    <input type="date" class="col-8 form-control" id="birthday" name="birthday">
                </div>
                <div class="form-group form-inline">
                    <label for="gender" class="col-2 d-flex justify-content-start">Gender</label>
                    <select class="col-8 form-control" id="gender" name="gender">
                        <option value="1">Male</option>
                        <option value="0">Female</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="idNumber" class="col-2 d-flex justify-content-start">Identify Number</label>
                    <input type="text" class="col-8 form-control" id="idNumber" name="idNumber">
                </div>
                <div class="form-group form-inline">
                    <label for="phone" class="col-2 d-flex justify-content-start">Phone</label>
                    <input type="text" class="col-8 form-control" id="phone" name="phone">
                </div>
                <div class="form-group form-inline">
                    <label for="email" class="col-2 d-flex justify-content-start">Email</label>
                    <input type="text" class="col-8 form-control" id="email" name="email">
                </div>
                <div class="form-group form-inline">
                    <label for="address" class="col-2 d-flex justify-content-start">Address</label>
                    <input type="text" class="col-8 form-control" id="address" name="address">
                </div>
                <div class="form-group form-inline">
                    <label for="typecutomer" class="col-2 d-flex justify-content-start">Customer Type</label>
                    <select class="col-8 form-control" id="typecutomer" name="typeId">
                        <option value="1">Diamond</option>
                        <option value="2">Platinum</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </div>

                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="hidden" name="action" value="create">
                        <input type="submit" value="Create" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/customer">Back</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

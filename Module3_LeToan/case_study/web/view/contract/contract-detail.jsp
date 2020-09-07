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
    <title>Contract</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/contract_detail?action=create&id=${contract.contractId}" role="button" class="btn btn-outline-dark float-left">Create New Contract Detail</a>
            <h2>Contract's Information Detail</h2>
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
                <td>${contract.contractId}</td>
            </tr>
            <tr>
                <td scope="row">Start Date</td>
                <td>${contract.contractStartDate}</td>
            </tr>
            <tr>
                <td scope="row">End Date</td>
                <td>${contract.contractEndDate}</td>
            </tr>
            <tr>
                <td scope="row">Deposit</td>
                <td>${contract.contractDeposit}</td>
            </tr>
            <tr>
                <td scope="row">Total Money</td>
                <td>${contract.contractTotalMoney}</td>
            </tr>
            <tr>
                <td scope="row">Employee ID</td>
                <td>${contract.employeeId}</td>
            </tr>
            <tr>
                <td scope="row">Customer ID</td>
                <td>${contract.customerId}</td>
            </tr>
            <tr>
                <td scope="row">Service ID</td>
                <td>${contract.serviceId}</td>
            </tr>
            </tbody>
        </table>
        <div class="row text-center col-12">
            <a href="/contract?action=edit&id=${contract.contractId}" role="button" class="btn btn-outline-dark mr-2">Edit <span class="fas fa-edit"></span></a>
            <a href="/contract?action=delete&id=${contract.contractId}" role="button" class="btn btn-outline-dark mr-2">Delete <span class="fas fa-eraser"></span></a>
            <a href="/contract" role="button" class="btn btn-outline-dark float-left">Back</a>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

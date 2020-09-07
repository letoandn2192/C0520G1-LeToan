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
    <div class="body position-relative" style="top: 160px">
        <form method="post">
            <fieldset>
                <legend class="text-center">Delete Information</legend>
                <div class="form-group form-inline">
                    <label for="id" class="col-2 d-flex justify-content-start">Id</label>
                    <input type="text" readonly class="col-8 form-control" id="id" name="id" value="${contract.contractId}">
                </div>
                <div class="form-group form-inline">
                    <label for="startDate" class="col-2 d-flex justify-content-start">Start Date</label>
                    <input type="text" class="col-8 form-control" id="startDate" name="startDate" value="${contract.contractStartDate}">
                </div>
                <div class="form-group form-inline">
                    <label for="endDate" class="col-2 d-flex justify-content-start">End Date</label>
                    <input type="text" class="col-8 form-control" id="endDate" name="endDate" value="${contract.contractEndDate}">
                </div>
                <div class="form-group form-inline">
                    <label for="deposit" class="col-2 d-flex justify-content-start">Deposit</label>
                    <input type="text" class="col-8 form-control" id="deposit" name="deposit" value="${contract.contractDeposit}">
                </div>
                <div class="form-group form-inline">
                    <label for="totalMoney" class="col-2 d-flex justify-content-start">Total Money</label>
                    <input type="text" class="col-8 form-control" id="totalMoney" name="totalMoney" value="${contract.contractTotalMoney}">
                </div>
                <div class="form-group form-inline">
                    <label for="employeeId" class="col-2 d-flex justify-content-start">Employee ID</label>
                    <input type="text" class="col-8 form-control" id="employeeId" name="employeeId" value="${contract.employeeId}">
                </div>
                <div class="form-group form-inline">
                    <label for="customerId" class="col-2 d-flex justify-content-start">Customer ID</label>
                    <input type="text" class="col-8 form-control" id="customerId" name="customerId" value="${contract.customerId}">
                </div>
                <div class="form-group form-inline">
                    <label for="serviceId" class="col-2 d-flex justify-content-start">Service ID</label>
                    <input type="text" class="col-8 form-control" id="serviceId" name="serviceId" value="${contract.serviceId}">
                </div>

                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="submit" value="Delete" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/contract?action=view&id=${contract.contractId}">Back</a>
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

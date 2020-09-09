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
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/jquery-ui-1.12.1/jquery-ui.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <form method="post" action="/contract">
            <fieldset>
                <legend class="text-center">Create New Contract</legend>
                <div class="form-group form-inline">
                    <label for="startDate" class="col-2 d-flex justify-content-start">Start Date</label>
                    <input type="text" class="col-8 form-control" id="startDate" name="startDate" required>
                </div>
                <c:if test='${errMessList.get(0) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(0)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="endDate" class="col-2 d-flex justify-content-start">End Date</label>
                    <input type="text" class="col-8 form-control" id="endDate" name="endDate" required>
                </div>
                <c:if test='${errMessList.get(1) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(1)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="deposit" class="col-2 d-flex justify-content-start">Deposit</label>
                    <input type="text" class="col-8 form-control" id="deposit" name="deposit">
                </div>
                <c:if test='${errMessList.get(2) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(2)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="totalMoney" class="col-2 d-flex justify-content-start">Total Money</label>
                    <input type="text" class="col-8 form-control" id="totalMoney" name="totalMoney">
                </div>
                <c:if test='${errMessList.get(3) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(3)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="employeeId" class="col-2 d-flex justify-content-start">Employee ID</label>
                    <select class="col-8 form-control" id="employeeId" name="employeeId">
                        <c:forEach var="employee" items="${employeeList}">
                            <option value="${employee.employeeId}">${employee.employeeId}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="customerId" class="col-2 d-flex justify-content-start">Customer ID</label>
                    <select class="col-8 form-control" id="customerId" name="customerId">
                        <c:forEach var="customer" items="${customerList}">
                            <option value="${customer.customerId}">${customer.customerId}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="serviceId" class="col-2 d-flex justify-content-start">Service ID</label>
                    <select class="col-8 form-control" id="serviceId" name="serviceId">
                        <c:forEach var="service" items="${serviceList}">
                            <option value="${service.serviceId}">${service.serviceId}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="hidden" name="action" value="create">
                        <input type="submit" value="Create" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/contract">Back</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
<script src="../../bootstrap_4/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script>
    $( document ).ready(function() {
        $("#startDate, #endDate").datepicker({ dateFormat: "dd/mm/yy" });
    });
</script>
</body>
</html>

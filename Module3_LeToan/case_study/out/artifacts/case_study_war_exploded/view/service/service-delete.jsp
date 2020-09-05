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
    <title>Service</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <form method="post">
            <fieldset>
                <legend class="text-center">Delete Information</legend>
                <div class="form-group form-inline">
                    <label for="id" class="col-2 d-flex justify-content-start">Id</label>
                    <input type="text" readonly class="col-8 form-control" id="id" name="id"
                           value="${service.serviceId}">
                </div>
                <div class="form-group form-inline">
                    <label for="name" class="col-2 d-flex justify-content-start">Name</label>
                    <input type="text" class="col-8 form-control" id="name" name="name" value="${service.serviceName}">
                </div>
                <div class="form-group form-inline">
                    <label for="area" class="col-2 d-flex justify-content-start">Area</label>
                    <input type="text" class="col-8 form-control" id="area" name="area" value="${service.serviceArea}">
                </div>
                <div class="form-group form-inline">
                    <label for="cost" class="col-2 d-flex justify-content-start">Cost</label>
                    <input type="text" class="col-8 form-control" id="cost" name="cost" value="${service.serviceCost}">
                </div>
                <div class="form-group form-inline">
                    <label for="maxPerson" class="col-2 d-flex justify-content-start">Max Person</label>
                    <input type="text" class="col-8 form-control" id="maxPerson" name="maxPerson"
                           value="${service.serviceMaxPerson}">
                </div>
                <div class="form-group form-inline">
                    <label for="rentType" class="col-2 d-flex justify-content-start">Rent Type</label>
                    <c:if test="${service.rentTypeId == 1}">
                        <input type="text" class="col-8 form-control" id="rentType" name="rentType" value="Year">
                    </c:if>
                    <c:if test="${service.rentTypeId == 2}">
                        <input type="text" class="col-8 form-control" id="rentType" name="rentType" value="Month">
                    </c:if>
                    <c:if test="${service.rentTypeId == 3}">
                        <input type="text" class="col-8 form-control" id="rentType" name="rentType" value="Day">
                    </c:if>
                    <c:if test="${service.rentTypeId == 4}">
                        <input type="text" class="col-8 form-control" id="rentType" name="rentType" value="Hour">
                    </c:if>
                </div>
                <div class="form-group form-inline">
                    <label for="serviceType" class="col-2 d-flex justify-content-start">Service Type</label>
                    <c:if test="${service.serviceTypeId == 1}">
                        <input type="text" class="col-8 form-control" id="serviceType" name="serviceType" value="Villa">
                    </c:if>
                    <c:if test="${service.serviceTypeId == 2}">
                        <input type="text" class="col-8 form-control" id="serviceType" name="serviceType" value="House">
                    </c:if>
                    <c:if test="${service.serviceTypeId == 3}">
                        <input type="text" class="col-8 form-control" id="serviceType" name="serviceType" value="Room">
                    </c:if>
                </div>
                <c:if test="${service.serviceTypeId == 2 || service.serviceTypeId == 1}">
                    <div class="form-group form-inline">
                        <label for="standard" class="col-2 d-flex justify-content-start">Standard Room</label>
                        <input type="text" class="col-8 form-control" id="standard" name="standard" value="${service.standardRoom}">
                    </div>
                    <div class="form-group form-inline">
                        <label for="description" class="col-2 d-flex justify-content-start">Description</label>
                        <input type="text" class="col-8 form-control" id="description" name="description" value="${service.description}">
                    </div>
                    <c:if test="${service.serviceTypeId == 1}">
                        <div class="form-group form-inline">
                            <label for="pool" class="col-2 d-flex justify-content-start">Pool Area</label>
                            <input type="text" class="col-8 form-control" id="pool" name="pool" value="${service.poolArea}">
                        </div>
                    </c:if>
                    <div class="form-group form-inline">
                        <label for="floor" class="col-2 d-flex justify-content-start">Floors</label>
                        <input type="text" class="col-8 form-control" id="floor" name="floor" value="${service.numberFloor}">
                    </div>
                </c:if>

                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="submit" value="Delete" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/service?action=view&id=${service.serviceId}">Back</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

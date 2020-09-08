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
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <h2>Service's Information Detail</h2>
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
                <td>${service.serviceId}</td>
            </tr>
            <tr>
                <td scope="row">Name</td>
                <td>${service.serviceName}</td>
            </tr>
            <tr>
                <td scope="row">Area</td>
                <td>${service.serviceArea}</td>
            </tr>
            <tr>
                <td scope="row">Cost</td>
                <td>${service.serviceCost}</td>
            </tr>
            <tr>
                <td scope="row">Max Person</td>
                <td>${service.serviceMaxPerson}</td>
            </tr>
            <tr>
                <td scope="row">Rent Type</td>
                <c:if test='${service.rentTypeId == 1}'>
                    <td>Year</td>
                </c:if>
                <c:if test='${service.rentTypeId == 2}'>
                    <td>Month</td>
                </c:if>
                <c:if test='${service.rentTypeId == 3}'>
                    <td>Day</td>
                </c:if>
                <c:if test='${service.rentTypeId == 4}'>
                    <td>Hour</td>
                </c:if>
            </tr>
            <tr>
                <td scope="row">Service Type</td>
                <c:if test='${service.serviceTypeId == 1}'>
                    <td>Villa</td>
                </c:if>
                <c:if test='${service.serviceTypeId == 2}'>
                    <td>House</td>
                </c:if>
                <c:if test='${service.serviceTypeId == 3}'>
                    <td>Room</td>
                </c:if>
            </tr>
            <c:if test='${service.serviceTypeId == 2 || service.serviceTypeId == 1 }'>
                <tr>
                    <td scope="row">Standard Room</td>
                    <td>${service.standardRoom}</td>
                </tr>
                <tr>
                    <td scope="row">Description</td>
                    <td>${service.description}</td>
                </tr>
                <c:if test="${service.serviceTypeId == 1}">
                    <tr>
                        <td scope="row">Pool Area</td>
                        <td>${service.poolArea}</td>
                    </tr>
                </c:if>
                <tr>
                    <td scope="row">Floors</td>
                    <td>${service.numberFloor}</td>
                </tr>
            </c:if>
            </tbody>
        </table>
        <div class="row text-center col-12">
            <a href="/service?action=edit&id=${service.serviceId}" role="button" class="btn btn-outline-dark mr-2">Edit <span class="fas fa-edit"></span></a>
            <a href="/service?action=delete&id=${service.serviceId}" role="button" class="btn btn-outline-dark mr-2">Delete <span class="fas fa-eraser"></span></a>
            <a href="/service" role="button" class="btn btn-outline-dark float-left">Back</a>
        </div>
        <c:if test="${messageInform != null}">
            <div class="alert alert-success col-4 d-flex justify-content-center" role="alert">
                    ${messageInform}
            </div>
        </c:if>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
<script>
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
</script>
</body>
</html>

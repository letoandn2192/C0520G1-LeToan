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
<%--    <link href="../../bootstrap413/css/bootstrap.min.css" type="text/css" rel="stylesheet">--%>
    <link href="../../datatables/css/dataTables.bootstrap4.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/service?action=create" role="button" class="btn btn-outline-dark float-left">Create New Service</a>
            <h2>List of Service</h2>
        </div>
        <table id="tableStudent" class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Area</th>
                <th scope="col">Cost</th>
                <th scope="col">Max Person</th>
                <th scope="col">Rent Type</th>
                <th scope="col">Service Type</th>
                <th scope="col">Detail</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="service" items="${serviceList}">
                <tr>
                    <td scope="row">${service.serviceId}</td>
                    <td>${service.serviceName}</td>
                    <td>${service.serviceArea}</td>
                    <td>${service.serviceCost}</td>
                    <td>${service.serviceMaxPerson}</td>
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
                    <c:if test='${service.serviceTypeId == 1}'>
                        <td>Villa</td>
                    </c:if>
                    <c:if test='${service.serviceTypeId == 2}'>
                        <td>House</td>
                    </c:if>
                    <c:if test='${service.serviceTypeId == 3}'>
                        <td>Room</td>
                    </c:if>
                    <td>
                        <a href="/service?action=view&id=${service.serviceId}">Detail <span class="fas fa-info mr-3"></span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test='${action == "search"}'>
            <div class="col-12 d-flex justify-content-center">
                <a class="btn btn-outline-dark" href="/service">Back</a>
            </div>
        </c:if>
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
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.js"></script>
<script>
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 2000);

    $(document).ready(function () {
        $("#tableStudent").dataTable({
            "dom": "lrtip",
            "lengthChange": false,
            "pageLength": 10
        })
    })
</script>
</body>
</html>

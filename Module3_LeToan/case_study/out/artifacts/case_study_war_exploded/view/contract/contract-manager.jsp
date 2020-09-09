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
    <link href="../../bootstrap413/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="../../datatables/css/dataTables.bootstrap4.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container-fluid">
    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <h2>Contract Manager</h2>
        </div>
        <table id="tableStudent" class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Customer Id</th>
                <th scope="col">Customer Name</th>
                <th scope="col">Service Id</th>
                <th scope="col">Service Name</th>
                <th scope="col">Contract Id</th>
                <th scope="col">Attach Service Name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contractList}">
                <tr>
                    <td>${contract.customerId}</td>
                    <td>${contract.customerName}</td>
                    <td><a href="/service?action=view&id=${contract.serviceId}" style="text-decoration: none">${contract.serviceId}</a></td>
                    <td>${contract.serviceName}</td>
                    <td>${contract.contractId}</td>
                    <td>${contract.attachServiceName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row text-center col-12 d-flex justify-content-end">
            <a href="/contract" role="button" class="btn btn-outline-dark">Back</a>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
<script>
    $(document).ready(function () {
        $("#tableStudent").dataTable({
            "dom": "lrtip",
            "lengthChange": false,
            "pageLength": 5
        })
    })
</script>
</body>
</html>

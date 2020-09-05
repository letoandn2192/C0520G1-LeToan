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
    <title>Employee</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/employee?action=create" role="button" class="btn btn-outline-dark float-left">Create New Employee</a>
            <h2>List of Employee</h2>
        </div>
        <table class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Birthday</th>
                <th scope="col">Email</th>
                <th scope="col">Address</th>
                <th scope="col">Detail</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="employee" items="${employeeList}">
                <tr>
                    <td scope="row">${employee.employeeId}</td>
                    <td>${employee.employeeName}</td>
                    <td>${employee.employeeBirthday}</td>
                    <td>${employee.employeeEmail}</td>
                    <td>${employee.employeeAddress}</td>
                    <td>
                        <a href="/employee?action=view&id=${employee.employeeId}">Detail <span class="fas fa-info mr-3"></span></a>
                            <%--                        <a href="/customer?action=edit&id=${customer.customerId}"><span class="fas fa-edit mr-3"></span></a>--%>
                            <%--                        <a href="/customer?action=delete&id=${customer.customerId}"><span class="fas fa-eraser"></span></a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test='${action != "search"}'>
            <div class="col-12 d-flex justify-content-center">
                <ul class="pagination pagination">
                        <%--                <li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
                    <li class="page-item"><a class="page-link" href="/employee?page=1&search=${search}">1</a></li>
                    <c:if test="${totalPage > 1}">
                        <c:forEach var="i" begin="2" end="${totalPage}">
                            <li class="page-item"><a class="page-link" href="/employee?page=${i}&search=${search}">${i}</a></li>
                        </c:forEach>
                    </c:if>
                        <%--                <li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
                </ul>
            </div>
        </c:if>
        <c:if test='${action == "search"}'>
            <div class="col-12 d-flex justify-content-center">
                <a class="btn btn-outline-dark" href="/employee">Back</a>
            </div>
        </c:if>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

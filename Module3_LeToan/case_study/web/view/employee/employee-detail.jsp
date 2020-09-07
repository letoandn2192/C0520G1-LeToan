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
            <h2>Employee's Information Detail</h2>
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
                <td>${employee.employeeId}</td>
            </tr>
            <tr>
                <td scope="row">Name</td>
                <td>${employee.employeeName}</td>
            </tr>
            <tr>
                <td scope="row">Birthday</td>
                <td>${employee.employeeBirthday}</td>
            </tr>
            <tr>
                <td scope="row">Identify Number</td>
                <td>${employee.employeeIdCard}</td>
            </tr>
            <tr>
                <td scope="row">Salary</td>
                <td>${employee.employeeSalary}</td>
            </tr>
            <tr>
                <td scope="row">Phone</td>
                <td>${employee.employeePhone}</td>
            </tr>
            <tr>
                <td scope="row">Email</td>
                <td>${employee.employeeEmail}</td>
            </tr>
            <tr>
                <td scope="row">Address</td>
                <td>${employee.employeeAddress}</td>
            </tr>
            <tr>
                <td scope="row">Position</td>
                <c:if test='${employee.positionId == 1}'>
                    <td>Receptionist</td>
                </c:if>
                <c:if test='${employee.positionId == 2}'>
                    <td>Serve</td>
                </c:if>
                <c:if test='${employee.positionId == 3}'>
                    <td>Expert</td>
                </c:if>
                <c:if test='${employee.positionId == 4}'>
                    <td>Supervisor</td>
                </c:if>
                <c:if test='${employee.positionId == 5}'>
                    <td>Manager</td>
                </c:if>
                <c:if test='${employee.positionId == 6}'>
                    <td>Director</td>
                </c:if>
            </tr>
            <tr>
                <td scope="row">Education</td>
                <c:if test='${employee.educationDegreeId == 1}'>
                    <td>Intermediate</td>
                </c:if>
                <c:if test='${employee.educationDegreeId == 2}'>
                    <td>Colleges</td>
                </c:if>
                <c:if test='${employee.educationDegreeId == 3}'>
                    <td>University</td>
                </c:if>
                <c:if test='${employee.educationDegreeId == 4}'>
                    <td>After university</td>
                </c:if>
            </tr>
            <tr>
                <td scope="row">Division</td>
                <c:if test='${employee.divisionId == 1}'>
                    <td>Sale – Marketing</td>
                </c:if>
                <c:if test='${employee.divisionId == 2}'>
                    <td>Administrative</td>
                </c:if>
                <c:if test='${employee.divisionId == 3}'>
                    <td>Service</td>
                </c:if>
                <c:if test='${employee.divisionId == 4}'>
                    <td>Management</td>
                </c:if>
            </tr>
            <tr>
                <td scope="row">User Name</td>
                <td>${employee.userName}</td>
            </tr>
            </tbody>
        </table>
        <div class="row text-center col-12">
            <a href="/employee?action=edit&id=${employee.employeeId}" role="button" class="btn btn-outline-dark mr-2">Edit <span class="fas fa-edit"></span></a>
            <a href="/employee?action=delete&id=${employee.employeeId}" role="button" class="btn btn-outline-dark mr-2">Delete <span class="fas fa-eraser"></span></a>
            <a href="/employee" role="button" class="btn btn-outline-dark float-left">Back</a>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

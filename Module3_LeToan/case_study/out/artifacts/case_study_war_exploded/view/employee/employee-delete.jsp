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
    <div class="body position-relative" style="top: 160px">
        <form method="post">
            <fieldset>
                <legend class="text-center">Delete Information</legend>
                <div class="form-group form-inline">
                    <label for="id" class="col-2 d-flex justify-content-start">Id</label>
                    <input type="text" readonly class="col-8 form-control" id="id" name="id" value="${employee.employeeId}">
                </div>
                <div class="form-group form-inline">
                    <label for="name" class="col-2 d-flex justify-content-start">Name</label>
                    <input type="text" class="col-8 form-control" id="name" name="name" value="${employee.employeeName}">
                </div>
                <div class="form-group form-inline">
                    <label for="birthday" class="col-2 d-flex justify-content-start">Birthday</label>
                    <input type="text" class="col-8 form-control" id="birthday" name="birthday" value="${customer.customerBirthday}">
                </div>
                <div class="form-group form-inline">
                    <label for="idNumber" class="col-2 d-flex justify-content-start">Identify Number</label>
                    <input type="text" class="col-8 form-control" id="idNumber" name="idNumber" value="${employee.employeeIdCard}">
                </div>
                <div class="form-group form-inline">
                    <label for="salary" class="col-2 d-flex justify-content-start">Salary</label>
                    <input type="text" class="col-8 form-control" id="salary" name="salary" value="${employee.employeeSalary}">
                </div>
                <div class="form-group form-inline">
                    <label for="phone" class="col-2 d-flex justify-content-start">Phone</label>
                    <input type="text" class="col-8 form-control" id="phone" name="phone" value="${employee.employeePhone}">
                </div>
                <div class="form-group form-inline">
                    <label for="email" class="col-2 d-flex justify-content-start">Email</label>
                    <input type="text" class="col-8 form-control" id="email" name="email" value="${employee.employeeEmail}">
                </div>
                <div class="form-group form-inline">
                    <label for="address" class="col-2 d-flex justify-content-start">Address</label>
                    <input type="text" class="col-8 form-control" id="address" name="address" value="${employee.employeeAddress}">
                </div>
                <div class="form-group form-inline">
                    <label for="position" class="col-2 d-flex justify-content-start">Position</label>
                    <c:if test='${employee.positionId == 1}'>
                        <input type="text" class="col-8 form-control" id="position" name="position" value="Receptionist">
                    </c:if>
                    <c:if test='${employee.positionId == 2}'>
                        <input type="text" class="col-8 form-control" id="position" name="position" value="Serve">
                    </c:if>
                    <c:if test='${employee.positionId == 3}'>
                        <input type="text" class="col-8 form-control" id="position" name="position" value="Expert">
                    </c:if>
                    <c:if test='${employee.positionId == 4}'>
                        <input type="text" class="col-8 form-control" id="position" name="position" value="Supervisor">
                    </c:if>
                    <c:if test='${employee.positionId == 5}'>
                        <input type="text" class="col-8 form-control" id="position" name="position" value="Manager">
                    </c:if>
                    <c:if test='${employee.positionId == 6}'>
                        <input type="text" class="col-8 form-control" id="position" name="position" value="Director">
                    </c:if>
                </div>
                <div class="form-group form-inline">
                    <label for="education" class="col-2 d-flex justify-content-start">Education</label>
                    <c:if test='${employee.educationDegreeId == 1}'>
                        <input type="text" class="col-8 form-control" id="education" name="education" value="Intermediate">
                    </c:if>
                    <c:if test='${employee.educationDegreeId == 2}'>
                        <input type="text" class="col-8 form-control" id="education" name="education" value="Colleges">
                    </c:if>
                    <c:if test='${employee.educationDegreeId == 3}'>
                        <input type="text" class="col-8 form-control" id="education" name="education" value="University">
                    </c:if>
                    <c:if test='${employee.educationDegreeId == 4}'>
                        <input type="text" class="col-8 form-control" id="education" name="education" value="After university">
                    </c:if>
                </div>
                <div class="form-group form-inline">
                    <label for="division" class="col-2 d-flex justify-content-start">Division</label>
                    <c:if test='${employee.divisionId == 1}'>
                        <input type="text" class="col-8 form-control" id="division" name="division" value="Sale – Marketing">
                    </c:if>
                    <c:if test='${employee.divisionId == 2}'>
                        <input type="text" class="col-8 form-control" id="division" name="division" value="Administrative">
                    </c:if>
                    <c:if test='${employee.divisionId == 3}'>
                        <input type="text" class="col-8 form-control" id="division" name="division" value="Service">
                    </c:if>
                    <c:if test='${employee.divisionId == 4}'>
                        <input type="text" class="col-8 form-control" id="division" name="division" value="Management">
                    </c:if>
                </div>
                <div class="form-group form-inline">
                    <label for="username" class="col-2 d-flex justify-content-start">User Name</label>
                    <input type="text" class="col-8 form-control" id="username" name="username" value="${employee.userName}">
                </div>

                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="submit" value="Delete" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/employee?action=view&id=${employee.employeeId}">Back</a>
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

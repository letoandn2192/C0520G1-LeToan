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
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/jquery-ui-1.12.1/jquery-ui.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <form method="post">
            <fieldset>
                <legend class="text-center">Update Information</legend>
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
                    <input type="text" class="col-8 form-control" id="birthday" name="birthday" value="${employee.employeeBirthday}">
                </div>
                <c:if test='${errMessList.get(0) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(0)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="idNumber" class="col-2 d-flex justify-content-start">Identify Number</label>
                    <input type="text" class="col-8 form-control" id="idNumber" name="idNumber" value="${employee.employeeIdCard}">
                </div>
                <c:if test='${errMessList.get(1) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(1)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="salary" class="col-2 d-flex justify-content-start">Salary</label>
                    <input type="text" class="col-8 form-control" id="salary" name="salary" value="${employee.employeeSalary}">
                </div>
                <c:if test='${errMessList.get(2) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(2)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="phone" class="col-2 d-flex justify-content-start">Phone</label>
                    <input type="text" class="col-8 form-control" id="phone" name="phone" value="${employee.employeePhone}">
                </div>
                <c:if test='${errMessList.get(3) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(3)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="email" class="col-2 d-flex justify-content-start">Email</label>
                    <input type="text" class="col-8 form-control" id="email" name="email" value="${employee.employeeEmail}">
                </div>
                <c:if test='${errMessList.get(4) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(4)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="address" class="col-2 d-flex justify-content-start">Address</label>
                    <input type="text" class="col-8 form-control" id="address" name="address" value="${employee.employeeAddress}">
                </div>
                <div class="form-group form-inline">
                    <label for="position" class="col-2 d-flex justify-content-start">Position</label>
                    <select class="col-8 form-control" id="position" name="position">
                        <option value="${employee.positionId}">
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
                        </option>
                        <option value="1">Receptionist</option>
                        <option value="2">Serve</option>
                        <option value="3">Expert</option>
                        <option value="4">Supervisor</option>
                        <option value="5">Manager</option>
                        <option value="6">Director</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="education" class="col-2 d-flex justify-content-start">Education</label>
                    <select class="col-8 form-control" id="education" name="education">
                        <option value="${employee.educationDegreeId}">
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
                        </option>
                        <option value="1">Intermediate</option>
                        <option value="2">Colleges</option>
                        <option value="3">University</option>
                        <option value="4">After university</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="division" class="col-2 d-flex justify-content-start">Division</label>
                    <select class="col-8 form-control" id="division" name="division">
                        <option value="${employee.divisionId}">
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
                        </option>
                        <option value="1">Sale – Marketing</option>
                        <option value="2">Administrative</option>
                        <option value="3">Service</option>
                        <option value="4">Management</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="username" class="col-2 d-flex justify-content-start">User Name</label>
                    <input type="text" class="col-8 form-control" id="username" name="username" value="${employee.userName}">
                </div>
                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="submit" value="Update" class="btn btn-outline-dark mr-2">
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
<script src="../../bootstrap_4/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script>
    $( document ).ready(function() {
        $("#birthday").datepicker({ dateFormat: "dd/mm/yy" });
    });
</script>
</body>
</html>

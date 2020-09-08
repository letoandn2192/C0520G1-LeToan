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
        <form method="post" action="/service">
            <fieldset>
                <legend class="text-center">Create New Service</legend>
                <div class="form-group form-inline">
                    <label for="id" class="col-2 d-flex justify-content-start">Id</label>
                    <input type="text" class="col-8 form-control" id="id" name="id">
                </div>
                <c:if test='${errMessList.get(0) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(0)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="name" class="col-2 d-flex justify-content-start">Name</label>
                    <input type="text" class="col-8 form-control" id="name" name="name">
                </div>
                <div class="form-group form-inline">
                    <label for="area" class="col-2 d-flex justify-content-start">Area</label>
                    <input type="text" class="col-8 form-control" id="area" name="area">
                </div>
                <c:if test='${errMessList.get(1) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(1)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="cost" class="col-2 d-flex justify-content-start">Cost</label>
                    <input type="text" class="col-8 form-control" id="cost" name="cost">
                </div>
                <c:if test='${errMessList.get(2) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(2)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="maxPerson" class="col-2 d-flex justify-content-start">Max Person</label>
                    <input type="text" class="col-8 form-control" id="maxPerson" name="maxPerson">
                </div>
                <c:if test='${errMessList.get(3) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(3)}</p>
                </c:if>
                <div class="form-group form-inline">
                    <label for="rentType" class="col-2 d-flex justify-content-start">Rent Type</label>
                    <select class="col-8 form-control" id="rentType" name="rentType">
                        <option value="1">Year</option>
                        <option value="2">Month</option>
                        <option value="3">Day</option>
                        <option value="4">Hour</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="serviceType" class="col-2 d-flex justify-content-start">Service Type</label>
                    <select class="col-8 form-control" id="serviceType" name="serviceType">
                        <option value="1">Villa</option>
                        <option value="2">House</option>
                        <option value="3">Room</option>
                    </select>
                </div>
                <div class="form-group form-inline" id="hidden1">
                    <label for="standard" class="col-2 d-flex justify-content-start">Standard Room</label>
                    <input type="text" class="col-8 form-control" id="standard" name="standard">
                </div>
                <div class="form-group form-inline" id="hidden2">
                    <label for="description" class="col-2 d-flex justify-content-start">Description</label>
                    <input type="text" class="col-8 form-control" id="description" name="description">
                </div>
                <div class="form-group form-inline" id="hidden3">
                    <label for="pool" class="col-2 d-flex justify-content-start">Pool Area</label>
                    <input type="text" class="col-8 form-control" id="pool" name="pool">
                </div>
                <c:if test='${errMessList.get(4) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(4)}</p>
                </c:if>
                <div class="form-group form-inline" id="hidden4">
                    <label for="floor" class="col-2 d-flex justify-content-start">Floors</label>
                    <input type="text" class="col-8 form-control" id="floor" name="floor">
                </div>
                <c:if test='${errMessList.get(5) != ""}'>
                    <p class="text-danger alert p-0" style="margin-left: 16.66%; margin-bottom: 0">${errMessList.get(5)}</p>
                </c:if>

                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="hidden" name="action" value="create">
                        <input type="submit" value="Create" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/service">Back</a>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
<script>
    $(document).ready(
        function () {
            let check;
            $("#serviceType").change(function () {
                 check = $("#serviceType").val();
                if (check === "2") {
                    $("#hidden3").hide();
                    $("#hidden1, #hidden2, #hidden4").show();
                } else if (check === "3") {
                    $("#hidden1, #hidden2, #hidden3, #hidden4").hide();
                } else {
                    $("#hidden1, #hidden2, #hidden3, #hidden4").show();
                }
            });
        }
    );
</script>
</body>
</html>

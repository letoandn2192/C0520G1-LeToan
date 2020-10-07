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
    <title>Customer</title>
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
                    <input type="text" readonly class="col-8 form-control" id="id" name="id" value="${product.productId}">
                </div>
                <div class="form-group form-inline">
                    <label for="name" class="col-2 d-flex justify-content-start">Name</label>
                    <input type="text" class="col-8 form-control" id="name" name="name" value="${product.productName}">
                </div>
                <div class="form-group form-inline">
                    <label for="price" class="col-2 d-flex justify-content-start">Price</label>
                    <input type="text" class="col-8 form-control" id="price" name="price" value="${product.productPrice}">
                </div>
                <div class="form-group form-inline">
                    <label for="amount" class="col-2 d-flex justify-content-start">Amount</label>
                    <input type="text" class="col-8 form-control" id="amount" name="amount" value="${product.productAmount}">
                </div>

                <div class="form-group form-inline">
                    <label for="color" class="col-2 d-flex justify-content-start">Color</label>
                    <input type="text" class="col-8 form-control" id="color" name="color" value="${product.productColor}">
                </div>
                <div class="form-group form-inline">
                    <label for="description" class="col-2 d-flex justify-content-start">Description</label>
                    <input type="text" class="col-8 form-control" id="description" name="description" value="${product.productDescription}">
                </div>
                <div class="form-group form-inline">
                    <label for="categoryId" class="col-2 d-flex justify-content-start">Category Id</label>
                    <input type="text" class="col-8 form-control" id="categoryId" name="categoryId" value="${product.productCategoryId}">
                </div>
                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="submit" value="Update" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/product">Back</a>
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
</body>
</html>

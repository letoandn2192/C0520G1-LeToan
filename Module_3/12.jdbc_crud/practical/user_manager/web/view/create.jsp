<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/30/2020
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create</title>
    <link type="text/css" rel="stylesheet" href="../bootstrap_4/css/bootstrap.min.css">
    <link href="../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<form method="post">
<fieldset>
    <legend>Create New User</legend>
    <div class="form-group col-md-4">
        <label for="name">Name</label>
        <input type="text" id="name" class="form-control" name="name">
    </div>

    <div class="form-group col-md-4">
        <label for="email">Email</label>
        <input type="text" id="email" class="form-control" name="email">
    </div>

    <div class="form-group col-md-4">
        <label for="address">Address</label>
        <input type="text" id="address" class="form-control" name="address">
    </div>

    <div class="form-group col-md-4">
        <input type="submit" role="button" class="btn btn-outline-dark">
        <a role="button" class="btn btn-outline-dark" href="/user">Back</a>
    </div>
</fieldset>
</form>
<script src="../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

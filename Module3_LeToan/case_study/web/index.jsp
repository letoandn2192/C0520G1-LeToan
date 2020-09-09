<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/8/2020
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="d-flex justify-content-center col-12">
    <form class="login-form col-6" action="login" method="post">
        <fieldset>
            <legend class="d-flex justify-content-center">LOGIN</legend>
            <div class="form-group form-inline">
                <label for="username" class="d-flex justify-content-start col-4">Username</label>
                <input type="text" class="form-control col-8" id="username" name="txtUsername">
            </div>
            <div class="form-group form-inline">
                <label for="password" class="d-flex justify-content-start col-4">Password</label>
                <input type="password" class="form-control col-8" id="password" name="txtPassword">
            </div>

            <div class="form-group form-check">
                <div class="col-4"></div>
                <div class="col-8">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Remember</label>
                </div>
            </div>
            <div class="form-group form-inline">
                <div class="col-4"></div>
                <div class="col-8 pl-0">
                    <button type="submit" class="btn btn-outline-dark">Submit</button>
                </div>
            </div>
            <div class="form-group form-inline">
                <div class="col-4"></div>
                <div class="col-8 pl-0">
                    <p class="text-danger">${error}</p>
                </div>
            </div>
        </fieldset>
    </form>
</div>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
</body>
</html>

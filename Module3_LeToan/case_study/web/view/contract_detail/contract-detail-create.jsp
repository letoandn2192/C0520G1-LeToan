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
    <title>Contract Detail</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <form method="post" action="/contract_detail">
            <fieldset>
                <legend class="text-center">Create New Contract Detail</legend>
                <div class="form-group form-inline">
                    <label for="contractId" class="col-2 d-flex justify-content-start">Contract Id</label>
                    <input type="text" readonly class="col-8 form-control" id="contractId" name="contractId" value="${contract.contractId}">
                </div>
                <div class="form-group form-inline">
                    <label for="attachService" class="col-2 d-flex justify-content-start">Attach Service</label>
                    <select class="col-8 form-control" id="attachService" name="attachService">
                        <option value="1">Massage</option>
                        <option value="2">Karaoke</option>
                        <option value="3">Food</option>
                        <option value="4">Drink</option>
                        <option value="5">Car</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="quantity" class="col-2 d-flex justify-content-start">Quantity</label>
                    <input type="text" class="col-8 form-control" id="quantity" name="quantity">
                </div>

                <div class="form-group form-inline">
                    <div class="col-2"></div>
                    <div class="col-8 pl-0">
                        <input type="hidden" name="action" value="create">
                        <input type="submit" value="Create" class="btn btn-outline-dark mr-2">
                        <a class="btn btn-outline-dark" href="/contract?action=view&id=${contract.contractId}">Back</a>
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
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 4000);
</script>
</body>
</html>

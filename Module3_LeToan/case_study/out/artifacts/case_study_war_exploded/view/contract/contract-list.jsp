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
</head>
<body>
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body row position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/contract?action=create" role="button" class="btn btn-outline-dark float-left mr-2">Create New Contract</a>
            <a href="/contract?action=manager" role="button" class="btn btn-outline-dark float-left">Manager</a>
            <h2>List of Contract</h2>
        </div>
        <table class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Start Date</th>
                <th scope="col">End Date</th>
                <th scope="col">Deposit</th>
                <th scope="col">Total Money</th>
                <th scope="col">Detail</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contractList}">
                <tr>
                    <td scope="row">${contract.contractId}</td>
                    <td>${contract.contractStartDate}</td>
                    <td>${contract.contractEndDate}</td>
                    <td>${contract.contractDeposit}</td>
                    <td>${contract.contractTotalMoney}</td>
                    <td>
                        <a href="/contract?action=view&id=${contract.contractId}" class="btn-outline-dark btn">Detail <span class="fas fa-info mr-3"></span></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <c:if test='${action != "search"}'>
            <div class="col-12 d-flex justify-content-center">
                <ul class="pagination pagination">
                        <%--                <li class="page-item"><a class="page-link" href="#">Previous</a></li>--%>
                    <c:if test="${totalPage > 1}">
                        <c:forEach var="i" begin="1" end="${totalPage}">
                            <li class="page-item"><a class="page-link" href="/contract?page=${i}&search=${search}">${i}</a></li>
                        </c:forEach>
                    </c:if>
                        <%--                <li class="page-item"><a class="page-link" href="#">Next</a></li>--%>
                </ul>
            </div>
        </c:if>
        <c:if test='${action == "search"}'>
            <div class="col-12 d-flex justify-content-center">
                <a class="btn btn-outline-dark" href="/contract">Back</a>
            </div>
        </c:if>
        <c:if test="${messageInform != null}">
            <div class="alert alert-success col-4 d-flex justify-content-center" role="alert">
                    ${messageInform}
            </div>
        </c:if>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
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

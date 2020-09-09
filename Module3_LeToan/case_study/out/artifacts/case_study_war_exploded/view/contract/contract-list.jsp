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
<%--    <link href="../../bootstrap413/css/bootstrap.min.css" type="text/css" rel="stylesheet">--%>
    <link href="../../datatables/css/dataTables.bootstrap4.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp"%>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/contract?action=create" role="button" class="btn btn-outline-dark float-left mr-2">Create New Contract</a>
            <a href="/contract?action=manager" role="button" class="btn btn-outline-dark float-left">Manager</a>
            <h2>List of Contract</h2>
        </div>
        <table id="tableStudent" class="table table-sm table-bordered table-hover">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Start Date</th>
                <th scope="col">End Date</th>
                <th scope="col">Deposit</th>
                <th scope="col">Total Money</th>
                <th scope="col">Detail</th>
                <th scope="col">Clear</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="contract" items="${contractList}">
                <tr id="${contract.contractId}">
                    <td scope="row">${contract.contractId}</td>
                    <td>${contract.contractStartDate}</td>
                    <td>${contract.contractEndDate}</td>
                    <td>${contract.contractDeposit}</td>
                    <td>${contract.contractTotalMoney}</td>
                    <td>
                        <a href="/contract?action=view&id=${contract.contractId}">Detail <span class="fas fa-info mr-3"></span></a>
                    </td>
                    <td>
                        <button id="clear1" type="button" class="btn btn-outline-dark" data-toggle="modal"
                                data-target="#exampleModal" value="${contract.contractId}" onclick="passId(this.value)">
                            Clear
                        </button>
                    </td>
                </tr>
            </c:forEach>
<%--            <tr class="border-0">--%>
<%--                <td></td>--%>
<%--                <td></td>--%>
<%--                <td></td>--%>
<%--                <td></td>--%>
<%--                <td>--%>
<%--                    <c:set var="total" value="${0}"/>--%>
<%--                    <c:forEach var="test" items="${contractList}">--%>
<%--                        <c:set var="total" value="${total + test.contractTotalMoney}"/>--%>
<%--                    </c:forEach>--%>
<%--                    ${total}--%>
<%--                </td>--%>
<%--                <td></td>--%>
<%--            </tr>--%>
            </tbody>
        </table>
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
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Warning</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Do you want to clear this contract ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <input type="hidden" id="rowDelete"/>
                <button type="button" class="btn btn-outline-dark" data-dismiss="modal"
                        onclick="clearRowDelete()">Clear
                </button>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp"%>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.js"></script>
<script>
    window.setTimeout(function() {
        $(".alert").fadeTo(500, 0).slideUp(500, function(){
            $(this).remove();
        });
    }, 2000);

    $(document).ready(function () {
        $("#tableStudent").dataTable({
            "dom": "lrtip",
            "lengthChange": false,
            "pageLength": 10
        })
    });
    function passId(id) {
        document.getElementById("rowDelete").value = id;
    }

    function clearRowDelete() {
        let valueRowDelete = document.getElementById("rowDelete").value;
        document.getElementById(valueRowDelete).style.display = "none";
    }
</script>
</body>
</html>

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
    <title>Complex</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
    <link href="../../datatables/css/dataTables.bootstrap4.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/complex?action=create" role="button" class="btn btn-outline-dark float-left">Create New
                Complex</a>
            <h2>List of Product</h2>
        </div>
            <table id="tableStudent" class="table table-sm table-bordered table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Status</th>
                    <th scope="col">Area</th>
                    <th scope="col">Floor</th>
                    <th scope="col">Type</th>
                    <th scope="col">Cost</th>
                    <th scope="col">Date Start</th>
                    <th scope="col">Date End</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="complex" items="${complexList}">
                    <tr>
                        <td scope="row">${complex.complexCode}</td>
                        <td>${complex.complexStatus}</td>
                        <td>${complex.complexArea}</td>
                        <td>${complex.complexFloor}</td>
                        <td>${complex.complexType}</td>
                        <td>${complex.complexCost}</td>
                        <td>${complex.complexStartDate}</td>
                        <td>${complex.complexEndDate}</td>
                        <td>
                            <a href="/complex?action=delete&id=${complex.complexCode}">Delete<span class="fas fa-eraser mr-3"></span></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        <c:if test="${messageInform != null}">
            <div class="alert alert-success col-4 d-flex justify-content-center" role="alert">
                    ${messageInform}
            </div>
        </c:if>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
<script src="../../bootstrap_4/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/js/bootstrap.min.js"></script>
<script src="../../datatables/js/jquery.dataTables.min.js"></script>
<script src="../../datatables/js/dataTables.bootstrap4.js"></script>
<script>
    window.setTimeout(function () {
        $(".alert").fadeTo(500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 2000);

    $(document).ready(function () {
        $("#tableStudent").dataTable({
            "dom": "lrtip",
            "lengthChange": false,
            "pageLength": 5
        })
    });
</script>
</body>
</html>

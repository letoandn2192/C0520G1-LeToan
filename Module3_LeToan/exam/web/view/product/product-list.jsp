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
    <title>Product</title>
    <link type="text/css" rel="stylesheet" href="../../bootstrap_4/css/bootstrap.min.css">
    <link href="../../bootstrap_4/font/css/all.css" type="text/css" rel="stylesheet">
    <link href="../../datatables/css/dataTables.bootstrap4.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@ include file="../../header.jsp" %>
<div class="container-fluid">
    <div class="body position-relative" style="top: 160px">
        <div class="text-center col-12">
            <a href="/product?action=create" role="button" class="btn btn-outline-dark float-left">Create New
                Product</a>
            <h2>List of Product</h2>
        </div>
            <table id="tableStudent" class="table table-sm table-bordered table-hover">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Color</th>
                    <th scope="col">Description</th>
                    <th scope="col">Category</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${productList}">
                    <tr>
                        <td scope="row">
                            <div id="${product.productId}Id1">
                                    ${product.productId}
                            </div>
                            <div id="${product.productId}Id2" style="display: none">
                                <input type="text" readonly class="form-control" name="id"
                                       value="${product.productId}">
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Name1">
                                    ${product.productName}
                            </div>
                            <div id="${product.productId}Name2" style="display: none">
                                <input type="text" class="form-control" name="name${product.productId}"
                                       value="${product.productName}"/>
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Price1">
                                    ${product.productPrice}
                            </div>
                            <div id="${product.productId}Price2" style="display: none">
                                <input type="text" class="form-control" name="price${product.productId}"
                                       value="${product.productPrice}">
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Amount1">
                                    ${product.productAmount}
                            </div>
                            <div id="${product.productId}Amount2" style="display: none">
                                <input type="text" class="form-control" name="amount${product.productId}"
                                       value="${product.productAmount}">
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Color1">
                                    ${product.productColor}
                            </div>
                            <div id="${product.productId}Color2" style="display: none">
                                <input type="text" class="form-control" name="color${product.productId}"
                                       value="${product.productColor}">
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Des1">
                                    ${product.productDescription}
                            </div>
                            <div id="${product.productId}Des2" style="display: none">
                                <input type="text" class="form-control" name="description${product.productId}"
                                       value="${product.productDescription}">
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Cate1">
                                <c:forEach var="category" items="${categoryList}">
                                    <c:if test="${product.productCategoryId == category.categoryId}">
                                        ${category.categoryName}
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div id="${product.productId}Cate2" style="display: none">
                                <select name="categoryId${product.productId}" class="form-control">
                                    <c:forEach var="category" items="${categoryList}">
                                        <c:if test="${product.productCategoryId == category.categoryId}">
                                            <option value="${category.categoryId}">${category.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                    <c:forEach var="category" items="${categoryList}">
                                        <c:if test="${product.productCategoryId != category.categoryId}">
                                            <option value="${category.categoryId}">${category.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </td>

                        <td>
                            <div id="${product.productId}Action1">
                                <input type="button" class="btn btn-outline-dark" id="${product.productId}" value="Edit"
                                       onclick="editProduct(this.id)">
                                <a href="/product?action=delete&id=${product.productId}" class="btn btn-outline-dark">Delete
                                    <span
                                            class="fas fa-eraser"></span></a>
                            </div>
                            <div id="${product.productId}Action2" style="display: none">
                                <input type="button" class="btn btn-outline-dark" value="Save" id="${product.productId}"
                                       onclick="editRest(this.id)">
                                <input type="button" class="btn btn-outline-dark" id="${product.productId}" value="Back"
                                       onclick="editSkip(this.id)">
                            </div>
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

    function editProduct(id) {
        document.getElementById(id + "Id1").style.display = "none";
        document.getElementById(id + "Name1").style.display = "none";
        document.getElementById(id + "Price1").style.display = "none";
        document.getElementById(id + "Amount1").style.display = "none";
        document.getElementById(id + "Color1").style.display = "none";
        document.getElementById(id + "Des1").style.display = "none";
        document.getElementById(id + "Cate1").style.display = "none";
        document.getElementById(id + "Action1").style.display = "none";

        document.getElementById(id + "Id2").style.display = "block";
        document.getElementById(id + "Name2").style.display = "block";
        document.getElementById(id + "Price2").style.display = "block";
        document.getElementById(id + "Amount2").style.display = "block";
        document.getElementById(id + "Color2").style.display = "block";
        document.getElementById(id + "Des2").style.display = "block";
        document.getElementById(id + "Cate2").style.display = "block";
        document.getElementById(id + "Action2").style.display = "block";
    }

    function editSkip(id) {
        document.getElementById(id + "Id1").style.display = "block";
        document.getElementById(id + "Name1").style.display = "block";
        document.getElementById(id + "Price1").style.display = "block";
        document.getElementById(id + "Amount1").style.display = "block";
        document.getElementById(id + "Color1").style.display = "block";
        document.getElementById(id + "Des1").style.display = "block";
        document.getElementById(id + "Cate1").style.display = "block";
        document.getElementById(id + "Action1").style.display = "block";

        document.getElementById(id + "Id2").style.display = "none";
        document.getElementById(id + "Name2").style.display = "none";
        document.getElementById(id + "Price2").style.display = "none";
        document.getElementById(id + "Amount2").style.display = "none";
        document.getElementById(id + "Color2").style.display = "none";
        document.getElementById(id + "Des2").style.display = "none";
        document.getElementById(id + "Cate2").style.display = "none";
        document.getElementById(id + "Action2").style.display = "none";
    }

    function editRest(id) {
        document.getElementById("mainForm").action = "/product?action=edit&id=" + id;
        document.getElementById("mainForm").submit();
    }
</script>
</body>
</html>

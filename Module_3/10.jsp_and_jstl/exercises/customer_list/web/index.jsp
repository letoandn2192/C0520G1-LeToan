<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/27/2020
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <style>
        table, th, tr, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        tr:hover {
            background-color: lightgray;
        }

        #header {
            background-color: lightblue;
        }

        .avatar {
            text-align: center;
        }

        caption {
            font-size: 20px;
            font-weight: bold;
        }
    </style>
</head>
<body>

<c:set var="customer_name" scope="page" value="Mai Văn Hoàn"/>
<c:set var="customer_date" scope="page" value="20-08-1983"/>
<c:set var="customer_address" scope="page" value="Hà Nội"/>
<c:set var="customer_image" scope="page" value="avatar1.png"/>

<table>
    <caption>List of Customer</caption>
    <tr id="header">
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th class="avatar">Avatar</th>
    </tr>

    <c:forEach var="temp" items="${employeeList}">
        <tr>
            <td>${temp.name}</td>
            <td>${temp.dateOfBirth}</td>
            <td>${temp.address}</td>
            <td class="avatar"><img src='<c:out value="${temp.image}"/>' alt="avatar" width="30" height="30"></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
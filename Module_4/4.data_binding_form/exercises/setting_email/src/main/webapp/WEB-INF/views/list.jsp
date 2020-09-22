<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/21/2020
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Setting Email</title>
</head>
<body>
<h1>Setting Email</h1>
    <table>
        <tr>
            <td><label >Languages: </label></td>
            <td>${setting.language}</td>
        </tr>
        <tr>
            <td><label >Page size: </label></td>
            <td>${setting.pageSize}</td>
        </tr>
        <tr>
            <td><label >Spam filter: </label></td>
            <td>
                <c:if test="${setting.filter == true}">
                    Enable
                </c:if>
                <c:if test="${setting.filter != true}">
                    Disable
                </c:if>
            </td>
        </tr>
        <tr>
            <td><label >Signature: </label></td>
            <td>${setting.signature}</td>
        </tr>
        <tr>
            <td colspan="2"><a href="/editForm" type="button">Change</a></td>
        </tr>
    </table>
</body>
</html>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/21/2020
  Time: 9:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border:1px solid #ccc;padding:5px;">
    <a href="${pageContext.request.contextPath}/uploadOneFile">Upload One File</a>&nbsp;|&nbsp;
    <a href="${pageContext.request.contextPath}/uploadMultiFile">Upload Multi File</a>
</div>
</body>
</html>

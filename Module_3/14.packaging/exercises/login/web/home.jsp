<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/8/2020
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Home</h1>
Welcome : <%= session.getAttribute("username")%>
<a href="LogoutController?logout=ok">logout</a>
</body>
</html>

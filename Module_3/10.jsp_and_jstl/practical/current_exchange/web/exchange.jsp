<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/27/2020
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exchange</title>
</head>
<body>
<h2>Current Exchange</h2>
    <%
        float rate = Float.parseFloat(request.getParameter("rate"));
        float usd = Float.parseFloat(request.getParameter("usd"));
        float vnd = usd * rate;
    %>
    <p>Rate: <%= rate %></p>
    <p>USD: <%= usd %></p>
    <p>VND: <%= vnd %></p>

</body>
</html>

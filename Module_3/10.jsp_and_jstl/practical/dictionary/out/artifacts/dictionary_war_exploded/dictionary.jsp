<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/27/2020
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Temp</title>
</head>
<body>
    <%!
        Map<String, String> dictionary = new TreeMap<>();
        String search, result;
    %>
    <%
        dictionary.put("hello", "xin chao");
        dictionary.put("house", "ngoi nha");
        dictionary.put("beautiful", "xinh dep");
        dictionary.put("dictionary", "tu dien");
        dictionary.put("laptop", "may tinh ca nha");
        search = request.getParameter("search").toLowerCase();
        result = dictionary.get(search);
        if (result == null) {
            result = "Not Found !!!";
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    %>
</body>
</html>

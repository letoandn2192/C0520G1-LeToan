<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/25/2020
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <form method="post" action="discount">
        <label for="description">Product Description</label>
        <input id="description" placeholder="Description">
        <label for="price">List Price</label>
        <input id="price" placeholder="price" name="price">
        <label for="discount">Discount Percent</label>
        <input id="discount" placeholder="Description" name="discount">
        <input type="submit" value="Calculate">
    </form>
    <h2>c:out example</h2>
    <c:out value="${'This is true: 10 > 1 '}" />
    <br/>
    Tag: <c:out value="${'<atag> , &'}"/>
</body>
</html>
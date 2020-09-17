<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/16/2020
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>exchange.Exchange Money</title>
</head>
<body>
<form:form method="post" id="form" modelAttribute="exchange">
    <fieldset>
        <legend>EXCHANGE MONEY</legend>
        <table>
            <tr>
                <td><form:label path="usd">USD</form:label></td>
                <td><form:input path="usd"/></td>
            </tr>
            <tr>
                <td><form:label path="rate">Rate</form:label></td>
                <td><form:input path="rate"/></td>
            </tr>
            <tr>
                <td><label for="vnd">VND</label></td>
                <td><p id="vnd">${vnd}</p></td>
            </tr>
            <tr>
                <td colspan="2"><input type="button" value="Submit 2" onclick="submitType2()"></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
<script>
    function submitType2() {
        document.getElementById("form").action = "/exchange2";
        document.getElementById("form").submit();
    }
</script>
</html>

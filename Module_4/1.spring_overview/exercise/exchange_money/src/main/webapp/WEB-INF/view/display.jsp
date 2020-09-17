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
<form id="form">
    <fieldset>
        <legend>EXCHANGE MONEY</legend>
        <table>
            <tr>
                <td><label for="usd">USD</label></td>
                <td><input  type="text" name="usd" id="usd"/></td>
            </tr>
            <tr>
                <td><label for="rate">Rate</label></td>
                <td><input type="text" name="rate" id="rate"/></td>
            </tr>
            <tr>
                <td><label for="vnd">VND</label></td>
                <td><p id="vnd">${vnd}</p></td>
            </tr>
            <tr>
                <td><input type="button" value="Submit 1" onclick="submitType1()"></td>
                <td><input type="button" value="Submit 2" onclick="submitType2()"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
<script>
    function submitType1() {
        document.getElementById("form").action = "/exchange1";
        document.getElementById("form").method = "post";
        document.getElementById("form").submit();
    }
    function submitType2() {
        document.getElementById("form").action = "/exchange2";
        document.getElementById("form").method = "get";
        document.getElementById("form").submit();
    }
</script>
</html>

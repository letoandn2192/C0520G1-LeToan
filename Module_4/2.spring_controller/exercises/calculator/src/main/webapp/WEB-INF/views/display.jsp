<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/18/2020
  Time: 7:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
    <form method="post" id="form" action="/calculator">
        <fieldset>
            <legend>Calculator</legend>
            <table>
                <tr>
                    <td><label for="firstOperand">First Operand</label></td>
                    <td><input type="text" id="firstOperand" name="firstOperand" required></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label for="secondOperand">Second Operand</label></td>
                    <td><input type="text" id="secondOperand" name="secondOperand" required></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td><label>Operator</label></td>
                    <td colspan="4">
                        <button name="operator" value="+" onclick="calculator()">Addition (+)</button>
                        <button name="operator" value="-" onclick="calculator()">Subtraction (-)</button>
                        <button name="operator" value="*" onclick="calculator()">Multiplication (*)</button>
                        <button name="operator" value="/" onclick="calculator()">Division (/)</button>
                    </td>
                </tr>
                <tr>
                    <td><label for="result">Result</label></td>
                    <td colspan="4"><p id="result">${result}</p></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
<script>
    function calculator() {
        document.getElementById("form").submit();
    }
</script>
</html>

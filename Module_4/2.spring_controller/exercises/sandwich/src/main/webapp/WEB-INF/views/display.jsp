<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/18/2020
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display</title>
</head>
<body>
<form method="post" action="/save">
    <fieldset>
        <legend>Make Your Sandwich</legend>
        <table>
            <tr>
                <td><label>Spice</label></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" name="spice" value="Lettuce">
                    <label>Lettuce</label>
                </td>
                <td>
                    <input type="checkbox" name="spice" value="Tomato">
                    <label>Tomato</label>
                </td>
                <td>
                    <input type="checkbox" name="spice" value="Mustard">
                    <label>Mustard</label>
                </td>
                <td>
                    <input type="checkbox" name="spice" value="Sprouts">
                    <label>Sprouts</label>
                </td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="Save"></td>
            </tr>
            <tr>
                <td><label for="result">Result</label></td>
                <td colspan="3"><p id="result">Sandwich with ${result}</p></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

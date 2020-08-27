<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/27/2020
  Time: 8:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
  <form action="calculate" method="get">
      <h2>Simple Calculator</h2>
      <fieldset>
        <legend>Calculator</legend>
          <table>
              <tr>
                  <td>First Operand:</td>
                  <td><input type="text" id="first_operand" name="first_operand"></td>
              </tr>
              <tr>
                  <td>Operator:</td>
                  <td><select name="operator">
                      <option>Add</option>
                      <option>Subtract</option>
                      <option>Divide</option>
                      <option>Multiple</option>
                  </select></td>
              </tr>
              <tr>
                  <td>Second Operand:</td>
                  <td><input type="text" id="second_operand" name="second_operand"></td>
              </tr>
              <tr>
                  <td></td>
                  <td><input type="submit" value="Calculation"></td>
              </tr>
              <tr>
                  <td>Result: </td>
                  <td>${result}</td>
              </tr>
          </table>
      </fieldset>
  </form>
</body>
</html>

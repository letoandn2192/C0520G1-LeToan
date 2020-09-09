<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/8/2020
  Time: 8:59 PM
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
<%
  Cookie[] listCookie = request.getCookies();
  String user = "";
  String pass = "";
  int co = 0;
  if(listCookie != null){
    while(co < listCookie.length){
      if(listCookie[co].getName().equals("user")){
        user = listCookie[co].getValue();
      }
      if(listCookie[co].getName().equals("pass")){
        pass = listCookie[co].getValue();
      }
      co++;
    }

  }
%>
${error}
<h1>Login</h1>
<form action="LoginController" method="POST">
  <table>
    <tr>
      <td>Username</td>
      <td><input type="text" name="txtUsername" value="<%out.print(user);%>"/></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password" name="txtPassword" value="<%out.print(pass);%>" />      </td>
    </tr>
    <tr>
      <td> <input type="checkbox" name="chkRemember" value="ON" />Remember to me</td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="Login" /></td>
    </tr>
  </table>
</form>
</body>
</html>
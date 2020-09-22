<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/21/2020
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Setting</title>
</head>
<body>
<form:form modelAttribute="setting" action="/edit" method="post">
    <fieldset>
        <legend>Setting Change</legend>
        <table>
            <tr>
                <td><form:label path="language">Language</form:label></td>
                <td>
                    <form:select path="language" items="${languageList}"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page size</form:label></td>
                <td>
                    <form:select path="pageSize" items="${pageSizeList}"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="filter">Spam filter</form:label></td>
                <td>
                    <form:checkbox path="filter"/>Enable
                </td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature</form:label></td>
                <td>
                    <form:textarea path="signature" cols="30" rows="5"/>
                </td>
            </tr>
            <tr>
                <td><button type="submit">Update</button></td>
                <td><a href="/">Cancel</a></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>

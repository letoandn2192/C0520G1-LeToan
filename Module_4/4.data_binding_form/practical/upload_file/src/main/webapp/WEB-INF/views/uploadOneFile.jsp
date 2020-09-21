<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Upload One File</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h3>Upload One File:</h3>
<!-- MyUploadForm -->
<form:form modelAttribute="myUploadForm" method="POST" action="/uploadOneFile" enctype="multipart/form-data">
    Description:
    <br>
    <form:input path="description" style="width:300px;"/>
    <br/><br/>
<%--    <form:label path="fileDatas"/>File to upload:--%>
<%--    <form:input path="fileDatas"/><br />--%>
    File to upload: <input name="file" type="file"/><br />
    <input type="submit" value="Upload">
</form:form>
</body>
</html>
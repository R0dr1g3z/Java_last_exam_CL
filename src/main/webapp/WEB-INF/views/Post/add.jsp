<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Add post</title>
</head>
<link rel="stylesheet" href="../theme/css/style.css">
<body>
<form:form method="post" modelAttribute="post">
<label>Title:</label>
<form:input path="title"/>
<form:errors path="title" cssClass="error"/><br>
<label>Content:</label>
<form:input path="content"/><br>
<label>Tags:</label>
<form:select path="tags" items="${tags}" itemLabel="name" multiple="true"/><br>
<form:button>Create post</form:button>
</form:form>
</body>
</html>
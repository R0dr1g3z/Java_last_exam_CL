<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Add tag</title>
</head>
<link rel="stylesheet" href="../theme/css/style.css">
<body>
<form:form method="post" modelAttribute="tag">
<label>Name:</label>
<form:input path="name"/>
<form:errors path="name" cssClass="error"/><br>
<form:button>Create tag</form:button>
</form:form>
</body>
</html>
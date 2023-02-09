<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tags</title>
</head>
<link rel="stylesheet" href="../theme/css/style.css">
<body>
<table>
    <tr>
        <th>Name:</th>
        <th>Active:</th>
        <th>Action:</th>
    </tr>
    <c:forEach items="${tags}" var="tag">
        <tr>
            <td>${tag.name}</td>
            <td>${tag.active}</td>
            <td><a href="/tag/${tag.id}/change">Active/Disable,</a>
            <a href="/tag/${tag.id}/posts">Show posts</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
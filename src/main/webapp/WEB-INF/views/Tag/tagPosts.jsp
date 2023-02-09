<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tag posts</title>
</head>
<body>
<c:forEach items="${posts}" var="post">
    ${post.title} <br>
    ${post.content} <br>
</c:forEach>
</body>
</html>
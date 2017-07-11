<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate Users</title>
</head>
<body>
    <spring:form modelAttribute="userFromServer" method="post" action="/user-system/users/check/">
        <spring:input path="name"/>
        <spring:input path="password"/>
        <spring:button>Check Users</spring:button>
    </spring:form>
</body>
</html>

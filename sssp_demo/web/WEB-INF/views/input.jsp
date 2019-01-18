<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: wangbo
  Date: 2019-01-18
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form action="${pageContext}/input" method="post">
        lastname:<form:input path="lastName"/>
        <br>
        email:<form:input path="email"/>
        <br>
        birth:<form:input path="birth"/>
        <br>
        department:
        <form:select path="department.id" items="${departments}" itemLabel="departmentname" itemValue="id"/>
        <br>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>

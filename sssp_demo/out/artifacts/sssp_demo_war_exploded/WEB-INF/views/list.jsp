<%--
  Created by IntelliJ IDEA.
  User: wangbo
  Date: 2019-01-17
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${employees == null || employees.numberOfElements == 0}">
        û�м�¼
    </c:if>
    <c:if test="${employees != null && employees.numberOfElements > 0}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>id</th>
                <th>birth</th>
                <th>create_time</th>
                <th>email</th>
                <th>lastName</th>
                <th>department_id</th>
                <th>�༭</th>
                <th>ɾ��</th>
            </tr>
            <c:forEach items="${employees.content}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td><fmt:formatDate value="${item.birth}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                    <td>${item.email}</td>
                    <td>${item.lastName}</td>
                    <td>${item.department.departmentname}</td>
                    <td><a href="">�༭</a></td>
                    <td><a href="">ɾ��</a></td>
                </tr>


            </c:forEach>

            <tr>
                <td colspan="8">
                    ��${employees.totalElements}����¼
                    ��${employees.totalPages}ҳ
                    ��ǰ${employees.number + 1}ҳ
                    <c:if test="${employees.hasNextPage()}">
                        <a href="list?pageNo=${employees.number + 1 + 1}">��һҳ</a>
                    </c:if>
                    <c:if test="${employees.hasPreviousPage()}">
                        <a href="list?pageNo=${employees.number - 1 + 1}">��һҳ</a>
                    </c:if>

                </td>
            </tr>
        </table>
    </c:if>

</body>
</html>

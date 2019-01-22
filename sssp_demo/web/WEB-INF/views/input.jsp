<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#lastName").change(function () {

                var lastname = $("oldName").val();
                lastname = $.trim(lastname);
                var val = $(this).val();
                val = $.trim(val);
                $(this).val(val);
                var url = "${pageContext.request.contextPath}/emps/checkLastName";
                var arg = {"lastName":val,"date":new Date()};
                if (val == lastname){
                    alert("该姓名可用");
                }else {
                    $.post(url, arg, function (date) {
                        if (date == "1") {
                            alert("该姓名不可用");
                        } else if (date == "0") {
                            alert("该姓名可用");
                        } else {
                            alert("网络异常");
                        }
                    });
                }
            });
        })
    </script>
</head>
<body>

    <c:set value="${pageContext.request.contextPath}/emps/add" var="url"></c:set>
    <c:if test="${employee.id != null}">

        <c:set value="${pageContext.request.contextPath}/emps/add/${employee.id}" var="url"></c:set>
    </c:if>

    <form:form action="${url}" method="post" modelAttribute="employee">
        lastname:<form:input path="lastName" id="lastName"/>
        <c:if test="${employee.id != null}">
            <input type="hidden" name="oldName" value="${employee.lastName}">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT">
        </c:if>

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

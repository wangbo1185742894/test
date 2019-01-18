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
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#lastName").change(function () {
                var val = $(this).val();
                val = $.trim(val);
                $(this).val(val);
                var url = "${pageContext.request.contextPath}/emps/checkLastName";
                var arg = {"lastName":val,"date":new Date()};
                $.post(url,arg,function (date) {
                    if (date == "1"){
                        alert("该姓名不可用");
                    } else if(date == "0"){
                        alert("该姓名可用");
                    }else{
                        alert("网络异常");
                    }
                });
            });
        })
    </script>
</head>
<body>

    <form:form action="${pageContext.request.contextPath}/emps/add" method="post" modelAttribute="employee">
        lastname:<form:input path="lastName" id="lastName"/>
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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>主页面</title>
</head>
<body>
<h1>用户列表</h1>
<table>
    <tr>
        <a href="${pageContext.request.contextPath}/user/add.html" class="add" name="test" title="新增"><button class="btn btn-primary">新增</button></a>
    </tr>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>sex</td>
        <td>hobby</td>
        <td>操作</td>
    </tr>
    <%--var是循环体内的变量  items是谁被循环 varstatus是专门做编号的--%>
    <c:forEach var="b" items="${requestScope.userList}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${b.username}</td>
            <td>${b.password}</td>
            <td>${b.sex}</td>
            <td>${b.hobby}</td>
            <td>
                <button class="btn btn-warning"><a href="${pageContext.request.contextPath}" >修改</a></button>
                <button class="btn btn-danger"><a href="/del?id=${b.id}" >删除</a></button>
            </td>
        </tr>
    </c:forEach>
</table>

    <div>
        <c:if test="${pageNum>1}">
            <button><a href="/list?pageNum=1">首页</a></button>
        </c:if>
        <c:if test="${1<pageNum&&pageNum<=totalPage}">
            <button><a href="/list?pageNum=${pageNum-1}">上一页</a></button>
        </c:if>
        <c:if test="${pageNum<totalPage}">
            <button><a href="/list?pageNum=${pageNum+1}">下一页</a></button>
            <button><a href="/list?pageNum=${totalPage}">末页</a></button>
        </c:if>
        当前页：${pageNum}/${totalPage}
    </div>
</body>
</html>

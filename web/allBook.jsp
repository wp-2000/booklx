<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/8/6
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="border: solid 1px red">
    <tr>
        <td>图书编号</td>
        <td>图书姓名</td>
        <td>图书价格</td>
        <td>图书标题</td>
        <td>图书内容</td>
        <td>图书类型</td>
        <td>内容</td>
        <td>编辑</td>
    </tr>
   <c:forEach items="${infos}" var="b">
        <tr>
            <td>${b.bookId}</td>
            <td>${b.bookName}</td>
            <td>${b.price}</td>
            <td>${b.title}</td>
            <td>${b.bookNote}</td>
            <td>${b.typeId}</td>
            <td>${b.typeName}</td>
            <td><a href="book.do?service=del&bookId=${b.bookId}">删除</a>
                <a href="addBook.jsp">添加</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

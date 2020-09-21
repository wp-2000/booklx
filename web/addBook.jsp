<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/8/7
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
        <form action="book.do?service=add" method="post">
        编号:<input type="text" name="bookId" value="${book.bookId}"><br>
        姓名:<input type="text" name="bookName" value="${book.bookName}"><br>
        价格:<input type="text" name="price" value="${book.price}"><br>
        标题:<input type="text" name="title" value="${book.title}"><br>
        内容:<input type="text" name="bookNote" value="${book.bookNote}"><br>
        类型:<input type="text" name="typeId" value="1"><br>
        <input type="submit" value="保存"/><br>
        </form>
</body>
</html>

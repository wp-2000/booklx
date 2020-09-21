<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/8/6
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>显示所有书籍</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript">
      $(function(){
        findAllBook();
      })
      function findAllBook(){
        // 使用ajax 发送异步请求
        $.ajax({
          type: "POST", // 请求的类型
          url: "book.do", // 请求的URL
          //data: "com.hd.service=allEmp", // 请求的参数
          data:{
            "service":"allBook"
          },
          dataType:"json",
          success: function(msg) { // 请求成功后会执行该方法
            // alert( "员工信息， 姓名：" + msg[0].empName + " 性别：" + msg[0].sex);
            // 给showData 表格添加行数据
            var str = "";
            for (var i = 0; i < msg.length; i++) {
              str += "<tr class='showRow'><td>" + msg[i].bookId + "</td><td>" + msg[i].bookName + "</td><td>" + msg[i].price + "</td><td>" + msg[i].title + "</td><td>" + msg[i].bookNote + "</td><td>" + msg[i].typeNote + "</td>>
            }
            $(".showRow").remove(); // 使用异步操作DOM节点时，先删除原先增加的数据，在进行重新添加
            $("#showData").append(str);

          }
        });
      }
      function del(bookId){
        $.ajax({
          type: "POST", // 请求的类型
          url: "book.do", // 请求的URL
          data:{
            "service":"del",
            "bookId" : bookId
          },
          // dataType:"json", 后台返回的数据是json ，你就要写类型json
          success: function(msg){
            // 全查询数据
            findAllBook();
          }
        });
      }
    </script>
  </head>
  <body>
  <a href="allBook.html">图书全查询</a>
  </body>
</html>

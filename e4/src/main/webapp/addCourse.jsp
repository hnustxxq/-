<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023/4/14
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加课程</title>
</head>
<body>
<h3>添加课程</h3>
<form action="/test/AddServlet" method="post">
    课程名称：<input name="name"><br>
    课时数：<input name="hours"><br>
    学院：<input name="sid"><br>

    <input type="submit" value="提交">
</form>
</body>
</html>

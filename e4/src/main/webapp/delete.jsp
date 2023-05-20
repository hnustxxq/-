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
  <title>删除课程</title>
  <script type="text/javascript">
    function test() {
      var result = confirm("Please make sure.");
      if (result == true) {
        location.href("/test/DeleteServlet?id=${course.id}");
      } else {
        location.href("/test/SelectAllServlet");
      }
    }
  </script>
</head>
<body>
<input type="button" value="是否删除" onClick="test();" />
</body>
</html>

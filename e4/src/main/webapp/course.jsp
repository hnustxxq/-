<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/course.css" rel="stylesheet">
</head>
<body>

<h1>用户，${user.email}</h1>

<input type="button" value="新增" id="add"><br>
<input type="button" value="退出" id="exit"><br>

<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>课程名称</th>
        <th>课时数</th>
        <th>学院</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${courses}" var="course" varStatus="status">
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${course.name}</td>
            <td>${course.hours}</td>
            <td>${course.sid}</td>

            <td><a href="/test/SelectByIdServlet?id=${course.id}" >修改</a> <div><a href="#">删除</a></div></td>
        </tr>

    </c:forEach>




</table>

<script>
    document.getElementById("add").onclick =function (){
        location.href="/test/addCourse.jsp";
    }

    document.getElementById("exit").onclick =function (){
        location.href="/test/login.jsp";
    }

    //删除之前弹窗
    window.onload = function(){
        var allA = document.getElementsByTagName("div");
        for(var i=0 ; i < allA.length ; i++){
            allA[i].onclick = function(){
                var tr = this.parentNode.parentNode;
                //var name = tr.getElementsByTagName("td")[0].innerHTML;
                var name = tr.children[1].innerHTML;
                var flag = confirm("确认删除"+name+"吗?");
                if(flag){
                    tr.parentNode.removeChild(tr);
                    location.href="/test/DeleteServlet?name="+name;
                }
                return false;
            };
        }
    };



</script>


</body>
</html>
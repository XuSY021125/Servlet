<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="http://localhost:1125/ServletDemo/loginServlet" method="post">
        用户名：<input type="text" name="username" value="${sessionScope.username}"><br>
        密码：<input type="password" name="password" ><br>
        <input type="submit" value="登录">
    </form>
    <form action="http://localhost:1125/ServletDemo/register.jsp" method="post">
        <input type="submit" value="注册">
    </form>
    <form action="http://localhost:1125/ServletDemo/deleteuser.jsp" method="post">
        <input type="submit" value="删除用户">
    </form>
</body>
</html>

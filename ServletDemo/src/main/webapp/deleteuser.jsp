<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除用户</title>
</head>
<body>
    <form action="http://localhost:1125/ServletDemo/deleteUserServlet" method="post">
    用户名：<input type="text" name="username" ><br>
    密码：<input type="password" name="password" ><br>
    <input type="submit" value="确认删除">
</form>
</body>
</html>

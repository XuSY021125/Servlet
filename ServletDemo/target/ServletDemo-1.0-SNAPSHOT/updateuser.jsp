
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
    <form action="http://localhost:1125/ServletDemo/updateUserServlet" method="post">
        旧用户名：<input type="text" name="oldUsername"><br>
        新用户名：<input type="text" name="newUsername"><br>
        新密码：<input type="password" name="newPassword"><br>
        <input type="submit" value="确认修改">
    </form>
</body>
</html>

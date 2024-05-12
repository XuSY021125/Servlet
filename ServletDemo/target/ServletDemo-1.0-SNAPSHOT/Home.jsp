
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
    <h1><%= "登录成功" %></h1>


    <form action="http://localhost:1125/ServletDemo/updateuser.jsp" method="post">
        <input type="submit" value="修改信息">
    </form>

    <form action="http://localhost:1125/ServletDemo/queryUserServlet" method="post">
        <input type="submit" value="查询所有用户">
    </form>

    <form action="http://localhost:1125/ServletDemo/login.jsp" method="post">
        <input type="submit" value="退出登录">
    </form>
</body>
</html>

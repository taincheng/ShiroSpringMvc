<%--
  Created by IntelliJ IDEA.
  User: Old_man
  Date: 2019/8/13
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>login page</h1>

<form action="/shiro/login" method="post">
    username :  <input type="text" name="username"/><br><br>
    password :  <input type="password" name="password"/><br><br>
    <input type="submit" value="submit"/>
</form>
</body>
</html>

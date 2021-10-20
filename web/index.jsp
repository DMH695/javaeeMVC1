<%--
  Created by IntelliJ IDEA.
  User: 23139
  Date: 2021/10/12
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录</title>

  </head>
  <body>
  <form method="post" action="LoginServlet">
    <div>
    <input type="text" name="userName" placeholder="用户名">
    </div>
    <div>
    <input type="test" name="passWord" placeholder="密码">
    </div>
    <input type="submit" value="登录">
  </form>
  </body>
</html>

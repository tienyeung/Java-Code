<%@ page import="cn.web.checkcode.User" %><%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2020/4/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登陆成功</title>

  </head>
  <body>
    <h1>欢迎您，
      <%
        User user=null;
        user = (User) request.getSession().getAttribute("user");
        String name = user.getUsername();

      %>
      <%= user==null?"": name%>

    </h1>
  </body>
</html>

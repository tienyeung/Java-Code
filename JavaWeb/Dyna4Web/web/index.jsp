<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2020/4/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>用户表单验证</title>
    <script>
      window.onload=function () {
        var img = document.getElementById('img');
        img.onclick=function () {
          //加时间戳，防止浏览器缓存造成的因更换验证码图片访问servlet失败
          let date = new Date().getTime();
          this.src="/checkCodeServlet?"+date;
        }
        document.getElementById("a").onclick=function () {
          let date = new Date().getTime();
          img.src="/checkCodeServlet?"+date;
        }
      }
    </script>
    <style>
      div{
        color:red;
      }
    </style>
  </head>
  <body>
  <form action="/LoginServlet" method="post">
    <table>
      <tr>
        <td>用户名</td>
        <td><input type="text" name="username"></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input type="password" name="password"></td>
      </tr>
      <tr>
        <td>验证码</td>
        <td><input type="text" name="checkCode"></td>
      </tr>
      <tr>
        <td><img src="/checkCodeServlet" id="img"></td>
        <td><a href="javascript:void(0)" id="a">看不清？换一张</a></td>
      </tr>
      <tr>
        <td colspan="2"><input type="submit" value="login"></td>
      </tr>
    </table>

  </form>
  <div><%=request.getSession().getAttribute("cc_error")==null?"":request.getSession().getAttribute("cc_error")%></div>
  <div><%=request.getSession().getAttribute("login_error")==null?"":request.getSession().getAttribute("cc_error")%></div>
  </body>
</html>

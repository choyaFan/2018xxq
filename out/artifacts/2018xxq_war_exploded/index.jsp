<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/25
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>web demo</title>
  </head>

  <body>
  <div style="text-align: center">
    <h1>Welcome to my web</h1>
    <hr/>
    现在这是一个二手交易平台了<br/>
    <br/>

    <tr>
      <td colspan="2">
        <input class="button" type="button" onclick="goRegister()" value="注册">
        <input class="button" type="button" onclick="goLogin()" value="登录">
      </td>
    </tr>
  </div>
  </body>

<script language="JavaScript">
  function goLogin() {
      window.location = "JSP/login.jsp";
  }

  function goRegister() {
      window.location = "JSP/register.jsp"
  }
</script>
</html>

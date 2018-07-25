<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/25
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<html>
<head>
    <base href="<%=basePath%>">
    <title>My 'register.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<h1>注     册</h1>
<hr>
<form action="RegisterServlet" method="post">
    <table class="centertable">
        <tr>
            <td class="td1">用户名</td>
            <td class="td2"><input class="text1" type="text" name="Username"/></td>
        </tr>
        <tr>
            <td class="td1">密码</td>
            <td class="td2"><input class="text1" type="password" name="Password"/></td>
        </tr>
        <tr>
            <td class="td1">确认密码</td>
            <td class="td2"><input class="text1" type="password" name="confirmPassword"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="button" type="submit" value="注册" onchange="checkpwd()"/>
                <input class="button" type="button" value="返回" onclick="history.back()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

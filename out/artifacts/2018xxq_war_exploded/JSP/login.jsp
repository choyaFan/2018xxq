<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/25
  Time: 14:26
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
    <meta name="viewport" content="width=device-width initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:600italic,400,300,600,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<%=basePath+"css/loginStyle.css"%>"/>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<%--<h1>登      录</h1>--%>
<%--<hr>--%>
<%--<form action="LoginServlet" method="post">--%>
    <%--<table class="centertable">--%>
        <%--<tr>--%>
            <%--<td class="td1">用户名</td>--%>
            <%--<td class="td2"><input class="text1" type="text" name="Username"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td class="td1">密码</td>--%>
            <%--<td class="td2"><input class="text1" type="password" name="Password"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td colspan="2">--%>
                <%--<input class="button" type="submit" value="登录" onchange="checkpwd()"/>--%>
                <%--<input class="button" type="button" value="返回" onclick="history.back();"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>

<div class="login-form">
    <div class="head">
        <img src="../image/mem2.jpg" alt=""/>
    </div>
    <form action="LoginServlet" method="post">
        <ul>
            <li>
                <input type="text" class="text" name="Username" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" /><a href="#" class=" icon user"></a>
            </li>
            <li>
                <input type="password" name="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}"/><a href="#" class=" icon lock"></a>
            </li>
        </ul>
        <div class="p-container">
            <%--<label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>Remember Me</label>--%>
            <input type="submit" value="SIGN IN" >
            <input type="button" value="SIGN UP" >
            <div class="clear"> </div>
        </div>
    </form>
</div>


</body>
</html>

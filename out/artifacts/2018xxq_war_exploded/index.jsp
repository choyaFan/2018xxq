<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/25
  Time: 10:55
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
    <meta name="viewport" content="width=device-width initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath+"css/style.css"%>"/>
    <style>h1{margin: 0;}</style>
</head>

<body>
<div id="index" style="text-align: center">
    <h1>四川大学二手交易平台</h1>
        <tr>
            <td colspan="2">
                <input class="button" type="button" onclick="goRegister()" value="注册">
                <input class="button" type="button" onclick="goLogin()" value="登录">
            </td>
        </tr>
</div>
</body>

<script src="js/jquery-3.2.1.js"></script>
<%--<script src="js/ios-parallax.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--$(document).ready(function() {--%>
<%--$('#index').iosParallax({--%>
<%--movementFactor: 600--%>
<%--});--%>
<%--});--%>
<%--</script>--%>

<script language="JavaScript">
    function goLogin() {
        window.location = "JSP/login.jsp";
    }

    function goRegister() {
        window.location = "JSP/register.jsp"
    }
</script>
</html>

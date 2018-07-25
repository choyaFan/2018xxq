<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/25
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String username = (String)session.getAttribute("Username");
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>main page</title>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<div>
    <table width="60%" align="center">
        <tr>
            <td align="left">欢迎您的光临，<%=username%><br></td>
        </tr>
    </table>
</div>
</body>
</html>

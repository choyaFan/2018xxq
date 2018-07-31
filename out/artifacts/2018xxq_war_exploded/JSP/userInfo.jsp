<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.UserEntity" %>
<%@ page import="org.apache.tomcat.jni.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/27
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    UserEntity user = (UserEntity) session.getAttribute("USER");
    int id = user.getId();
    int doManage;
    if(request.getParameter("doManage") != null) {
        doManage = Integer.parseInt(request.getParameter("doManage"));
        session.setAttribute("doManage", doManage);
    }
    else doManage = 0;

    int flag1 = 0, flag2 = 0;
    if(session.getAttribute("userFind") != null){
        UserEntity userFind = (UserEntity)session.getAttribute("userFind");
        request.setAttribute("userNAME", userFind.getName());
        request.setAttribute("userEMAIL", userFind.getEmail());
        request.setAttribute("userPHONE", userFind.getPhone());
        request.setAttribute("userID", userFind.getId());
        flag1 = 1;
    }
%>

<html>
<head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width initial-scale=1">
    <link rel="stylesheet" href="<%=basePath+"css/userInfoStyle.css"%>"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<body>
<div id="header">
    <div class="overlay">
        <div class="container">
            <div class="row">
                <div class="col-md-4 logo-div">
                    <div class="logo-inner text-center">
                        <div class="logo-name">
                            <a href="">
                                <img src="../image/me.jpg" class="img-circle" />
                            </a>
                        </div>

                    </div>

                </div>
                <div class="col-md-8 header-text-top " id="about">

                    <h1>The user info page</h1>
                    Some info here<br />
                    <h2><strong>Who I am ? </strong></h2>
                    <i>I am Fcy </i>

                </div>
            </div>
        </div>
    </div>
</div>
<!--END HEADER SECTION-->

<div class="container">
    <div class="row">
        <div class="col-md-8 ">
            <c:choose>
                <c:when test="<%=id > 5%>">
                    <div class="blog-post">
                        <h2>对不起</h2>
                        <p>
                            您不是管理员，无法查看对应信息
                        </p>
                        <a href="#" class="btn btn-default btn-lg ">Read More <i class="fa fa-angle-right"></i></a>
                    </div>
                </c:when>
                <c:otherwise>
                            <nav>
                                <ul class="pagination">
                                    <li>
                                        <a href="../JSP/userInfo.jsp?doManage=1">管理用户</a>
                                    </li>
                                    <li>
                                        <a href="../JSP/userInfo.jsp?doManage=2">管理商品</a>
                                    </li>
                                </ul>
                            </nav>
                </c:otherwise>
            </c:choose>
            <c:if test="<%=doManage == 1%>">
                <div class="input-grout">
                    <form action="DoManageServlet" method="post">
                        <input type="text" class="form-control" placeholder="请输入用户名" name="userNameToBan">
                        <button type="submit" class="btn btn-default">查询</button>
                    </form>
                </div>
            </c:if>


            <c:if test="<%=flag1 == 1%>">
                <div class="blog-post">
                    <h2><%=request.getAttribute("userNAME")%></h2>
                    <h4>Email: <%=request.getAttribute("userEMAIL")%></h4>
                    <p>
                        联系方式： <%=request.getAttribute("userPHONE")%>
                    </p>
                    <a href="BanUserServlet?banID=<%=request.getAttribute("userID")%>" class="btn btn-default btn-lg ">封禁<i class="fa fa-angle-right"></i></a>
                </div>
            </c:if>
            <br />
        </div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item"><strong>CATEGORIES</strong></li>
                    <li class="list-group-item">
                        <a href="ShoppingCartServlet?currPage=1">我的购物车</a>
                    </li>
                    <li class="list-group-item">已买到的宝贝</li>
                    <li class="list-group-item">我的收藏</li>
                    <li class="list-group-item">我的信息</li>
                    <li class="list-group-item">发布商品</li>
                </ul>
            </div>
            <div class="row">
                <h3>Advertising</h3>
                <br/>
                <h4>性感静侃</h4>
                <h4>现招女友</h4>
                <br/>
                <br/>
                <br/>
            </div>
        </div>

    </div>


</div>
<!--END HOME PAGE SECTION-->
<div class="footer-sec" style="margin-top: 0px;">
    <div class="container">
        <div class="row">
            <div class="col-md-12 foo-inner">
                &copy; 2018 SiChuan University
            </div>
        </div>
    </div>
</div>
<!-- END FOOTER SECTION -->
</body>
</html>

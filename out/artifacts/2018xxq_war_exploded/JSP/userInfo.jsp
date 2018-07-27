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
            <div class="blog-post">
                <h2>某先进的超电磁炮</h2>
                <h4>购买于 <a href="#">fcy</a> 2018.1.24 </h4>
                <p>
                    这是某个贼nb的炮火攻击系统
                </p>
                <a href="#" class="btn btn-default btn-lg ">更多 <i class="fa fa-angle-right"></i></a>
            </div>
            <div class="blog-post">
                <h2>某先进的超电磁炮</h2>
                <h4>购买于 <a href="#">admin</a> 2018.1.24 </h4>
                <p>
                    这是某个贼nb的炮火攻击系统
                </p>
                <a href="#" class="btn btn-default btn-lg ">Read More <i class="fa fa-angle-right"></i></a>
            </div>
            <div class="blog-post">
                <h2>某先进的超电磁炮</h2>
                <h4>购买于 <a href="#">admin</a> 2018.1.24 </h4>
                <p>
                    这是某个贼nb的炮火攻击系统
                </p>
                <a href="#" class="btn btn-default btn-lg ">Read More <i class="fa fa-angle-right"></i></a>
            </div>

            <br />
            <nav>
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-3" style="padding-top: 30px;">
            <div class="row">
                <ul class="list-group">
                    <li class="list-group-item"><strong>CATEGORIES</strong></li>
                    <li class="list-group-item">我的购物车</li>
                    <li class="list-group-item">已买到的宝贝</li>
                    <li class="list-group-item">我的收藏</li>
                    <li class="list-group-item">我的信息</li>
                </ul>
            </div>
            <div class="row">
                <h3>Advertising</h3>


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

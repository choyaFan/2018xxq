<%@ page import="entity.GoodsEntity" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: 63583
  Date: 2018/7/29
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    int flag2 = 1, flag3 = 1;

    int countPage = (int)session.getAttribute("countPage");
    int currPage = (int)session.getAttribute("currPage");
    int pageF = (3 * (currPage - 1)) + 1;

    GoodsEntity goods1 = (GoodsEntity) session.getAttribute("goodsEntity" + Integer.toString(pageF));
    String Name1 = goods1.getName();
    String content1 = goods1.getContent();
    String  time1 = goods1.getCreateDate().toString();
    int id1 = goods1.getId();
    if(session.getAttribute("goodsEntity" + Integer.toString(pageF + 1)) != null){
        GoodsEntity goods2 = (GoodsEntity)session.getAttribute("goodsEntity" + Integer.toString(pageF + 1));
        request.setAttribute("name2", goods2.getName());
        request.setAttribute("content2", goods2.getContent());
        request.setAttribute("time2", goods2.getCreateDate().toString());
        request.setAttribute("id2", goods2.getId());
    }
    else flag2 = 0;
    if(session.getAttribute("goodsEntity" + Integer.toString(pageF + 2)) != null){
        GoodsEntity goods3 = (GoodsEntity)session.getAttribute("goodsEntity" + Integer.toString(pageF + 2));
        request.setAttribute("name3", goods3.getName());
        request.setAttribute("content3", goods3.getContent());
        request.setAttribute("time3", goods3.getCreateDate().toString());
        request.setAttribute("id3", goods3.getId());
    }
    else flag3 = 0;

%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width initial-scale=1">
    <link rel="stylesheet" href="<%=basePath+"css/userInfoStyle.css"%>"/>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--<link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>--%>
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
                <h2><%=Name1%></h2>
                <h4>发布于<%=time1%> </h4>
                <p>
                    <%=content1%>
                </p>
                <a href="#" class="btn btn-default btn-lg ">更多 <i class="fa fa-angle-right"></i></a>
            </div>
            <c:if test="<%=flag2 == 1%>">
                <div class="blog-post">
                    <h2><%=request.getAttribute("name2")%></h2>
                    <h4>购买于<%=request.getAttribute("time2")%> </h4>
                    <p>
                        <%=request.getAttribute("content2")%>
                    </p>
                    <a href="#" class="btn btn-default btn-lg ">更多<i class="fa fa-angle-right"></i></a>
                </div>
            </c:if>
            <c:if test="<%=flag3 == 1%>">
                <div class="blog-post">
                    <h2><%=request.getAttribute("name3")%></h2>
                    <h4>购买于<%=request.getAttribute("time3")%></h4>
                    <p>
                        <%=request.getAttribute("content3")%>
                    </p>
                    <a href="#" class="btn btn-default btn-lg ">更多<i class="fa fa-angle-right"></i></a>
                </div>
            </c:if>
            <br />

            <nav>
                <ul class="pagination">
                    <li>
                        <c:set var="prePage" value="<%=currPage - 1%>"/>
                        <c:if test="<%=currPage == 1%>">
                            <c:set var="prePage" value="1"/>
                        </c:if>
                        <a href="ShoppingCartServlet?currPage=${prePage}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <c:choose>
                        <c:when test="<%=countPage <= 5%>">
                            <c:set var="begin" value="1"/>
                            <c:set var="end" value="<%=countPage%>"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="<%=currPage - 3%>"/>
                            <c:set var="end" value="<%=currPage + 2%>"/>
                        </c:otherwise>
                    </c:choose>
                            <%--<c:if test="${end} > <%=countPage%>">--%>
                                <%--<c:set var="begin" value="<%=currPage - 3%>"/>--%>
                                <%--<c:set var="end" value="<%=countPage%>"/>--%>
                            <%--</c:if>--%>
                            <%--<c:if test="${begin < 1}">--%>
                                <%--<c:set var="begin" value="1"/>--%>
                                <%--<c:set var="end" value="<%=countPage%>"/>--%>
                            <%--</c:if>--%>
                    <c:forEach var="i" begin="${begin}" end="${end}">
                        <li><a href="ShoppingCartServlet?currPage=${i}">${i}</a> </li>
                    </c:forEach>
                    <li>
                        <c:set var="nextPage" value="<%=currPage + 1%>"/>
                        <c:if test="<%=currPage == countPage%>">
                            <c:set var="nextPage" value="<%=currPage%>"/>
                        </c:if>
                        <a href="ShoppingCartServlet?currPage=${nextPage}" aria-label="Next">
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
                    <li class="list-group-item">
                        <a href="ShoppingCartServlet?currPage=1">我的购物车</a>
                    </li>
                    <li class="list-group-item">已买到的宝贝</li>
                    <li class="list-group-item">我的收藏</li>
                    <li class="list-group-item">我的信息</li>
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

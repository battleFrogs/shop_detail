<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/10/21
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index/index.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap-table.min.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>

</head>


<body>

    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">管理页面</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li id="index">首页</li>
                    <li id="front" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            前台 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:frontGoods()">商品</a></li>
                            <li><a href="javascript:frontTrade()">订单</a></li>
                        </ul>
                    </li>
                    <li id="behind" class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            后台 <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:behind()">商品</a></li>
                            <li><a href="javascript:behind()">订单</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>



<script type="text/javascript">

    function frontGoods() {
        window.location.href = "${pageContext.request.contextPath}/goods/goodsInfo";
    }

    function frontTrade() {
        window.location.href = "${pageContext.request.contextPath}/trade/tradeInfo";
    }


    function behind() {
        alert("后台");
    }

    $(function () {
        $("#index").addClass("active");
    });


</script>
</body>
</html>

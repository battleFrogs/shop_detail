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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/toastr.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/toastr.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-datetimepicker.min.js"></script>

</head>


<body>

<%--顶部导航栏--%>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">管理页面</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
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
                        <li><a href="javascript:behindGoods()">商品</a></li>
                        <li><a href="javascript:behindTrade()">订单</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<script type="text/javascript">

    // 前台上商品页面跳转
    function frontGoods() {
        window.location.href = "${pageContext.request.contextPath}/goods/goodsInfo";
    }

    // 前台订单页面跳转
    function frontTrade() {
        window.location.href = "${pageContext.request.contextPath}/trade/tradeInfo";
    }

    // 后台商品页面跳转
    function behindGoods() {
        window.location.href = "${pageContext.request.contextPath}/goods/goodsManage";
    }

    // 后台订单页面跳转
    function behindTrade() {
        window.location.href = "${pageContext.request.contextPath}/goods/tradeManage";
    }


    $(function () {

        // 初始化 toast 提示框
        toastr.options = {
            "closeButton": false, //是否显示关闭按钮
            "debug": false, //是否使用debug模式
            "positionClass": "toast-top-center",//弹出窗的位置
            "showDuration": "300",//显示的动画时间
            "hideDuration": "1000",//消失的动画时间
            "timeOut": "5000", //展现时间
            "extendedTimeOut": "1000",//加长展示时间
            "showEasing": "swing",//显示时的动画缓冲方式
            "hideEasing": "linear",//消失时的动画缓冲方式
            "showMethod": "fadeIn",//显示时的动画方式
            "hideMethod": "fadeOut" //消失时的动画方式
        };

    });


</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/10/27
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index/login.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>

<div class="center-in-center"></div>

<div id="frame">


    <div id="inner-frame">
        <h1 style="text-align: center">管理系统</h1>
        <div id="account-from" class="form-group">
            <lable for="account">账号 :</lable>
            <input type="text" id="account" class="form-control"
                   placeholder="请输入账号">
        </div>
        <div class="form-group ">
            <lable for="password">密码 :</lable>
            <input type="password" id="password" class="form-control"
                   placeholder="请输入密码">
        </div>
        <div style="text-align: center">
            <button type="button" class="btn btn-primary" id="loginIn">登录</button>
        </div>
    </div>


</div>

<script>
    $(function () {
        // 登录请求
        $("#loginIn").click(function () {
            const account = $("#account").val();
            const password = $("#password").val();
            if (!account || !password) {
                alert("输入不能为空");
                return;
            }
            $.get("${pageContext.request.contextPath}/index/loginIn",
                {account: account, password: password},
                function (data) {
                    if (data) {
                        if (data.code === 0) {
                            window.location.href = "${pageContext.request.contextPath}/page/goods/goodsInfo";
                            return;
                        }
                        alert(data.msg);
                    }
                });
        });

    })
    ;


</script>

</body>
</html>

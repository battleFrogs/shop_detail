<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/10/27
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>

<div style="margin: 20px;">
    <label>
        账号：<input type="text" id="account" placeholder="请输入账号">
    </label>
    <label>
        密码：<input type="password" id="password" placeholder="请输入密码">
    </label>
    <button type="button" id="loginIn">登录</button>

</div>


<script>
    $(function () {
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
                            window.location.href = "${pageContext.request.contextPath}/index/index";
                            return;
                        }
                        alert(data.msg);
                    }
                });
        });

    });


</script>

</body>
</html>

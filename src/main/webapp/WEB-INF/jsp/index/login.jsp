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
</head>
<body>

<div style="margin: 20px;">
        用户名：<label>
                 <input type="text">
               </label>
        密码： <label>
                 <input type="text">
              </label>
    <button type="button" id="button1" >登录</button>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js">


    $(function() {
        $("#button1").click(function () {

            <%--$.get("${pageContext.request.contextPath}/index/login",function(data,status){--%>
            <%--    alert("Data: " + data + "\nStatus: " + status);--%>
            <%--});--%>
            alert("dsfdsf")
        });

    });


</script>

</body>
</html>

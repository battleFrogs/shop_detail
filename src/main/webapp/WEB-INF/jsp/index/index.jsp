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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hello.css">
</head>


<body>

<div>

    <button type="button" onclick="front()">前台</button>
    <button type="button" onclick="behind()">后台</button>

</div>


<script type="text/javascript">

    function front() {
        alert("前台");
    }

    function behind() {
        alert("后台");
    }


</script>
</body>
</html>

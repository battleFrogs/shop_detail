<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/10/28
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Goods</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>

<table border="1">

    <tr>
        <th width="100px">商品Id</th>
        <th width="100px">商品名称</th>
        <th width="100px">商品价格</th>
        <th width="100px">操作</th>
    </tr>

    <c:if test="${requestScope.goodsList!=null}">
        <c:forEach var="goods" items="${requestScope.goodsList}">
            <tr>
                <td align="center">${goods.goodsId}</td>
                <td align="center">${goods.goodsName}</td>
                <td align="center">${goods.goodsPrice}</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/goodsDetail/goodsDetail?goodsId=${goods.goodsId}">编辑</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>


</table>

<script>

</script>
</body>
</html>

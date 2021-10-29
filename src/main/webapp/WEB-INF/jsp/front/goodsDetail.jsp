<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/10/29
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>goodsDetail</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>
<body>

<div style="margin: 20px">商品id： <span>${requestScope.goods.goodsId}</span></div>
<div style="margin: 20px">商品名称： <span>${requestScope.goods.goodsName}</span></div>
<div style="margin: 20px">商品价格： <span>${requestScope.goods.goodsPrice}</span></div>
<div style="margin: 20px">商品描述： <span>${requestScope.goods.goodsDescription}</span></div>
<div style="margin: 20px">
    <button type="button" id="buyAndPay">购买并支付</button>
    <span style="margin-right: 20px"></span>
    <button type="button">只下单</button>
</div>

<script>

    $(function () {

        $("#buyAndPay").click(function () {



        });

    });

</script>
</body>
</html>

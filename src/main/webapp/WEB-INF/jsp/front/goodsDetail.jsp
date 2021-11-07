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
<jsp:include page="../index/index.jsp"/>

<div style="margin: 20px">商品id： <span id="goodsId">${requestScope.goods.goodsId}</span></div>
<div style="margin: 20px">商品名称： <span>${requestScope.goods.goodsName}</span></div>
<div style="margin: 20px">商品价格： <span>${requestScope.goods.goodsPrice}</span></div>
<div style="margin: 20px">商品描述： <span>${requestScope.goods.goodsDescription}</span></div>
<div style="margin: 20px">
    <label for="goodsNum">下单件数：</label><input type="number" id="goodsNum" value="1"/>
    <button type="button" id="buyAndPay">购买并支付</button>
    <span style="margin-right: 20px"></span>
    <button type="button" id="buyAndNoPay">只下单</button>
</div>

<script>

    $(function () {

        $("#buyAndPay").click(function () {

            let goodsId = $("#goodsId").text();
            let goodsNum = $("#goodsNum").val();
            $.get("${pageContext.request.contextPath}/trade/createTradePay",
                {goodsId: goodsId, num: goodsNum}, function (data) {
                    if (data) {
                        if (data.code === 0) {
                            alert("购买成功");
                            window.location.href = "${pageContext.request.contextPath}/index/index";
                            return;
                        }
                        alert(data.msg);
                    }
                });

        });

        $("#buyAndNoPay").click(function () {

            let goodsId = $("#goodsId").text();
            let goodsNum = $("#goodsNum").val();
            $.get("${pageContext.request.contextPath}/trade/createTradeNoPay",
                {goodsId: goodsId, num: goodsNum},function (data) {
                    if (data) {
                        if (data.code === 0) {
                            alert("购买成功");
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

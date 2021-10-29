<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/10/29
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>trade</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>


<div style="margin-bottom: 20px">
    <label for="sex">性别:</label>
    <select id="sex" style="width: 150px">
        <option value="ALL" selected>所有状态</option>
        <option value="WAIT_PAY">待付款</option>
        <option value="WAIT_SEND">待发货</option>
        <option value="WAIT_RECEIVE">待收货</option>
    </select>

    <button type="button" id="selectTrade">查询</button>
</div>

<table border="1">
    <tr>
        <th width="100px">订单编号</th>
        <th width="100px">订单商品名称</th>
        <th width="100px">订单价钱</th>
        <th width="100px">订单状态</th>
    </tr>

    <c:if test="${requestScope.tradeList!=null}">

        <c:forEach items="${requestScope.tradeList}" var="trade">

            <tr>
                <td align="center">${trade.tradeNo}</td>
                <td align="center">${trade.goodsName}</td>
                <td align="center">${trade.total}</td>
                <td align="center">${trade.tradeStatus}</td>
            </tr>

        </c:forEach>


    </c:if>


</table>

<script>

    $(function () {
        $("#selectTrade").click(function () {



        });
    });


</script>

</body>
</html>

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
<jsp:include page="../index/index.jsp"/>


<div style="margin: 50px">


    <ol class="breadcrumb">
        <li>前台</li>
        <li>订单</li>
    </ol>

    <form class="form-inline">
        <label for="tradeStatus">订单类型:</label>
        <select id="tradeStatus" class="form-control" style="width: 150px">
            <option value="ALL" selected>所有状态</option>
            <option value="WAIT_PAY">待付款</option>
            <option value="WAIT_SEND">待发货</option>
            <option value="WAIT_RECEIVE">待收货</option>
        </select>
        <button type="button" class="btn btn-primary" id="selectTrade">查询</button>
    </form>


    <table id="tradeTbale" class="table table-bordered table-hover">
        <tr>
            <th class="text-center">订单编号</th>
            <th class="text-center">订单商品名称</th>
            <th class="text-center">订单价钱</th>
            <th class="text-center">订单状态</th>
            <th class="text-center">订单操作</th>
        </tr>

        <c:if test="${requestScope.tradeList!=null}">

            <c:forEach items="${requestScope.tradeList}" var="trade">

                <tr class="text-center">
                    <td style="vertical-align: middle">${trade.tradeNo}</td>
                    <td style="vertical-align: middle">${trade.goodsName}</td>
                    <td style="vertical-align: middle">${trade.total}</td>

                    <c:if test="${trade.tradeStatus == 'WAIT_PAY'}">
                        <td style="vertical-align: middle">待付款</td>
                        <td style="vertical-align: middle">
                            <button id="pay" class="btn btn-danger"
                                    onclick="tradePay('${trade.tradeNo}')">付款
                            </button>
                        </td>
                    </c:if>
                    <c:if test="${trade.tradeStatus == 'WAIT_SEND'}">
                        <td style="vertical-align: middle">待发货</td>
                        <td style="vertical-align: middle">
                            <button id="send" class="btn btn-default"
                                    onclick="tradeSend('${trade.tradeNo}')">发货
                            </button>
                        </td>
                    </c:if>
                    <c:if test="${trade.tradeStatus == 'WAIT_RECEIVE'}">
                        <td style="vertical-align: middle">待确认收货</td>
                        <td style="vertical-align: middle">
                            <button id="receive" class="btn btn-success"
                                    onclick="tradeReceive('${trade.tradeNo}')">确认收货
                            </button>
                        </td>
                    </c:if>

                </tr>
            </c:forEach>
        </c:if>

    </table>

</div>


<script>


    // 订单发货
    function tradeSend(tradeNo) {
        $.get("${pageContext.request.contextPath}/trade/tradeSend", {tradeNo: tradeNo}, function (data) {
            getTradeStatus();
        });

    }

    // 订单收货
    function tradeReceive(tradeNo) {
        $.get("${pageContext.request.contextPath}/trade/tradeReceive", {tradeNo: tradeNo}, function (data) {
            getTradeStatus();
        });
    }

    // 订单付款
    function tradePay(tradeNo) {
        $.get("${pageContext.request.contextPath}/trade/tradePay", {tradeNo: tradeNo}, function (data) {
            getTradeStatus();
        });
    }

    /**
     * 获取当前状态的订单信息
     */
    var getTradeStatus = function () {

        let tradeStatus = $("#tradeStatus").val();
        let param = {};
        $("#tradeTbale").empty();

        let htmlHead = "<tr><th class=\"text-center\">订单编号</th> " +
            "<th class=\"text-center\">订单商品名称</th>" +
            "<th class=\"text-center\">订单价钱</th>" +
            "<th class=\"text-center\">订单状态</th>" +
            "<th class=\"text-center\">订单操作</th>"
            + "</tr>";
        if (tradeStatus !== "ALL") {
            param["tradeStatus"] = tradeStatus;
        }
        $.get("${pageContext.request.contextPath}/trade/tradeInfoByStatus", param, function (data) {
            if (data) {
                if (data.code === 0) {
                    let tradeList = data.data.tradeList;
                    let htmlContent = "";
                    for (let i = 0; i < tradeList.length; i++) {
                        let x = tradeList[i];
                        let tradeNo = x.tradeNo;
                        let goodsName = x.goodsName;
                        let tradeStatus = x.tradeStatus;
                        let total = x.total;


                        let operateTrade = ""
                        let tradeStatusCn = ""
                        if (tradeStatus === "WAIT_PAY") {
                            tradeStatusCn = '待付款'
                            operateTrade = "<button id=\"pay\" class=\"btn btn-danger\" " +
                                "onclick=\"tradePay('" + tradeNo + "')\">付款" +
                                "</button>";
                        }
                        if (tradeStatus === "WAIT_SEND") {
                            tradeStatusCn = '待发货'
                            operateTrade = "<button id=\"send\" class=\"btn btn-default\" " +
                                "onclick=\"tradeSend('" + tradeNo + "')\">发货" +
                                "</button>";
                        }
                        if (tradeStatus === "WAIT_RECEIVE") {
                            tradeStatusCn = '待确认收货'
                            operateTrade = "<button id=\"receive\" class=\"btn btn-success\" " +
                                "onclick=\"tradeReceive('" + tradeNo + "')\">确认收货" +
                                "</button>";
                        }

                        htmlContent += "<tr class=\"text-center\">" +
                            "<td style=\"vertical-align: middle\">" + tradeNo + "</td>" +
                            "<td style=\"vertical-align: middle\">" + goodsName + "</td>" +
                            "<td style=\"vertical-align: middle\">" + total + "</td>" +
                            "<td style=\"vertical-align: middle\">" + tradeStatusCn + "</td>" +
                            "<td style=\"vertical-align: middle\">" +
                            operateTrade +
                            "</td>" +
                            "</tr>";


                    }
                    $("#tradeTbale").html(htmlHead + htmlContent);
                }
            }
        })


    };


    // 订单状态查询
    $(function () {
        $("#selectTrade").click(getTradeStatus);
    });


</script>

</body>
</html>

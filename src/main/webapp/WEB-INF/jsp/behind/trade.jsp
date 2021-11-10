<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/11/7
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>trade</title>
</head>
<body>
<jsp:include page="../index/header.jsp"/>


<div style="margin: 50px">
    <ol class="breadcrumb">
        <li>后台</li>
        <li>订单</li>
    </ol>

    <form class="form-inline">
        <label for="tradeStatus">订单类型:</label>
        <select id="tradeStatus" class="form-control" style="width: 150px">
            <option value="ALL" selected>所有状态</option>
            <option value="WAIT_PAY">待付款</option>
            <option value="FINISH">已完成</option>
            <option value="WAIT_RECEIVE">待收货</option>
        </select>
        <div id="pay-from" class="form-group">
            <label for="begin">支付时间 :</label>
            <input type="text" class="form-control" id="begin" placeholder="请选择开始时间">
            <input type="text" class="form-control" id="end" placeholder="请选择结束时间">
        </div>
        <button type="button" class="btn btn-primary" id="selectTrade">查询</button>
        <button type="button" class="btn btn-primary" id="clear">清空</button>
    </form>


    <table id="tradeTbale" class="table table-bordered table-hover"></table>
</div>


<script>
    // 订单发货
    function tradeSend(tradeNo) {
        $.get("${pageContext.request.contextPath}/trade/tradeSend", {tradeNo: tradeNo}, function (data) {
            checkReLogin(data);
            getTradeStatus();
        });

    }

    /**
     * 获取当前状态的订单信息
     */
    var getTradeStatus = function () {

        let tradeStatus = $("#tradeStatus").val();
        let beginTime = $("#begin").val();
        let endTime = $("#end").val();
        let param = {};
        $("#tradeTbale").empty();

        let htmlHead = "<tr><th class=\"text-center\">订单编号</th> " +
            "<th class=\"text-center\">订单商品名称</th>" +
            "<th class=\"text-center\">订单价钱</th>" +
            "<th class=\"text-center\">付款时间</th>" +
            "<th class=\"text-center\">订单状态</th>" +
            "<th class=\"text-center\">订单操作</th>"
            + "</tr>";
        if (tradeStatus !== "ALL") {
            param["tradeStatus"] = tradeStatus;
        }
        if (begin) {
            param['beginTime'] = beginTime;
        }
        if (end) {
            param['endTime'] = endTime;
        }
        $.ajax({
            url: "${pageContext.request.contextPath}/trade/tradeInfoByStatus",
            type: 'post',
            data: JSON.stringify(param),
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                checkReLogin(data);
                if (data.code === 0) {
                    let tradeList = data.data.tradeList;
                    let htmlContent = "";
                    for (let i = 0; i < tradeList.length; i++) {
                        let x = tradeList[i];
                        let tradeNo = x.tradeNo;
                        let goodsName = x.goodsName;
                        let tradeStatus = x.tradeStatus;
                        let payTime = x.payTime;
                        let total = x.total;

                        let operateTrade = ""
                        let tradeStatusCn = ""
                        if (tradeStatus === "WAIT_PAY") {
                            tradeStatusCn = '待付款'
                            operateTrade = "";
                        }
                        if (tradeStatus === "WAIT_SEND") {
                            tradeStatusCn = '待发货'
                            operateTrade = "<button id=\"send\" class=\"btn btn-default\" " +
                                "onclick=\"tradeSend('" + tradeNo + "')\">发货" +
                                "</button>";
                        }
                        if (tradeStatus === "WAIT_RECEIVE") {
                            tradeStatusCn = '待确认收货'
                            operateTrade = "";
                        }
                        if (tradeStatus === "FINISH") {
                            tradeStatusCn = '已完成'
                            operateTrade = "";
                        }

                        htmlContent += "<tr class=\"text-center\">" +
                            "<td style=\"vertical-align: middle\">" + tradeNo + "</td>" +
                            "<td style=\"vertical-align: middle\">" + goodsName + "</td>" +
                            "<td style=\"vertical-align: middle\">" + total + "</td>" +
                            "<td style=\"vertical-align: middle\">" + payTime + "</td>" +
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


    $(function () {

        getTradeStatus();

        // 时间框的设定
        $('#begin').datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            initialDate: new Date(),
            language: 'zh-CN'
        });
        $('#end').datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            initialDate: new Date(),
            language: 'zh-CN'
        });

        // 数据框的清空
        $("#clear").click(function () {
            $("#begin").val('');
            $("#end").val('');
            $("#tradeStatus  option:first").prop('selected', true);
            getTradeStatus();
        });

        // 订单状态查询
        $("#selectTrade").click(getTradeStatus);
    });

</script>

</body>
</html>

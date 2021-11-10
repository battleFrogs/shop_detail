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
</head>
<body>
<jsp:include page="../index/header.jsp"/>


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

    <div id="example" style="text-align: right">
        <ul id="pageLimit"></ul>
    </div>

</div>


<script>

    let currentPage = 1;
    let pageSize = 10;


    // 订单收货
    function tradeReceive(tradeNo) {
        $.get("${pageContext.request.contextPath}/trade/tradeReceive", {tradeNo: tradeNo}, function (data) {
            checkReLogin(data);
            getTradeStatus();
        });
    }

    // 订单付款
    function tradePay(tradeNo) {
        $.get("${pageContext.request.contextPath}/trade/tradePay", {tradeNo: tradeNo}, function (data) {
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
        param['page'] = currentPage;
        param['pageSize'] = pageSize;
        $.ajax({
            url: "${pageContext.request.contextPath}/trade/tradeInfoByStatus",
            type: 'post',
            data: JSON.stringify(param),
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                    checkReLogin(data);
                    if (data.code === 0) {
                        let tradeList = data.data.tradeList;
                        let total = data.data.total;
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
                                operateTrade = "<button id=\"pay\" class=\"btn btn-danger\" " +
                                    "onclick=\"tradePay('" + tradeNo + "')\">付款" +
                                    "</button>";
                            }
                            if (tradeStatus === "WAIT_SEND") {
                                tradeStatusCn = '待发货'
                                operateTrade = "";
                            }
                            if (tradeStatus === "WAIT_RECEIVE") {
                                tradeStatusCn = '待确认收货'
                                operateTrade = "<button id=\"receive\" class=\"btn btn-success\" " +
                                    "onclick=\"tradeReceive('" + tradeNo + "')\">确认收货" +
                                    "</button>";
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
                        setPage(currentPage, Math.ceil(total / pageSize), getTradeStatus);
                    }
                }
            })
    };


    /**
     *
     * @param pageCurrent 当前所在页
     * @param pageSum 总页数
     * @param callback 调用ajax
     */
    function setPage(pageCurrent, pageSum, callback) {


        $('#pageLimit').bootstrapPaginator({
            currentPage: pageCurrent,//当前的请求页面。
            totalPages: pageSum,//一共多少页。
            size: "normal",//应该是页眉的大小。
            bootstrapMajorVersion: 3,//bootstrap的版本要求。
            alignment: "right",
            numberOfPages: 5,//一页列出多少数据。
            itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page) {
                // 把当前点击的页码赋值给currentPage, 调用ajax,渲染页面
                currentPage = page
                callback && callback()
            }
        });

    }


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

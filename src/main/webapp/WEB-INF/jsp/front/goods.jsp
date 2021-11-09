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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front/goods.css">
</head>
<body>
<jsp:include page="../index/header.jsp"/>


<div style="margin: 50px">

    <ol class="breadcrumb">
        <li>前台</li>
        <li>商品</li>
    </ol>

    <form class="form-inline">
        <div id="goods-from" class="form-group">
            <lable for="goodsName">商品名称 :</lable>
            <input type="text" id="goodsName" class="form-control"
                   placeholder="请输入商品名称">
        </div>
        <button id="search" type="button" class="btn btn-primary">搜索</button>
        <button id="clear" type="button" class="btn btn-primary">清空</button>
    </form>

    <table id="goods-table" class="table table-bordered table-hover"></table>


    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <input type="hidden" id="goodsId-value" value="">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        标题
                    </h4>
                </div>
                <div id="body-value" class="modal-body">
                    <div style="margin: 30px">
                        <div>商品Id：<span id="goodsIdResult" style="margin: 15px"></span></div>
                        <div>商品名称：<span id="goodsNameResult" style="margin: 15px"></span></div>
                        <div>商品价格：<span id="goodsPriceResult" style="margin: 15px"></span></div>
                        <form class="form-inline">
                            购买的数目
                            <input type="number" class="form-control" id="buyNum" value="1"/>
                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="buyAndPay()">
                        购买且支付
                    </button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="buyAndNoPay()">
                        下单不支付
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

</div>

<script>


    $(function () {

        getinfo();

        $("#front").addClass("active");
        /**
         * 搜索
         */
        $("#search").click(function () {
            getinfo();

        });
        /**
         * 清空
         */
        $("#clear").click(function () {
            $("#goodsName").val("")
            getinfo();
        });


    });


    /**
     * 购买且支付
     */
    function buyAndPay() {
        let goodsId = $("#goodsIdResult").text();
        let buyNum = $("#buyNum").val();
        $.get("${pageContext.request.contextPath}/trade/createTradePay",
            {goodsId: goodsId, num: buyNum}, function (data) {
                if (data) {
                    checkReLogin(data);
                    if (data.code === 0) {
                        toastr.success("购买成功");
                        return;
                    }
                    toastr.error(data.msg);
                }
            });
        getinfo();
    }

    /**
     * 下单未支付
     */
    function buyAndNoPay() {
        let goodsId = $("#goodsIdResult").text();
        let buyNum = $("#buyNum").val();
        $.get("${pageContext.request.contextPath}/trade/createTradeNoPay",
            {goodsId: goodsId, num: buyNum}, function (data) {
                if (data) {
                    checkReLogin(data);
                    if (data.code === 0) {
                        toastr.success("购买成功");
                        return;
                    }
                    toastr.error(data.msg);
                }
            });
        getinfo();
    }

    /**
     * 选择按钮 给提示框赋值
     * @param goodsId
     * @param goodsName
     * @param goodsPrice
     */
    function choose(goodsId, goodsName, goodsPrice) {
        $("#goodsIdResult").text(goodsId);
        $("#goodsNameResult").text(goodsName);
        $("#goodsPriceResult").text(goodsPrice);
    }

    /**
     * 获取表格信息
     */
    var getinfo = function () {
        let goodsName = $("#goodsName").val();
        $("#goods-table").empty();
        let tableHeader = "<tr><th class=\"text-center\">商品Id</th> " +
            "<th class=\"text-center\">商品名称</th>" +
            "<th class=\"text-center\">商品价格</th>" +
            "<th class=\"text-center\">操作</th>" +
            +"</tr>";
        param = {goodsName: goodsName}
        $.ajax({
            url: "${pageContext.request.contextPath}/goods/goodsSearch",
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(param),
            success: function (data) {
                if (data){
                    checkReLogin(data);
                    if (data.code === 0) {
                        let goodsList = data.data.goodsList;
                        let htmlContent = "";
                        for (let i = 0; i < goodsList.length; i++) {
                            let x = goodsList[i];
                            let goodsId = x.goodsId;
                            let goodsName = x.goodsName;
                            let goodsPrice = x.goodsPrice;
                            htmlContent += "<tr class=\"text-center\">" +
                                "<td style=\"vertical-align: middle\">" + goodsId + "</td>" +
                                "<td style=\"vertical-align: middle\">" + goodsName + "</td>" +
                                "<td style=\"vertical-align: middle\">" + goodsPrice + "</td>" +
                                "<td style=\"vertical-align: middle\">" +
                                "<button id=\"choose\" data-toggle=\"modal\" data-target=\"#myModal\"" +
                                "class=\"btn btn-danger\"" +
                                "onclick=\"choose('" + goodsId + "','" + goodsName + "' , '" + goodsPrice + "')\" > 选择 </button> " +
                                "</td>" +
                                "</tr>";
                        }
                        $("#goods-table").html(tableHeader + htmlContent);
                    }
                }
            }
        });
    }

</script>
</body>
</html>

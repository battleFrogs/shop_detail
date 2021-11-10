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

    <div id="example" style="text-align: right">
        <ul id="pageLimit"></ul>
    </div>

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

<script type="text/html" id="templateResult">
    <thead>
    <tr>
        <th class="text-center">商品Id</th>
        <th class="text-center">商品名称</th>
        <th class="text-center">商品价格</th>
        <th class="text-center">操作</th>
    </tr>
    </thead>
    <tbody>
    {{each list as value i}}
    <tr class="text-center">
        <td style="vertical-align: middle">{{value.goodsId}}</td>
        <td style="vertical-align: middle">{{value.goodsName}}</td>
        <td style="vertical-align: middle">{{value.goodsPrice}}</td>
        <td style="vertical-align: middle">
            <button id="choose" data-toggle="modal" data-target="#myModal"
                    class="btn btn-danger"
                    onclick="choose('{{value.goodsId}}','{{value.goodsName}}','{{value.goodsPrice}}')"> 选择
            </button>
        </td>
    </tr>
    {{/each}}
    </tbody>

</script>

<script>

    let currentPage = 1;
    let pageSize = 10;

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
        param = {goodsName: goodsName, page: currentPage, pageSize}
        $.ajax({
            url: "${pageContext.request.contextPath}/goods/goodsSearch",
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(param),
            success: function (data) {
                if (data) {
                    checkReLogin(data);
                    if (data.code === 0) {
                        setPage(currentPage, Math.ceil(data.data.total / pageSize), getinfo);
                        $("#goods-table").html(template("templateResult", {list: data.data.goodsList}));
                    }
                }
            }
        });
    }

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


</script>
</body>
</html>

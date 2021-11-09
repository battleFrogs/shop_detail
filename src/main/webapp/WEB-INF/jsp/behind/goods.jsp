<%--
  Created by IntelliJ IDEA.
  User: Gjc
  Date: 2021/11/7
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>goods</title>
</head>
<body>
<jsp:include page="../index/header.jsp"/>


<div style="margin: 50px">
    <ol class="breadcrumb">
        <li>后台</li>
        <li>商品</li>
    </ol>

    <form class="form-inline">
        <div id="goods-from" class="form-group">
            <lable for="goodsName">商品名称 :</lable>
            <input type="text" id="goodsName" class="form-control"
                   placeholder="请输入商品名称">
        </div>

        <button id="search" type="button" class="btn btn-primary">搜索</button>
        <button id="addGoods" type="button" class="btn btn-success">添加</button>
        <button id="clear" type="button" class="btn btn-default">清空</button>
    </form>

    <table id="goods-table" class="table table-bordered table-hover">
    </table>


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
                        添加商品
                    </h4>
                </div>
                <div id="body-value" class="modal-body">
                    <div style="margin: 100px "/>
                        <div style="display: flex;justify-content: space-around">
                            商品Id：<input id="goodsIdResult" class="form-control" /></div>
                        <div style="display: flex;justify-content: space-around">
                            商品名称：<input id="goodsNameResult " class="form-control" /></div>
                        <div style="display: flex;justify-content: space-around">
                            商品价格：<input id="goodsPriceResult" class="form-control" /></div>
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

<script type="text/javascript">

    $(function () {

        getInfo();

        $("#clear").on("click", function () {
            $("#goodsName").val('');
        });

        $("#search").click(function () {
            getInfo();
        });

        $("#addGoods").click(function () {

        })



    });

    function choose(goodsId, goodsName, goodsPrice) {



    }

    /**
     * 获取表格信息
     */
    var getInfo = function () {
        let goodsName = $("#goodsName").val();
        $("#goods-table").empty();
        let tableHeader = "<tr><th class=\"text-center\">商品Id</th> " +
            "<th class=\"text-center\">商品名称</th>" +
            "<th class=\"text-center\">商品价格</th>" +
            "<th class=\"text-center\">商品数目</th>" +
            "<th class=\"text-center\">操作</th>" +
            +"</tr>";
        param = {goodsName: goodsName}
        $.ajax({
            url: "${pageContext.request.contextPath}/goods/goodsSearch",
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data: JSON.stringify(param),
            success: function (data) {
                if (data) {
                    checkReLogin(data);
                    if (data.code === 0) {
                        let goodsList = data.data.goodsList;
                        let htmlContent = "";
                        for (let i = 0; i < goodsList.length; i++) {
                            let x = goodsList[i];
                            let goodsId = x.goodsId;
                            let goodsName = x.goodsName;
                            let goodsPrice = x.goodsPrice;
                            let goodsNum = x.goodsNum;
                            htmlContent += "<tr class=\"text-center\">" +
                                "<td style=\"vertical-align: middle\">" + goodsId + "</td>" +
                                "<td style=\"vertical-align: middle\">" + goodsName + "</td>" +
                                "<td style=\"vertical-align: middle\">" + goodsPrice + "</td>" +
                                "<td style=\"vertical-align: middle\" width='200px'>" + "<input  class='form-control' type='number' value='" + goodsNum + "'></input>" + "</td>" +
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

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


    <div class="modal fade" id="myModalChoose" tabindex="-1" role="dialog" aria-labelledby="myModalChooseLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalChooseLabel">
                        修改商品
                    </h4>
                </div>
                <div class="modal-body">
                    <div>商品Id: <input id="updateGoodsId" class="form-control" disabled/></div>
                    <div>商品名称: <input id="updateGoodsName" class="form-control"/></div>
                    <div>商品价格: <input id="updateGoodsPrice" class="form-control"/></div>
                    <div>商品数目: <input id="updateGoodsNum" class="form-control"/></div>
                    <div>商品描述: <input id="updateGoodsDescription" class="form-control"/></div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-danger" id="updateGoodsConfirm">
                        确认修改
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModalAdd" tabindex="-1" role="dialog" aria-labelledby="myModalAddLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalAddLabel">
                        添加商品
                    </h4>
                </div>
                <div class="modal-body">
                    <div style="margin: 50px "/>
                    <div>
                        商品名称：<input id="goodsNameResult" class="form-control"/></div>
                    <div>
                        商品描述：<input id="goodsDescriptionResult" class="form-control"/></div>
                    <div>
                        商品价格：<input type="number" id="goodsPriceResult" class="form-control" value="100"/></div>
                    <div>
                        商品数目：<input type="number" id="goodsNumResult" class="form-control" value="1"/></div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger" id="addGoodsConfirm">
                    确认添加
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
            $("#myModalAdd").modal('show');
        });
        $("#addGoodsConfirm").click(function () {
            let goodsNameResult = $("#goodsNameResult").val();
            let goodsDescriptionResult = $("#goodsDescriptionResult").val();
            let goodsPriceResult = $("#goodsPriceResult").val();
            let goodsNumResult = $("#goodsNumResult").val();

            if (!goodsNameResult) {
                toastr.error("名称为空");
                return;
            }
            if (!goodsDescriptionResult) {
                toastr.error("描述为空");
                return;
            }
            if (!goodsPriceResult) {
                toastr.error("价格为空");
                return;
            }
            if (!goodsNumResult) {
                toastr.error("数目为空");
                return;
            }


            let param = {
                'goodsNum': parseInt(goodsNumResult),
                'goodsDescription': goodsDescriptionResult,
                'goodsPrice': parseInt(goodsPriceResult), "goodsName": goodsNameResult
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/goods/addGoods",
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(param),
                success: function (data) {
                    if (data) {
                        checkReLogin(data)
                        if (data.code === 0) {
                            getInfo();
                            $("#myModalAdd").modal('hide');
                        }
                    }
                }
            });


        });

        $("#updateGoodsConfirm").click(function () {
            let updateGoodsName = $("#updateGoodsName").val();
            let updateGoodsId = $("#updateGoodsId").val();
            let updateGoodsPrice = $("#updateGoodsPrice").val();
            let updateGoodsNum = $("#updateGoodsNum").val();
            let updateGoodsDescription = $("#updateGoodsDescription").val();

            if (!updateGoodsId) {
                toastr.error("ID为空");
                return;
            }
            if (!updateGoodsName) {
                toastr.error("名称为空");
                return;
            }
            if (!updateGoodsDescription) {
                toastr.error("描述为空");
                return;
            }
            if (!updateGoodsPrice) {
                toastr.error("价格为空");
                return;
            }
            if (!updateGoodsNum) {
                toastr.error("数目为空");
                return;
            }


            let param = {
                'goodsId':parseInt(updateGoodsId),
                'goodsNum': parseInt(updateGoodsNum),
                'goodsDescription': updateGoodsDescription,
                'goodsPrice': parseInt(updateGoodsPrice), "goodsName": updateGoodsName
            };
            $.ajax({
                url: "${pageContext.request.contextPath}/goods/updateGoods",
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(param),
                success: function (data) {
                    if (data) {
                        checkReLogin(data)
                        if (data.code === 0) {
                            getInfo();
                            $("#myModalChoose").modal('hide');
                        }
                    }
                }
            });

        });

    });

    // 删除商品
    function deleteGoods(goodsId) {
        $.get("${pageContext.request.contextPath}/goods/deleteGoods", {goodsId}, function (data) {
            if (data) {
                checkReLogin(data)
                if (data.code === 0) {
                    getInfo();
                }
            }
        });
    }

    // 修改商品
    function choose(goodsId, goodsName, goodsPrice, goodsNum, goodsDescription) {
        $("#updateGoodsName").val(goodsName);
        $("#updateGoodsId").val(goodsId);
        $("#updateGoodsPrice").val(goodsPrice);
        $("#updateGoodsNum").val(goodsNum);
        $("#updateGoodsDescription").val(goodsDescription);

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
                            let goodsDescription = x.goodsDescription;
                            htmlContent += "<tr class=\"text-center\">" +
                                "<td style=\"vertical-align: middle\">" + goodsId + "</td>" +
                                "<td style=\"vertical-align: middle\">" + goodsName + "</td>" +
                                "<td style=\"vertical-align: middle\">" + goodsPrice + "</td>" +
                                "<td style=\"vertical-align: middle\" width='200px'>" + "<input  class='form-control' type='number' value='" + goodsNum + "'></input>" + "</td>" +
                                "<td style=\"vertical-align: middle\">" +
                                "<button id=\"choose\" data-toggle=\"modal\" data-target=\"#myModalChoose\"" +
                                "class=\"btn btn-warning\"" +
                                "onclick=\"choose('" + goodsId + "','" + goodsName + "' ," +
                                " '" + goodsPrice + "','" + goodsNum + "', '" + goodsDescription + "')\" > 修改 </button> " +
                                "<button id=\"deleteGoods\"" +
                                "class=\"btn btn-danger\"" +
                                "onclick=\"deleteGoods('" + goodsId + "')\" > 删除 </button> " +
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

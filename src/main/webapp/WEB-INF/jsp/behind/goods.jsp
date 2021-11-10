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

    <div id="example" style="text-align: right">
        <ul id="pageLimit"></ul>
    </div>

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
                    <div>商品价格: <input type="number" id="updateGoodsPrice" class="form-control"/></div>
                    <div>商品数目: <input type="number" id="updateGoodsNum" class="form-control"/></div>
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


<script type="text/html" id="templateResult">
    <thead>
    <tr>
        <th class="text-center">商品Id</th>
        <th class="text-center">商品名称</th>
        <th class="text-center">商品价格</th>
        <th class="text-center">商品数目</th>
        <th class="text-center">操作</th>
    </tr>
    </thead>
    <tbody>
    {{each list as value i}}
    <tr class="text-center">
        <td style="vertical-align: middle">{{value.goodsId}}</td>
        <td style="vertical-align: middle">{{value.goodsName}}</td>
        <td style="vertical-align: middle">{{value.goodsPrice}}</td>
        <td style="vertical-align: middle ; width:200px">
            <input onfocusout="changeGoodsNum('{{value.goodsId}}')"
                   id='updateGoodsNum_{{value.goodsId}}'
                   class='form-control' type='number' value='{{value.goodsNum}}'/>
        </td>
        <td style="vertical-align: middle">
            <button id="choose" data-toggle="modal" data-target="#myModalChoose"
                    class="btn btn-warning"
                    onclick="choose('{{value.goodsId}}','{{value.goodsName}} ' ,
             '{{value.goodsPrice}}','{{value.goodsNum}}', '{{value.goodsDescription}}')"> 修改
            </button>
            <button id="deleteGoods"
                    class="btn btn-danger"
                    onclick="deleteGoods('{{value.goodsId}}')"> 删除
            </button>
        </td>
    </tr>
    {{/each}}
    </tbody>

</script>


<script type="text/javascript">

    let currentPage = 1;
    let pageSize = 10;

    $(function () {

        getInfo();

        $("#clear").on("click", function () {
            $("#goodsName").val('');
            getInfo();
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
                'goodsId': parseInt(updateGoodsId),
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

    function changeGoodsNum(goodsId) {
        let goodsNum = $("#updateGoodsNum_" + goodsId).val();
        $.ajax(
            {
                url: "${pageContext.request.contextPath}/goods/updateGoodsNum",
                data: JSON.stringify({goodsId, goodsNum: parseInt(goodsNum)}),
                type: 'post',
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    if (data) {
                        checkReLogin(data)
                        if (data.code === 0) {
                            getInfo();
                        }
                    }
                }
            });
    }

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
        param = {goodsName: goodsName, page: currentPage, pageSize};
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
                        let total = data.data.total;
                        setPage(currentPage, Math.ceil(total / pageSize), getInfo);
                        $("#goods-table").html(template("templateResult", {list: goodsList}));
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

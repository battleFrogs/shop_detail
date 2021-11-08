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
        <button id="clear" type="button" class="btn btn-primary">清空</button>
    </form>

</div>

<script type="text/javascript">

    $(function () {
        $('#begin').datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            initialDate: new Date(),
            language:'zh-CN'
        });

        $('#end').datetimepicker({
            format: 'yyyy-mm-dd hh:ii:ss',
            initialDate: new Date(),
            language:'zh-CN'
        });

        $("#clear").on("click", function () {
            alert("dsfdsf")
        });
    });
</script>
</body>
</html>

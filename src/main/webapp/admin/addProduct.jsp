<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/10/26 0026
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@include file="/shop/header.jsp" %>
<body>
<%@include file="/shop/top-bar.jsp" %>

<%@include file="/shop/menu.jsp" %>

<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">

            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1>新增产品</h1>

                <div class="content-form-page">
                    <div class="row">
                        <div class="col-md-10 col-sm-10">
                            <form action="/super-shop/admin/addPic" id="addProForm" class="form-horizontal form-without-legend"
                                  enctype="multipart/form-data" method="post">
                                <div class="form-body">
                                    <div class="alert alert-danger" style="display: none;">
                                        <button class="close" data-close="alert"></button>
                                        提交的表单还有验证错误，请检查！！！
                                    </div>
                                    <div class="alert alert-success" style="display: none;">
                                        <button class="close" data-close="alert"></button>
                                        表单验证成功！
                                    </div>
                                    <div class="form-group">
                                        <label for="proName" class="col-lg-4 control-label">产品名称<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input type="text" id="proName" name="proName" placeholder="请输入产品名称"
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="realPrice" class="col-lg-4 control-label">原价<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input name="realPrice" id="realPrice" type="text" placeholder="请输入原价"
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="nowPrice" class="col-lg-4 control-label">现价<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input name="nowPrice" id="nowPrice" type="text" placeholder="请输入现价"
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">是否有库存：</label>

                                        <div class="radio-list col-lg-6">
                                            <label class="col-lg-2 control-label">
                                                <input type="radio" name="isStock" value="1" checked>是
                                            </label>
                                            <label class="col-lg-4 control-label">
                                                <input type="radio" name="isStock" value="0"> 否
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">规格：</label>

                                        <div class="checkbox-list col-lg-6">
                                            <label>
                                                <input type="checkbox" name="proSize" value="M" checked/> M
                                                <input type="checkbox" name="proSize" value="L" checked/> L
                                                <input type="checkbox" name="proSize" value="XL" checked/> XL
                                                <input type="checkbox" name="proSize" value="XXL" checked/> XXL
                                                <input type="checkbox" name="proSize" value="XXL" checked/> XXL
                                                <input type="checkbox" name="proSize" value="XXXL" checked/> XXXL
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">颜色：</label>

                                        <div class="checkbox-list col-lg-6">
                                            <label>
                                                <input type="checkbox" name="proColor" value="red" checked/> 红
                                                <input type="checkbox" name="proColor" value="blue" checked/> 蓝
                                                <input type="checkbox" name="proColor" value="white" checked/> 白
                                                <input type="checkbox" name="proColor" value="black" checked/> 黑
                                                <input type="checkbox" name="proColor" value="yellow" checked/> 黄
                                                <input type="checkbox" name="proColor" value="green" checked/> 绿
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="proScore" class="col-lg-4 control-label">评分<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input type="text" id="proScore" name="proScore" placeholder="请输入评分"
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="aType" class="col-lg-4 control-label">所属产品类型：<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <select class="form-control" id="aType" name="typeId">
                                                <option value="0000">请选择</option>
                                            </select>
                                            <select id="bType" style="display: none" name="typeId" class="form-control">
                                            </select>
                                            <select id="cType" style="display: none" name="typeId" class="form-control">
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">图片信息：<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            1.<input type="file" name="picUri1" class="form-control"/><br/>
                                            2.<input type="file" name="picUri2" class="form-control"/><br/>
                                            3.<input type="file" name="picUri3" class="form-control"/><br/>
                                            4.<input type="file" name="picUri4" class="form-control"/><br/>
                                            5.<input type="file" name="picUri5" class="form-control"/><br/>
                                            6.<input type="file" name="picUri6" class="form-control"/><br/>
                                            7.<input type="file" name="picUri7" class="form-control"/><br/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="proDesc" class="col-lg-4 control-label">产品简述：<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <textarea name="nowPrice" id="proDesc" type="text" rows="6"
                                                      placeholder="请输入产品简述"
                                                      class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <hr/>
                                    <div class="form-group">
                                        <label class="col-lg-4 control-label">长宽高：<span
                                                class="require">*</span></label>

                                        <div class="col-lg-8">
                                            <label>
                                                <input name="detLength" type="text" placeholder="请输入长"
                                                       class="form-control"/>
                                            </label>
                                            <label>
                                                <input name="detWidth" type="text" placeholder="请输入宽"
                                                       class="form-control"/>
                                            </label>
                                            <label>
                                                <input name="detHeight" type="text" placeholder="请输入高"
                                                       class="form-control"/>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="detMate" class="col-lg-4 control-label">产品质地<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input type="text" id="detMate" name="detMate" placeholder="请输入产品质地"
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="detAddr" class="col-lg-4 control-label">产品的产地<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input type="text" id="detAddr" name="detAddr" placeholder="请输入产品的产地"
                                                   class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="d11" class="col-lg-4 control-label">生产日期<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <input class="form-control" id="d11" name="detDate" placeholder="生产日期"
                                                   type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="detDesc" class="col-lg-4 control-label">产品详细描述：<span
                                                class="require">*</span></label>

                                        <div class="col-lg-6">
                                            <textarea id="detDesc" name="detDesc" rows="6" class="form-control"
                                                      placeholder="产品详细描述"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0">
                                        <font color="red">${requestScope.message}</font>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                        <button type="submit" class="btn btn-success">登陆</button>
                                        <button type="reset" class="btn btn-info">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<%@include file="/shop/footer.jsp" %>
<script type="text/javascript" src="${path}/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="${path}/assets/plugins/jquery-validation/localization/messages_zh.js"></script>
<script type="text/javascript" src="${path}/assets/plugins/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="${path}/assets/scripts/custom/form-validation-product.js"></script>
<script type="text/javascript" charset="utf-8">

    $(function () {

        FormValidation.init();

        $.post("/super-shop/shop/menu", {}, function (data, status) {
            var jsonObj = eval('(' + data + ')');

            if (status == 'success') {
                $.each(jsonObj[0], function (index, val) {
                    $("#aType").append('<option value="' + val.id + '">' + val.menuName + '</option>');
                });
            }
        });

        $("#aType").change(function () {
            var ind = this.value;

            if (ind == '0000') {
                $("#bType").hide();
                $("#cType").hide();
                return;
            } else {
                $.post("/super-shop/shop/menu", {}, function (data, status) {
                    var jsonObj = eval('(' + data + ')');
                    if (status == 'success' && jsonObj[ind].length > 0) {
                        $("#bType").empty();
                        $("#bType").show();
                        $("#cType").hide();
                        $("#dType").hide();
                        $.each(jsonObj[ind], function (index, val) {
                            $("#bType").append('<option value="' + val.id + '">' + val.menuName + '</option>');
                        });
                    }
                });
            }
        });

        $("#bType").change(function () {
            var ind = this.value;
            $.post("/super-shop/shop/menu", {}, function (data, status) {
                var jsonObj = eval('(' + data + ')');

                if (status == 'success' && jsonObj[ind].length > 0) {
                    $("#cType").empty();
                    $("#cType").show();
                    $.each(jsonObj[ind], function (index, val) {
                        $("#cType").append('<option value="' + val.id + '">' + val.menuName + '</option>');
                    });
                } else {
                    $("#cType").hide();
                }
            });
        });
    });

</script>
</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/11/1 0001
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增产品</title>
    <script src="/super-shop/shop/assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript" src="/super-shop/shop/assets/plugins/calendar/WdatePicker.js"></script>
</head>

<script type="text/javascript" charset="utf-8">

    $(function () {
        $.post("/super-shop/shop/menu",{},function(data,status){
            var jsonObj = eval('(' + data + ')');

            if(status=='success'){
                $.each(jsonObj[0],function(index,val){
                    $("#aType").append('<option value="'+ val.id +'">'+ val.menuName +'</option>');
                });
            }
        });

        $("#aType").change(function(){
            var ind = this.value;

            if(ind=='0000') {
                $("#bType").hide();
                $("#cType").hide();
                return;
            }else{
                $.post("/super-shop/shop/menu", {}, function (data, status) {
                    var jsonObj = eval('(' + data + ')');
                    if (status == 'success'&&jsonObj[ind].length>0) {
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

        $("#bType").change(function(){
            var ind = this.value;
            $.post("/super-shop/shop/menu",{},function(data,status){
                var jsonObj = eval('(' + data + ')');

                if(status=='success' && jsonObj[ind].length>0){
                    $("#cType").empty();
                    $("#cType").show();
                    $.each(jsonObj[ind],function(index,val){
                        $("#cType").append('<option value="'+ val.id +'">'+ val.menuName +'</option>');
                    });
                }else{
                    $("#cType").hide();
                }
            });
        });
    });

</script>

<body>
<div align="center">
    <br/>
    <br/>
<form action="/super-shop/admin/addPro" name="add-product" method="post">
    <table width="60%">
        <tr>
            <td>产品名称：</td>
            <td><input type="text" name="proName" id="proName"/></td>
        </tr>

        <tr>
            <td>原价：</td>
            <td><input type="text" name="realPrice" id="realPrice"/></td>
        </tr>

        <tr>
            <td>现价：</td>
            <td><input type="text" name="nowPrice" id="nowPrice"/></td>
        </tr>
        <tr>
            <td>是否有库存：</td>
            <td>
                <input type="radio" name="isStock" value="1" checked/> 是
                <input type="radio" name="isStock" value="0"/> 否
            </td>
        </tr>
        <tr>
            <td>规格：</td>
            <td>
                <input type="checkbox" name="proSize" value="M" checked/> M
                <input type="checkbox" name="proSize" value="L" checked/> L
                <input type="checkbox" name="proSize" value="XL" checked/> XL
                <input type="checkbox" name="proSize" value="XXL" checked/> XXL
                <input type="checkbox" name="proSize" value="XXL" checked/> XXL
                <input type="checkbox" name="proSize" value="XXXL" checked/> XXXL
            </td>
        </tr>
        <tr>
            <td>颜色：</td>
            <td>
                <input type="checkbox" name="proColor" value="red" checked/> 红
                <input type="checkbox" name="proColor" value="blue" checked/> 蓝
                <input type="checkbox" name="proColor" value="white" checked/> 白
                <input type="checkbox" name="proColor" value="black" checked/> 黑
                <input type="checkbox" name="proColor" value="yellow" checked/> 黄
                <input type="checkbox" name="proColor" value="green" checked/> 绿
            </td>
        </tr>
        <tr>
            <td>评分：</td>
            <td>
                <input type="text" name="proScore" id="proScore"/>
            </td>
        </tr>

        <tr>
            <td>所属产品类型：</td>
            <td>
                <select id="aType" name="typeId">
                    <option value="0000">请选择</option>
                </select>
                <select id="bType" style="display: none" name="typeId">
                </select>
                <select id="cType" style="display: none" name="typeId">
                </select>
            </td>
        </tr>

        <tr>
            <td>图片信息：</td>
            <td>
                1.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model1.jpg" size="50"/><br/>
                2.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model2.jpg" size="50"/><br/>
                3.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model3.jpg" size="50"/><br/>
                4.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model4.jpg" size="50"/><br/>
                5.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model5.jpg" size="50"/><br/>
                6.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model6.jpg" size="50"/><br/>
                7.<input type="text" name="picUri" value="/super-shop/shop/assets/temp/products/model7.jpg" size="50"/><br/>
            </td>
        </tr>
        <tr>
            <td>产品简述：</td>
            <td>
                <textarea name="proDesc" rows="6" cols="54"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2"><hr/></td>
        </tr>
        <tr>
            <td colspan="2">以下商品详细信息</td>
        </tr>
        <tr>
            <td>长宽高</td>
            <td>
                <input type="text" name="detLength"/>
                <input type="text" name="detHeight"/>
                <input type="text" name="detWidth"/>
            </td>
        </tr>
        <tr>
            <td>产品的质地：</td>
            <td>
                <input type="text" name="detMate"/>
            </td>
        </tr>
        <tr>
            <td>产品的产地：</td>
            <td>
                <input type="text" name="detAddr"/>
            </td>
        </tr>
        <tr>
            <td>生产日期：</td>
            <td>
                <input id="d11" name="detDate" type="text" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/>
            </td>
        </tr>
        <tr>
            <td>产品详细描述：</td>
            <td>
                <textarea name="detDesc" rows="6" cols="54"></textarea>
            </td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"/></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>

</div>
</body>
</html>

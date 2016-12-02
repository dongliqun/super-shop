<%--
  Created by IntelliJ IDEA.
  User: zhangls
  Date: 2016/10/31 0031
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<%@include file="header.jsp" %>
<body>
<%@include file="top-bar.jsp" %>

<%@include file="menu.jsp" %>

<div class="title-wrapper">
    <div class="container">
        <div class="container-inner">
            <h1><span>女士</span>专区</h1>
            <em>超过4000款商品，等待您的选购</em>
        </div>
    </div>
</div>

<div class="main">

    <div class="container">
        <ul class="breadcrumb">
            <li><a href="${path}/index.jsp">主页</a></li>
            <li><a href="${path}/index.jsp">专区</a></li>
            <li class="active">女士专区</li>
        </ul>
        <%--<h1>${param.typeId}</h1>--%>
        <input type="hidden" value="${param.typeId}" id="typeId"/>
        <input type="hidden" value="${param.pageNo}" id="pageNo"/>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <%@include file="sidebar.jsp"%>
            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7" id="pro-list">
                <!-- BEGIN PRODUCT LIST -->

        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<%@include file="footer.jsp" %>
<script type="text/javascript" src="${path}/assets/scripts/custom/proList.js" charset="utf-8"></script>
</body>
</html>

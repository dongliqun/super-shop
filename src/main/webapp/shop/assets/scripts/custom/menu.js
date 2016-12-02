/**
 * Created by zhangls on 2016/10/29 0029.
 */
$(function () {

    $.post("/super-shop/shop/menu", {}, function (data, status) {

        var jsonObj = eval('(' + data + ')');

        if (status == 'success') {
            $.each(jsonObj[0], function (i, val) {
                var menuStyle = val.menuStyle;

                //菜单样式 1: 平铺,2: 层级菜单, 3: 图片 ,4: 仅链接
                switch (parseInt(menuStyle)) {
                    case 1 :
                        menuStyle1(val, jsonObj);
                        break;
                    case 2 :
                        menuStyle2(val, jsonObj);
                        break;
                    case 3 :
                        $.post("/super-shop/shop/menu/pro", {"menuId": val.id}, function (dd, ss) {
                            menuStyle3(val, jsonObj, dd);
                        });
                        break;
                    case 4 :
                        menuStyle4(val, jsonObj);
                        break;
                    default :
                        menuStyle4(val, jsonObj);
                        break;
                }
            });

        }
    });
});

/**
 * 平铺
 * @param val
 */
menuStyle1 = function (val, jsonObj) {
    var plist = "/super-shop" + val.menuUri + "?pageNo=1&typeId=" + val.id;

    var htmlStr = '<li class="dropdown">';

    htmlStr += '<a class="dropdown-toggle" href="' + plist + '">' +
        val.menuName + '<i class="fa fa-angle-down"></i></a>';

    if (jsonObj[val.id].length != 0) {
        htmlStr += '<ul class="dropdown-menu" aria-labelledby="mega-menu"><li><div class="nav-content">';


        $.each(jsonObj[val.id], function (i, v) {
            htmlStr += '<div class="nav-content-col"><h3>' + v.menuName + '</h3>';
            htmlStr += '<ul>';

            if (jsonObj[v.id].length != 0) {
                $.each(jsonObj[v.id], function (ix, va) {
                    plist = "/super-shop" + va.menuUri + "?pageNo=1&typeId=" + va.id;

                    htmlStr += '<li><a href="' + plist + '">' + va.menuName + '</a></li>';
                });
            }

            htmlStr += '</ul>';
            htmlStr += '</div>';

        });
        htmlStr += '</div></li></ul>';
    }

    htmlStr += "</li>";

    $("#menuItem").prepend(htmlStr);
};

/**
 * 层级菜单  此方法可以用递归方式实现 （作业）
 * @param val
 */
menuStyle2 = function (val, jsonObj) {
    var plist = "/super-shop" + val.menuUri + "?pageNo=1&typeId=" + val.id;

    var htmlStr = '<li class="dropdown">';

    htmlStr += '<a class="dropdown-toggle" href="' + plist + '">' +
        val.menuName + '<i class="fa fa-angle-down"></i></a>';
    //第一层遍历
    if (jsonObj[val.id].length != 0) {
        htmlStr += '<ul class="dropdown-menu">';
        $.each(jsonObj[val.id], function (i, v) {

            //第二层遍历
            if (jsonObj[v.id].length != 0) {
                htmlStr += '<li class="dropdown-submenu">';
                htmlStr += '<a href="' + v.menuUri + '">' + v.menuName + '<i class="fa fa-angle-right"></i></a>';
                htmlStr += '<ul class="dropdown-menu">';
                $.each(jsonObj[v.id], function (ix, va) {
                    plist = "/super-shop" + va.menuUri + "?pageNo=1&typeId=" + va.id;
                    htmlStr += '<li><a href="' + plist + '">' + va.menuName + '</a></li>';

                    //第三层遍历
                    if (jsonObj[va.id].length != 0) {
                        htmlStr += '<li class="dropdown-submenu">';
                        htmlStr += '<a href="' + plist + '">' + va.menuName + '<i class="fa fa-angle-right"></i></a>';
                        htmlStr += '<ul class="dropdown-menu">';
                        $.each(jsonObj[va.id], function (ixi, vav) {
                            plist = "/super-shop" + vav.menuUri + "?pageNo=1&typeId=" + vav.id;
                            htmlStr += '<li><a href="' + plist + '">' + vav.menuName + '</a></li>';
                        });
                        htmlStr += '</ul>';
                        htmlStr += '</li>';
                    }
                    //else{
                    //    htmlStr += '<li><a href="'+ va.menuUri +'">'+ va.menuName +'</a></li>';
                    //}

                });
                htmlStr += '</ul>';
                htmlStr += '</li>';
            } else {
                htmlStr += '<li><a href="' + v.menuUri + '">' + v.menuName + '</a></li>';
            }
        });

        htmlStr += '</ul>';
    }

    htmlStr += "</li>";

    $("#menuItem").prepend(htmlStr);

};

/**
 * 图片
 * @param val
 */
menuStyle3 = function (val, jsonObj, data) {

    var obj = eval('(' + data + ')');

    var htmlStr = '<li class="dropdown">';

    htmlStr += '<a class="dropdown-toggle" data-toggle="dropdown" data-delay="0" data-close-others="false" data-target="product-list.html" href="#">' +
        val.menuName + '<i class="fa fa-angle-down"></i></a>';

    if (jsonObj[val.id].length != 0) {
        htmlStr += '<ul class="dropdown-menu" aria-labelledby="mega-menu-catalogue"><li><div class="nav-content">';
        $.each(obj, function (i, v) {
            htmlStr += ' <div class="product-item">';
            htmlStr += '<div class="pi-img-wrapper">';
            htmlStr += '<a href="/super-shop/shop/proDet?pId=' + v.id + '"><img src="' + v.proPicUri + '" class="img-responsive" alt="' + v.proName + '"></a>';
            htmlStr += '</div>';
            htmlStr += '<h3><a href="/super-shop/shop/proDet?pId=' + v.id + '">' + v.proName + '</a></h3>';
            htmlStr += '<div class="pi-price">' + v.proNowPrice + '</div>';
            htmlStr += '<a href="/super-shop/shop/addCar?proId=' + v.id + '&proPrice=' + v.proNowPrice + '" class="btn btn-default add2cart">' + v.proDesc + '</a>';
            htmlStr += '</div>';

        });

        htmlStr += "</div></li></ul>";
    }

    htmlStr += "</li>";

    $("#menuItem").prepend(htmlStr);
};

/**
 * 仅链接
 * @param val
 */
menuStyle4 = function (val, jsonObj) {
    var htmlStr = '<li><a href="/super-shop' + val.menuUri + '">' + val.menuName + '</a></li>';
    $("#menuItem").prepend(htmlStr);
};

# 用户表
INSERT INTO tb_user (user_name, pass_word, real_name, email, cell_phone, address, user_type, state, create_by, create_date, update_by, update_date)
VALUES ('admin', 'admin123', '系统管理员', 'admin@admin.com', '13612345678', '河南郑州', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_user (user_name, pass_word, real_name, email, cell_phone, address, user_type, state, create_by, create_date, update_by, update_date)
VALUES ('member', 'member123', '张三', 'member@member.com', '13612345679', '河南郑州', '1', '1', 'member', NOW(), 'member', NOW());

# 产品类型表
INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('女士专区', 0, '/shop/product-list.jsp', '1', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('男士专区', 0, '/shop/product-list.jsp', '2', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('儿童专区', 0, '/shop/product-list.jsp', '2', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('新品发布', 0, '/shop/product-list.jsp', '3', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('电子产品', 0, '/shop/product-list.jsp', '2', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('二手市场', 0, '/shop/product-list.jsp', '4', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, menu_style, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('管理后台', 0, '/shop/product-list.jsp', '4', '1', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('女士裙子', 1, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('连衣裙', 8, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('衬裙', 8, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('毛裙', 8, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('女鞋', 1, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('高跟鞋', 12, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('流行运动鞋', 12, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('板鞋', 12, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('珠宝/饰品', 1, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('项链', 16, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('手镯', 16, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('戒指', 16, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('耳环', 16, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('男鞋', 2, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('帆布鞋', 21, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('运动鞋', 21, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('商务皮鞋', 21, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('男裤', 2, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('休闲裤', 25, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('运动裤', 25, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('牛仔裤', 25, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('男装', 2, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('西服', 29, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('夹克', 29, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('衬衣', 29, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('男士化妆品', 2, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

/**
  新品发布  type_name 做为 商品ID
 */
INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('1', 4, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('2', 4, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_type (type_name, type_p_id, menu_uri, is_menu, state, create_by, create_date, update_by, update_date)
VALUES ('3', 4, '/shop/product-list.jsp', '0', '1', 'admin', NOW(), 'admin', NOW());

#商品图片表
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('1','/super-shop/shop/assets/temp/products/model4.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('2','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('3','/super-shop/shop/assets/temp/products/model7.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model4.jpg','0','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model2.jpg','1','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model1.jpg','3','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model5.jpg','4','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model6.jpg','5','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('4','/super-shop/shop/assets/temp/products/model7.jpg','6','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model5.jpg','0','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model2.jpg','1','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model4.jpg','3','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model1.jpg','4','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model6.jpg','5','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('5','/super-shop/shop/assets/temp/products/model7.jpg','6','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model6.jpg','0','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model2.jpg','1','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model4.jpg','3','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model5.jpg','4','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model1.jpg','5','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('6','/super-shop/shop/assets/temp/products/model7.jpg','6','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model7.jpg','0','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model2.jpg','1','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model4.jpg','3','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model5.jpg','4','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model6.jpg','5','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('7','/super-shop/shop/assets/temp/products/model1.jpg','6','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model2.jpg','1','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model4.jpg','3','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model5.jpg','4','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model6.jpg','5','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model7.jpg','6','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('8','/super-shop/shop/assets/temp/products/model1.jpg','7','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model2.jpg','1','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model3.jpg','2','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model4.jpg','3','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model5.jpg','4','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model6.jpg','5','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model7.jpg','6','1','admin',now(),'admin',now());
insert into `tb_prod_pic` (`pro_id`, `pic_uri`, `is_order`, `state`, `create_by`, `create_date`, `update_by`, `update_date`) values('9','/super-shop/shop/assets/temp/products/model1.jpg','8','1','admin',now(),'admin',now());

#商品表
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('淑女成衣真丝裙子，活动促销中','889.32','499.21','1','活动促销中,活动促销中,活动促销中,活动促销中,活动促销中','L,M,XL,XXL,XXXL','red,green','4.5','9','1','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:31:52','admin','2016-11-01 21:31:52');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女生高档眼镜，活动促销中','89.45','49.26','1','活动促销中,活动促销中,活动促销中,活动促销中,活动促销中','L,M,XL,XXL,XXXL','red,green','4.5','9','2','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:31:52','admin','2016-11-01 21:31:52');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女士鞋子特价，活动促销中','239.20','99.23','1','活动促销中,活动促销中,活动促销中,活动促销中,活动促销中','L,M,XL,XXL,XXXL','red,green','4.5','9','3','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:31:52','admin','2016-11-01 21:31:52');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('男鞋001','599.00','399.00','1','双十一促销','M,L,XL,XXL,XXL,XXXL','red,blue,white,black,yellow,green','4.5','2,21,23','4','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:44:49','admin','2016-11-01 21:44:49');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女士套装001','542.33','356.78','1','双十一促销','M,L,XL,XXL,XXL,XXXL','red,blue,white,black,yellow,green','4.5','1,8,9','13','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:57:40','admin','2016-11-01 21:57:40');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女士套装002','432.58','316.93','1','双十一促销','M,L,XL,XXL,XXL,XXXL','red,blue,white,black,yellow,green','4.5','1,8,10','22','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:58:21','admin','2016-11-01 21:58:21');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女士套装003','237.88','126.92','1','双十一促销','M,L,XL,XXL,XXL,XXXL','red,blue,white,black,yellow,green','4.5','1,12,14','31','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 21:59:34','admin','2016-11-01 21:59:34');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女士套装004','856.84','562.73','1','双十一促销','M,L,XL,XXL,XXL,XXXL','red,blue,white,black,yellow,green','4.5','1,8,11','36','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 22:00:20','admin','2016-11-01 22:00:20');
insert into `tb_product` (`pro_name`, `pro_real_price`, `pro_now_price`, `is_stock`, `pro_desc`, `pro_size`, `pro_color`, `pro_score`, `pro_type_id`, `pro_pic_id`, `pro_pic_uri`, `state`, `create_by`, `create_date`, `update_by`, `update_date`)
values('女士套装005','336.93','198.40','1','双十一促销','M,L,XL,XXL,XXL,XXXL','red,blue,white,black,yellow,green','4.5','1,12,13','43','/super-shop/shop/assets/temp/products/model1.jpg','1','admin','2016-11-01 22:05:55','admin','2016-11-01 22:05:55');

#商品明细表
INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (1, '200', '300', '400', '真丝', '河南郑州', '2015-10-03 09:24:02', '淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (2, '300', '400', '500', '聚酯纤维', '河南郑州', '2014-10-18 10:35:07', '太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (3, '500', '600', '700', '牛皮', '河南郑州', '2015-04-22 22:45:01', '高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (4, '200', '300', '400', '真丝', '河南郑州', '2015-04-22 22:45:01', '淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (5, '300', '400', '500', '聚酯纤维', '河南郑州', '2015-04-22 22:45:01', '太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (6, '500', '600', '700', '牛皮', '河南郑州', '2015-04-22 22:45:01', '高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (7, '200', '300', '400', '真丝', '河南郑州', '2015-04-22 22:45:01', '淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子,淑女成衣真丝裙子', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (8, '300', '400', '500', '聚酯纤维', '河南郑州', '2015-04-22 22:45:01', '太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；太阳镜，大促销；', '1', 'admin', NOW(), 'admin', NOW());

INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date)
VALUES (9, '500', '600', '700', '牛皮', '河南郑州', '2015-04-22 22:45:01', '高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋，高跟鞋', '1', 'admin', NOW(), 'admin', NOW());

#商品评论表
INSERT INTO tb_prod_comment(pro_id, user_id, com_title, com_desc, pro_score, state, create_by, create_date, update_by, update_date)
VALUES (7,2,'产品评论001','产品评论产品评论产品评论产品评论',4.5,'1','member',NOW(),'member',NOW());
INSERT INTO tb_prod_comment(pro_id, user_id, com_title, com_desc, pro_score, state, create_by, create_date, update_by, update_date)
VALUES (7,2,'产品评论002','产品评论产品评论产品评论产品评论',3.5,'1','member',NOW(),'member',NOW());
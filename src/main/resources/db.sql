/**
  创建数据库 utf8编码格式
 */
CREATE DATABASE IF NOT EXISTS super_shop
  DEFAULT CHARSET utf8
  COLLATE utf8_general_ci;

USE super_shop;

/**
  创建用户表(包括管理员用户和会员信息)
  user_type = 1:系统用户 0:注册会员用户
  state = 1:可用状态  0:删除状态
 */
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE tb_user (
  user_id     INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  user_name   VARCHAR(50) NOT NULL UNIQUE,
  pass_word   VARCHAR(50) NOT NULL,
  real_name   VARCHAR(20) NOT NULL,
  email       VARCHAR(50) NOT NULL UNIQUE,
  cell_phone  VARCHAR(20) NOT NULL UNIQUE,
  address     VARCHAR(50) NOT NULL,
  user_type   VARCHAR(10) NOT NULL,
  state       VARCHAR(10) NOT NULL,
  create_by   VARCHAR(20) NOT NULL,
  create_date DATETIME    NOT NULL,
  update_by   VARCHAR(20) NOT NULL,
  update_date DATETIME    NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
  商品类型表
  state = 1:可用状态  0:删除状态
  is_meun = 1:是菜单  0:不是菜单
  meun_style 菜单样式 1: 平铺,2: 层级菜单, 3: 图片 ,4: 仅链接
*/
DROP TABLE IF EXISTS `tb_prod_type`;
CREATE TABLE tb_prod_type (
  type_id     INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  type_name   VARCHAR(50)  NOT NULL,
  type_p_id   INT UNSIGNED NOT NULL,
  menu_uri    VARCHAR(100),
  menu_style  VARCHAR(10),
  is_menu     VARCHAR(10)  NOT NULL,
  state       VARCHAR(10)  NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
  商品图片表
  is_order 图片排序
 */
DROP TABLE IF EXISTS `tb_prod_pic`;
CREATE TABLE tb_prod_pic (
  pic_id      INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  pro_id      INT UNSIGNED NOT NULL,
  pic_uri     VARCHAR(100) NOT NULL,
  is_order    VARCHAR(10)  NOT NULL,
  state       VARCHAR(10)  NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
  商品表
  is_stock = 1:有库存 0:缺货
 */
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE tb_product (
  pro_id         INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  pro_name       VARCHAR(50)  NOT NULL UNIQUE,
  pro_real_price DOUBLE(9, 2) NOT NULL,
  pro_now_price  DOUBLE(9, 2) NOT NULL,
  is_stock       VARCHAR(2)   NOT NULL,
  pro_desc       VARCHAR(200) NOT NULL,
  pro_size       VARCHAR(50)  NOT NULL,
  pro_color      VARCHAR(50)  NOT NULL,
  pro_score      DOUBLE       NOT NULL,
  pro_type_id    VARCHAR(20)  NOT NULL,
  pro_pic_id     INT UNSIGNED,
  pro_pic_uri    VARCHAR(100),
  state          VARCHAR(10)  NOT NULL,
  create_by      VARCHAR(20)  NOT NULL,
  create_date    DATETIME     NOT NULL,
  update_by      VARCHAR(20)  NOT NULL,
  update_date    DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
  商品明细表
 */
DROP TABLE IF EXISTS `tb_prod_detail`;
CREATE TABLE tb_prod_detail (
  det_id      INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  prod_id     INT UNSIGNED NOT NULL,
  det_length  VARCHAR(10)  NOT NULL,
  det_height  VARCHAR(10)  NOT NULL,
  det_width   VARCHAR(10)  NOT NULL,
  det_mate    VARCHAR(200) NOT NULL,
  det_addr    VARCHAR(20)  NOT NULL,
  det_date    DATETIME     NOT NULL,
  det_desc    VARCHAR(500) NOT NULL,
  state       INT UNSIGNED NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;


/**
购物车表
*/
DROP TABLE IF EXISTS `tb_prod_car`;
CREATE TABLE tb_prod_car (
  car_id      INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  user_id     INT UNSIGNED NOT NULL,
  prod_id     INT UNSIGNED NOT NULL,
  pro_size    VARCHAR(10)  NOT NULL,
  pro_color   VARCHAR(20)  NOT NULL,
  pro_num     INT UNSIGNED NOT NULL,
  pro_price   DOUBLE(9, 2) NOT NULL,
  tal_price   DOUBLE(9, 2) NOT NULL,
  state       VARCHAR(10)  NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
  产品评论表
*/
DROP TABLE IF EXISTS `tb_prod_comment`;
CREATE TABLE tb_prod_comment (
  com_id      INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  pro_id      INT UNSIGNED NOT NULL,
  user_id     INT UNSIGNED NOT NULL,
  com_title   VARCHAR(50)  NOT NULL,
  com_desc    VARCHAR(500) NOT NULL,
  pro_score   DOUBLE       NOT NULL,
  state       VARCHAR(10)  NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
订单表
state:
0:删除状态
1:初始状态(待付款)
2:已付款(待发货)
3:已发货(待签收)
4:已签收(待确认)
5:已确认(归档状态)
*/
/**
订单表
*/
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE tb_order (
  order_id    VARCHAR(20) PRIMARY KEY,
  user_id     INT UNSIGNED NOT NULL,
  order_price DOUBLE(9, 2) NOT NULL,
  order_name  VARCHAR(20)  NOT NULL,
  order_addr  VARCHAR(100) NOT NULL,
  order_phone VARCHAR(20)  NOT NULL,
  order_tel   VARCHAR(20),
  order_desc  VARCHAR(100),
  state       VARCHAR(10)  NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
订单详表
*/
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE tb_order_detail (
  detail_id   INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  order_id    VARCHAR(20)  NOT NULL,
  pro_id      INT UNSIGNED NOT NULL,
  pro_name    VARCHAR(50)  NOT NULL,
  pro_desc    VARCHAR(200) NOT NULL,
  pro_size    VARCHAR(10)  NOT NULL,
  pro_color   VARCHAR(20)  NOT NULL,
  pro_num     INT UNSIGNED NOT NULL,
  pro_price   DOUBLE(9, 2) NOT NULL,
  tal_price   DOUBLE(9, 2) NOT NULL,
  state       VARCHAR(10)  NOT NULL,
  create_by   VARCHAR(20)  NOT NULL,
  create_date DATETIME     NOT NULL,
  update_by   VARCHAR(20)  NOT NULL,
  update_date DATETIME     NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
  AUTO_INCREMENT = 1;

/**
用于生成序列号
 */
DROP TABLE IF EXISTS `order_seq`;
CREATE TABLE order_seq (
  timestr  VARCHAR(20) NOT NULL,
  order_sn INT         NOT NULL
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8
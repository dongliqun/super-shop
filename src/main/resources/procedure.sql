/**
  创建存储过程，用于生成订单号 utf8编码格式
 */
DELIMITER $$
USE `super_shop`$$
DROP PROCEDURE IF EXISTS `seq_no`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `seq_no`()
  BEGIN
    DECLARE v_cnt INT;
    DECLARE v_timestr INT;
    DECLARE rowcount BIGINT;
    SET v_timestr = DATE_FORMAT(NOW(),'%Y%m%d');
    SELECT ROUND(RAND()*10,0)+1 INTO v_cnt;
    START TRANSACTION;
    UPDATE order_seq SET order_sn = order_sn + v_cnt WHERE timestr = v_timestr;
    IF ROW_COUNT() = 0 THEN
      INSERT INTO order_seq(timestr,order_sn) VALUES(v_timestr,v_cnt);
    END IF;
    SELECT CONCAT(v_timestr,LPAD(order_sn,7,0))AS order_sn FROM order_seq WHERE timestr = v_timestr;
    COMMIT;
  END$$
DELIMITER ;
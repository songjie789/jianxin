# Host: 39.106.36.61  (Version 5.5.13)
# Date: 2018-03-26 14:38:49
# Generator: MySQL-Front 5.4  (Build 4.153) - http://www.mysqlfront.de/

/*!40101 SET NAMES utf8 */;

#
# Structure for table "admin_login_table"
#

DROP TABLE IF EXISTS `admin_login_table`;
CREATE TABLE `admin_login_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `time` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "admin_login_table"
#

INSERT INTO `admin_login_table` VALUES (1,'124.133.255.146','2018/03/25 13:28:59','songjie'),(2,'124.133.255.146','2018/03/25 13:36:57','1'),(3,'0:0:0:0:0:0:0:1','2018/03/25 15:07:06','1'),(4,'0:0:0:0:0:0:0:1','2018/03/25 20:31:36','1'),(5,'0:0:0:0:0:0:0:1','2018/03/25 21:53:26','1'),(6,'0:0:0:0:0:0:0:1','2018/03/25 21:58:49','1'),(7,'0:0:0:0:0:0:0:1','2018/03/25 23:21:41','1'),(8,'58.56.21.246','2018/03/26 10:12:47','1'),(9,'0:0:0:0:0:0:0:1','2018/03/26 10:11:46','admin'),(10,'0:0:0:0:0:0:0:1','2018/03/26 10:29:04','admin'),(11,'124.133.255.146','2018/03/26 13:07:12','1'),(12,'0:0:0:0:0:0:0:1','2018/03/26 14:30:36','1');

#
# Structure for table "admin_power_table"
#

DROP TABLE IF EXISTS `admin_power_table`;
CREATE TABLE `admin_power_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL COMMENT '二级菜单id',
  `aid` int(11) DEFAULT NULL COMMENT '管理员id',
  `fid` int(11) DEFAULT NULL COMMENT '一级菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "admin_power_table"
#


#
# Structure for table "car_repair_table"
#

DROP TABLE IF EXISTS `car_repair_table`;
CREATE TABLE `car_repair_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆维修表',
  `car_number` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '车牌号',
  `repair_address` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '维修地点',
  `repair_part` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '维修部件',
  `unit_price` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '部件单价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "car_repair_table"
#

INSERT INTO `car_repair_table` VALUES (1003,'鲁Q58675','山东济南','挡风玻璃','12345'),(1004,'鲁A12345','123123','轮胎','123123'),(1005,'鲁Q58675','123123','挡风玻璃','123123'),(1006,'鲁Q58675','山东吉娜娜','轮胎','123'),(1007,'鲁Q58675','1','轮胎','123'),(1008,'鲁Q58675','123','挡风玻璃','123123'),(1009,'鲁A12345','123','轮胎','123');

#
# Structure for table "car_storage"
#

DROP TABLE IF EXISTS `car_storage`;
CREATE TABLE `car_storage` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动编号',
  `car_name` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL COMMENT '车辆名称',
  `type` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL COMMENT '车辆类型',
  `length` double DEFAULT NULL COMMENT '车辆长度',
  `frame_number` int(11) DEFAULT NULL COMMENT '车架号',
  `factory_date` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL COMMENT '车辆出厂日期',
  `warehouse_staff` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL COMMENT '入库人员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "car_storage"
#


#
# Structure for table "car_table"
#

DROP TABLE IF EXISTS `car_table`;
CREATE TABLE `car_table` (
  `car_id` int(6) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `car_length` double(10,0) NOT NULL,
  `car_vin` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `car_number` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `car_driver` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `car_unit` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='车辆信息表';

#
# Data for table "car_table"
#

INSERT INTO `car_table` VALUES (1007,'奔驰',10,'FIUHNT9J23OI4J523','鲁A12345','宋杰','百世'),(1008,'宝马',4,'7889UROIJRJRK2I34','鲁Q58675','宋杰','百世'),(1009,'奥迪',4,'NT893U49TH34UIOTY','鲁B12345','张志杰',' 请  选  择  所  属  单位 ');

#
# Structure for table "driver_table"
#

DROP TABLE IF EXISTS `driver_table`;
CREATE TABLE `driver_table` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `driver_car_number` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `driver_address` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `driver_phone` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "driver_table"
#

INSERT INTO `driver_table` VALUES (1001,'宋杰','鲁Q58675','山东省临沂市郯城县港上镇一村251','13376444463'),(1002,'张志杰','鲁A12345','山东省临沂市郯城县红花镇龙湖村','18354947102'),(1003,'吕晨晨','鲁A12345','山东省菏泽市','15012345679'),(1004,'','请选择车辆','','');

#
# Structure for table "error_table"
#

DROP TABLE IF EXISTS `error_table`;
CREATE TABLE `error_table` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL COMMENT '操作人的用户名',
  `error_message` text COLLATE utf8_sinhala_ci COMMENT '错误信息[打印出的异常栈]',
  `time` text COLLATE utf8_sinhala_ci COMMENT '发生异常时间',
  `controller` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1041 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "error_table"
#

INSERT INTO `error_table` VALUES (1001,'songjie','not null','201',''),(1002,NULL,'cuowu  cuopwu ',NULL,NULL),(1003,NULL,'Fri Mar 23 00:16:20 CST 2018:[类:com.yuyi.controller.JSYController]调用pilot时在第55行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1004,NULL,'Fri Mar 23 00:16:36 CST 2018:[类:com.yuyi.controller.JSYController]调用pilot时在第55行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1005,NULL,'Fri Mar 23 00:16:37 CST 2018:[类:com.yuyi.controller.JSYController]调用pilot时在第55行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1006,NULL,'Fri Mar 23 00:18:37 CST 2018:[类:com.yuyi.controller.JSYController]调用pilot时在第55行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1007,NULL,'Fri Mar 23 00:18:44 CST 2018:[类:com.yuyi.controller.JSYController]调用AddDrivers时在第81行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1008,NULL,'Fri Mar 23 00:19:07 CST 2018:[类:com.yuyi.controller.JSYController]调用pilot时在第55行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1009,NULL,'Fri Mar 23 00:19:17 CST 2018:[类:com.yuyi.controller.JSYController]调用AddDrivers时在第81行代码处发生异常!异常类型:java.lang.ArithmeticException',NULL,NULL),(1010,NULL,'Fri Mar 23 20:00:58 CST 2018:[类:org.springframework.jdbc.datasource.DataSourceTransactionManager]调用doRollback时在第290行代码处发生异常!异常类型:org.springframework.transaction.TransactionSystemException',NULL,NULL),(1012,NULL,'Fri Mar 23 20:56:01 CST 2018:[类:org.springframework.jdbc.datasource.DataSourceTransactionManager]调用doCommit时在第275行代码处发生异常!异常类型:org.springframework.transaction.TransactionSystemException',NULL,NULL),(1013,NULL,'Fri Mar 23 20:56:04 CST 2018:[类:org.springframework.jdbc.datasource.DataSourceTransactionManager]调用doCommit时在第275行代码处发生异常!异常类型:org.springframework.transaction.TransactionSystemException',NULL,NULL),(1014,NULL,'Fri Mar 23 20:56:17 CST 2018:[类:org.springframework.jdbc.datasource.DataSourceTransactionManager]调用doRollback时在第290行代码处发生异常!异常类型:org.springframework.transaction.TransactionSystemException',NULL,NULL),(1015,NULL,'Fri Mar 23 22:00:19 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1016,NULL,'Fri Mar 23 22:01:42 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1017,NULL,'Fri Mar 23 22:01:48 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1018,NULL,'Fri Mar 23 22:08:12 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1019,NULL,'Fri Mar 23 22:08:15 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1020,NULL,'Fri Mar 23 22:08:44 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1021,NULL,'Fri Mar 23 22:09:04 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1022,NULL,'Fri Mar 23 22:13:26 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1023,NULL,'Fri Mar 23 22:13:26 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1024,NULL,'Fri Mar 23 22:14:20 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1025,NULL,'Fri Mar 23 22:15:17 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1026,NULL,'Fri Mar 23 22:17:00 CST 2018:[类:org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator]调用doTranslate时在第231行代码处发生异常!异常类型:org.springframework.jdbc.BadSqlGrammarException',NULL,NULL),(1027,NULL,'Fri Mar 23 22:18:20 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1028,NULL,'Fri Mar 23 22:19:12 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1029,NULL,'Sun Mar 25 22:13:18 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1030,NULL,'Sun Mar 25 22:13:34 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1031,NULL,'Sun Mar 25 22:14:56 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1032,NULL,'Sun Mar 25 22:16:31 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1033,NULL,'Sun Mar 25 22:16:53 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1034,NULL,'Sun Mar 25 22:19:56 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1035,NULL,'Sun Mar 25 22:20:16 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1036,NULL,'Sun Mar 25 22:24:11 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1037,NULL,'Sun Mar 25 22:25:15 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1038,NULL,'Sun Mar 25 22:25:44 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1039,NULL,'Sun Mar 25 22:27:13 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL),(1040,NULL,'Sun Mar 25 22:27:13 CST 2018:[类:org.mybatis.spring.MyBatisExceptionTranslator]调用translateExceptionIfPossible时在第79行代码处发生异常!异常类型:org.mybatis.spring.MyBatisSystemException',NULL,NULL);

#
# Structure for table "first_menu_table"
#

DROP TABLE IF EXISTS `first_menu_table`;
CREATE TABLE `first_menu_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '菜单类型',
  `classname` varchar(30) DEFAULT NULL COMMENT '菜单图标类型',
  `menu_order` int(3) DEFAULT NULL COMMENT '菜单顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

#
# Data for table "first_menu_table"
#

INSERT INTO `first_menu_table` VALUES (5,'用户管理','img/coin10.png',NULL),(6,'车辆管理','img/coin10.png',NULL),(7,'驾驶员管理','img/coin10.png',NULL),(8,'系统管理','img/coin10.png',NULL),(10,'会员管理','img/coin10.png',NULL),(11,'单位管理','img/coin10.png',NULL);

#
# Structure for table "part_table"
#

DROP TABLE IF EXISTS `part_table`;
CREATE TABLE `part_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部件id(自增)',
  `part_name` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '部件名称',
  PRIMARY KEY (`id`,`part_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1012 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "part_table"
#

INSERT INTO `part_table` VALUES (1001,'轮胎'),(1002,'挡风玻璃'),(1003,'皮带'),(1004,'啊啊'),(1005,'啊哈'),(1006,'部件1'),(1007,'部件2'),(1008,'部件3'),(1009,'哈哈'),(1010,'哈啊哈哈哈哈'),(1011,'过滤芯');

#
# Structure for table "second_menu_table"
#

DROP TABLE IF EXISTS `second_menu_table`;
CREATE TABLE `second_menu_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firset_menu_id` int(11) DEFAULT NULL COMMENT '一级菜单id',
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名',
  `address` varchar(100) DEFAULT NULL COMMENT '连接地址',
  PRIMARY KEY (`id`),
  KEY `firset_menu_id` (`firset_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

#
# Data for table "second_menu_table"
#

INSERT INTO `second_menu_table` VALUES (9,5,'添加用户','changepwda'),(10,5,'修改用户密码','changepwd'),(11,6,'车辆信息管理','carcontent'),(12,7,'驾驶员信息','pilot'),(13,6,'车辆维修管理','car_repair'),(14,8,'操作日志','adderror'),(16,10,'会员管理','power'),(17,11,'添加单位信息','addunit'),(18,11,'单位信息','SelectUnit');

#
# Structure for table "unit_table"
#

DROP TABLE IF EXISTS `unit_table`;
CREATE TABLE `unit_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '单位名称',
  `unit_address` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `unit_contact` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '单位负责人',
  `unit_phone` varchar(255) COLLATE utf8_sinhala_ci NOT NULL COMMENT '单位人联系电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "unit_table"
#

INSERT INTO `unit_table` VALUES (1001,'百世','山东济南历程区','宋杰','13376444463'),(1002,'顺丰','山东省济南市郭店镇','宋1','15012345678'),(1003,'圆通','山东省济南市历城区遥墙镇大码头村','圆通老总','15078945612'),(1004,'邮政','山东省济南市高新区','国家','13012345678'),(1005,'韵达','山东省济南市历下区','韵达老总','15689483381');

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_sinhala_ci NOT NULL,
  `supera` varchar(10) COLLATE utf8_sinhala_ci NOT NULL COMMENT '超级管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'1','4297F44B13955235245B2497399D7A93','15012345678','150','正常'),(2,'admin','4297F44B13955235245B2497399D7A93','15012345678','admin','正常'),(3,'songjie','4297F44B13955235245B2497399D7A93','15012345678','songjie','正常');

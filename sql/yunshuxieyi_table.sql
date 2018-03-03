/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for yunshuxieyi_table
-- ----------------------------
DROP TABLE IF EXISTS `yunshuxieyi_table`;
CREATE TABLE `yunshuxieyi_table` (
  `yunshu_id` int(6) NOT NULL COMMENT '运输协议id',
  `yunshu_tim` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '运输时间',
  `car_id` int(6) NOT NULL COMMENT '运输车辆编号',
  `jiashiyuan_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '驾驶员姓名',
  `shifadi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '始发地',
  `mudidi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '目的地',
  `huowumingcheng` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '货物名称',
  `dunwei` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '吨位',
  `lifang` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '立方',
  `yunshu_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '委托运输公司或个人姓名',
  `yunshu_call` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '委托运输人电话',
  `yunshu_adder` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '委托运输人地址',
  `beizhu` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`yunshu_id`,`car_id`),
  KEY `yunshu_car_id` (`car_id`),
  CONSTRAINT `yunshuxieyi_table_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `car_table` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='运输协议表';

-- ----------------------------
-- Records of yunshuxieyi_table
-- ----------------------------

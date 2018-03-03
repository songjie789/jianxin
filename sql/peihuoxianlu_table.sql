/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for peihuoxianlu_table
-- ----------------------------
DROP TABLE IF EXISTS `peihuoxianlu_table`;
CREATE TABLE `peihuoxianlu_table` (
  `peihuo_id` int(6) NOT NULL COMMENT '配货线路id',
  `yunshu_car_id` int(6) NOT NULL COMMENT '运输车辆编号',
  `yunshu_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '运输人姓名',
  `yunshu_id` int(6) NOT NULL COMMENT '运输协议号',
  `huowu_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '货物名称',
  `dunwei` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '货物吨位',
  `shifadi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '始发地',
  `mudidi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '目的地',
  `yunshujiage` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '运输价格',
  `youfeikaizhi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '油费开支',
  `lufeikaizhi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '路费开支',
  `jaishiyuankaizhi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '驾驶开支',
  `beizhu` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`peihuo_id`,`yunshu_car_id`,`yunshu_name`,`yunshu_id`),
  KEY `peihuo_xieyi_id` (`yunshu_id`),
  KEY `peihuo_car_id` (`yunshu_car_id`),
  CONSTRAINT `peihuoxianlu_table_ibfk_1` FOREIGN KEY (`yunshu_car_id`) REFERENCES `car_table` (`car_id`),
  CONSTRAINT `peihuoxianlu_table_ibfk_2` FOREIGN KEY (`yunshu_id`) REFERENCES `yunshuxieyi_table` (`yunshu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='配货线路表';

-- ----------------------------
-- Records of peihuoxianlu_table
-- ----------------------------

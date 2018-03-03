/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lufei_table
-- ----------------------------
DROP TABLE IF EXISTS `lufei_table`;
CREATE TABLE `lufei_table` (
  `etc` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'ETC卡所属省份',
  `ETC_ID` int(20) NOT NULL COMMENT 'ETC卡号',
  `Car_id` int(6) NOT NULL COMMENT '运输车辆编号',
  `jiashiyuan_Name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '运输人姓名',
  `yunshuxieyi_id` int(6) NOT NULL COMMENT '运输协议号',
  `lufei` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '路费费用',
  PRIMARY KEY (`ETC_ID`),
  KEY `lufei_car_id` (`Car_id`),
  CONSTRAINT `lufei_table_ibfk_1` FOREIGN KEY (`Car_id`) REFERENCES `car_table` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='路费表\r\n\r\n';

-- ----------------------------
-- Records of lufei_table
-- ----------------------------

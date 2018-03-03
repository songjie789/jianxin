/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for youfei_table
-- ----------------------------
DROP TABLE IF EXISTS `youfei_table`;
CREATE TABLE `youfei_table` (
  `youka_id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '油卡所属公司',
  `Car_id` int(6) NOT NULL COMMENT '加油车辆编号',
  `jiashiyuan_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '驾驶员姓名',
  `sheng` int(255) NOT NULL COMMENT '升',
  `meisheng` int(255) NOT NULL COMMENT '每升价格',
  `zongjiage` int(10) NOT NULL COMMENT '总价格',
  PRIMARY KEY (`Car_id`),
  CONSTRAINT `youfei_table_ibfk_1` FOREIGN KEY (`Car_id`) REFERENCES `car_table` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='油费表';

-- ----------------------------
-- Records of youfei_table
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for weixiufei_table
-- ----------------------------
DROP TABLE IF EXISTS `weixiufei_table`;
CREATE TABLE `weixiufei_table` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '维修费表ID',
  `car_id` int(11) NOT NULL COMMENT '车辆编号',
  `jiashiyuan_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '驾驶员姓名',
  `weixiubujian` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '维修部件',
  `bujiangeshu` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '部件个数',
  `bujiandanjia` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '部件单价',
  `zongfeiyong` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '维修总费用',
  PRIMARY KEY (`id`,`car_id`),
  KEY `weixiubujian_id` (`weixiubujian`),
  CONSTRAINT `weixiufei_table_ibfk_1` FOREIGN KEY (`weixiubujian`) REFERENCES `weixiubujian_table` (`bujian_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='维修费用表';

-- ----------------------------
-- Records of weixiufei_table
-- ----------------------------

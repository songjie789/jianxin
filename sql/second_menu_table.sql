/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for second_menu_table
-- ----------------------------
DROP TABLE IF EXISTS `second_menu_table`;
CREATE TABLE `second_menu_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firset_menu_id` int(11) DEFAULT NULL COMMENT '一级菜单id',
  `name` varchar(30) DEFAULT NULL COMMENT '菜单名',
  `address` varchar(100) DEFAULT NULL COMMENT '连接地址',
  PRIMARY KEY (`id`),
  KEY `firset_menu_id` (`firset_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of second_menu_table
-- ----------------------------
INSERT INTO `second_menu_table` VALUES ('6', '4', '车辆信息', '111');
INSERT INTO `second_menu_table` VALUES ('7', '4', '车辆维修', '111');
INSERT INTO `second_menu_table` VALUES ('8', '3', '会员管理', '111');

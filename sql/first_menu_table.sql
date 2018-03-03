/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:44:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for first_menu_table
-- ----------------------------
DROP TABLE IF EXISTS `first_menu_table`;
CREATE TABLE `first_menu_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL COMMENT '菜单类型',
  `classname` varchar(30) DEFAULT NULL COMMENT '菜单图标类型',
  `menu_order` int(3) DEFAULT NULL COMMENT '菜单顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of first_menu_table
-- ----------------------------
INSERT INTO `first_menu_table` VALUES ('3', '会员管理', 'img/coin08.png', null);
INSERT INTO `first_menu_table` VALUES ('4', '车辆管理', 'img/coin08.png', null);

/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for weixiubujian_table
-- ----------------------------
DROP TABLE IF EXISTS `weixiubujian_table`;
CREATE TABLE `weixiubujian_table` (
  `bujian_id` varchar(6) COLLATE utf8_unicode_ci NOT NULL COMMENT '部件id',
  `bujian1` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '部件1',
  `bujian2` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件2',
  `bujian3` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件3',
  `bujian4` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件4',
  `bujian5` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件5',
  `bujian6` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件6',
  `bujian7` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件7',
  `bujian8` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件8',
  `bujian9` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件9',
  `bujian10` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部件10',
  PRIMARY KEY (`bujian_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='维修部件表';

-- ----------------------------
-- Records of weixiubujian_table
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:44:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_login_table
-- ----------------------------
DROP TABLE IF EXISTS `admin_login_table`;
CREATE TABLE `admin_login_table` (
  `id` int(11) primary key not  null  auto_increment,
  `ip` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `time` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_sinhala_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of admin_login_table
-- ----------------------------
INSERT INTO `admin_login_table` VALUES ('113', '2018-02-28 15:43:37 ', 'Admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('114', '2018-02-28 16:09:43 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('115', '2018-02-28 16:09:47 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('116', '2018-02-28 16:26:21 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('117', '2018-02-28 16:26:27 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('118', '2018-02-28 16:27:45 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('119', '2018-03-01 09:32:14 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('120', '2018-03-01 09:33:43 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('121', '2018-03-01 09:45:54 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('122', '2018-03-01 09:54:58 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('123', '2018-03-01 10:56:31 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('124', '2018-03-01 11:05:31 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('125', '2018-03-01 14:03:23 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('126', '2018-03-01 14:22:08 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('127', '2018-03-01 14:25:53 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('128', '2018-03-01 14:32:25 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('129', '2018-03-01 14:53:43 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('130', '2018-03-01 15:03:55 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('131', '2018-03-01 15:05:46 ', 'admin', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES ('132', '2018-03-01 15:21:52 ', '1', '192.168.1.136');
INSERT INTO `admin_login_table` VALUES (null, '192.168.2.184', '2018-03-01 17:46:33 ', '1');
INSERT INTO `admin_login_table` VALUES (null, '192.168.2.184', '2018-03-01 17:54:45 ', '1');

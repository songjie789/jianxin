/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:44:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for car_table
-- ----------------------------
DROP TABLE IF EXISTS `car_table`;
CREATE TABLE `car_table` (
  `car_id` int(6) NOT NULL,
  `car_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `car_length` double(10,0) NOT NULL,
  `car_vin` varchar(17) COLLATE utf8_unicode_ci NOT NULL,
  `car_adder` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `car_number` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='车辆信息表';

-- ----------------------------
-- Records of car_table
-- ----------------------------

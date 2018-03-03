/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:44:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jiashiyuan_table
-- ----------------------------
DROP TABLE IF EXISTS `jiashiyuan_table`;
CREATE TABLE `jiashiyuan_table` (
  `ID` int(6) NOT NULL AUTO_INCREMENT COMMENT '驾驶员编号',
  `name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '驾驶员姓名',
  `age` int(3) NOT NULL COMMENT '年龄',
  `shenfezheng_id` int(18) NOT NULL COMMENT '车辆编号',
  `jiashiyuan_name` int(18) NOT NULL COMMENT '驾驶证编号',
  `zhuzhi` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '住址',
  `Phone` varchar(11) COLLATE utf8_bin NOT NULL,
  `Car_Number` int(11) NOT NULL COMMENT '使用车辆编号',
  PRIMARY KEY (`ID`),
  KEY `car_id` (`Car_Number`),
  CONSTRAINT `jiashiyuan_table_ibfk_1` FOREIGN KEY (`Car_Number`) REFERENCES `car_table` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='驾驶员信息表';

-- ----------------------------
-- Records of jiashiyuan_table
-- ----------------------------

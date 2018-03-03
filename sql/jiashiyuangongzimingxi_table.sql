/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:44:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for jiashiyuangongzimingxi_table
-- ----------------------------
DROP TABLE IF EXISTS `jiashiyuangongzimingxi_table`;
CREATE TABLE `jiashiyuangongzimingxi_table` (
  `jiashiyuan_id` int(6) NOT NULL COMMENT '驾驶员编号',
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '驾驶员姓名',
  `ruzhi_time` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '入职时间',
  `laodonghetong` int(11) NOT NULL COMMENT '劳动合同是都签约,是:1否2',
  `gongzi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '工资金额',
  `back_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '银行卡号',
  `beizhu` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`jiashiyuan_id`),
  CONSTRAINT `jiashiyuangongzimingxi_table_ibfk_1` FOREIGN KEY (`jiashiyuan_id`) REFERENCES `jiashiyuan_table` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='驾驶员工资名字表';

-- ----------------------------
-- Records of jiashiyuangongzimingxi_table
-- ----------------------------

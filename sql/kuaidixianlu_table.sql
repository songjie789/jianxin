/*
Navicat MySQL Data Transfer

Source Server         : 建新物流
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : xiaofeixia

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2018-03-02 17:45:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kuaidixianlu_table
-- ----------------------------
DROP TABLE IF EXISTS `kuaidixianlu_table`;
CREATE TABLE `kuaidixianlu_table` (
  `id` int(6) NOT NULL,
  `car_id` int(6) NOT NULL COMMENT '车辆编号',
  `jiashiyuan_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '驾驶员姓名',
  `yunshu_id` int(6) NOT NULL COMMENT '运输协议编号',
  `shuangbian` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '双边',
  `danbian` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '单边',
  `shifadi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '始发地',
  `mudidi` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '目的地',
  `feiyong` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '费用',
  `a_tiem` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '竞标时间',
  `b_time` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '截止时间',
  `meitangjiage` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '每趟价格',
  `beizhu` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`,`car_id`),
  KEY `kuaidixianlu_car_id` (`car_id`),
  CONSTRAINT `kuaidixianlu_table_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `car_table` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='快递线路表';

-- ----------------------------
-- Records of kuaidixianlu_table
-- ----------------------------

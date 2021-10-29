/*
Navicat MySQL Data Transfer

Source Server         : 本机mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : gjc_test

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2021-10-29 16:50:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品Id',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_num` bigint(20) DEFAULT NULL COMMENT '商品数目',
  `goods_description` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `goods_price` bigint(20) DEFAULT NULL COMMENT '商品价格',
  PRIMARY KEY (`goods_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '商品1', '1', '好好好好好好好', '100');

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade` (
  `trade_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id',
  `trade_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `total` bigint(20) DEFAULT NULL COMMENT '订单价钱',
  `trade_status` varchar(255) DEFAULT NULL COMMENT '订单类型',
  PRIMARY KEY (`trade_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of trade
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123456', 'e10adc3949ba59abbe56e057f20f883e');

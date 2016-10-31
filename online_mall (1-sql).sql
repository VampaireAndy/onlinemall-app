/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : online_mall

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2016-07-28 14:41:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `admin_pwd` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin');

-- ----------------------------
-- Table structure for `basket`
-- ----------------------------
DROP TABLE IF EXISTS `basket`;
CREATE TABLE `basket` (
  `basket_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `goods_number` int(11) DEFAULT NULL,
  `goods_sale_price` float(100,2) DEFAULT NULL,
  PRIMARY KEY (`basket_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of basket
-- ----------------------------
INSERT INTO `basket` VALUES ('6', '3', '0', '100', '123000.54');
INSERT INTO `basket` VALUES ('7', '3', '1', '100', '123000.54');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_time` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `comment_content` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '2022-02-29', '5', '这里的衣服太好看了，下次再也不来这里买了');
INSERT INTO `comment` VALUES ('5', '2022-02-29', '5', '这里的衣服太好丑了，下次再来这里买了');
INSERT INTO `comment` VALUES ('6', '2022-02-29', '5', '这里的衣服太好丑了，下次再来这里买了');
INSERT INTO `comment` VALUES ('7', '2022-02-29', '5', '这里的衣服太好丑了，下次再来这里买了');

-- ----------------------------
-- Table structure for `feedback`
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `feedback_name` varchar(62) COLLATE utf8_unicode_ci DEFAULT NULL,
  `feedback_email` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `feedback_phone` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `feedback_content` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('2', '二郎神', '110119120114@163.com', '6641110', '这里的衣服太好丑了，下次还来这里买');
INSERT INTO `feedback` VALUES ('3', '123', '123', '121', ' asdsadasdasdaasd');
INSERT INTO `feedback` VALUES ('4', '11111', '1111', '1111', ' 1111111');
INSERT INTO `feedback` VALUES ('5', 'he', '873052025', '18170148036', ' heiheihei');

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_type` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_number` int(11) DEFAULT NULL,
  `goods_business` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_sale_price` float(48,2) DEFAULT NULL,
  `goods_store_price` float(48,2) DEFAULT NULL,
  `goods_buy_count` int(11) DEFAULT NULL,
  `goods_img` varchar(48) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goods_content` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('2', 'ApronDress', '豹女1', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pr1.jpg', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('3', 'ApronDress', '豹女2', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pr2.jpg', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('4', 'ApronDress', '豹女3', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pr3.jpg', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('5', 'ApronDress', '豹女4', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pr2.jpg', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('6', 'ApronDress', '豹女5', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pi5.png', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('7', 'ApronDress', '豹女6', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pi6.png', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('8', 'ApronDress', '豹女7', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pi7.png', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('9', 'ApronDress', '豹女8', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pi1.png', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('10', 'ApronDress', '豹女9', '666', 'ggg服装厂', '456.75', '100.00', '300', 'pi2.png', 'hsadsshrhsghae');
INSERT INTO `goods` VALUES ('13', '休闲', '清纯休闲', '100', 'ggg', '9999.99', '99.99', '0', '12.jpg', 'hehehehhehehhe');
INSERT INTO `goods` VALUES ('14', 'ApronDress', 'ggg', '342', 'dfshg', '32222.00', '23342.00', '0', 'pr1.jpg', 'erggg');
INSERT INTO `goods` VALUES ('15', '丝袜', 'eedgf', '35', 'gshsh', '353.00', '353.00', '0', 'pr3.jpg', 'ng');

-- ----------------------------
-- Table structure for `goods_type`
-- ----------------------------
DROP TABLE IF EXISTS `goods_type`;
CREATE TABLE `goods_type` (
  `goods_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `goods_img` varchar(48) COLLATE utf8_unicode_ci NOT NULL,
  `goods_sex` int(8) NOT NULL,
  PRIMARY KEY (`goods_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO `goods_type` VALUES ('1', '男装', '10.jpg', '1');
INSERT INTO `goods_type` VALUES ('3', '丝袜', '13.jpg', '0');
INSERT INTO `goods_type` VALUES ('4', 'ApronDress', '12.jpg', '0');
INSERT INTO `goods_type` VALUES ('5', '休闲', '14.jpg', '1');
INSERT INTO `goods_type` VALUES ('9', '西装', '14.jpg', '1');
INSERT INTO `goods_type` VALUES ('10', '晚礼服', '6.jpg', '0');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(16) DEFAULT NULL,
  `order_number` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_item` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_time` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_price` float(100,0) DEFAULT NULL,
  `order_address` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_phone` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `order_state` int(8) DEFAULT NULL,
  `order_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('4', '3', '1469444099774', '豹女', '2016-07-25', '457', '423', '110', 'haha', '1', '1');
INSERT INTO `orders` VALUES ('5', '3', '1469444099774', '豹女', '2016-07-25', '457', '423', '110', 'haha', '1', '1');
INSERT INTO `orders` VALUES ('6', '3', '1469444099774', '豹女', '2016-07-25', '457', '423', '110', 'haha', '1', '1');
INSERT INTO `orders` VALUES ('7', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('8', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('9', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('10', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('11', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('12', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('13', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');
INSERT INTO `orders` VALUES ('14', '3', '1469503010811', '豹女', '2016-07-26', '457', '423', '110', 'heiheihei', '0', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_login_name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_login_pwd` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_name` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_sex` int(8) DEFAULT NULL,
  `user_address` varchar(108) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_phone` varchar(13) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_email` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'he', '123456', 'heiheihei', '0', '423', '110', '110112119120@163.com');
INSERT INTO `user` VALUES ('4', '1111', '11111', '1111', '0', 'null', 'null', '111');
INSERT INTO `user` VALUES ('5', '11111', '11111', '11111', '0', 'rrrr', 'fff', 'er');

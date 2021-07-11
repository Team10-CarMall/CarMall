/*
Navicat MySQL Data Transfer

Source Server         : VM_linux
Source Server Version : 80025
Source Host           : 192.168.174.128:3306
Source Database       : CarMall

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-07-11 15:48:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货人姓名',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收货人联系电话',
  `addr` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址名称',
  `user_id` char(9) DEFAULT NULL COMMENT '用户id  user+10000 递增',
  `state` tinyint(1) DEFAULT NULL COMMENT '用于判断当前地址是否有效，1有效，0无效',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `update_time` char(19) DEFAULT NULL,
  `version` smallint DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_userId` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_dic_sub_type
-- ----------------------------
DROP TABLE IF EXISTS `t_dic_sub_type`;
CREATE TABLE `t_dic_sub_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `text` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品二级分类的中文描述',
  `value` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品二级分类的值',
  `order` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用于排序',
  `parent_id` int DEFAULT NULL COMMENT '父类型的id值',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否启用 1启用，0禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `t_dic_type`;
CREATE TABLE `t_dic_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '父类型主键',
  `text` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品类型的中文描述',
  `value` char(2) DEFAULT NULL COMMENT '商品类型的值',
  `order` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用于排序',
  `enable` tinyint(1) DEFAULT '1' COMMENT '是否启用，1启用，0禁用',
  `colType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '字段的类型',
  `picUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类的图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `goods_id` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品id goods+10000 自增',
  `goods_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品的描述信息',
  `pic_url1` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片1',
  `pic_url2` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片2',
  `union_id` int DEFAULT NULL COMMENT '商品的集合id，将不同规格的商品联系起来',
  `stock` int DEFAULT NULL COMMENT '库存数',
  `color` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品颜色,文字描述',
  `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品状态，0表示下架了，1表示可以购买,  2表示售罄了',
  `sale_num` int DEFAULT NULL COMMENT '该款商品的销售数量',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品创建时间',
  `edit_time` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改时间',
  `version` smallint DEFAULT '1',
  `user_id` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户的id user+10000',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_createTime` (`create_time`),
  KEY `idx_userId` (`user_id`),
  KEY `idx_goodsId` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_goods_union
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_union`;
CREATE TABLE `t_goods_union` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '集合创建的时间',
  `sub_type_id` int DEFAULT NULL COMMENT '所属的分类下的二级分类id',
  `edit_time` char(19) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL COMMENT '用于判断当前商品集合是否还在，1表示使用，0表示不使用',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_subTypeId` (`sub_type_id`),
  KEY `idx_createTime` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_log_controller
-- ----------------------------
DROP TABLE IF EXISTS `t_log_controller`;
CREATE TABLE `t_log_controller` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `controller` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '调用的接口路径',
  `create_time` char(19) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '最近修改时间',
  `user_id` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '什么用户产生的',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_userId` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_log_exception
-- ----------------------------
DROP TABLE IF EXISTS `t_log_exception`;
CREATE TABLE `t_log_exception` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '异常内容描述',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '异常发生的时间',
  `user_id` char(9) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '什么用户产生的',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_userId` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_id` char(17) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单id，3位随机数+当前时间',
  `num` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '购买数量',
  `price` decimal(10,0) DEFAULT NULL COMMENT '订单总价',
  `express_fee` decimal(7,0) DEFAULT NULL COMMENT '快递费',
  `goods_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品id：goods+10000递增',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `address_id` int DEFAULT NULL COMMENT '收获地址',
  `state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单状态，0未付款，1已付款，2表示未发货，3表示已发货，4表示已完成',
  `create_time` char(19) DEFAULT NULL,
  `edit_time` char(19) DEFAULT NULL,
  `version` smallint DEFAULT '1',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价格',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_createTime` (`create_time`),
  KEY `idx_userId` (`user_id`),
  KEY `idx_orderId` (`order_id`) USING BTREE,
  KEY `idx_goodsId` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'user+10000递增',
  `username` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码，md5加密的32位',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户个人描述',
  `pic_url` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户头像的url地址',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账号的创建时间',
  `edit_time` char(19) DEFAULT NULL,
  `version` smallint DEFAULT '1',
  `state` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '保留字段，用于判断当前用户的状态，0表示账号异常，1表示账号正常，2表示账号有风险',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_userId` (`user_id`) USING BTREE,
  KEY `idx_createTime` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for t_user_collection
-- ----------------------------
DROP TABLE IF EXISTS `t_user_collection`;
CREATE TABLE `t_user_collection` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` char(9) DEFAULT NULL COMMENT '用户id',
  `goods_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品id',
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收藏时间',
  `edit_time` char(19) DEFAULT NULL,
  `version` smallint DEFAULT NULL,
  `state` tinyint(1) DEFAULT '1' COMMENT '1表示收藏，0表示取消收藏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

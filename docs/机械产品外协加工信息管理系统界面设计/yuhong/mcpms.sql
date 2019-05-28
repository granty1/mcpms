/*
Navicat MySQL Data Transfer

Source Server         : zyh-mysqlconnect
Source Server Version : 50515
Source Host           : localhost:3308
Source Database       : mcpms

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-02-01 20:18:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_mode
-- ----------------------------
DROP TABLE IF EXISTS `m_mode`;
CREATE TABLE `m_mode` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `way` varchar(255) DEFAULT NULL COMMENT '加工方式',
  `order` int(8) DEFAULT NULL COMMENT '显示序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加工方式表';

-- ----------------------------
-- Records of m_mode
-- ----------------------------
INSERT INTO `m_mode` VALUES ('1', '火焰下料', '1');

-- ----------------------------
-- Table structure for m_order
-- ----------------------------
DROP TABLE IF EXISTS `m_order`;
CREATE TABLE `m_order` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_num` varchar(255) NOT NULL COMMENT '订单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `linkman` varchar(255) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `sign_time` varchar(255) DEFAULT NULL COMMENT '签订时间',
  `deliver_time` varchar(255) DEFAULT NULL COMMENT '交货时间',
  `deliver_address` varchar(255) DEFAULT NULL COMMENT '交货地址',
  `price` double(10,2) DEFAULT NULL COMMENT '总价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of m_order
-- ----------------------------

-- ----------------------------
-- Table structure for m_order_product
-- ----------------------------
DROP TABLE IF EXISTS `m_order_product`;
CREATE TABLE `m_order_product` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_id` bigint(15) NOT NULL COMMENT '订单id',
  `product_id` bigint(15) NOT NULL COMMENT '产品id',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_order_id` (`order_id`),
  KEY `fk_product_id` (`product_id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `m_product` (`id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `m_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单产品表';

-- ----------------------------
-- Records of m_order_product
-- ----------------------------

-- ----------------------------
-- Table structure for m_order_product_part
-- ----------------------------
DROP TABLE IF EXISTS `m_order_product_part`;
CREATE TABLE `m_order_product_part` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `part_process _id` bigint(15) NOT NULL COMMENT '订单产品ID',
  `part_id` bigint(15) NOT NULL COMMENT '零件ID',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_part_process _id` (`part_process _id`),
  KEY `fk_part_id` (`part_id`),
  CONSTRAINT `fk_part_id` FOREIGN KEY (`part_id`) REFERENCES `m_part` (`id`),
  CONSTRAINT `fk_part_process _id` FOREIGN KEY (`part_process _id`) REFERENCES `m_part_process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单产品零件表';

-- ----------------------------
-- Records of m_order_product_part
-- ----------------------------

-- ----------------------------
-- Table structure for m_out
-- ----------------------------
DROP TABLE IF EXISTS `m_out`;
CREATE TABLE `m_out` (
  `id` bigint(15) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '单位名称',
  `person` varchar(255) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外协单位表';

-- ----------------------------
-- Records of m_out
-- ----------------------------

-- ----------------------------
-- Table structure for m_part
-- ----------------------------
DROP TABLE IF EXISTS `m_part`;
CREATE TABLE `m_part` (
  `id` bigint(15) NOT NULL,
  `part_num` varchar(255) NOT NULL COMMENT '零件编号',
  `name` varchar(255) DEFAULT NULL COMMENT '零件名称',
  `drawing_num` varchar(255) DEFAULT NULL COMMENT '零件图号',
  `unit` varchar(10) DEFAULT NULL COMMENT '单位',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件表';

-- ----------------------------
-- Records of m_part
-- ----------------------------
INSERT INTO `m_part` VALUES ('1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for m_part_plan
-- ----------------------------
DROP TABLE IF EXISTS `m_part_plan`;
CREATE TABLE `m_part_plan` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件id',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `mode_id` bigint(15) NOT NULL COMMENT '加工方式id',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位id',
  `plan_time` varchar(255) DEFAULT NULL COMMENT '计划完成时间',
  `actual_time` varchar(255) DEFAULT NULL COMMENT '实际完成时间',
  `in_time` varchar(255) DEFAULT NULL COMMENT '实际入库时间',
  `is_insert` int(2) DEFAULT NULL COMMENT '是否插单',
  `text` varchar(255) DEFAULT NULL COMMENT '工序计划摘要',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `producer` varchar(255) DEFAULT NULL COMMENT '制作人',
  `create_time` varchar(255) DEFAULT NULL COMMENT '制作时间',
  `approve_status` int(2) DEFAULT NULL COMMENT '审批状态',
  `approve_people` varchar(255) DEFAULT NULL COMMENT '审批人',
  `approve_time` varchar(255) DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`),
  KEY `mode_id` (`mode_id`),
  KEY `order_product_part_id` (`order_product_part_id`),
  KEY `out_id` (`out_id`),
  CONSTRAINT `m_part_plan_ibfk_4` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_part_plan_ibfk_1` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`),
  CONSTRAINT `m_part_plan_ibfk_3` FOREIGN KEY (`order_product_part_id`) REFERENCES `m_product_part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件计划表';

-- ----------------------------
-- Records of m_part_plan
-- ----------------------------

-- ----------------------------
-- Table structure for m_part_process
-- ----------------------------
DROP TABLE IF EXISTS `m_part_process`;
CREATE TABLE `m_part_process` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `parts_id` bigint(15) NOT NULL COMMENT '零件id',
  `process_id` bigint(15) NOT NULL COMMENT '工序id',
  `way` varchar(255) DEFAULT NULL COMMENT '加工方式',
  `day` int(8) DEFAULT NULL COMMENT '加工天数',
  `drawing_num` varchar(255) DEFAULT NULL COMMENT '工序图号',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `parts_id` (`parts_id`),
  KEY `process_id` (`process_id`),
  KEY `out_id` (`out_id`),
  CONSTRAINT `m_part_process_ibfk_3` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_part_process_ibfk_1` FOREIGN KEY (`parts_id`) REFERENCES `m_part` (`id`),
  CONSTRAINT `m_part_process_ibfk_2` FOREIGN KEY (`process_id`) REFERENCES `m_process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件工序表';

-- ----------------------------
-- Records of m_part_process
-- ----------------------------

-- ----------------------------
-- Table structure for m_part_process_plan
-- ----------------------------
DROP TABLE IF EXISTS `m_part_process_plan`;
CREATE TABLE `m_part_process_plan` (
  `id` bigint(15) NOT NULL,
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件id',
  `part_process_plan_id` bigint(15) NOT NULL COMMENT '零件工序',
  `mode_id` bigint(255) NOT NULL COMMENT '加工方式',
  `day` int(8) DEFAULT NULL COMMENT '加工天数',
  `plan_time` varchar(255) DEFAULT NULL COMMENT '计划完成时间',
  `actual_time` varchar(255) DEFAULT NULL COMMENT '实际完成时间',
  `in_time` varchar(255) DEFAULT NULL COMMENT '实际入库时间',
  `drawing_num` varchar(255) DEFAULT NULL COMMENT '零件图号',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位id',
  `out_time` varchar(255) DEFAULT NULL COMMENT '外转时间',
  `deliver_time` varchar(255) DEFAULT NULL COMMENT '交货时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `approve_status` int(2) DEFAULT NULL COMMENT '审批状态',
  `approve_people` varchar(255) DEFAULT NULL COMMENT '审批人',
  `approve_time` varchar(255) DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`),
  KEY `order_product_part_id` (`order_product_part_id`),
  KEY `part_process_plan_id` (`part_process_plan_id`),
  KEY `mode_id` (`mode_id`),
  KEY `out_id` (`out_id`),
  CONSTRAINT `m_part_process_plan_ibfk_4` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_part_process_plan_ibfk_1` FOREIGN KEY (`order_product_part_id`) REFERENCES `m_order_product_part` (`id`),
  CONSTRAINT `m_part_process_plan_ibfk_2` FOREIGN KEY (`part_process_plan_id`) REFERENCES `m_part_process_plan` (`id`),
  CONSTRAINT `m_part_process_plan_ibfk_3` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件工序计划表';

-- ----------------------------
-- Records of m_part_process_plan
-- ----------------------------

-- ----------------------------
-- Table structure for m_process
-- ----------------------------
DROP TABLE IF EXISTS `m_process`;
CREATE TABLE `m_process` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '工序名称',
  `order` int(8) DEFAULT NULL COMMENT '显示序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工序表';

-- ----------------------------
-- Records of m_process
-- ----------------------------

-- ----------------------------
-- Table structure for m_product
-- ----------------------------
DROP TABLE IF EXISTS `m_product`;
CREATE TABLE `m_product` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `type` varchar(255) DEFAULT NULL COMMENT '产品型号',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品表';

-- ----------------------------
-- Records of m_product
-- ----------------------------
INSERT INTO `m_product` VALUES ('1', '产品1', '1', '1');

-- ----------------------------
-- Table structure for m_product_part
-- ----------------------------
DROP TABLE IF EXISTS `m_product_part`;
CREATE TABLE `m_product_part` (
  `id` bigint(15) NOT NULL,
  `product_id` bigint(15) NOT NULL COMMENT '产品id',
  `part_id` bigint(15) NOT NULL COMMENT '零件id',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`),
  KEY `wj_1` (`part_id`) USING BTREE,
  KEY `m_product_part_ibfk_1` (`product_id`),
  CONSTRAINT `m_product_part_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `m_product` (`id`),
  CONSTRAINT `m_product_part_ibfk_2` FOREIGN KEY (`part_id`) REFERENCES `m_part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品零件表';

-- ----------------------------
-- Records of m_product_part
-- ----------------------------
INSERT INTO `m_product_part` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for m_product_part_outprocess
-- ----------------------------
DROP TABLE IF EXISTS `m_product_part_outprocess`;
CREATE TABLE `m_product_part_outprocess` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件ID',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `mode_id` bigint(15) DEFAULT NULL COMMENT '加工方式id',
  `part_process_id` bigint(15) DEFAULT NULL COMMENT '零件工序id',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位id',
  `out_time` varchar(255) DEFAULT NULL COMMENT '外转时间',
  `deliver_time` varchar(255) DEFAULT NULL COMMENT '交货时间',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `linkman` varchar(255) DEFAULT NULL COMMENT '联系人',
  `tel` varchar(255) DEFAULT NULL COMMENT '联系电话',
  PRIMARY KEY (`id`),
  KEY `order_product_part_id` (`order_product_part_id`),
  KEY `mode_id` (`mode_id`),
  KEY `part_process_id` (`part_process_id`),
  KEY `m_product_part_outprocess_ibfk_4` (`out_id`),
  CONSTRAINT `m_product_part_outprocess_ibfk_4` FOREIGN KEY (`out_id`) REFERENCES `m_mode` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_product_part_outprocess_ibfk_1` FOREIGN KEY (`order_product_part_id`) REFERENCES `m_order_product_part` (`id`),
  CONSTRAINT `m_product_part_outprocess_ibfk_2` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`),
  CONSTRAINT `m_product_part_outprocess_ibfk_3` FOREIGN KEY (`part_process_id`) REFERENCES `m_part_process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品零件外协加工表';

-- ----------------------------
-- Records of m_product_part_outprocess
-- ----------------------------

-- ----------------------------
-- Table structure for m_product_part_repertory
-- ----------------------------
DROP TABLE IF EXISTS `m_product_part_repertory`;
CREATE TABLE `m_product_part_repertory` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件ID',
  `part_id` bigint(15) NOT NULL COMMENT '零件ID',
  `cinvcode` varchar(255) DEFAULT NULL COMMENT '存货编码',
  `num` int(2) DEFAULT NULL COMMENT '数量',
  `price` double(10,2) DEFAULT NULL COMMENT '单价',
  `re_time` varchar(255) DEFAULT NULL COMMENT '出库时间	',
  `in_time` varchar(255) DEFAULT NULL COMMENT '入库时间',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `mode_id` bigint(15) DEFAULT NULL COMMENT '加工方式ID',
  `part_process_id` bigint(15) DEFAULT NULL COMMENT '零件工序ID',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位ID',
  PRIMARY KEY (`id`),
  KEY `order_product_part_id` (`order_product_part_id`),
  KEY `part_id` (`part_id`),
  KEY `mode_id` (`mode_id`),
  KEY `part_process_id` (`part_process_id`),
  KEY `out_id` (`out_id`),
  CONSTRAINT `m_product_part_repertory_ibfk_5` FOREIGN KEY (`out_id`) REFERENCES `m_mode` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_product_part_repertory_ibfk_1` FOREIGN KEY (`order_product_part_id`) REFERENCES `m_order_product_part` (`id`),
  CONSTRAINT `m_product_part_repertory_ibfk_2` FOREIGN KEY (`part_id`) REFERENCES `m_part` (`id`),
  CONSTRAINT `m_product_part_repertory_ibfk_3` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`),
  CONSTRAINT `m_product_part_repertory_ibfk_4` FOREIGN KEY (`part_process_id`) REFERENCES `m_part_process` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品零件库存表';

-- ----------------------------
-- Records of m_product_part_repertory
-- ----------------------------

-- ----------------------------
-- Table structure for m_status
-- ----------------------------
DROP TABLE IF EXISTS `m_status`;
CREATE TABLE `m_status` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `type` int(2) DEFAULT NULL COMMENT '状态类型',
  `num` int(2) DEFAULT NULL COMMENT '状态值',
  `name` varchar(20) DEFAULT NULL COMMENT '状态名称',
  `order` int(8) DEFAULT NULL COMMENT '显示序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='状态表';

-- ----------------------------
-- Records of m_status
-- ----------------------------

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `time` varchar(255) DEFAULT NULL COMMENT '登陆时间',
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of m_user
-- ----------------------------

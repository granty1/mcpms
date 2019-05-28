/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : mcpms

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-03-30 12:45:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for m_mode
-- ----------------------------
DROP TABLE IF EXISTS `m_mode`;
CREATE TABLE `m_mode` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `way` varchar(255) DEFAULT NULL COMMENT '加工方式',
  `sort` int(8) DEFAULT NULL COMMENT '显示序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加工方式表';

-- ----------------------------
-- Records of m_mode
-- ----------------------------
INSERT INTO `m_mode` VALUES ('1', '自加工', '1');
INSERT INTO `m_mode` VALUES ('2', '自下料外协加工', '2');
INSERT INTO `m_mode` VALUES ('3', '外协加工', '3');
INSERT INTO `m_mode` VALUES ('4', '外购', '4');

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
  `price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of m_order
-- ----------------------------
INSERT INTO `m_order` VALUES ('155392105775297', '1', '1', '1', null, '1', '2019-03-30', '2019-03-30', '1', '150000.00', null, '51');

-- ----------------------------
-- Table structure for m_order_product
-- ----------------------------
DROP TABLE IF EXISTS `m_order_product`;
CREATE TABLE `m_order_product` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_id` bigint(15) NOT NULL COMMENT '订单id',
  `product_id` bigint(15) NOT NULL COMMENT '产品id',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_order_id` (`order_id`),
  KEY `fk_product_id` (`product_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `m_order` (`id`),
  CONSTRAINT `fk_product_id` FOREIGN KEY (`product_id`) REFERENCES `m_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单产品表';

-- ----------------------------
-- Records of m_order_product
-- ----------------------------
INSERT INTO `m_order_product` VALUES ('155392109436010', '155392105775297', '155041063214986', '15', '10000.00', null);

-- ----------------------------
-- Table structure for m_order_product_part
-- ----------------------------
DROP TABLE IF EXISTS `m_order_product_part`;
CREATE TABLE `m_order_product_part` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_product_id` bigint(15) NOT NULL COMMENT '订单产品ID',
  `part_id` bigint(15) NOT NULL COMMENT '零件ID',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `fk_part_process _id` (`order_product_id`),
  KEY `fk_part_id` (`part_id`),
  CONSTRAINT `fk_part_id` FOREIGN KEY (`part_id`) REFERENCES `m_part` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单产品零件表';

-- ----------------------------
-- Records of m_order_product_part
-- ----------------------------
INSERT INTO `m_order_product_part` VALUES ('155392109436230', '155392109436010', '1', '15', null);
INSERT INTO `m_order_product_part` VALUES ('155392109438584', '155392109436010', '155041024899885', '15', null);

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
INSERT INTO `m_out` VALUES ('123456789', '云彩', '云彩', '212345678', '连云港市新东街道');
INSERT INTO `m_out` VALUES ('155038149848602', '云亨', '张云亨', '1234567891', '连云港');
INSERT INTO `m_out` VALUES ('155106913921497', '卯', '张云', '185533625623', '墟沟59号');

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
INSERT INTO `m_part` VALUES ('1', '2050500042', '右墙板-打孔图', 'GTSG3-XGJ-180-01-01-01A', '件', '');
INSERT INTO `m_part` VALUES ('155037862680753', '20702006755', '机架支撑梁', 'GTSG3-180-0104A', '件', '');
INSERT INTO `m_part` VALUES ('155040976679617', '2010400051', '换辊臂支轴挡圈', 'GTSG3-180-0123', '件', '');
INSERT INTO `m_part` VALUES ('155040977284618', '546645', '复合', 'GTSG3-220-03-04', '件', '');
INSERT INTO `m_part` VALUES ('155041024899885', '2020300400', '螺母叉杆', 'GTSG3-XGJ-180-03-08', '件', '');
INSERT INTO `m_part` VALUES ('155118115153063', '1233', '4', 'd2333333', '23', '4234');

-- ----------------------------
-- Table structure for m_part_process
-- ----------------------------
DROP TABLE IF EXISTS `m_part_process`;
CREATE TABLE `m_part_process` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `parts_id` bigint(15) NOT NULL COMMENT '零件id',
  `process_id` bigint(15) NOT NULL COMMENT '工序id',
  `mode_id` bigint(15) DEFAULT NULL,
  `day` int(8) DEFAULT NULL COMMENT '加工天数',
  `drawing_num` varchar(255) DEFAULT NULL COMMENT '工序图号',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `parts_id` (`parts_id`),
  KEY `process_id` (`process_id`),
  KEY `out_id` (`out_id`),
  CONSTRAINT `m_part_process_ibfk_1` FOREIGN KEY (`parts_id`) REFERENCES `m_part` (`id`),
  CONSTRAINT `m_part_process_ibfk_2` FOREIGN KEY (`process_id`) REFERENCES `m_process` (`id`),
  CONSTRAINT `m_part_process_ibfk_3` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件工序表';

-- ----------------------------
-- Records of m_part_process
-- ----------------------------
INSERT INTO `m_part_process` VALUES ('155392092393346', '1', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392093866004', '1', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392095991642', '155037862680753', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392095991771', '155037862680753', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392096544686', '155040976679617', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392096544779', '155040976679617', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392097126852', '155040977284618', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392097126945', '155040977284618', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392097686763', '155041024899885', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392097686818', '155041024899885', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392098457727', '155118115153063', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392098457766', '155118115153063', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);

-- ----------------------------
-- Table structure for m_plan_warning
-- ----------------------------
DROP TABLE IF EXISTS `m_plan_warning`;
CREATE TABLE `m_plan_warning` (
  `id` bigint(15) NOT NULL,
  `type` int(2) DEFAULT NULL,
  `expediting_time` varchar(255) DEFAULT NULL,
  `expediting_num` int(11) DEFAULT NULL,
  `day` varchar(255) DEFAULT NULL,
  `order_product_part_id` bigint(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_plan_warning
-- ----------------------------

-- ----------------------------
-- Table structure for m_process
-- ----------------------------
DROP TABLE IF EXISTS `m_process`;
CREATE TABLE `m_process` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT NULL COMMENT '工序名称',
  `sort` int(8) DEFAULT NULL COMMENT '显示序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工序表';

-- ----------------------------
-- Records of m_process
-- ----------------------------
INSERT INTO `m_process` VALUES ('155040894345591', '铣床', '6');
INSERT INTO `m_process` VALUES ('155040897021836', '小件', '7');
INSERT INTO `m_process` VALUES ('155040900379702', '自下料外协', '8');
INSERT INTO `m_process` VALUES ('155040901758734', '电镀/发黑', '9');
INSERT INTO `m_process` VALUES ('155047852007494', '锯床下料', '2');
INSERT INTO `m_process` VALUES ('155047852644168', '剪板下料', '3');
INSERT INTO `m_process` VALUES ('155047853376710', '焊接', '4');
INSERT INTO `m_process` VALUES ('155047853863695', '车床', '5');
INSERT INTO `m_process` VALUES ('155106916450396', '火焰下料', '1');

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
INSERT INTO `m_product` VALUES ('1', '180新超纤革机', '1801', '爆款');
INSERT INTO `m_product` VALUES ('155041063214986', '220超纤维机', '220', null);

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
INSERT INTO `m_product_part` VALUES ('155392081882437', '1', '1', '1');
INSERT INTO `m_product_part` VALUES ('155392081882614', '1', '155037862680753', '1');
INSERT INTO `m_product_part` VALUES ('155392081882869', '1', '155040976679617', '1');
INSERT INTO `m_product_part` VALUES ('155392081883022', '1', '155040977284618', '1');
INSERT INTO `m_product_part` VALUES ('155392082567448', '155041063214986', '1', '1');
INSERT INTO `m_product_part` VALUES ('155392082567691', '155041063214986', '155041024899885', '1');

-- ----------------------------
-- Table structure for m_product_part_outprocess
-- ----------------------------
DROP TABLE IF EXISTS `m_product_part_outprocess`;
CREATE TABLE `m_product_part_outprocess` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件ID',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
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
  CONSTRAINT `m_product_part_outprocess_ibfk_2` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`),
  CONSTRAINT `m_product_part_outprocess_ibfk_3` FOREIGN KEY (`part_process_id`) REFERENCES `m_part_process` (`id`),
  CONSTRAINT `m_product_part_outprocess_ibfk_4` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品零件外协加工表';

-- ----------------------------
-- Records of m_product_part_outprocess
-- ----------------------------
INSERT INTO `m_product_part_outprocess` VALUES ('155392109437728', '155392109436230', '15', '1000.00', '2', '155392092393346', '155038149848602', null, null, '31', null, null, null);
INSERT INTO `m_product_part_outprocess` VALUES ('155392109438336', '155392109436230', '15', '23.00', '2', '155392093866004', '123456789', null, null, '31', null, null, null);
INSERT INTO `m_product_part_outprocess` VALUES ('155392109439566', '155392109438584', '15', '1000.00', '2', '155392097686763', '155038149848602', null, null, '31', null, null, null);
INSERT INTO `m_product_part_outprocess` VALUES ('155392109440015', '155392109438584', '15', '23.00', '2', '155392097686818', '123456789', null, null, '31', null, null, null);

-- ----------------------------
-- Table structure for m_product_part_plan
-- ----------------------------
DROP TABLE IF EXISTS `m_product_part_plan`;
CREATE TABLE `m_product_part_plan` (
  `id` bigint(15) NOT NULL COMMENT 'ID',
  `batch` varchar(255) DEFAULT NULL COMMENT '批次',
  `running_num` varchar(255) DEFAULT NULL COMMENT '流水号',
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件id',
  `num` int(8) DEFAULT NULL COMMENT '数量',
  `actual_num` int(8) DEFAULT NULL COMMENT '实际报废数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `mode_id` bigint(15) DEFAULT NULL COMMENT '加工方式id',
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
  KEY `mode_id` (`mode_id`) USING BTREE,
  KEY `out_id` (`out_id`) USING BTREE,
  KEY `m_part_plan_ibfk_3` (`order_product_part_id`) USING BTREE,
  CONSTRAINT `m_part_plan_ibfk_4` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件计划表';

-- ----------------------------
-- Records of m_product_part_plan
-- ----------------------------
INSERT INTO `m_product_part_plan` VALUES ('155392109436360', null, null, '155392109436230', '15', '0', '0.00', null, null, null, null, null, '62', null, '11', '外协管理员老赵', '2019-03-30', '22', null, null);
INSERT INTO `m_product_part_plan` VALUES ('155392109438507', null, null, '155392109438584', '15', '0', '0.00', null, null, null, null, null, '62', null, '11', '外协管理员老赵', '2019-03-30', '22', null, null);

-- ----------------------------
-- Table structure for m_product_part_process_plan
-- ----------------------------
DROP TABLE IF EXISTS `m_product_part_process_plan`;
CREATE TABLE `m_product_part_process_plan` (
  `id` bigint(15) NOT NULL,
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件id',
  `part_process_id` bigint(15) NOT NULL COMMENT '零件工序',
  `mode_id` bigint(255) DEFAULT NULL COMMENT '加工方式',
  `day` int(8) DEFAULT NULL COMMENT '加工天数',
  `plan_time` varchar(255) DEFAULT NULL COMMENT '计划完成时间',
  `actual_time` varchar(255) DEFAULT NULL COMMENT '实际完成时间',
  `in_time` varchar(255) DEFAULT NULL COMMENT '实际入库时间',
  `drawing_num` varchar(255) DEFAULT NULL COMMENT '零件图号',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `out_id` bigint(15) DEFAULT NULL COMMENT '外协单位id',
  `out_time` varchar(255) DEFAULT NULL COMMENT '外转时间',
  `deliver_time` varchar(255) DEFAULT NULL COMMENT '交货时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `approve_status` int(2) DEFAULT NULL COMMENT '审批状态',
  `approve_people` varchar(255) DEFAULT NULL COMMENT '审批人',
  `approve_time` varchar(255) DEFAULT NULL COMMENT '审批时间',
  PRIMARY KEY (`id`),
  KEY `order_product_part_id` (`order_product_part_id`) USING BTREE,
  KEY `mode_id` (`mode_id`) USING BTREE,
  KEY `out_id` (`out_id`) USING BTREE,
  KEY `part_process_id` (`part_process_id`) USING BTREE,
  CONSTRAINT `m_product_part_process_plan_ibfk_5` FOREIGN KEY (`part_process_id`) REFERENCES `m_part_process` (`id`),
  CONSTRAINT `m_product_part_process_plan_ibfk_6` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_product_part_process_plan_ibfk_7` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件工序计划表';

-- ----------------------------
-- Records of m_product_part_process_plan
-- ----------------------------
INSERT INTO `m_product_part_process_plan` VALUES ('155392109436560', '155392109436230', '155392092393346', '2', '4', null, null, null, 'GBBF', '1000.00', '155038149848602', null, null, null, '11', '22', null, null);
INSERT INTO `m_product_part_process_plan` VALUES ('155392109437981', '155392109436230', '155392093866004', '2', '3', null, null, null, 'GDGS', '23.00', '123456789', null, null, null, '11', '22', null, null);
INSERT INTO `m_product_part_process_plan` VALUES ('155392109439010', '155392109438584', '155392097686763', '2', '4', null, null, null, 'GBBF', '1000.00', '155038149848602', null, null, null, '11', '22', null, null);
INSERT INTO `m_product_part_process_plan` VALUES ('155392109439771', '155392109438584', '155392097686818', '2', '3', null, null, null, 'GDGS', '23.00', '123456789', null, null, null, '11', '22', null, null);

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
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
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
  CONSTRAINT `m_product_part_repertory_ibfk_2` FOREIGN KEY (`part_id`) REFERENCES `m_part` (`id`),
  CONSTRAINT `m_product_part_repertory_ibfk_3` FOREIGN KEY (`mode_id`) REFERENCES `m_mode` (`id`),
  CONSTRAINT `m_product_part_repertory_ibfk_4` FOREIGN KEY (`part_process_id`) REFERENCES `m_part_process` (`id`),
  CONSTRAINT `m_product_part_repertory_ibfk_5` FOREIGN KEY (`out_id`) REFERENCES `m_out` (`id`) ON DELETE SET NULL,
  CONSTRAINT `m_product_part_repertory_ibfk_6` FOREIGN KEY (`order_product_part_id`) REFERENCES `m_order_product_part` (`id`)
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
  `type` varchar(255) DEFAULT NULL COMMENT '状态类型',
  `num` int(2) DEFAULT NULL COMMENT '状态值',
  `name` varchar(20) DEFAULT NULL COMMENT '状态名称',
  `sort` int(8) DEFAULT NULL COMMENT '显示序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='状态表';

-- ----------------------------
-- Records of m_status
-- ----------------------------
INSERT INTO `m_status` VALUES ('11', '计划', '11', '未开始', '1');
INSERT INTO `m_status` VALUES ('12', '计划', '12', '执行', '2');
INSERT INTO `m_status` VALUES ('13', '计划', '13', '完成', '3');
INSERT INTO `m_status` VALUES ('14', '计划', '14', '报废', '4');
INSERT INTO `m_status` VALUES ('21', '审批', '21', '未审', '1');
INSERT INTO `m_status` VALUES ('22', '审批', '22', '已审', '3');
INSERT INTO `m_status` VALUES ('23', '审批', '23', '驳回', '2');
INSERT INTO `m_status` VALUES ('24', '审批', '24', '无需审批', '4');
INSERT INTO `m_status` VALUES ('31', '外协', '31', '待出库', '1');
INSERT INTO `m_status` VALUES ('32', '外协', '32', '已出库', '2');
INSERT INTO `m_status` VALUES ('33', '外协', '33', '已入库', '3');
INSERT INTO `m_status` VALUES ('41', '库存', '41', '送外协', '1');
INSERT INTO `m_status` VALUES ('42', '库存', '42', '报废', '2');
INSERT INTO `m_status` VALUES ('43', '库存', '43', '在库', '3');
INSERT INTO `m_status` VALUES ('44', '库存', '44', '出库', '4');
INSERT INTO `m_status` VALUES ('51', '订单', '51', '进行中', '1');
INSERT INTO `m_status` VALUES ('52', '订单', '52', '完成', '2');
INSERT INTO `m_status` VALUES ('53', '订单', '53', '报废', '3');
INSERT INTO `m_status` VALUES ('61', '插单', '61', '是', '1');
INSERT INTO `m_status` VALUES ('62', '插单', '62', '否', '2');
INSERT INTO `m_status` VALUES ('71', 'ROLE_MANAGER_SYSTEM', null, '系统管理员', '1');
INSERT INTO `m_status` VALUES ('72', 'ROLE_MANAGER_OUTSOURCE', null, '外协管理员', '2');
INSERT INTO `m_status` VALUES ('73', 'ROLE_MANAGER_STATISTICS', null, '统计管理员', '3');
INSERT INTO `m_status` VALUES ('74', 'ROLE_PRODUCTION_DIRECTOR', null, '生产厂长', '4');
INSERT INTO `m_status` VALUES ('81', '预警', '81', '计划预警时间', '5');
INSERT INTO `m_status` VALUES ('82', '预警', '82', '工序预警时间', '23');

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
INSERT INTO `m_user` VALUES ('1', 'tj', '96E79218965EB72C92A549DD5A330112', '统计管理员小王', '2019-03-08 16:40:39', 'ROLE_MANAGER_STATISTICS');
INSERT INTO `m_user` VALUES ('2', 'cz', '96E79218965EB72C92A549DD5A330112', '生产厂长小李', '2019-03-04 16:52:15', 'ROLE_PRODUCTION_DIRECTOR');
INSERT INTO `m_user` VALUES ('3', 'wx', '96E79218965EB72C92A549DD5A330112', '外协管理员老赵', '2019-03-30 12:43:22', 'ROLE_MANAGER_OUTSOURCE');
INSERT INTO `m_user` VALUES ('4', 'xt', '96E79218965EB72C92A549DD5A330112', '系统管理员老方', '2019-03-30 12:41:42', 'ROLE_MANAGER_SYSTEM');
INSERT INTO `m_user` VALUES ('155098605816278', 'yinguolin', '96E79218965EB72C92A549DD5A330112', '印国林', '2019-02-27 08:51:38', 'ROLE_MANAGER_SYSTEM');
INSERT INTO `m_user` VALUES ('155098853412641', 'yuhong', '96E79218965EB72C92A549DD5A330112', '张禹鸿', '2019-02-24 14:11:15', 'ROLE_MANAGER_STATISTICS');

-- ----------------------------
-- Table structure for m_warning
-- ----------------------------
DROP TABLE IF EXISTS `m_warning`;
CREATE TABLE `m_warning` (
  `id` bigint(15) NOT NULL,
  `type` int(2) DEFAULT NULL COMMENT '预警种类',
  `expediting_time` varchar(255) DEFAULT NULL COMMENT '最后一次催货时间',
  `expediting_num` int(11) DEFAULT NULL COMMENT '催货次数',
  `order_product_part_id` bigint(15) NOT NULL COMMENT '订单产品零件id',
  `day` int(11) DEFAULT NULL COMMENT '还有多少天到期',
  PRIMARY KEY (`id`),
  KEY `order_product_part_id` (`order_product_part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of m_warning
-- ----------------------------

-- ----------------------------
-- View structure for v_order
-- ----------------------------
DROP VIEW IF EXISTS `v_order`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_order` AS SELECT
m_order.id,
m_order.order_num,
m_order.`name`,
m_order.address,
m_order.linkman,
m_order.tel,
m_order.sign_time,
m_order.deliver_time,
m_order.deliver_address,
m_order.price AS price,
m_order.remarks,
m_status.`name` AS status_name,
m_order.`status`
FROM
m_order
INNER JOIN m_status ON m_status.num = m_order.`status`
ORDER BY
m_status.sort ASC ; ;

-- ----------------------------
-- View structure for v_order_product
-- ----------------------------
DROP VIEW IF EXISTS `v_order_product`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%`  VIEW `v_order_product` AS SELECT
m_order_product.id,
m_order_product.order_id,
m_order_product.product_id,
m_product.`name`,
m_order_product.price,
m_order_product.num,
m_order_product.remarks
FROM
m_order_product
INNER JOIN m_product ON m_order_product.product_id = m_product.id ; ;

-- ----------------------------
-- View structure for v_order_product_part
-- ----------------------------
DROP VIEW IF EXISTS `v_order_product_part`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_order_product_part` AS SELECT
m_order_product_part.id,
m_order_product_part.order_product_id,
m_order_product_part.part_id,
m_order_product_part.num,
m_part.`name` AS part_name,
m_part.drawing_num,
m_part.unit,
m_part.remarks,
m_order.order_num,
m_part.part_num,
m_order_product.product_id
FROM
m_order_product_part
INNER JOIN m_order_product ON m_order_product_part.order_product_id = m_order_product.id
INNER JOIN m_order ON m_order_product.order_id = m_order.id
INNER JOIN m_part ON m_order_product_part.part_id = m_part.id ; ;

-- ----------------------------
-- View structure for v_plan_warning
-- ----------------------------
DROP VIEW IF EXISTS `v_plan_warning`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_plan_warning` AS SELECT
m_plan_warning.id,
m_plan_warning.type,
m_plan_warning.expediting_time,
m_plan_warning.expediting_num,
m_plan_warning.`day`,
m_plan_warning.order_product_part_id
FROM
m_plan_warning ; ;

-- ----------------------------
-- View structure for v_process_plan_warning
-- ----------------------------
DROP VIEW IF EXISTS `v_process_plan_warning`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_process_plan_warning` AS SELECT
m_product_part_process_plan.id,
m_product_part_process_plan.order_product_part_id,
m_product_part_process_plan.part_process_id,
m_product_part_process_plan.mode_id,
m_product_part_process_plan.`day`,
m_product_part_process_plan.plan_time,
m_product_part_process_plan.actual_time,
m_product_part_process_plan.in_time,
m_product_part_process_plan.drawing_num,
m_product_part_process_plan.price,
m_product_part_process_plan.out_id,
m_product_part_process_plan.out_time,
m_product_part_process_plan.deliver_time,
m_product_part_process_plan.remarks,
m_product_part_process_plan.`status`,
m_product_part_process_plan.approve_status,
m_product_part_process_plan.approve_people,
m_product_part_process_plan.approve_time,
m_process.`name` AS process_name,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_process_plan.`status`) AS status_str,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_process_plan.approve_status) AS approve_status_str,
(SELECT m_status.sort FROM m_status WHERE m_status.num = m_product_part_process_plan.`status`) AS status_sort,
(SELECT m_status.sort FROM m_status WHERE m_status.num = m_product_part_process_plan.approve_status) AS approve_status_sort,
(SELECT m_mode.way FROM m_mode WHERE m_mode.id = m_product_part_process_plan.mode_id) AS way,
(SELECT m_out.`name` FROM m_out WHERE m_out.id = m_product_part_process_plan.out_id) AS out_name,
m_part_process.process_id,
m_process.sort AS process_sort,
m_order.order_num,
m_part_process.parts_id,
m_order_product.product_id,
m_part.`name` AS parts_name,
m_product.`name` AS product_name,
m_product_part_plan.num,
m_product_part_plan.`status` AS plan_status,
m_product_part_plan.approve_status AS plan_approve_status,
m_product_part_plan.running_num,
m_product_part_plan.is_insert,
(SELECT m_product_part_repertory.`status` FROM m_product_part_repertory WHERE m_product_part_repertory.order_product_part_id = m_product_part_process_plan.order_product_part_id) AS repertory_status,
m_status.`name` AS is_insert_str
FROM
m_product_part_process_plan
INNER JOIN m_part_process ON m_product_part_process_plan.part_process_id = m_part_process.id
INNER JOIN m_process ON m_part_process.process_id = m_process.id
INNER JOIN m_order_product_part ON m_product_part_process_plan.order_product_part_id = m_order_product_part.id
INNER JOIN m_order_product ON m_order_product_part.order_product_id = m_order_product.id
INNER JOIN m_order ON m_order_product.order_id = m_order.id AND m_order_product.order_id = m_order.id
INNER JOIN m_part ON m_part_process.parts_id = m_part.id
INNER JOIN m_product ON m_order_product.product_id = m_product.id
INNER JOIN m_product_part_plan ON m_product_part_process_plan.order_product_part_id = m_product_part_plan.order_product_part_id
INNER JOIN m_status ON m_product_part_plan.is_insert = m_status.num
ORDER BY
process_sort ASC ; ;

-- ----------------------------
-- View structure for v_product_part
-- ----------------------------
DROP VIEW IF EXISTS `v_product_part`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_product_part` AS SELECT
m_product_part.id,
m_product_part.product_id,
m_product_part.part_id,
m_product_part.num,
m_part.`name`,
m_part.part_num,
m_part.unit
FROM
m_part
INNER JOIN m_product_part ON m_product_part.part_id = m_part.id ; ;

-- ----------------------------
-- View structure for v_product_part_plan
-- ----------------------------
DROP VIEW IF EXISTS `v_product_part_plan`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_product_part_plan` AS SELECT
m_product_part_plan.id,
m_product_part_plan.batch,
m_product_part_plan.running_num,
m_product_part_plan.order_product_part_id,
m_product_part_plan.num,
m_product_part_plan.price,
m_product_part_plan.plan_time,
m_product_part_plan.actual_time,
m_product_part_plan.in_time,
m_product_part_plan.text,
m_product_part_plan.producer,
m_product_part_plan.create_time,
m_product_part_plan.approve_people,
m_product_part_plan.approve_time,
m_order.order_num,
m_order_product_part.part_id,
m_order_product.product_id,
m_part.`name` AS part_name,
m_product.`name` AS product_name,
m_part.drawing_num,
m_part.unit,
m_product_part_plan.is_insert,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_plan.is_insert) AS is_insert_str,
m_product_part_plan.`status`,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_plan.`status`) AS status_str,
m_product_part_plan.approve_status,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_plan.approve_status) AS approve_status_str,
(SELECT m_status.sort FROM m_status WHERE m_status.num = m_product_part_plan.`status`) AS status_sort,
(SELECT m_status.sort FROM m_status WHERE m_status.num = m_product_part_plan.approve_status) AS approve_status_sort,
m_order.id AS order_id,
m_product_part_plan.actual_num
FROM
m_product_part_plan
INNER JOIN m_order_product_part ON m_product_part_plan.order_product_part_id = m_order_product_part.id
INNER JOIN m_order_product ON m_order_product_part.order_product_id = m_order_product.id
INNER JOIN m_order ON m_order_product.order_id = m_order.id
INNER JOIN m_part ON m_order_product_part.part_id = m_part.id
INNER JOIN m_product ON m_order_product.product_id = m_product.id
ORDER BY
approve_status_sort ASC,
status_sort ASC ; ;

-- ----------------------------
-- View structure for v_product_part_process_plan
-- ----------------------------
DROP VIEW IF EXISTS `v_product_part_process_plan`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_product_part_process_plan` AS SELECT
m_product_part_process_plan.id,
m_product_part_process_plan.order_product_part_id,
m_product_part_process_plan.part_process_id,
m_product_part_process_plan.mode_id,
m_product_part_process_plan.`day`,
m_product_part_process_plan.plan_time,
m_product_part_process_plan.actual_time,
m_product_part_process_plan.in_time,
m_product_part_process_plan.drawing_num,
m_product_part_process_plan.price,
m_product_part_process_plan.out_id,
m_product_part_process_plan.out_time,
m_product_part_process_plan.deliver_time,
m_product_part_process_plan.remarks,
m_product_part_process_plan.`status`,
m_product_part_process_plan.approve_status,
m_product_part_process_plan.approve_people,
m_product_part_process_plan.approve_time,
m_process.`name` AS process_name,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_process_plan.`status`) AS status_str,
(SELECT m_status.`name` FROM m_status WHERE m_status.num = m_product_part_process_plan.approve_status) AS approve_status_str,
(SELECT m_status.sort FROM m_status WHERE m_status.num = m_product_part_process_plan.`status`) AS status_sort,
(SELECT m_status.sort FROM m_status WHERE m_status.num = m_product_part_process_plan.approve_status) AS approve_status_sort,
(SELECT m_mode.way FROM m_mode WHERE m_mode.id = m_product_part_process_plan.mode_id) AS way,
(SELECT m_out.`name` FROM m_out WHERE m_out.id = m_product_part_process_plan.out_id) AS out_name,
m_part_process.process_id,
m_process.sort AS process_sort,
m_order.order_num,
m_part_process.parts_id,
m_order_product.product_id,
m_part.`name` AS parts_name,
m_product.`name` AS product_name,
m_product_part_plan.num,
m_product_part_plan.`status` AS plan_status,
m_product_part_plan.approve_status AS plan_approve_status,
m_product_part_plan.running_num,
m_product_part_plan.is_insert,
(SELECT m_product_part_repertory.`status` FROM m_product_part_repertory WHERE m_product_part_repertory.order_product_part_id = m_product_part_process_plan.order_product_part_id) AS repertory_status,
m_status.`name` AS is_insert_str,
m_product_part_plan.actual_num,
m_part.unit
FROM
m_product_part_process_plan
INNER JOIN m_part_process ON m_product_part_process_plan.part_process_id = m_part_process.id
INNER JOIN m_process ON m_part_process.process_id = m_process.id
INNER JOIN m_order_product_part ON m_product_part_process_plan.order_product_part_id = m_order_product_part.id
INNER JOIN m_order_product ON m_order_product_part.order_product_id = m_order_product.id
INNER JOIN m_order ON m_order_product.order_id = m_order.id AND m_order_product.order_id = m_order.id
INNER JOIN m_part ON m_part_process.parts_id = m_part.id
INNER JOIN m_product ON m_order_product.product_id = m_product.id
INNER JOIN m_product_part_plan ON m_product_part_process_plan.order_product_part_id = m_product_part_plan.order_product_part_id
INNER JOIN m_status ON m_product_part_plan.is_insert = m_status.num
ORDER BY
process_sort ASC ; ;

-- ----------------------------
-- View structure for v_user
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_user` AS SELECT
m_user.id,
m_user.username,
m_user.`password`,
m_user.`name`,
m_user.time,
m_user.role,
m_status.`name` AS roleName
FROM
m_user
INNER JOIN m_status ON m_status.type = m_user.role ; ;

-- ----------------------------
-- View structure for v_warning
-- ----------------------------
DROP VIEW IF EXISTS `v_warning`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_warning` AS SELECT
m_part.`name` AS part_name,
m_order.order_num,
m_order.deliver_time,
m_product.`name` AS product_name,
m_product.id AS product_id,
m_part.id AS part_id,
m_warning.id,
m_warning.type,
m_warning.expediting_time,
m_warning.expediting_num,
m_warning.order_product_part_id,
m_warning.`day`,
m_product_part_plan.num,
m_part.drawing_num,
m_product_part_process_plan.part_process_id,
m_product_part_process_plan.mode_id,
m_product_part_process_plan.plan_time,
m_product_part_process_plan.out_id,
m_product_part_process_plan.remarks,
m_product_part_process_plan.`status`,
m_product_part_process_plan.approve_status,
m_product_part_process_plan.approve_people,
m_product_part_process_plan.approve_time,
m_process.`name`,
m_mode.way,
m_product_part_process_plan.price,
m_out.person AS out_person,
m_out.`name` AS out_name,
m_out.tel AS out_tel,
m_out.address AS out_address,
m_product_part_process_plan.out_time,
m_product_part_repertory.`status` AS repertory_status
FROM
m_order_product_part
INNER JOIN m_part ON m_order_product_part.part_id = m_part.id
INNER JOIN m_order_product ON m_order_product_part.order_product_id = m_order_product.id
INNER JOIN m_order ON m_order_product.order_id = m_order.id
INNER JOIN m_product ON m_order_product.product_id = m_product.id
INNER JOIN m_warning ON m_warning.order_product_part_id = m_order_product_part.id
INNER JOIN m_product_part_plan ON m_warning.order_product_part_id = m_product_part_plan.order_product_part_id
INNER JOIN m_product_part_process_plan ON m_warning.order_product_part_id = m_product_part_process_plan.order_product_part_id
INNER JOIN m_part_process ON m_product_part_process_plan.part_process_id = m_part_process.id
INNER JOIN m_process ON m_part_process.process_id = m_process.id
INNER JOIN m_mode ON m_product_part_process_plan.mode_id = m_mode.id
INNER JOIN m_out ON m_product_part_process_plan.out_id = m_out.id
INNER JOIN m_product_part_repertory ON m_product_part_process_plan.order_product_part_id = m_product_part_repertory.order_product_part_id
WHERE
m_product_part_repertory.`status` = 41 and m_product_part_process_plan.`status` = 12
ORDER BY
m_warning.`day` ASC ;

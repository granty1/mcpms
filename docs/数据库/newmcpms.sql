/*
Navicat MySQL Data Transfer

Source Server         : 47.94.254.75
Source Server Version : 50549
Source Host           : 47.94.254.75:3306
Source Database       : newmcpms

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2019-04-20 12:17:57
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
INSERT INTO `m_mode` VALUES ('218', '未编辑', '5');

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
INSERT INTO `m_out` VALUES ('218', '未编辑', '', '', '');
INSERT INTO `m_out` VALUES ('123456789', '云彩', '云彩', '1256558945', null);
INSERT INTO `m_out` VALUES ('155038149848602', '卯', '张云', '185533625623', '墟沟59号');

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
  `spec_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件表';

-- ----------------------------
-- Records of m_part
-- ----------------------------
INSERT INTO `m_part` VALUES ('1', '2050500042', '右墙板-打孔图', 'GTSG3-XGJ-180-01-01-01A', '件', '', '20*213&');
INSERT INTO `m_part` VALUES ('155037862680753', '20702006755', '机架支撑梁', 'GTSG3-180-0104A', '件', '', null);
INSERT INTO `m_part` VALUES ('155040976679617', '2010400051', '换辊臂支轴挡圈', 'GTSG3-180-0123', '件', '', null);
INSERT INTO `m_part` VALUES ('155041024899885', '2020300400', '螺母叉杆', 'GTSG3-XGJ-180-03-08', '件', '', null);
INSERT INTO `m_part` VALUES ('155118115153063', '1233', '零件459012', 'd2333333', '个', '4234', null);
INSERT INTO `m_part` VALUES ('155538642237444', '1277430', '零件1277', null, '件', null, null);
INSERT INTO `m_part` VALUES ('155538643368907', '17621', '零件1762', null, '件', null, null);
INSERT INTO `m_part` VALUES ('155538644266195', '1852', '零件1852', null, '件', null, null);
INSERT INTO `m_part` VALUES ('155567047976108', '1102778845', '鼠标', 'GJJAO', '个', null, '20*781');
INSERT INTO `m_part` VALUES ('155567298597625', '18522', '零件	18522', null, '把', null, null);

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
  KEY `out_id` (`out_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='零件工序表';

-- ----------------------------
-- Records of m_part_process
-- ----------------------------
INSERT INTO `m_part_process` VALUES ('155392092393346', '1', '155040897021836', '2', '1', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392093866004', '1', '155047852007494', '2', '2', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392095991642', '155037862680753', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392095991771', '155037862680753', '155047852007494', '2', '4', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392096544686', '155040976679617', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392096544779', '155040976679617', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392097686763', '155041024899885', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392097686818', '155041024899885', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155392098457727', '155118115153063', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155392098457766', '155118115153063', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155547985895012', '155538643368907', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155547985895134', '155538643368907', '155047852007494', '2', '1', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155549381091854', '155538644266195', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155549381091923', '155538644266195', '155047852007494', '2', '3', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155567069293048', '155538642237444', '155040897021836', '2', '1', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155567069293278', '155538642237444', '155047852007494', '2', '2', 'GDGS', '123456789', '23.00', null);
INSERT INTO `m_part_process` VALUES ('155567069293341', '155538642237444', '155040900379702', null, '5', null, null, '23.20', null);
INSERT INTO `m_part_process` VALUES ('155567071354033', '1', '155047853863695', '3', '6', null, '155038149848602', '32.00', null);
INSERT INTO `m_part_process` VALUES ('155567099101718', '155538644266195', '155106916450396', '3', '6', null, null, '23.00', null);
INSERT INTO `m_part_process` VALUES ('155567101393460', '155538644266195', '155047852644168', '3', '7', null, '123456789', '55.50', null);
INSERT INTO `m_part_process` VALUES ('155567104028761', '155567047976108', '155040897021836', '2', '4', 'GBBF', '155038149848602', '1000.00', null);
INSERT INTO `m_part_process` VALUES ('155567104028847', '155567047976108', '155047852007494', '2', '3', 'GDGS', '123456789', '24.00', null);
INSERT INTO `m_part_process` VALUES ('155567104029056', '155567047976108', '155106916450396', '3', '6', null, null, '23.00', null);
INSERT INTO `m_part_process` VALUES ('155567104029207', '155567047976108', '155047852644168', '3', '7', null, '123456789', '55.50', null);
INSERT INTO `m_part_process` VALUES ('155567197157810', '155567047976108', '155047853863695', '3', '8', null, '155038149848602', '21.00', null);

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
INSERT INTO `m_process` VALUES ('218', '未开始', '1');
INSERT INTO `m_process` VALUES ('219', '已完成', '1');
INSERT INTO `m_process` VALUES ('155040897021836', '小件', '7');
INSERT INTO `m_process` VALUES ('155040900379702', '自下料外协', '8');
INSERT INTO `m_process` VALUES ('155047852007494', '锯床下料', '2');
INSERT INTO `m_process` VALUES ('155047852644168', '剪板下料', '3');
INSERT INTO `m_process` VALUES ('155047853376710', '焊接', '4');
INSERT INTO `m_process` VALUES ('155047853863695', '车床', '5');
INSERT INTO `m_process` VALUES ('155106916450396', '火焰下料', '1');

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
INSERT INTO `m_status` VALUES ('12', '计划', '12', '执行中', '2');
INSERT INTO `m_status` VALUES ('13', '计划', '13', '已完成', '3');
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
INSERT INTO `m_status` VALUES ('81', '预警', '81', '计划预警时间', '6');
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
INSERT INTO `m_user` VALUES ('3', 'wx', '96E79218965EB72C92A549DD5A330112', '外协管理员老赵', '2019-04-20 12:07:53', 'ROLE_MANAGER_OUTSOURCE');
INSERT INTO `m_user` VALUES ('4', 'xt', '96E79218965EB72C92A549DD5A330112', '系统管理员老方', '2019-04-17 13:49:55', 'ROLE_MANAGER_SYSTEM');
INSERT INTO `m_user` VALUES ('155098605816278', 'yinguolin', '96E79218965EB72C92A549DD5A330112', '印国林', '2019-02-27 08:51:38', 'ROLE_MANAGER_SYSTEM');
INSERT INTO `m_user` VALUES ('155098853412641', 'yuhong', '96E79218965EB72C92A549DD5A330112', '张禹鸿', '2019-02-24 14:11:15', 'ROLE_MANAGER_STATISTICS');

-- ----------------------------
-- Table structure for new_m_part_plan
-- ----------------------------
DROP TABLE IF EXISTS `new_m_part_plan`;
CREATE TABLE `new_m_part_plan` (
  `id` bigint(15) NOT NULL,
  `run_num` varchar(255) DEFAULT NULL,
  `part_id` bigint(15) DEFAULT NULL,
  `num` int(8) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `current_process_id` bigint(15) DEFAULT NULL,
  `plan_finish_time` varchar(255) DEFAULT NULL,
  `actual_finish_time` varchar(255) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `plan_status` bigint(15) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `is_warning` bigint(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of new_m_part_plan
-- ----------------------------
INSERT INTO `new_m_part_plan` VALUES ('155573290532055', '20190420120145', '1', '1', null, '218', null, null, null, '11', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573290533653', '20190420120145', '155037862680753', '1', null, '218', null, null, null, '11', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573290535178', '20190420120145', '155040976679617', '1', null, '155047852007494', '2019-05-02', null, null, '12', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573290539848', '20190420120145', '155041024899885', '1', null, '218', null, null, null, '11', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573290541429', '20190420120145', '155118115153063', '1', null, '218', null, null, null, '11', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573290542942', '20190420120145', '155538642237444', '1', null, '218', null, null, null, '11', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573290546139', '20190420120145', '155567047976108', '1', null, '218', '2019-04-30', null, null, '11', '2019-04-20 12:01:45', null);
INSERT INTO `new_m_part_plan` VALUES ('155573293469565', '20190420120214', '155538643368907', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:14', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296816424', '20190420120248', '1', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296827341', '20190420120248', '155037862680753', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296838285', '20190420120248', '155040976679617', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296841444', '20190420120248', '155041024899885', '2', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296842939', '20190420120248', '155538642237444', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296842993', '20190420120248', '155118115153063', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296844529', '20190420120248', '155567047976108', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);
INSERT INTO `new_m_part_plan` VALUES ('155573296844566', '20190420120248', '155538643368907', '1', null, '218', null, null, null, '11', '2019-04-20 12:02:48', null);

-- ----------------------------
-- Table structure for new_m_part_plan_process
-- ----------------------------
DROP TABLE IF EXISTS `new_m_part_plan_process`;
CREATE TABLE `new_m_part_plan_process` (
  `id` bigint(15) NOT NULL,
  `part_plan_id` bigint(15) DEFAULT NULL,
  `part_process_id` bigint(15) DEFAULT NULL,
  `process_mode_id` bigint(15) DEFAULT NULL,
  `part_drawing_num` varchar(255) DEFAULT NULL,
  `turn_out_time` varchar(255) DEFAULT NULL,
  `plan_finish_time` varchar(255) DEFAULT NULL,
  `actual_finish_time` varchar(255) DEFAULT NULL,
  `days` int(8) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `out_id` bigint(15) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `plan_process_status` bigint(15) DEFAULT NULL,
  `do_sort` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of new_m_part_plan_process
-- ----------------------------
INSERT INTO `new_m_part_plan_process` VALUES ('155573290533607', '155573290532055', '155392092393346', '2', 'GBBF', null, '2019-04-22', null, null, '1000.00', '155038149848602', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290533608', '155573290532055', '155567071354033', '3', null, null, null, null, null, '32.00', '155038149848602', null, '11', '3');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290533622', '155573290533653', '155392095991642', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290533693', '155573290532055', '155392093866004', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290535112', '155573290533653', '155392095991771', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290535145', '155573290535178', '155392096544779', '2', 'GDGS', '2019-04-20 12:03:31', '2019-04-22', null, null, '23.00', '123456789', null, '12', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290539807', '155573290535178', '155392096544686', '2', 'GBBF', null, '2019-04-24', null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290541407', '155573290539848', '155392097686763', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290541422', '155573290539848', '155392097686818', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290541438', '155573290541429', '155392098457727', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290541486', '155573290541429', '155392098457766', '2', 'GDGS', null, '2019-05-01', null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290542962', '155573290542942', '155567069293278', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290542973', '155573290542942', '155567069293048', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290544547', '155573290542942', '155567069293341', '218', null, null, null, null, null, '23.20', '218', null, '11', '3');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290546112', '155573290546139', '155567104028847', '2', 'GDGS', null, null, null, null, '24.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290546189', '155573290546139', '155567104028761', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290550726', '155573290546139', '155567104029207', '3', null, null, null, null, null, '55.50', '123456789', null, '11', '4');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290550789', '155573290546139', '155567104029056', '3', null, null, null, null, null, '23.00', '218', null, '11', '3');
INSERT INTO `new_m_part_plan_process` VALUES ('155573290552316', '155573290546139', '155567197157810', '3', null, null, null, null, null, '21.00', '155038149848602', null, '11', '5');
INSERT INTO `new_m_part_plan_process` VALUES ('155573293469561', '155573293469565', '155547985895012', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573293469578', '155573293469565', '155547985895134', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296817995', '155573296816424', '155392092393346', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296821154', '155573296816424', '155392093866004', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296821155', '155573296816424', '155567071354033', '3', null, null, null, null, null, '32.00', '155038149848602', null, '11', '3');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296827303', '155573296827341', '155392095991771', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296827385', '155573296827341', '155392095991642', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296838245', '155573296838285', '155392096544779', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296838253', '155573296838285', '155392096544686', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296842908', '155573296842993', '155392098457727', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296842914', '155573296842993', '155392098457766', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296842922', '155573296842939', '155567069293278', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296842938', '155573296842939', '155567069293048', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296842949', '155573296841444', '155392097686818', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296842955', '155573296841444', '155392097686763', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844503', '155573296844529', '155567104028847', '2', 'GDGS', null, null, null, null, '24.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844515', '155573296844529', '155567104028761', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844526', '155573296844566', '155547985895134', '2', 'GDGS', null, null, null, null, '23.00', '123456789', null, '11', '1');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844538', '155573296844529', '155567104029207', '3', null, null, null, null, null, '55.50', '123456789', null, '11', '4');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844539', '155573296844529', '155567197157810', '3', null, null, null, null, null, '21.00', '155038149848602', null, '11', '5');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844578', '155573296844529', '155567104029056', '3', null, null, null, null, null, '23.00', '218', null, '11', '3');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296844593', '155573296842939', '155567069293341', '218', null, null, null, null, null, '23.20', '218', null, '11', '3');
INSERT INTO `new_m_part_plan_process` VALUES ('155573296846111', '155573296844566', '155547985895012', '2', 'GBBF', null, null, null, null, '1000.00', '155038149848602', null, '11', '2');

-- ----------------------------
-- View structure for v_part_plan
-- ----------------------------
DROP VIEW IF EXISTS `v_part_plan`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_part_plan` AS SELECT
new_m_part_plan.part_id,
m_part.part_num,
m_part.`name` AS part_name,
m_part.drawing_num,
m_part.unit,
new_m_part_plan.id,
new_m_part_plan.run_num,
new_m_part_plan.num,
new_m_part_plan.price,
new_m_part_plan.current_process_id,
new_m_part_plan.plan_finish_time,
new_m_part_plan.actual_finish_time,
new_m_part_plan.remarks,
new_m_part_plan.plan_status,
new_m_part_plan.create_time,
new_m_part_plan.is_warning,
m_process.`name` AS current_process_name,
m_status.`name` AS status_name,
m_part.spec_type
FROM
new_m_part_plan
INNER JOIN m_part ON new_m_part_plan.part_id = m_part.id
INNER JOIN m_process ON new_m_part_plan.current_process_id = m_process.id
INNER JOIN m_status ON new_m_part_plan.plan_status = m_status.id
ORDER BY
new_m_part_plan.plan_status ASC,
new_m_part_plan.create_time ASC ; ;

-- ----------------------------
-- View structure for v_part_plan_process
-- ----------------------------
DROP VIEW IF EXISTS `v_part_plan_process`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER  VIEW `v_part_plan_process` AS SELECT
new_m_part_plan_process.id,
new_m_part_plan_process.part_plan_id,
new_m_part_plan_process.part_process_id,
new_m_part_plan_process.process_mode_id,
new_m_part_plan_process.part_drawing_num,
new_m_part_plan_process.turn_out_time,
new_m_part_plan_process.plan_finish_time,
new_m_part_plan_process.actual_finish_time,
new_m_part_plan_process.days,
new_m_part_plan_process.price,
new_m_part_plan_process.out_id,
new_m_part_plan_process.remarks,
new_m_part_plan_process.plan_process_status,
new_m_part_plan_process.do_sort,
m_part_process.process_id,
m_out.`name` AS out_name,
m_status.`name` AS status_name,
m_process.`name` AS process_name,
m_part.part_num,
m_part.unit,
m_part.spec_type,
new_m_part_plan.num AS num,
m_mode.way
FROM
new_m_part_plan_process
INNER JOIN m_part_process ON new_m_part_plan_process.part_process_id = m_part_process.id
INNER JOIN m_out ON new_m_part_plan_process.out_id = m_out.id
INNER JOIN m_status ON new_m_part_plan_process.plan_process_status = m_status.id
INNER JOIN m_process ON m_part_process.process_id = m_process.id
INNER JOIN m_part ON m_part_process.parts_id = m_part.id
INNER JOIN new_m_part_plan ON new_m_part_plan_process.part_plan_id = new_m_part_plan.id
INNER JOIN m_mode ON m_mode.id = new_m_part_plan_process.process_mode_id
ORDER BY
new_m_part_plan_process.do_sort ASC ; ;

-- ----------------------------
-- View structure for v_user
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_user` AS SELECT
m_user.id,
m_user.username,
m_user.`password`,
m_user.`name`,
m_user.time,
m_user.role,
m_status.`name` AS roleName
FROM
m_user
INNER JOIN m_status ON m_status.type = m_user.role ;

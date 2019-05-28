DROP TABLE IF EXISTS `外协单位`; -- 
CREATE TABLE `外协单位`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  单位名称  VARCHAR(255),--
  联系人  VARCHAR(255),--
  联系电话  VARCHAR(255),--
  地址  VARCHAR(255),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `加工方式`; -- 
CREATE TABLE `加工方式`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  加工方式  VARCHAR(255),--
  显示序号  INT(8),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `加工工序`; -- 
CREATE TABLE `加工工序`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  工序名称  VARCHAR(255),--
  显示序号  INT(8),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `零件`; -- 
CREATE TABLE `零件`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  零件编号  VARCHAR(255),--
  零件名称  VARCHAR(255),--
  零件图号  VARCHAR(255),--
  单位  VARCHAR(255),--
  备注  VARCHAR(255),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `零件工序`; -- 
CREATE TABLE `零件工序`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  零件ID  BIGINT(15),--
  加工工序ID  BIGINT(15),--
  加工方式ID  BIGINT(15),--
  加工天数  INT(8),--
  工序图号  VARCHAR(255),--
  外协单位ID  BIGINT(15),--
  单价  FLOAT(10,2),--
  备注  VARCHAR(255),--
 CONSTRAINT `F_零件工序_零件_ID` FOREIGN KEY (`零件ID`) REFERENCES `零件`(`ID`),
 CONSTRAINT `F_零件工序_加工工序_ID` FOREIGN KEY (`加工工序ID`) REFERENCES `加工工序`(`ID`),
 CONSTRAINT `F_零件工序_加工方式_ID` FOREIGN KEY (`加工方式ID`) REFERENCES `加工方式`(`ID`),
 CONSTRAINT `F_零件工序_外协单位_ID` FOREIGN KEY (`外协单位ID`) REFERENCES `外协单位`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `产品`; -- 
CREATE TABLE `产品`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  产品名称  VARCHAR(255),--
  产品型号  VARCHAR(255),--
  备注  VARCHAR(255),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `产品零件`; -- 
CREATE TABLE `产品零件`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  产品ID  BIGINT(15),--
  零件ID  BIGINT(15),--
  数量  INT(8),--
 CONSTRAINT `F_产品零件_产品_ID` FOREIGN KEY (`产品ID`) REFERENCES `产品`(`ID`),
 CONSTRAINT `F_产品零件_零件_ID` FOREIGN KEY (`零件ID`) REFERENCES `零件`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `订单`; -- 
CREATE TABLE `订单`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  订单编号  VARCHAR(255),--
  客户名称  VARCHAR(255),--
  地址  VARCHAR(255),--
  联系人  VARCHAR(255),--
  联系电话  VARCHAR(255),--
  签订时间  VARCHAR(255),--
  交货时间  VARCHAR(255),--
  交货地址  VARCHAR(255),--
  总价  FLOAT(10,2),--
  状态  INT(2),--
  备注  VARCHAR(255),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `订单产品`; -- 
CREATE TABLE `订单产品`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  订单ID  BIGINT(15),--
  产品ID  BIGINT(15),--
  数量  INT(8),--
  单价  FLOAT(10,2),--
  备注  VARCHAR(255),--
 CONSTRAINT `F_订单产品_订单_ID` FOREIGN KEY (`订单ID`) REFERENCES `订单`(`ID`),
 CONSTRAINT `F_订单产品_产品_ID` FOREIGN KEY (`产品ID`) REFERENCES `产品`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `订单产品零件`; -- 
CREATE TABLE `订单产品零件`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  订单产品ID  BIGINT(15),--
  零件ID  BIGINT(15),--
  数量  INT(8),--
  备注  VARCHAR(255),--
 CONSTRAINT `F_订单产品零件_订单产品_ID` FOREIGN KEY (`订单产品ID`) REFERENCES `订单产品`(`ID`),
 CONSTRAINT `F_订单产品零件_零件_ID` FOREIGN KEY (`零件ID`) REFERENCES `零件`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `产品零件生产计划`; -- 
CREATE TABLE `产品零件生产计划`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  流水号  VARCHAR(255),--
  订单产品零件ID  BIGINT(15),--
  数量  INT(8),--
  单价  FLOAT(10,2),--
  加工方式ID  BIGINT(15),--
  外协单位ID  BIGINT(15),--
  计划完成时间  VARCHAR(255),--
  实际完成时间  VARCHAR(255),--
  实际入库时间  VARCHAR(255),--
  是否插单  INT(2),--
  工序计划摘要  VARCHAR(255),--
  状态  INT(2),--
  制作人  VARCHAR(255),--
  制作时间  VARCHAR(255),--
  审批状态  INT(2),--
  审批人  VARCHAR(255),--
  审批时间  VARCHAR(255),--
 CONSTRAINT `F_产品零件生产计划_订单产品零件_ID` FOREIGN KEY (`订单产品零件ID`) REFERENCES `订单产品零件`(`ID`),
 CONSTRAINT `F_产品零件生产计划_加工方式_ID` FOREIGN KEY (`加工方式ID`) REFERENCES `加工方式`(`ID`),
 CONSTRAINT `F_产品零件生产计划_外协单位_ID` FOREIGN KEY (`外协单位ID`) REFERENCES `外协单位`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `产品零件工序计划`; -- 
CREATE TABLE `产品零件工序计划`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  订单产品零件ID  BIGINT(15),--
  零件工序ID  BIGINT(15),--
  加工方式ID  BIGINT(15),--
  加工天数  INT(8),--
  计划完成时间  VARCHAR(255),--
  实际完成时间  VARCHAR(255),--
  实际入库时间  VARCHAR(255),--
  零件图号  VARCHAR(255),--
  单价  FLOAT(10,2),--
  外协单位ID  BIGINT(15),--
  外转时间  VARCHAR(255),--
  交货时间  VARCHAR(255),--
  备注  VARCHAR(255),--
  状态  INT(2),--
  审批状态  INT(2),--
  审批人  VARCHAR(255),--
  审批时间  VARCHAR(255),--
 CONSTRAINT `F_产品零件工序计划_订单产品零件_ID` FOREIGN KEY (`订单产品零件ID`) REFERENCES `订单产品零件`(`ID`),
 CONSTRAINT `F_产品零件工序计划_零件工序_ID` FOREIGN KEY (`零件工序ID`) REFERENCES `零件工序`(`ID`),
 CONSTRAINT `F_产品零件工序计划_加工方式_ID` FOREIGN KEY (`加工方式ID`) REFERENCES `加工方式`(`ID`),
 CONSTRAINT `F_产品零件工序计划_外协单位_ID` FOREIGN KEY (`外协单位ID`) REFERENCES `外协单位`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `产品零件外协加工`; -- 
CREATE TABLE `产品零件外协加工`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  订单产品零件ID  BIGINT(15),--
  数量  INT(8),--
  单价  FLOAT(10,2),--
  加工方式ID  BIGINT(15),--
  零件工序ID  BIGINT(15),--
  外协单位ID  BIGINT(15),--
  外转时间  VARCHAR(255),--
  交货时间  VARCHAR(255),--
  状态  INT(2),--
  地址  VARCHAR(255),--
  联系人  VARCHAR(255),--
  联系电话  VARCHAR(255),--
 CONSTRAINT `F_产品零件外协加工_订单产品零件_ID` FOREIGN KEY (`订单产品零件ID`) REFERENCES `订单产品零件`(`ID`),
 CONSTRAINT `F_产品零件外协加工_加工方式_ID` FOREIGN KEY (`加工方式ID`) REFERENCES `加工方式`(`ID`),
 CONSTRAINT `F_产品零件外协加工_零件工序_ID` FOREIGN KEY (`零件工序ID`) REFERENCES `零件工序`(`ID`),
 CONSTRAINT `F_产品零件外协加工_外协单位_ID` FOREIGN KEY (`外协单位ID`) REFERENCES `外协单位`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `产品零件库存`; -- 
CREATE TABLE `产品零件库存`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  订单产品零件ID  BIGINT(15),--
  零件ID  BIGINT(15),--
  存货编码  VARCHAR(255),--
  数量  INT(2),--
  单价  FLOAT(10,2),--
  出库时间  VARCHAR(255),--
  入库时间  VARCHAR(255),--
  状态  INT(2),--
  加工方式ID  BIGINT(15),--
  零件工序ID  BIGINT(15),--
  外协单位ID  BIGINT(15),--
 CONSTRAINT `F_产品零件库存_订单产品零件_ID` FOREIGN KEY (`订单产品零件ID`) REFERENCES `订单产品零件`(`ID`),
 CONSTRAINT `F_产品零件库存_零件_ID` FOREIGN KEY (`零件ID`) REFERENCES `零件`(`ID`),
 CONSTRAINT `F_产品零件库存_加工方式_ID` FOREIGN KEY (`加工方式ID`) REFERENCES `加工方式`(`ID`),
 CONSTRAINT `F_产品零件库存_零件工序_ID` FOREIGN KEY (`零件工序ID`) REFERENCES `零件工序`(`ID`),
 CONSTRAINT `F_产品零件库存_外协单位_ID` FOREIGN KEY (`外协单位ID`) REFERENCES `外协单位`(`ID`),
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `状态`; -- 
CREATE TABLE `状态`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  状态类型  INT(2),--
  状态值  INT(2),--
  状态名称  VARCHAR(20),--
  显示序号  INT(8),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';

DROP TABLE IF EXISTS `用户`; -- 
CREATE TABLE `用户`( -- 
  ID  bigint(15) NOT NULL AUTO_INCREMENT,--
  用户名  VARCHAR(50),--
  用户密码  VARCHAR(50),--
  用户姓名  VARCHAR(50),--
  登陆时间  VARCHAR(50),--
  角色  VARCHAR(50),--
 primary key (`ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='';


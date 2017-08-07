/*
Navicat MySQL Data Transfer

Source Server         : 新开发框架(framework)
Source Server Version : 50534
Source Host           : 192.168.1.254:3306
Source Database       : framework

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2016-10-11 19:11:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for FRAMEWORK_SYS_USER
-- ----------------------------
DROP TABLE IF EXISTS `FRAMEWORK_SYS_USER`;
CREATE TABLE `FRAMEWORK_SYS_USER` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `SU_LOGIN_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录名',
  `SU_LOGIN_PASS` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '登录密码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Table structure for SYS_PERMISION
-- ----------------------------
DROP TABLE IF EXISTS `SYS_PERMISION`;
CREATE TABLE `SYS_PERMISION` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `PERMISION_NAME` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `PERMISION_PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父资源ID',
  `PERMISION_TYPE` varchar(255) DEFAULT NULL COMMENT '资源类型',
  `PERMISION_SORT` int(11) DEFAULT NULL COMMENT '排序',
  `PERMISION_URL` varchar(255) DEFAULT NULL COMMENT '资源地址',
  `PERMISION_RELATED_URL` varchar(5000) DEFAULT NULL COMMENT '关联资源',
  `PERMISION_DESC` varchar(1000) DEFAULT NULL COMMENT '资源描述',
  `PERMISION_STATE` varchar(255) DEFAULT NULL COMMENT '权限状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE`;
CREATE TABLE `SYS_ROLE` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `ROLE_NAME` varchar(255) NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(1000) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for SYS_ROLE_PERMISION
-- ----------------------------
DROP TABLE IF EXISTS `SYS_ROLE_PERMISION`;
CREATE TABLE `SYS_ROLE_PERMISION` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `RP_ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `RP_PERMISION_ID` varchar(32) DEFAULT NULL,
  `RP_RESOURCE_ID` varchar(32) DEFAULT NULL COMMENT '权限ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限业务表';

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER`;
CREATE TABLE `SYS_USER` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `USER_USERNAME` varchar(255) DEFAULT NULL COMMENT '登录用户名',
  `USER_PASSWORD` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `USER_PASSWORD_SALT` varchar(255) DEFAULT NULL COMMENT '密码盐值',
  `USER_IDENTITY` varchar(255) DEFAULT NULL COMMENT '用户唯一编号',
  `USER_REAL_NAME` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `USER_EMAIL` varchar(255) DEFAULT NULL COMMENT '电子邮件',
  `USER_CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `USER_LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `USER_STATUS` varchar(255) DEFAULT NULL COMMENT '用户状态',
  `USER_DESC` varchar(1000) DEFAULT NULL COMMENT '用户描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='111111';

-- ----------------------------
-- Table structure for SYS_USER_PERMISION
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER_PERMISION`;
CREATE TABLE `SYS_USER_PERMISION` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `UP_USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `UP_RESOURCE_ID` varchar(32) DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE IF EXISTS `SYS_USER_ROLE`;
CREATE TABLE `SYS_USER_ROLE` (
  `ID` varchar(32) NOT NULL COMMENT '主键',
  `UR_USER_ID` varchar(32) DEFAULT '' COMMENT '用户ID',
  `UR_ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

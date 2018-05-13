/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : jc

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-04 20:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ex_car`
-- ----------------------------
DROP TABLE IF EXISTS `ex_car`;
CREATE TABLE `ex_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_number` varchar(20) DEFAULT NULL,
  `car_type` varchar(20) DEFAULT NULL,
  `car_load` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `car_model` varchar(20) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ex_car
-- ----------------------------

-- ----------------------------
-- Table structure for `ex_order`
-- ----------------------------
DROP TABLE IF EXISTS `ex_order`;
CREATE TABLE `ex_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `send_name` varchar(20) DEFAULT NULL,
  `send_telephone` varchar(20) DEFAULT NULL,
  `semd_area` varchar(50) DEFAULT NULL,
  `send_address` varchar(50) DEFAULT NULL,
  `receive_name` varchar(20) DEFAULT NULL,
  `receive_telephone` varchar(20) DEFAULT NULL,
  `receive_area` varchar(50) DEFAULT NULL,
  `receive_address` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ex_order
-- ----------------------------

-- ----------------------------
-- Table structure for `ex_order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ex_order_detail`;
CREATE TABLE `ex_order_detail` (
  `id` varchar(20) DEFAULT NULL,
  `order_id` varchar(20) DEFAULT NULL,
  `order_weight` varchar(20) DEFAULT NULL,
  `order_type` varchar(20) DEFAULT NULL,
  `order_remark` varchar(20) DEFAULT NULL,
  `order_img` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ex_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `ex_order_records`
-- ----------------------------
DROP TABLE IF EXISTS `ex_order_records`;
CREATE TABLE `ex_order_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ex_order_records
-- ----------------------------

-- ----------------------------
-- Table structure for `os_customer`
-- ----------------------------
DROP TABLE IF EXISTS `os_customer`;
CREATE TABLE `os_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_telephone` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `customer_email` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of os_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(20) DEFAULT NULL,
  `parent_code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `layer` varchar(20) DEFAULT NULL,
  `order_num` int(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_area
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_fixed`
-- ----------------------------
DROP TABLE IF EXISTS `sys_fixed`;
CREATE TABLE `sys_fixed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fixed_code` varchar(20) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `fixed_name` varchar(20) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_fixed
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `spend_time` int(11) DEFAULT NULL,
  `method` varchar(20) DEFAULT NULL,
  `user_agent` varchar(20) DEFAULT NULL,
  `user_ip` varchar(50) DEFAULT NULL,
  `opt_content` varchar(20) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_partition`
-- ----------------------------
DROP TABLE IF EXISTS `sys_partition`;
CREATE TABLE `sys_partition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `partition_code` varchar(20) DEFAULT NULL,
  `addresskey` varchar(20) DEFAULT NULL,
  `single` int(10) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `village` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_partition
-- ----------------------------

-- ----------------------------
-- Table structure for `t_driver`
-- ----------------------------
DROP TABLE IF EXISTS `t_driver`;
CREATE TABLE `t_driver` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_driver
-- ----------------------------

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_code` varchar(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `menu_type` int(10) DEFAULT NULL,
  `sort` int(10) DEFAULT NULL,
  `menu_name` varchar(20) DEFAULT NULL,
  `href` varchar(50) DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `permission` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `t_organization`
-- ----------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization` (
  `org_id` int(11) NOT NULL AUTO_INCREMENT,
  `org_name` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_organization
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `role_sign` varchar(20) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`role_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `t_staff`
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `pic_img` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `last_login_ip` varchar(50) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_login_log`;
CREATE TABLE `t_user_login_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_time` datetime DEFAULT NULL,
  `user_ip` varchar(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `operating_system` varchar(50) DEFAULT NULL,
  `browser` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------

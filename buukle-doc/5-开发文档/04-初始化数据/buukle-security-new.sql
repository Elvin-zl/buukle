/*
 Navicat Premium Data Transfer

 Source Server         : buukle-database
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : 39.107.78.160:3654
 Source Schema         : buukle-security-new

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 15/08/2019 22:13:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '应用表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES (3, 'buukle-security', '布壳儿安全管理系统', '用于所有项目的用户及其权限管理', '用于所有项目的用户及其权限管理', '2019-08-09 16:57:49', 'elvin', 'BK_000000000', '2019-08-14 23:37:32', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `application` VALUES (4, 'buukle-cms', '布壳儿内容管理系统', '布壳儿内容管理系统', '布壳儿内容管理系统', '2019-08-13 16:40:07', 'elvin', 'BK_000000000', '2019-08-13 16:40:07', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int(16) NULL DEFAULT NULL COMMENT '上级区域id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '区域' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for button
-- ----------------------------
DROP TABLE IF EXISTS `button`;
CREATE TABLE `button`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `system_flag` int(1) NULL DEFAULT NULL COMMENT '是否是系统守护 0 : 否 1: 是',
  `application_id` int(16) NULL DEFAULT NULL COMMENT '所属应用id',
  `menu_id` int(16) NULL DEFAULT NULL COMMENT '所属菜单id',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `operation_type` int(2) NULL DEFAULT NULL COMMENT '操作类型 0:添加 1删除 2:修改 3:详情 4: 申请启用 5:审核 6;启/停用 7:分配设置)',
  `response_type` int(2) NULL DEFAULT NULL COMMENT '按钮响应类型  0:confirm(确认框) 1:frame(弹层) 2: frame(弹层,取后台数据) 3:加载其他页面 4: 带页面查询表单条件访问后台',
  `layout_level` int(2) NULL DEFAULT NULL COMMENT '按钮分布级别  0:页面级别 1: 列表级别',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '按钮' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of button
-- ----------------------------
INSERT INTO `button` VALUES (41, NULL, 3, 29, '/security/application/applicationCrudView', '编辑/添加应用', NULL, NULL, NULL, '编辑添加应用', '编辑添加应用', '2019-08-12 09:18:30', 'elvin', 'BK_000000000', '2019-08-14 23:26:30', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (42, NULL, 3, 31, '/security/button/buttonCrudJson', '删除按钮', NULL, NULL, NULL, '删除按钮', '删除按钮', '2019-08-12 09:19:59', 'elvin', 'BK_000000000', '2019-08-14 23:26:21', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (43, NULL, 3, 29, '/security/application/applicationCrudJson', '删除应用', NULL, NULL, NULL, '删除应用', '删除应用', '2019-08-14 23:34:05', 'elvin', 'BK_000000000', '2019-08-14 23:34:05', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (44, NULL, 3, 29, '/application/saveOrEdit', '提交应用', NULL, NULL, NULL, '提交应用', '提交应用', '2019-08-14 23:36:44', 'elvin', 'BK_000000000', '2019-08-14 23:36:44', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (45, NULL, 3, 30, '/security/role/roleCrudView', '新增/编辑角色', NULL, NULL, NULL, '新增/编辑角色', '新增/编辑角色', '2019-08-14 23:38:52', 'elvin', 'BK_000000000', '2019-08-14 23:38:52', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (46, NULL, 3, 30, '/role/saveOrEdit', '提交角色', NULL, NULL, NULL, '提交角色', '提交角色', '2019-08-14 23:40:42', 'elvin', 'BK_000000000', '2019-08-14 23:40:42', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (47, NULL, 3, 30, '/security/role/roleCrudJson', '删除角色', NULL, NULL, NULL, '删除角色', '删除角色', '2019-08-14 23:41:03', 'elvin', 'BK_000000000', '2019-08-14 23:41:03', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (48, NULL, 3, 32, '/security/menu/menuCrudView', '新增/编辑菜单', NULL, NULL, NULL, '新增/编辑菜单', '新增/编辑菜单', '2019-08-14 23:41:59', 'elvin', 'BK_000000000', '2019-08-14 23:41:59', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (49, NULL, 3, 32, '/security/menu/menuCrudJson', '删除菜单', NULL, NULL, NULL, '删除菜单', '删除菜单', '2019-08-14 23:42:21', 'elvin', 'BK_000000000', '2019-08-14 23:42:21', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (50, NULL, 3, 32, '/menu/saveOrEdit', '提交菜单', NULL, NULL, NULL, '提交菜单', '提交菜单', '2019-08-14 23:44:00', 'elvin', 'BK_000000000', '2019-08-14 23:44:00', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (51, NULL, 3, 31, '/security/button/buttonCrudView', '新增/编辑按钮', NULL, NULL, NULL, '新增/编辑按钮', '新增/编辑按钮', '2019-08-14 23:44:45', 'elvin', 'BK_000000000', '2019-08-14 23:44:45', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (52, NULL, 3, 31, '/button/saveOrEdit', '提交按钮', NULL, NULL, NULL, '提交按钮', '提交按钮', '2019-08-14 23:45:45', 'elvin', 'BK_000000000', '2019-08-14 23:45:45', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (53, NULL, 3, 34, '/security/user/userCrudView', '新增/编辑用户', NULL, NULL, NULL, '新增/编辑用户', '新增/编辑用户', '2019-08-14 23:46:27', 'elvin', 'BK_000000000', '2019-08-14 23:46:27', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (54, NULL, 3, 34, '/security/user/userCrudJson', '删除用户', NULL, NULL, NULL, '删除用户', '删除用户', '2019-08-14 23:46:51', 'elvin', 'BK_000000000', '2019-08-14 23:46:51', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (55, NULL, 3, 34, '/user/saveOrEdit', '提交用户', NULL, NULL, NULL, '提交用户', '提交用户', '2019-08-14 23:47:56', 'elvin', 'BK_000000000', '2019-08-14 23:56:43', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (56, NULL, 3, 30, '/security/role/roleMenuSetView', '分配资源', NULL, NULL, NULL, '分配资源', '分配资源', '2019-08-15 00:06:52', 'elvin', 'BK_000000000', '2019-08-15 00:06:52', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (57, NULL, 3, 30, '/role/roleMenuSet', '提交分配资源', NULL, NULL, NULL, '提交分配资源', '提交分配资源', '2019-08-15 00:07:39', 'elvin', 'BK_000000000', '2019-08-15 00:07:39', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (58, NULL, 3, 34, '/security/user/userRoleSetView', '分配角色', NULL, NULL, NULL, '分配角色', '分配角色', '2019-08-15 02:04:21', 'elvin', 'BK_000000000', '2019-08-15 02:04:21', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (59, NULL, 3, 34, '/user/userRoleSet', '提交分配角色', NULL, NULL, NULL, '提交分配角色', '提交分配角色', '2019-08-15 02:05:16', 'elvin', 'BK_000000000', '2019-08-15 02:05:16', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (60, NULL, 3, 29, '/security/application/applicationBatchDeleteJson', '批量删除应用', NULL, NULL, NULL, '批量删除应用', '批量删除应用', '2019-08-15 21:37:24', 'elvin', 'BK_000000000', '2019-08-15 21:38:15', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (61, NULL, 3, 31, '/security/button/buttonBatchDeleteJson', '批量删除按钮', NULL, NULL, NULL, '批量删除按钮', '批量删除按钮', '2019-08-15 21:37:59', 'elvin', 'BK_000000000', '2019-08-15 21:39:59', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (62, NULL, 3, 32, '/security/menu/menuBatchDeleteJson', '批量删除菜单', NULL, NULL, NULL, '批量删除菜单', '批量删除菜单', '2019-08-15 21:39:05', 'elvin', 'BK_000000000', '2019-08-15 21:39:05', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (63, NULL, 3, 30, '/security/role/roleBatchDeleteJson', '批量删除角色', NULL, NULL, NULL, '批量删除角色', '批量删除角色', '2019-08-15 21:39:40', 'elvin', 'BK_000000000', '2019-08-15 21:40:27', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `button` VALUES (64, NULL, 3, 34, '/security/user/userBatchDeleteJson', '批量删除用户', NULL, NULL, NULL, '批量删除用户', '批量删除用户', '2019-08-15 21:45:59', 'elvin', 'BK_000000000', '2019-08-15 21:45:59', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for buukle_sign
-- ----------------------------
DROP TABLE IF EXISTS `buukle_sign`;
CREATE TABLE `buukle_sign`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `partner_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `partner_id` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `partner_type` int(1) NULL DEFAULT NULL COMMENT '合作方类型\r\n            0:外部\r\n            1:内部用户\r\n            2:内部应用',
  `partner_key` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `partner_key_valid` datetime(0) NULL DEFAULT NULL,
  `partner_key_endvalid` datetime(0) NULL DEFAULT NULL,
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_partner_id`(`partner_id`) USING BTREE,
  INDEX `merchantCode`(`partner_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29077 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'buukle验签配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for interface_register
-- ----------------------------
DROP TABLE IF EXISTS `interface_register`;
CREATE TABLE `interface_register`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `application_id` int(16) NULL DEFAULT NULL COMMENT '所属应用id',
  `menu_id` int(16) NULL DEFAULT NULL COMMENT '所属菜单id',
  `button_id` int(16) NULL DEFAULT NULL COMMENT '按钮id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign_type` int(1) NULL DEFAULT NULL COMMENT '验签类型 : 0 不需要验签 ;1 需要验签',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接口注册\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for interface_register_logs
-- ----------------------------
DROP TABLE IF EXISTS `interface_register_logs`;
CREATE TABLE `interface_register_logs`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `register_id` int(16) NULL DEFAULT NULL COMMENT '注册表id',
  `application_id` int(16) NULL DEFAULT NULL COMMENT '所属应用id',
  `menu_id` int(16) NULL DEFAULT NULL COMMENT '所属菜单id',
  `button_id` int(16) NULL DEFAULT NULL COMMENT '按钮id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接口注册日志表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'uuid',
  `skuId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku',
  `skuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `bizType` int(2) NULL DEFAULT NULL COMMENT '业务类型',
  `productId` int(2) NULL DEFAULT NULL COMMENT '产品类型',
  `merchantId` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户编码',
  `merchantName` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户名称',
  `thirdCode` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基金代码,子产品ID,险种代码',
  `itemStatus` int(1) NULL DEFAULT NULL COMMENT '售卖状态',
  `auditStatus` int(1) NULL DEFAULT NULL COMMENT '审核状态',
  `pin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pin',
  `fundCloseEndDate` datetime(0) NULL DEFAULT NULL COMMENT '购买起时间',
  `fundCloseBeginDate` datetime(0) NULL DEFAULT NULL COMMENT '购买止时间',
  `fundraisingBeginDate` datetime(0) NULL DEFAULT NULL COMMENT '起息日',
  `fundraisingEndDate` datetime(0) NULL DEFAULT NULL COMMENT '止息日',
  `version` int(255) NULL DEFAULT NULL COMMENT '版本',
  `detail` json NULL COMMENT '详情',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak06` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak07` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak08` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak09` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak10` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uuidUnique`(`uuid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 345529 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES (345527, NULL, 'BK_EDEESRG3', '测试商品名称', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '{\"id\": \"\", \"skuid\": \"BK_EDEESRG3\", \"isBook\": \"0\", \"productStyle\": \"2\", \"fundCloseEndDate\": \"2019-06-01\", \"fundCloseBeginDate\": \"2019-06-01\"}', NULL, '2019-08-07 14:27:08', 'elvin', 'BK_000000000', '2019-08-07 14:27:08', 'elvin', 'BK_000000000', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `item` VALUES (345528, NULL, '343423', '测试商品名称2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '{\"id\": \"\", \"skuid\": \"BK_EDEESRG3\", \"isBook\": \"0\", \"productStyle\": \"2\", \"fundCloseEndDate\": \"2019-06-11\", \"fundCloseBeginDate\": \"2019-06-01\"}', NULL, '2019-08-07 18:12:45', 'elvin', 'BK_000000000', '2019-08-07 18:12:45', 'elvin', 'BK_000000000', 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `system_flag` int(1) NULL DEFAULT NULL COMMENT '是否是系统守护 0 : 否 1: 是',
  `pid` int(16) NULL DEFAULT NULL COMMENT '父菜单id',
  `application_id` int(16) NULL DEFAULT NULL COMMENT '所属应用id',
  `application_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `page_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `display` int(1) NULL DEFAULT NULL COMMENT '展示否 1: 展示 0:不展示',
  `order_no` int(2) NULL DEFAULT NULL COMMENT '排序号',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型  1: 菜单 0: 组件',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 52 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (28, NULL, 35, 3, NULL, '资源管理', '', NULL, '&#xe60a;', 1, 1, 1, '资源管理', '资源管理', '2019-08-12 09:15:08', 'elvin', 'BK_000000000', '2019-08-15 15:51:01', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (29, NULL, 28, 3, NULL, '应用管理', '/security/application/applicationHome', NULL, '', 1, 2, 1, 'security-应用管理', 'security-应用管理', '2019-08-12 09:16:05', 'elvin', 'BK_000000000', '2019-08-15 20:55:01', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (30, NULL, 28, 3, NULL, '角色管理', '/security/role/roleHome', NULL, '', 1, 3, 1, '角色管理', '角色管理', '2019-08-14 22:25:59', 'elvin', 'BK_000000000', '2019-08-15 20:55:32', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (31, NULL, 28, 3, NULL, '按钮管理', '/security/button/buttonHome', NULL, '', 1, 5, 1, '按钮管理', '按钮管理', '2019-08-14 22:26:42', 'elvin', 'BK_000000000', '2019-08-15 20:55:59', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (32, NULL, 28, 3, NULL, '菜单&组件', '/security/menu/menuHome', NULL, '', 1, 4, 1, '菜单&组件', '菜单&组件', '2019-08-14 22:27:17', 'elvin', 'BK_000000000', '2019-08-15 15:53:22', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (33, NULL, 35, 3, NULL, '用户管理', '', NULL, '&#xe607;', 1, 6, 1, '用户管理', '用户管理', '2019-08-14 22:28:14', 'elvin', 'BK_000000000', '2019-08-15 15:58:00', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (34, NULL, 33, 3, NULL, '用户列表', '/security/user/userHome', NULL, '', 1, 7, 1, '用户列表', '用户列表', '2019-08-14 22:28:56', 'elvin', 'BK_000000000', '2019-08-15 15:58:48', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (35, NULL, 0, 3, NULL, 'home页面', '/security/home', NULL, '', 0, NULL, 1, 'home页面', 'home页面', '2019-08-14 22:59:47', 'elvin', 'BK_000000000', '2019-08-15 15:48:53', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (36, NULL, 29, 3, NULL, '应用分页', '/application/applicationPage', NULL, '', 0, 99999, 1, '应用分页', '应用分页', '2019-08-14 23:12:59', 'elvin', 'BK_000000000', '2019-08-15 15:52:04', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (37, NULL, 30, 3, NULL, '角色分页', '/role/rolePage', NULL, '', 0, 9999, 1, '角色分页', '角色分页', '2019-08-14 23:13:32', 'elvin', 'BK_000000000', '2019-08-15 15:52:54', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (38, NULL, 32, 3, NULL, '菜单&组件分页', '/menu/menuPage', NULL, '', 0, 9999, 1, '菜单分页', '菜单分页', '2019-08-14 23:13:58', 'elvin', 'BK_000000000', '2019-08-15 15:53:44', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (39, NULL, 31, 3, NULL, '按钮分页', '/button/buttonPage', NULL, '', 0, 9999, 1, '按钮分页', '按钮分页', '2019-08-14 23:14:24', 'elvin', 'BK_000000000', '2019-08-15 15:54:43', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (40, NULL, 34, 3, NULL, '用户分页', '/user/userPage', NULL, '', 0, NULL, 1, '用户分页', '用户分页', '2019-08-14 23:14:52', 'elvin', 'BK_000000000', '2019-08-15 15:58:59', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (41, NULL, 35, 3, NULL, '控制台', '/security/index/welcome', NULL, '&#xe629;', 0, 0, 1, '控制台', '控制台', '2019-08-15 01:58:00', 'elvin', 'BK_000000000', '2019-08-15 21:01:00', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (42, NULL, 29, 3, NULL, '应用下拉框', '/application/getApplicationTree', NULL, '', 0, NULL, 0, '应用下拉框', '应用下拉框', '2019-08-15 16:05:28', 'elvin', 'BK_000000000', '2019-08-15 16:13:02', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (43, NULL, 30, 3, NULL, '角色下拉框', '/role/getRoleTree', NULL, '', 0, NULL, 0, '角色下拉框', '角色下拉框', '2019-08-15 16:06:43', 'elvin', 'BK_000000000', '2019-08-15 16:06:43', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (44, NULL, 32, 3, NULL, '菜单下拉框', '/menu/getMenuTree', NULL, '', 0, NULL, 0, '菜单下拉框', '菜单下拉框', '2019-08-15 16:08:01', 'elvin', 'BK_000000000', '2019-08-15 16:08:01', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (45, NULL, 34, 3, NULL, '分配角色树', '/role/getAppUserRole', NULL, '', 0, NULL, 0, '分配角色树', '', '2019-08-15 16:09:22', 'elvin', 'BK_000000000', '2019-08-15 16:09:22', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (46, NULL, 30, 3, NULL, '分配资源树', '/role/getRoleMenuTree', NULL, '', 0, NULL, 0, '分配资源树', '分配资源树', '2019-08-15 16:11:43', 'elvin', 'BK_000000000', '2019-08-15 16:11:43', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (47, NULL, 29, 3, NULL, '模糊搜索应用', '/security/application/fuzzy/search', NULL, '', 0, NULL, 0, '模糊搜索应用', '模糊搜索应用', '2019-08-15 18:13:28', 'elvin', 'BK_000000000', '2019-08-15 18:13:28', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (48, NULL, 30, 3, NULL, '模糊搜索角色', '/security/role/fuzzy/search', NULL, '', 0, NULL, 0, '模糊搜索角色', '模糊搜索角色', '2019-08-15 18:15:48', 'elvin', 'BK_000000000', '2019-08-15 18:15:48', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (49, NULL, 32, 3, NULL, '模糊搜索菜单', '/security/menu/fuzzy/search', NULL, '', 0, NULL, 0, '模糊搜索菜单', '模糊搜索菜单', '2019-08-15 18:16:22', 'elvin', 'BK_000000000', '2019-08-15 18:16:22', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (50, NULL, 31, 3, NULL, '模糊搜索按钮', '/security/button/fuzzy/search', NULL, '', 0, NULL, 0, '模糊搜索按钮', '模糊搜索按钮', '2019-08-15 18:17:09', 'elvin', 'BK_000000000', '2019-08-15 18:17:09', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `menu` VALUES (51, NULL, 34, 3, NULL, '模糊搜索用户', '/security/user/fuzzy/search', NULL, '', NULL, NULL, NULL, '模糊搜索用户', '模糊搜索用户', '2019-08-15 18:17:44', 'elvin', 'BK_000000000', '2019-08-15 18:17:44', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int(16) NULL DEFAULT NULL COMMENT '上级角色id',
  `system_flag` int(1) NULL DEFAULT NULL COMMENT '是否是系统守护 0 : 否 1: 是',
  `application_id` int(16) NULL DEFAULT NULL COMMENT '所属应用id',
  `application_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_name` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (12, 0, NULL, 3, NULL, '超级管理员', 'security系统超级管理员', 'security系统超级管理员', '2019-08-12 09:12:11', 'elvin', 'BK_000000000', '2019-08-12 09:12:11', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES (13, 12, NULL, 3, NULL, '普通管理员', 'security-普通管理员', 'security-普通管理员', '2019-08-12 09:13:29', 'elvin', 'BK_000000000', '2019-08-12 09:13:29', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES (14, 12, NULL, 3, NULL, '安全管理员', '安全管理员', '安全管理员', '2019-08-13 21:56:18', 'elvin', 'BK_000000000', '2019-08-15 14:27:10', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_menu_button_relation
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_button_relation`;
CREATE TABLE `role_menu_button_relation`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(16) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` int(16) NULL DEFAULT NULL COMMENT '菜单id',
  `button_id` int(16) NULL DEFAULT NULL COMMENT '按钮id',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 698 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色菜单按钮关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_button_relation
-- ----------------------------
INSERT INTO `role_menu_button_relation` VALUES (802, 13, 35, NULL, NULL, NULL, '2019-08-15 22:04:05', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (803, 13, 28, NULL, NULL, NULL, '2019-08-15 22:04:05', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (804, 13, 29, NULL, NULL, NULL, '2019-08-15 22:04:05', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (806, 13, 30, NULL, NULL, NULL, '2019-08-15 22:04:06', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (808, 13, 31, NULL, NULL, NULL, '2019-08-15 22:04:06', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (810, 13, 32, NULL, NULL, NULL, '2019-08-15 22:04:06', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (812, 13, 33, NULL, NULL, NULL, '2019-08-15 22:04:06', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (813, 13, 34, NULL, NULL, NULL, '2019-08-15 22:04:06', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (815, 13, 41, NULL, NULL, NULL, '2019-08-15 22:04:07', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (816, 12, 35, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (817, 12, 28, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (818, 12, 29, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (819, 12, 36, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (820, 12, 42, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (821, 12, 47, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (822, 12, 30, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (823, 12, 37, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (824, 12, 43, NULL, NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (825, 12, 46, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (826, 12, 48, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (827, 12, 31, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (828, 12, 39, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (829, 12, 50, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (830, 12, 32, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (831, 12, 38, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (832, 12, 44, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (833, 12, 49, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (834, 12, 33, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (835, 12, 34, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (836, 12, 40, NULL, NULL, NULL, '2019-08-15 22:12:36', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (837, 12, 45, NULL, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (838, 12, 51, NULL, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (839, 12, 41, NULL, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (840, 12, 29, 41, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (841, 12, 31, 42, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (842, 12, 29, 43, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (843, 12, 29, 44, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (844, 12, 30, 45, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (845, 12, 30, 46, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (846, 12, 30, 47, NULL, NULL, '2019-08-15 22:12:37', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (847, 12, 32, 48, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (848, 12, 32, 49, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (849, 12, 32, 50, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (850, 12, 31, 51, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (851, 12, 31, 52, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (852, 12, 34, 53, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (853, 12, 34, 54, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (854, 12, 34, 55, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (855, 12, 30, 56, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (856, 12, 30, 57, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (857, 12, 34, 58, NULL, NULL, '2019-08-15 22:12:38', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (858, 12, 34, 59, NULL, NULL, '2019-08-15 22:12:39', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (859, 12, 29, 60, NULL, NULL, '2019-08-15 22:12:39', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (860, 12, 31, 61, NULL, NULL, '2019-08-15 22:12:39', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (861, 12, 32, 62, NULL, NULL, '2019-08-15 22:12:39', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (862, 12, 30, 63, NULL, NULL, '2019-08-15 22:12:39', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation` VALUES (863, 12, 34, 64, NULL, NULL, '2019-08-15 22:12:39', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_menu_button_relation_logs
-- ----------------------------
DROP TABLE IF EXISTS `role_menu_button_relation_logs`;
CREATE TABLE `role_menu_button_relation_logs`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(16) NULL DEFAULT NULL COMMENT '角色id',
  `menu_id_collections` varchar(10000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '菜单id集合',
  `button_id_collections` varchar(1000) CHARACTER SET utf8 COLLATE utf8_danish_ci NULL DEFAULT NULL COMMENT '按钮id集合',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 345 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '角色菜单按钮关系日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu_button_relation_logs
-- ----------------------------
INSERT INTO `role_menu_button_relation_logs` VALUES (316, 14, '[]', '[]', NULL, NULL, '2019-08-14 20:36:56', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (317, 14, '[28,29,28,29,28,29,28,29]', '[]', NULL, NULL, '2019-08-14 20:37:09', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (318, 14, '[28,29,28,29,28,29]', '[]', NULL, NULL, '2019-08-14 20:37:24', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (319, 14, '[]', '[]', NULL, NULL, '2019-08-14 21:03:16', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (320, 14, '[]', '[]', NULL, NULL, '2019-08-14 21:54:45', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (321, 14, '[28,29,28,29,28,29,28,29]', '[]', NULL, NULL, '2019-08-14 21:54:56', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (322, 14, '[28,29]', '[]', NULL, NULL, '2019-08-14 21:56:24', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (323, 14, '[28]', '[]', NULL, NULL, '2019-08-14 22:07:50', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (324, 14, '[28]', '[]', NULL, NULL, '2019-08-14 22:12:44', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (325, 14, '[28]', '[]', NULL, NULL, '2019-08-14 22:12:55', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (326, 14, '[28]', '[]', NULL, NULL, '2019-08-14 22:15:27', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (327, 12, '[]', '[]', NULL, NULL, '2019-08-14 22:30:28', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (328, 12, '[28,29,30,31,32,33,34,29,29]', '[]', NULL, NULL, '2019-08-14 22:30:40', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (329, 12, '[28,29,30,31,32,33,34]', '[]', NULL, NULL, '2019-08-14 22:30:49', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (330, 12, '[28,29,30,31,32,33,34,29,29]', '[]', NULL, NULL, '2019-08-14 23:02:06', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (331, 12, '[35,28,29,30,31,32,33,34,29,29]', '[]', NULL, NULL, '2019-08-14 23:15:53', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (332, 12, '[35,28,29,36,30,37,31,39,32,38,33,34,40,29,29]', '[]', NULL, NULL, '2019-08-14 23:49:19', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (333, 12, '[35,28,29,36,30,37,31,39,32,38,33,34,40,29,31,29,29,30,30,30,32,32,32,31,31,34,34,34]', '[]', NULL, NULL, '2019-08-15 00:08:05', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (334, 13, '[]', '[]', NULL, NULL, '2019-08-15 00:34:53', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (335, 14, '[]', '[]', NULL, NULL, '2019-08-15 01:55:25', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (336, 14, '[30]', '[]', NULL, NULL, '2019-08-15 01:55:36', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (337, 14, '[]', '[]', NULL, NULL, '2019-08-15 01:56:13', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (338, 12, '[35,28,29,36,37,31,39,32,38,33,34,40,29,31,29,29,32,32,32,31,31,34,34,34]', '[]', NULL, NULL, '2019-08-15 01:58:51', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (339, 14, '[]', '[]', NULL, NULL, '2019-08-15 01:58:58', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (340, 12, '[35,28,29,36,30,37,31,39,32,38,33,34,40,41,29,31,29,29,30,30,30,32,32,32,31,31,34,34,34,30,30]', '[]', NULL, NULL, '2019-08-15 02:05:48', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (341, 12, '[35,28,29,36,30,37,31,39,32,38,33,34,40,41,29,31,29,29,30,30,30,32,32,32,31,31,34,34,34,30,30,34,34]', '[]', NULL, NULL, '2019-08-15 16:14:09', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (342, 12, '[35,28,29,36,42,30,37,43,46,31,39,32,38,44,33,34,40,45,41,29,31,29,29,30,30,30,32,32,32,31,31,34,34,34,30,30,34,34]', '[]', NULL, NULL, '2019-08-15 18:18:57', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (343, 12, '[]', '[]', NULL, NULL, '2019-08-15 18:23:53', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (344, 12, '[35,28,29,36,42,47,30,37,43,46,48,31,39,50,32,38,44,49,33,34,40,45,51,41,29,31,29,29,30,30,30,32,32,32,31,31,34,34,34,30,30,34,34]', '[]', NULL, NULL, '2019-08-15 18:23:54', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (345, 12, '[]', '[]', NULL, NULL, '2019-08-15 21:44:39', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (346, 12, '[35,28,29,36,42,47,30,37,43,46,48,31,39,50,32,38,44,49,33,34,40,45,51,41,29,31,29,29,30,30,30,32,32,32,31,31,34,34,34,30,30,34,34,29,31,32,30]', '[]', NULL, NULL, '2019-08-15 21:46:37', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (347, 13, '[]', '[]', NULL, NULL, '2019-08-15 21:57:49', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (348, 13, '[35,28,29,30,31,32,33,34,41]', '[]', NULL, NULL, '2019-08-15 22:04:05', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `role_menu_button_relation_logs` VALUES (349, 12, '[36,42,47,37,43,46,48,39,50,38,44,49,40,45,51]', '[]', NULL, NULL, '2019-08-15 22:12:35', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area_id` int(16) NULL DEFAULT NULL COMMENT '区域id',
  `area_admin` int(1) NULL DEFAULT NULL COMMENT '区域管理员 0 不是 1 是',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_cn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_name_cn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_en` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_name_en` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `praise` int(16) NULL DEFAULT NULL COMMENT '赞数',
  `fans` int(16) NULL DEFAULT NULL COMMENT '粉丝数量',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` int(11) NULL DEFAULT NULL COMMENT '手机号',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别 : 0 女 1 男',
  `age` int(4) NULL DEFAULT NULL,
  `sign` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_strategy` int(1) NULL DEFAULT NULL COMMENT '登录策略 1: 一周 0:系统默认时间',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `theme` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `theme_id` int(16) NULL DEFAULT NULL COMMENT '主题id',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `super_manager` int(1) NULL DEFAULT NULL COMMENT '是否是超管',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_last_login` datetime(0) NULL DEFAULT NULL COMMENT '最近登陆时间',
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'BK_000000000', 0, 1, 'elvin', 'c4ca4238a0b923820dcc509a6f75849b', '惊羽', NULL, 'elvin', NULL, NULL, NULL, NULL, NULL, 1, 20, NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, '2019-08-15 22:12:51', NULL, NULL, NULL, '2019-08-15 22:05:32', 'elvina', 'BK_LJDOWKRMF', 3, '', NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (50, 'BK_LJDOWKRMF', NULL, NULL, 'elvina', 'c4ca4238a0b923820dcc509a6f75849b', '冀玉敬', NULL, 'elvina', NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, 0, NULL, '2019-08-15 22:11:38', '2019-08-12 09:23:52', 'elvin', 'BK_000000000', '2019-08-12 09:23:52', 'elvin', 'BK_000000000', 3, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_logs
-- ----------------------------
DROP TABLE IF EXISTS `user_logs`;
CREATE TABLE `user_logs`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area_id` int(16) NULL DEFAULT NULL COMMENT '区域id',
  `area_admin` int(1) NULL DEFAULT NULL COMMENT '区域管理员 0 不是 1 是',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_cn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_name_cn` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_en` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `full_name_en` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `praise` int(16) NULL DEFAULT NULL COMMENT '赞数',
  `fans` int(16) NULL DEFAULT NULL COMMENT '粉丝数量',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` int(11) NULL DEFAULT NULL COMMENT '手机号',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别 : 0 女 1 男',
  `age` int(4) NULL DEFAULT NULL,
  `sign` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_strategy` int(1) NULL DEFAULT NULL COMMENT '登录策略 1: 一周 0:系统默认时间',
  `head_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `theme` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `theme_id` int(16) NULL DEFAULT NULL COMMENT '主题id',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `super_manager` int(1) NULL DEFAULT NULL COMMENT '是否是超管',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_last_login` datetime(0) NULL DEFAULT NULL COMMENT '最近登陆时间',
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation`;
CREATE TABLE `user_role_relation`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id` int(16) NULL DEFAULT NULL COMMENT '角色id',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relation
-- ----------------------------
INSERT INTO `user_role_relation` VALUES (113, 'BK_LJDOWKRMF', 13, NULL, NULL, '2019-08-15 22:02:41', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation` VALUES (114, 'BK_000000000', 12, NULL, NULL, '2019-08-15 22:11:56', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role_relation_logs
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relation_logs`;
CREATE TABLE `user_role_relation_logs`  (
  `id` int(16) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_id_collection` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户角色日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role_relation_logs
-- ----------------------------
INSERT INTO `user_role_relation_logs` VALUES (100, 'BK_000000000', '12,13,', NULL, NULL, '2019-08-13 21:54:14', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (101, 'BK_000000000', '12,13,', NULL, NULL, '2019-08-13 22:00:13', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (102, 'BK_LJDOWKRMF', '', NULL, NULL, '2019-08-13 22:01:44', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (103, 'BK_000000000', '13,', NULL, NULL, '2019-08-13 23:45:12', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (104, 'BK_000000000', '12,13,14,', NULL, NULL, '2019-08-14 22:23:49', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (105, 'BK_LJDOWKRMF', '12,', NULL, NULL, '2019-08-14 22:24:11', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (106, 'BK_000000000', '12,', NULL, NULL, '2019-08-14 22:31:07', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (107, 'BK_LJDOWKRMF', '12,14,', NULL, NULL, '2019-08-14 23:28:20', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (108, 'BK_LJDOWKRMF', '12,', NULL, NULL, '2019-08-15 22:02:41', 'elvin', 'BK_000000000', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_role_relation_logs` VALUES (109, 'BK_000000000', '12,', NULL, NULL, '2019-08-15 22:11:56', 'elvina', 'BK_LJDOWKRMF', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_trail
-- ----------------------------
DROP TABLE IF EXISTS `user_trail`;
CREATE TABLE `user_trail`  (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `application_id` int(16) NULL DEFAULT NULL COMMENT '所属应用id',
  `menu_id` int(16) NULL DEFAULT NULL COMMENT '所属菜单id',
  `button_id` int(16) NULL DEFAULT NULL COMMENT '按钮id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sign_type` int(1) NULL DEFAULT NULL COMMENT '验签类型 : 0 不需要验签 ;1 需要验签',
  `description` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_created` datetime(0) NULL DEFAULT NULL,
  `creator` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `creator_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gmt_modified` datetime(0) NULL DEFAULT NULL,
  `modifier` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `modifier_code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '状态',
  `bak01` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak02` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak03` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak04` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bak05` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户轨迹表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : labdb

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-24 03:41:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `adminId` int(50) NOT NULL AUTO_INCREMENT,
  `adminPwd` varchar(50) NOT NULL,
  `adminName` varchar(50) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'admin', 'admin');
INSERT INTO `administrator` VALUES ('2', 'cwj', 'cwj');
INSERT INTO `administrator` VALUES ('3', 'lk', 'lk');
INSERT INTO `administrator` VALUES ('4', 'lwx', 'lwx');

-- ----------------------------
-- Table structure for computer
-- ----------------------------
DROP TABLE IF EXISTS `computer`;
CREATE TABLE `computer` (
  `computerId` int(50) NOT NULL AUTO_INCREMENT,
  `computerPosition` int(50) NOT NULL,
  `labId` int(50) NOT NULL,
  `computerIp` varchar(50) NOT NULL,
  `isUsing` tinyint(4) NOT NULL,
  PRIMARY KEY (`computerId`),
  UNIQUE KEY `ip` (`computerIp`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of computer
-- ----------------------------
INSERT INTO `computer` VALUES ('7', '1', '9', '192.168.1.1', '0');
INSERT INTO `computer` VALUES ('8', '2', '9', '192.168.1.2', '0');
INSERT INTO `computer` VALUES ('9', '3', '9', '192.168.1.3', '0');
INSERT INTO `computer` VALUES ('10', '1', '10', '192.169.1.1', '0');
INSERT INTO `computer` VALUES ('11', '2', '10', '192.169.1.2', '0');

-- ----------------------------
-- Table structure for lab
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `labId` int(50) NOT NULL AUTO_INCREMENT,
  `labPosition` varchar(50) NOT NULL,
  `labName` varchar(50) NOT NULL,
  PRIMARY KEY (`labId`),
  UNIQUE KEY `position` (`labPosition`),
  UNIQUE KEY `name` (`labName`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lab
-- ----------------------------
INSERT INTO `lab` VALUES ('9', '理四201', 'ACM实验室');
INSERT INTO `lab` VALUES ('10', '理四301', '数学建模实验室');
INSERT INTO `lab` VALUES ('11', '理四501', '机器人实验室');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `duration` double(31,1) DEFAULT NULL,
  `recordId` int(50) NOT NULL AUTO_INCREMENT,
  `studentId` int(50) NOT NULL,
  `labId` int(50) NOT NULL,
  `computerPosition` int(50) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `endTime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `studentName` varchar(50) NOT NULL,
  `labName` varchar(50) NOT NULL,
  PRIMARY KEY (`recordId`),
  KEY `record_ibfk_1` (`studentName`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('11776.2', '10', '31501092', '9', '1', '2018-06-22 22:46:39', '2018-06-23 02:02:55', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('1900.7', '11', '31501092', '9', '2', '2018-06-24 03:39:26', '2018-06-23 02:43:25', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('20.7', '12', '31501092', '9', '3', '2018-06-23 02:54:28', '2018-06-23 02:54:49', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('10.5', '13', '31501084', '9', '3', '2018-06-23 02:54:39', '2018-06-23 02:54:49', '陈文杰', 'ACM实验室');
INSERT INTO `record` VALUES ('53.9', '14', '31501092', '9', '1', '2018-06-24 00:03:18', '2018-06-24 00:04:12', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('5.2', '15', '31501092', '9', '1', '2018-06-24 01:29:23', '2018-06-24 01:29:28', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('14.8', '16', '31501092', '9', '1', '2018-06-24 01:29:31', '2018-06-24 01:29:46', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('253.4', '17', '31501084', '9', '2', '2018-06-24 01:29:42', '2018-06-24 01:33:55', '陈文杰', 'ACM实验室');
INSERT INTO `record` VALUES ('196.1', '21', '31501092', '10', '1', '2018-06-24 01:30:38', '2018-06-24 01:33:54', '卢凯', '数学建模实验室');
INSERT INTO `record` VALUES ('171.5', '22', '31501092', '10', '2', '2018-06-24 01:31:02', '2018-06-24 01:33:54', '卢凯', '数学建模实验室');
INSERT INTO `record` VALUES ('165.8', '23', '31501092', '10', '2', '2018-06-24 01:31:07', '2018-06-24 01:33:53', '卢凯', '数学建模实验室');
INSERT INTO `record` VALUES ('175.0', '28', '31501092', '9', '1', '2018-06-24 03:26:59', '2018-06-24 03:29:54', '卢凯', 'ACM实验室');
INSERT INTO `record` VALUES ('122.7', '29', '31501084', '10', '2', '2018-06-24 03:27:52', '2018-06-24 03:29:55', '陈文杰', '数学建模实验室');
INSERT INTO `record` VALUES ('252.5', '30', '31501092', '9', '1', '2018-06-24 03:34:47', '2018-06-24 03:39:00', '卢凯', 'ACM实验室');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` int(50) NOT NULL,
  `studentName` varchar(50) DEFAULT NULL,
  `isUsing` tinyint(4) NOT NULL,
  PRIMARY KEY (`studentId`),
  KEY `studentName` (`studentName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('31501084', '陈文杰', '0');
INSERT INTO `student` VALUES ('31501092', '卢凯', '0');

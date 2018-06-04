/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : labdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-04 14:21:59
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('1', 'admin', 'admin');

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
  PRIMARY KEY (`computerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of computer
-- ----------------------------

-- ----------------------------
-- Table structure for lab
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `labId` int(50) NOT NULL AUTO_INCREMENT,
  `labPosition` varchar(50) NOT NULL,
  `labName` varchar(50) NOT NULL,
  PRIMARY KEY (`labId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lab
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(50) NOT NULL AUTO_INCREMENT,
  `studentId` int(50) NOT NULL,
  `labId` int(50) NOT NULL,
  `computerPosition` int(50) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `endTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `studentName` varchar(50) NOT NULL,
  `labName` varchar(50) NOT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` int(50) NOT NULL,
  `studentName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

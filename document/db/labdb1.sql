/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : labdb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-05-21 16:47:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `adminId` int(50) NOT NULL,
  `adminPwd` varchar(50) NOT NULL,
  `adminName` varchar(50) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for computer
-- ----------------------------
DROP TABLE IF EXISTS `computer`;
CREATE TABLE `computer` (
  `computerId` int(50) NOT NULL AUTO_INCREMENT,
  `computerPosition` int(50) NOT NULL,
  `labId` int(50) NOT NULL,
  `computerIp` varchar(50) NOT NULL,
  PRIMARY KEY (`computerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lab
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab` (
  `labId` int(50) NOT NULL AUTO_INCREMENT,
  `labPostion` varchar(50) NOT NULL,
  `labName` varchar(50) NOT NULL,
  PRIMARY KEY (`labId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(50) NOT NULL AUTO_INCREMENT,
  `studentId` int(50) NOT NULL,
  `labId` int(50) NOT NULL,
  `computerPosition` int(50) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentId` int(50) NOT NULL,
  `studentName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`studentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

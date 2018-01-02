-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.47-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for task
CREATE DATABASE IF NOT EXISTS `task` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `task`;


-- Dumping structure for table task.address
CREATE TABLE IF NOT EXISTS `address` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(20) NOT NULL,
  `address2` varchar(20) NOT NULL,
  `userid` int(16) NOT NULL,
  `pincodeid` int(10) NOT NULL,
  PRIMARY KEY (`addressid`),
  KEY `pincodeid` (`pincodeid`),
  KEY `userid` (`userid`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`pincodeid`) REFERENCES `pincode` (`pincodeid`),
  CONSTRAINT `address_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table task.address: ~2 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`addressid`, `address1`, `address2`, `userid`, `pincodeid`) VALUES
	(1, 'Bang', 'Bang2', 101, 123123),
	(2, 'Hyd1', 'Hyd2', 102, 456456);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- Dumping structure for table task.meeting
CREATE TABLE IF NOT EXISTS `meeting` (
  `dateid` int(16) NOT NULL AUTO_INCREMENT,
  `startdate` date NOT NULL,
  `starttime` varchar(20) NOT NULL,
  `enddate` date NOT NULL,
  `endtime` varchar(20) NOT NULL,
  `userid` int(20) NOT NULL,
  `attendee` varchar(20) NOT NULL,
  PRIMARY KEY (`dateid`),
  KEY `FK_meeting_user` (`userid`),
  CONSTRAINT `FK_meeting_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- Dumping data for table task.meeting: ~0 rows (approximately)
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;


-- Dumping structure for table task.pincode
CREATE TABLE IF NOT EXISTS `pincode` (
  `pincodeid` int(10) NOT NULL,
  `country` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `town` varchar(20) NOT NULL,
  `village` varchar(20) NOT NULL,
  PRIMARY KEY (`pincodeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table task.pincode: ~2 rows (approximately)
/*!40000 ALTER TABLE `pincode` DISABLE KEYS */;
INSERT INTO `pincode` (`pincodeid`, `country`, `state`, `district`, `town`, `village`) VALUES
	(123123, 'India', 'Punjab', 'CH', 'Ch', 'Ch'),
	(456456, 'India', 'TS', 'HYD', 'HYD', 'Hyd');
/*!40000 ALTER TABLE `pincode` ENABLE KEYS */;


-- Dumping structure for table task.user
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(16) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `middlename` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `landline` varchar(8) DEFAULT NULL,
  `uniqueid` int(16) NOT NULL,
  `relation` varchar(50) DEFAULT NULL,
  `status` varchar(50) NOT NULL,
  `image` text,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `uniqueid` (`uniqueid`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- Dumping data for table task.user: ~2 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userid`, `email`, `password`, `firstname`, `middlename`, `lastname`, `gender`, `dob`, `mobile`, `landline`, `uniqueid`, `relation`, `status`, `image`) VALUES
	(101, '', '', 'Mohpreet', 'Singh', 'D', 'Male', '11-11-1111', '1231231234', '123123', 999999, 'TL', 'TL', NULL),
	(102, '', '', 'Shravan', 'Kumar', 'E', 'Male', '22-11-2222', '4564564563', '456456', 888888, 'SE', 'SE', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

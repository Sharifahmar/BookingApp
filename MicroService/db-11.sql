-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.9-log - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for task_backend
CREATE DATABASE IF NOT EXISTS `task_backend` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `task_backend`;


-- Dumping structure for table task_backend.address
CREATE TABLE IF NOT EXISTS `address` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(20) NOT NULL,
  `address2` varchar(20) NOT NULL,
  `userid` int(16) NOT NULL,
  `pincodeid` int(10) NOT NULL,
  `isactive` varchar(50) NOT NULL DEFAULT 'true',
  PRIMARY KEY (`addressid`),
  KEY `pincodeid` (`pincodeid`),
  KEY `userid` (`userid`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`pincodeid`) REFERENCES `pincode` (`pincodeid`),
  CONSTRAINT `address_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table task_backend.address: ~8 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`addressid`, `address1`, `address2`, `userid`, `pincodeid`, `isactive`) VALUES
	(8, 'testtttt', 'testttt', 108, 123123, 'false'),
	(9, 'fdfs', 'abc', 107, 456456, 'false'),
	(10, 'camp', 'camp', 106, 456456, 'false'),
	(11, 'testtttt', 'testttt', 109, 45658, 'true'),
	(12, 'dff', 'testsfdsfttt', 110, 5958, 'true'),
	(13, 'jkhj', 'testsfdsfttt', 111, 59858, 'true'),
	(14, 'pune', 'pune', 112, 44602, 'true'),
	(16, 'camp', 'pune', 116, 59858, 'true'),
	(17, 'camp', 'pune', 117, 5487, 'true');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- Dumping structure for table task_backend.meeting
CREATE TABLE IF NOT EXISTS `meeting` (
  `dateid` int(16) NOT NULL AUTO_INCREMENT,
  `startdate` date NOT NULL,
  `starttime` varchar(20) NOT NULL,
  `enddate` date NOT NULL,
  `endtime` varchar(20) NOT NULL,
  `userid` int(11) NOT NULL,
  `attendee` varchar(20) NOT NULL,
  `isactive` varchar(20) NOT NULL DEFAULT 'true',
  PRIMARY KEY (`dateid`),
  KEY `FK_meeting_user` (`userid`),
  CONSTRAINT `FK_meeting_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- Dumping data for table task_backend.meeting: ~3 rows (approximately)
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
INSERT INTO `meeting` (`dateid`, `startdate`, `starttime`, `enddate`, `endtime`, `userid`, `attendee`, `isactive`) VALUES
	(14, '1212-12-12', '67464', '1213-12-12', '65466', 107, '123', 'false'),
	(15, '1970-01-18', '12:12:12', '1970-01-18', '12:12:12', 106, '101,104', 'false'),
	(16, '2018-01-02', '123', '2018-01-02', '123', 108, '103\'104', 'false');
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;


-- Dumping structure for table task_backend.pincode
CREATE TABLE IF NOT EXISTS `pincode` (
  `pincodeid` int(10) NOT NULL,
  `country` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `district` varchar(20) NOT NULL,
  `town` varchar(20) NOT NULL,
  `village` varchar(20) NOT NULL,
  `isactive` varchar(50) NOT NULL DEFAULT 'true',
  PRIMARY KEY (`pincodeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table task_backend.pincode: ~7 rows (approximately)
/*!40000 ALTER TABLE `pincode` DISABLE KEYS */;
INSERT INTO `pincode` (`pincodeid`, `country`, `state`, `district`, `town`, `village`, `isactive`) VALUES
	(485, 'New Zealand', 'HYD', 'HYD', 'HYD', 'HYD', 'true'),
	(5487, 'India', 'Maharashtra', 'Amt', 'Amt', 'Amt', 'Amt'),
	(5958, 'India', 'Telangana', 'RR', 'Hyd', 'Ch', 'true'),
	(44602, 'India', 'Telangana', 'RR', 'Hyd', 'Ch', 'true'),
	(45658, 'India', 'Telangana', 'RR', 'Hyd', 'Ch', 'true'),
	(59858, 'India', 'Telangana', 'RR', 'Hyd', 'Ch', 'true'),
	(123123, 'India', 'Telangana', 'RR', 'Hyd', 'Ch', 'true'),
	(456456, 'India', 'TS', 'HYD', 'HYD', 'Hyd', 'true');
/*!40000 ALTER TABLE `pincode` ENABLE KEYS */;


-- Dumping structure for table task_backend.priority
CREATE TABLE IF NOT EXISTS `priority` (
  `pid` int(16) NOT NULL AUTO_INCREMENT,
  `empid` int(16) NOT NULL DEFAULT '0',
  `title` text NOT NULL,
  `prioritycreationdate` date NOT NULL,
  `priorityupdateddate` date NOT NULL,
  `isactive` varchar(10) NOT NULL,
  `prioritystartdate` date NOT NULL,
  `priorityenddate` date NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table task_backend.priority: ~9 rows (approximately)
/*!40000 ALTER TABLE `priority` DISABLE KEYS */;
INSERT INTO `priority` (`pid`, `empid`, `title`, `prioritycreationdate`, `priorityupdateddate`, `isactive`, `prioritystartdate`, `priorityenddate`, `status`) VALUES
	(1, 6545456, 'ahmarkhan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(2, 6545456, 'ahmarkhan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(7, 32164, 'shravan', '1111-11-11', '1111-11-11', 'true', '2017-12-23', '2017-12-23', 'publish'),
	(8, 32164, 'shravan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(16, 6545456, 'ahmarkhan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(17, 6545456, 'ahmarkhan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(18, 6445456, 'ahmarkhan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(19, 6445456, 'ahmarkhan', '1111-11-11', '1111-11-11', 'false', '2017-12-23', '2017-12-23', 'save'),
	(20, 0, 'jhmh', '1111-11-11', '1111-11-11', 'false', '2018-01-10', '2018-01-19', 'save');
/*!40000 ALTER TABLE `priority` ENABLE KEYS */;


-- Dumping structure for table task_backend.progressnote
CREATE TABLE IF NOT EXISTS `progressnote` (
  `progressid` int(16) NOT NULL AUTO_INCREMENT,
  `pid` int(16) NOT NULL,
  `progressnote` text NOT NULL,
  `createddate` date NOT NULL,
  `updateddate` date NOT NULL,
  `active` varchar(10) NOT NULL,
  PRIMARY KEY (`progressid`),
  KEY `priorityid` (`pid`),
  CONSTRAINT `progressnote_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `priority` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table task_backend.progressnote: ~4 rows (approximately)
/*!40000 ALTER TABLE `progressnote` DISABLE KEYS */;
INSERT INTO `progressnote` (`progressid`, `pid`, `progressnote`, `createddate`, `updateddate`, `active`) VALUES
	(2, 18, 'singh', '2017-12-25', '2017-12-23', 'true'),
	(6, 8, 'kumar', '2017-12-23', '2017-12-23', 'true'),
	(17, 19, 'singh', '2017-12-25', '2017-12-23', 'true'),
	(18, 20, '', '2017-12-25', '2017-12-23', 'true');
/*!40000 ALTER TABLE `progressnote` ENABLE KEYS */;


-- Dumping structure for table task_backend.user
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
  `isactive` varchar(50) NOT NULL DEFAULT 'true',
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- Dumping data for table task_backend.user: ~8 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userid`, `email`, `password`, `firstname`, `middlename`, `lastname`, `gender`, `dob`, `mobile`, `landline`, `uniqueid`, `relation`, `status`, `image`, `isactive`) VALUES
	(106, 'shravan@acc.com', 'qwerty', 'Shravan', 'Singh', 'D', 'Male', '11-11-1111', '1231231234', '123123', 123456789, 'TL', 'TL', NULL, 'true'),
	(107, 'a@email.com', 'qazzaqzasx', 'ahmar', 'akhtar', 'sharif', 'male', '11-11-2111', '6548887', '321654', 123, 'SE', 'SE', NULL, 'true'),
	(108, 'ahmar@acc.com', 'qwerty', 'Shravan', 'Singh', 'D', 'Male', '11-11-1111', '123123', '123123', 123456789, 'TL', 'TL', NULL, 'false'),
	(109, 'b@acc.com', '213', 'ahmar', 'sharif', 'Dsds', 'Female', '11-11-1111', '12623', '123123', 65456, 'TL', 'TL', NULL, 'true'),
	(110, 'ahc@acc.com', '213', 'shravn', 'sharif', 'Dsds', 'Female', '11-11-1111', '5464646', '123123', 6462, 'TL', 'TL', NULL, 'true'),
	(111, 'debanth@acc.com', '213', 'deb', 'nath', 'Dsds', 'male', '11-11-1111', '987654', '123123', 2562, 'TL', 'TL', NULL, 'true'),
	(112, 'abhi@test.com', 'abhi', 'Abhirup', 'rup', 'Debnath', 'Male', '1994-11-11', '123456789', '12345', 123456, 'ASE', 'ASE', '', 'true'),
	(116, 'arif@acc.com', '979d472a84804b9f647bc185a877a8b5', 'arif', 'shaikh', 'shaikh', 'male', '11-11-1111', '32454', '123', 456, 'TL', 'TL', NULL, 'true'),
	(117, 'sharif@acc.com', '827ccb0eea8a706c4c34a16891f84e7b', 'sharif', 'shaikh', 'shaikh', 'male', '11-11-1111', '321', '123', 123, 'TL', 'TL', NULL, 'true');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

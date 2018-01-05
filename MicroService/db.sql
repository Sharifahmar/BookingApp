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

-- Dumping database structure for task
CREATE DATABASE IF NOT EXISTS `task` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `task`;


-- Dumping structure for table task.address
CREATE TABLE IF NOT EXISTS `address` (
  `addressid` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(20) NOT NULL,
  `address2` varchar(20) NOT NULL,
  `userid` int(16) NOT NULL,
  `pincodeid` int(10) DEFAULT NULL,
  PRIMARY KEY (`addressid`),
  KEY `address_ibfk_2` (`userid`),
  KEY `FK_address_pincode` (`pincodeid`),
  CONSTRAINT `FK_address_pincode` FOREIGN KEY (`pincodeid`) REFERENCES `pincode` (`pincodeid`) ON DELETE CASCADE,
  CONSTRAINT `address_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Dumping data for table task.address: ~6 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`addressid`, `address1`, `address2`, `userid`, `pincodeid`) VALUES
	(1, 'Pune', 'Pune', 1, 444602),
	(2, 'Pune', 'Pune', 5, 444602),
	(3, 'hyd', 'hyd', 6, 44201),
	(4, 'hyd', 'hyd', 7, 97869),
	(5, 'hyd', 'hyd', 8, 6666),
	(8, 'hyd', 'hyd', 11, 6766);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


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

-- Dumping data for table task.pincode: ~5 rows (approximately)
/*!40000 ALTER TABLE `pincode` DISABLE KEYS */;
INSERT INTO `pincode` (`pincodeid`, `country`, `state`, `district`, `town`, `village`) VALUES
	(6666, 'India', 'Oriisa', 'Orisa', 'Orisa', 'Orisa'),
	(6766, 'India', 'Oriisa', 'Orisa', 'Orisa', 'Orisa'),
	(44201, 'India', 'Oriisa', 'Orisa', 'Orisa', 'Orisa'),
	(97869, 'India', 'Oriisa', 'Orisa', 'Orisa', 'Orisa'),
	(444602, 'India', 'Oriisa', 'Orisa', 'Orisa', 'Orisa');
/*!40000 ALTER TABLE `pincode` ENABLE KEYS */;


-- Dumping structure for table task.user
CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(16) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NOT NULL,
  `middlename` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `landline` varchar(8) DEFAULT NULL,
  `uniqueid` int(16) NOT NULL,
  `relation` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `image` text,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `uniqueid` (`uniqueid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- Dumping data for table task.user: ~8 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`userid`, `firstname`, `middlename`, `lastname`, `gender`, `dob`, `mobile`, `landline`, `uniqueid`, `relation`, `status`, `image`) VALUES
	(1, 'sangita', 'mohanty', 'mohanty', 'female', '05-02-1993', '987654', '987654', 12345, 'married', 'married', NULL),
	(5, 'ahmar', 'mohanty', 'sharif', 'female', '05-02-1993', '987654', '987654', 875, 'married', 'married', NULL),
	(6, 'shravan', 'mohanty', 'kumar', 'male', '05-02-1993', '987654', '987654', 895, 'married', 'married', NULL),
	(7, 'shravan', 'mohanty', 'kumar', 'male', '05-02-1993', '987654', '987654', 815, 'married', 'married', NULL),
	(8, 'priyanka', 'mohanty', 'kumar', 'male', '05-02-1993', '987654', '987654', 7777, 'married', 'married', NULL),
	(11, 'priyankaaa', 'mohanty', 'kumar', 'male', '05-02-1993', '987654', '987654', 5565, 'married', 'married', NULL),
	(12, 'sangitaa', 'mohanty', 'kumar', 'male', '05-02-1993', '987654', '987654', 453, 'married', 'married', NULL),
	(13, 'Hello', 'mohanty', 'kumar', 'male', '05-02-1993', '987654', '987654', 11129, 'married', 'married', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

# ************************************************************
# Sequel Pro SQL dump
# Version 4499
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.10-log)
# Database: database1
# Generation Time: 2017-06-03 22:53:36 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table chore_dim
# ------------------------------------------------------------

DROP TABLE IF EXISTS `chore_dim`;

CREATE TABLE `chore_dim` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chore` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `chore_dim` WRITE;
/*!40000 ALTER TABLE `chore_dim` DISABLE KEYS */;

INSERT INTO `chore_dim` (`id`, `chore`)
VALUES
	(1,'Kitchen'),
	(2,'Common Area'),
	(3,'Trash'),
	(4,'Outside'),
	(5,'Bathrooms');

/*!40000 ALTER TABLE `chore_dim` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table member
# ------------------------------------------------------------

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `upstairs` int(4) DEFAULT '0',
  `bathroom_num` int(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;

INSERT INTO `member` (`id`, `firstname`, `state`, `upstairs`, `bathroom_num`)
VALUES
	(1,'Will','ACTIVE',0,2),
	(2,'Shayne','ACTIVE',1,4),
	(3,'Peter','ACTIVE',0,1),
	(4,'Kevine','ACTIVE',1,4),
	(5,'Sabrina','ACTIVE',1,3),
	(6,'Seth','ACTIVE',0,1),
	(7,'Luminesse','ACTIVE',1,4),
	(8,'Nancy','ACTIVE',1,3),
	(9,'Charlene','ACTIVE',0,2),
	(10,'Anthony','ACTIVE',0,1),
	(11,'Lilli','ACTIVE',1,3),
	(12,'Elijah','ACTIVE',0,1),
	(13,'Yolie','ACTIVE',1,4),
	(14,'Sherry','ACTIVE',0,2),
	(15,'Austin','ACTIVE',0,2);

/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table monthly_chore
# ------------------------------------------------------------

DROP TABLE IF EXISTS `monthly_chore`;

CREATE TABLE `monthly_chore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `chore_dim_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `monthly_chore` WRITE;
/*!40000 ALTER TABLE `monthly_chore` DISABLE KEYS */;

INSERT INTO `monthly_chore` (`id`, `year`, `month`, `member_id`, `chore_dim_id`)
VALUES
	(1,2017,6,1,1),
	(2,2017,6,2,1),
	(3,2017,6,3,1),
	(4,2017,6,4,1),
	(5,2017,6,5,1),
	(6,2017,6,6,1),
	(7,2017,6,7,1),
	(8,2017,6,8,2),
	(9,2017,6,9,2),
	(10,2017,6,10,3),
	(11,2017,6,11,5),
	(12,2017,6,12,5),
	(13,2017,6,13,5),
	(14,2017,6,14,5),
	(15,2017,5,1,5),
	(16,2017,5,2,5),
	(17,2017,5,3,5),
	(18,2017,5,4,1),
	(19,2017,5,5,1),
	(20,2017,5,6,1),
	(21,2017,5,7,4),
	(22,2017,5,8,5),
	(23,2017,5,9,1),
	(24,2017,5,10,1),
	(25,2017,5,11,2),
	(26,2017,5,12,3),
	(27,2017,5,13,1),
	(28,2017,5,14,2),
	(29,2017,4,1,1),
	(30,2017,4,2,1),
	(31,2017,4,3,1),
	(32,2017,4,4,5),
	(33,2017,4,5,5),
	(34,2017,4,6,3),
	(35,2017,4,7,1),
	(36,2017,4,8,1),
	(37,2017,4,9,5),
	(38,2017,4,10,5),
	(39,2017,4,11,1),
	(40,2017,4,12,2),
	(41,2017,4,13,2),
	(42,2017,3,1,5),
	(43,2017,3,2,1),
	(44,2017,3,3,3),
	(45,2017,3,4,2),
	(46,2017,3,5,1),
	(47,2017,3,6,5),
	(48,2017,3,7,5),
	(49,2017,3,8,1),
	(50,2017,3,9,2),
	(51,2017,3,10,1),
	(52,2017,3,11,5),
	(53,2017,3,12,1),
	(54,2017,3,13,1),
	(55,2017,2,1,3),
	(56,2017,2,2,1),
	(57,2017,2,3,1),
	(58,2017,2,4,1),
	(59,2017,2,5,1),
	(60,2017,2,6,1),
	(61,2017,2,7,4),
	(62,2017,2,8,5),
	(63,2017,2,9,5),
	(64,2017,2,10,1),
	(65,2017,2,11,2),
	(66,2017,2,12,5),
	(67,2017,2,13,5),
	(68,2017,1,1,5),
	(69,2017,1,2,5),
	(70,2017,1,3,5),
	(71,2017,1,4,1),
	(72,2017,1,5,5),
	(73,2017,1,6,1),
	(74,2017,1,7,4),
	(75,2017,1,8,1),
	(76,2017,1,9,2),
	(77,2017,1,10,3),
	(78,2017,1,11,1),
	(79,2017,1,12,1),
	(80,2017,1,13,2),
	(81,2016,12,1,2),
	(82,2016,12,2,1),
	(83,2016,12,3,1),
	(84,2016,12,4,5),
	(85,2016,12,5,2),
	(86,2016,12,6,1),
	(87,2016,12,7,1),
	(88,2016,12,8,1),
	(89,2016,12,9,5),
	(90,2016,12,10,5),
	(91,2016,12,11,5),
	(92,2016,12,12,3),
	(93,2016,12,13,1),
	(94,2016,11,1,1),
	(95,2016,11,2,2),
	(96,2016,11,3,3),
	(97,2016,11,4,1),
	(98,2016,11,5,1),
	(99,2016,11,6,5),
	(100,2016,11,7,5),
	(101,2016,11,8,5),
	(102,2016,11,9,1),
	(103,2016,11,10,4),
	(104,2016,11,11,2),
	(105,2016,11,12,1),
	(106,2016,11,13,1),
	(107,2016,10,1,5),
	(108,2016,10,2,1),
	(109,2016,10,3,1),
	(110,2016,10,4,2),
	(111,2016,10,5,5),
	(112,2016,10,6,1),
	(113,2016,10,7,1),
	(114,2016,10,8,3),
	(115,2016,10,9,4),
	(116,2016,10,10,1),
	(117,2016,10,11,1),
	(118,2016,10,12,5),
	(119,2016,10,13,5);

/*!40000 ALTER TABLE `monthly_chore` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

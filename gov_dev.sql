-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 19, 2016 at 10:49 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gov_dev`
--

-- --------------------------------------------------------

--
-- Table structure for table `applicants`
--

CREATE TABLE IF NOT EXISTS `applicants` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `applicants`
--

INSERT INTO `applicants` (`id`, `fname`, `lname`) VALUES
(1, 'Jonny', 'Cavell'),
(2, 'Tony', 'Manwaring'),
(3, 'John', 'Sheppard'),
(4, 'Pete', 'Parren'),
(5, 'Joynal', 'Abedin');

-- --------------------------------------------------------

--
-- Table structure for table `cv`
--

CREATE TABLE IF NOT EXISTS `cv` (
  `CvId` int(11) NOT NULL AUTO_INCREMENT,
  `DocType` varchar(60) NOT NULL,
  `ApplicantId` int(60) NOT NULL,
  `CvDocs` text NOT NULL,
  PRIMARY KEY (`CvId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `cv`
--

INSERT INTO `cv` (`CvId`, `DocType`, `ApplicantId`, `CvDocs`) VALUES
(10, 'null.txt', 1, 'C:\\'),
(12, 'FTAfull.pdf', 2, 'C:\\'),
(13, 'HousePaint.doc', 3, 'C:\\'),
(14, 'sms.jpg', 4, 'C:\\'),
(15, 'draft.doc', 5, 'C:\\');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2017 at 04:37 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs102_projekat`
--
CREATE DATABASE IF NOT EXISTS `cs102_projekat` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cs102_projekat`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) NOT NULL,
  `sifra` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `ime`, `sifra`) VALUES
(1, 'David', 'david');

-- --------------------------------------------------------

--
-- Table structure for table `igraci`
--

CREATE TABLE IF NOT EXISTS `igraci` (
  `id_i` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) NOT NULL,
  `sifra` varchar(20) NOT NULL,
  PRIMARY KEY (`id_i`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `igraci`
--

INSERT INTO `igraci` (`id_i`, `ime`, `sifra`) VALUES
(3, 'Mirko', 'mirko'),
(4, 'Sima', 'sima'),
(5, 'Zeljko', 'zeljko');

-- --------------------------------------------------------

--
-- Table structure for table `rezultati`
--

CREATE TABLE IF NOT EXISTS `rezultati` (
  `id_r` int(11) NOT NULL AUTO_INCREMENT,
  `sifra` varchar(20) DEFAULT NULL,
  `rezultat` int(11) NOT NULL,
  PRIMARY KEY (`id_r`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rezultati`
--

INSERT INTO `rezultati` (`id_r`, `sifra`, `rezultat`) VALUES
(3, 'mirko', 1),
(4, 'sima', 102),
(5, 'zeljko', 8);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

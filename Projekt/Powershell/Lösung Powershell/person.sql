-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 10. Dez 2013 um 16:21
-- Server Version: 5.6.11
-- PHP-Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Datenbank: `schule`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `vorname` varchar(255) NOT NULL,
  `passwort` varchar(255) NOT NULL,
  `user` varchar(100) NOT NULL,
  `klasse` varchar(20) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted` tinyint(1) NOT NULL,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`username`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Daten für Tabelle `person`
--

INSERT INTO `person` (`id`, `name`, `vorname`, `passwort`, `user`, `klasse`, `timestamp`, `deleted`, `username`) VALUES
(1, 'Meyer', 'Hans', 'ChangeMe1', 'it3-HaMeye', '1', '2013-12-09 13:51:16', 0, 'HaMeye'),
(2, 'Schuetz', 'Eva ', 'ChangeMe1', 'it3-SchueEv', '2', '2013-12-09 13:51:23', 0, 'SchueEv'),
(3, 'Mustermann', 'Peter', 'ChangeMe1', 'it3-MustPe', '3', '2013-12-09 13:51:29', 0, 'MustPe'),
(4, 'Meyer', 'Petra', 'ChangeMe1', 'it3-MeyePe', '3', '2013-12-09 13:51:33', 0, 'MeyePe'),
(5, 'htras', 'wrthr', 'jzwwrhD3', 'rwhwjz', '2', '2013-12-10 13:33:22', 0, 'wrhtzdj'),
(10, 'lzig', 'lzug', 'lzugLZV6', '', '2', '2013-12-10 13:53:13', 0, 'lzugzul'),
(19, 'kunert', 'leon', 'Changeme1!', '', '11', '2013-12-10 15:17:32', 1, 'kunel'),
(18, 'gruneter', 'jenny', 'Changeme1!', '', '11', '2013-12-10 15:02:53', 0, 'gundje');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

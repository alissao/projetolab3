-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Jun 21, 2019 as 04:20 
-- Versão do Servidor: 5.1.41
-- Versão do PHP: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `agenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `eventagenda`
--

CREATE TABLE IF NOT EXISTS `eventagenda` (
  `eventname` varchar(120) NOT NULL,
  `username` varchar(120) NOT NULL,
  `eventdate` date NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `location` varchar(1000) NOT NULL,
  `eventstarttime` time DEFAULT NULL,
  `eventendtime` time DEFAULT NULL,
  `id_eventtype` int(3) NOT NULL,
  PRIMARY KEY (`eventdate`, `id_eventtype`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `eventagenda`
--

INSERT INTO `eventagenda` (`id_event`, `eventname`, `username`, `eventdate`, `description`, `location`, `eventstarttime`, `eventendtime`) VALUES
(1, 'dasdasd', 'asdasdas', '1999-01-01', '', 'sdfafsadfsd', '12:00:00', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `eventtype`
--

CREATE TABLE IF NOT EXISTS `eventtype` (
  `id_eventtype` int(3) NOT NULL AUTO_INCREMENT,
  `eventtypename` varchar(120) NOT NULL,
  PRIMARY KEY (`id_eventtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `eventtype`
--
INSERT INTO `eventtype` (`id_eventtype`,`eventtypename`) VALUES (1,'Meeting'), (2,'Workshop'), (3,'Lecture');
"Meeting", "Workshop", "Lecture"
-- --------------------------------------------------------

--
-- Estrutura da tabela `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `id_login` int(3) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL,
  PRIMARY KEY (`id_login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `login`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `registry`
--

CREATE TABLE IF NOT EXISTS `registry` (
  `id_reg` int(3) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `id_user` int(3) NOT NULL,
  `id_event` int(3) NOT NULL,
  `id_eventtype` int(3) NOT NULL,
  PRIMARY KEY (`id_reg`),
  KEY `id_user` (`id_user`),
  KEY `id_event` (`id_event`),
  KEY `id_eventtype` (`id_eventtype`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `registry`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(3) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `name` varchar(120) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id_user`, `login`, `name`, `password`) VALUES
(1, '', 'joe', ''),
(2, '', 'maria', ''),
(3, 'asdasda', 'sdaasda', 'sadasd'),
(4, 'sfasdfs', 'eae', 'asdasdas');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

ALTER TABLE eventagenda ADD CONSTRAINT FOREIGN KEY(id_eventtype) REFERENCES eventtype(id_eventtype);

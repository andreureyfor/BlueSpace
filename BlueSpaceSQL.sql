-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.27 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bluespace
CREATE DATABASE IF NOT EXISTS `bluespace` /*!40100 DEFAULT CHARACTER SET latin1 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bluespace`;

-- Volcando estructura para tabla bluespace.actors
CREATE TABLE IF NOT EXISTS `actors` (
  `id_actor` int NOT NULL AUTO_INCREMENT,
  `nomactor` varchar(100) NOT NULL,
  `nacionalitat` varchar(100) NOT NULL,
  PRIMARY KEY (`id_actor`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.actors: ~8 rows (aproximadamente)
/*!40000 ALTER TABLE `actors` DISABLE KEYS */;
INSERT INTO `actors` (`id_actor`, `nomactor`, `nacionalitat`) VALUES
	(1, 'Leonardo DiCaprio', 'Estados Unidos'),
	(2, 'Penélope Cruz', 'España'),
	(3, 'Tom Hanks', 'Estados Unidos'),
	(4, 'Gong Li', 'China'),
	(5, 'Julia Roberts', 'Estados Unidos'),
	(6, 'Ricardo Darín', 'Argentina'),
	(7, 'Meryl Streep', 'Estados Unidos'),
	(8, 'Aishwarya Rai Bachchan', 'India'),
	(9, 'Robert Downey Jr.', 'Estados Unidos'),
	(10, 'Marion Cotillard', 'Francia'),
	(11, 'Johnny Depp', 'Estados Unidos'),
	(12, 'Salma Hayek', 'México'),
	(13, 'Hugh Jackman', 'Australia'),
	(14, 'Sofia Vergara', 'Colombia'),
	(15, 'Brad Pitt', 'Estados Unidos'),
	(16, 'Catherine Zeta-Jones', 'Gales'),
	(17, 'Will Smith', 'Estados Unidos'),
	(18, 'Charlize Theron', 'Sudáfrica'),
	(19, 'George Clooney', 'Estados Unidos'),
	(20, 'Priyanka Chopra', 'India'),
	(21, 'John Travolta', 'Estados Unidos'),
	(22, 'Samuel L Jackson', 'Estados Unidos'),
	(23, 'Morgan Freeman', 'Estados Unidos'),
	(24, 'Tim Robbins', 'Estados Unidos'),
	(25, 'Christian Bale', 'Estados Unidos'),
	(26, 'Emilia Clarke', 'Reino Unido'),
	(27, 'Maisie Williams', 'Reino Unido'),
	(28, 'Keanu Reeves', 'El Líbano'),
	(29, 'Laurence Fishburn', 'Estados Unidos'),
	(30, 'Emma Stone', 'Estados Unidos'),
	(31, 'Ryan Gosling', 'Estados Unidos'),
	(32, 'Al Pacino', 'Estados Unidos'),
	(33, 'John Cazale', 'Estados Unidos'),
	(34, 'Ving Rhames', 'Estados Unidos');
/*!40000 ALTER TABLE `actors` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.actuen
CREATE TABLE IF NOT EXISTS `actuen` (
  `id_actor` int NOT NULL,
  `id_produccio` int NOT NULL,
  `protagonista?` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_actor`,`id_produccio`),
  KEY `id_produccio` (`id_produccio`),
  CONSTRAINT `actuen_ibfk_1` FOREIGN KEY (`id_actor`) REFERENCES `actors` (`id_actor`),
  CONSTRAINT `actuen_ibfk_2` FOREIGN KEY (`id_produccio`) REFERENCES `pelis` (`id_produccio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.actuen: ~16 rows (aproximadamente)
/*!40000 ALTER TABLE `actuen` DISABLE KEYS */;
INSERT INTO `actuen` (`id_actor`, `id_produccio`, `protagonista?`) VALUES
	(1, 11, 1),
	(1, 18, 1),
	(10, 11, 0),
	(15, 9, 0),
	(21, 3, 1),
	(22, 3, 1),
	(23, 1, 1),
	(24, 1, 1),
	(25, 5, 1),
	(28, 15, 1),
	(29, 15, 0),
	(30, 20, 1),
	(31, 20, 1),
	(32, 13, 1),
	(33, 13, 0),
	(34, 3, 0);
/*!40000 ALTER TABLE `actuen` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.clients
CREATE TABLE IF NOT EXISTS `clients` (
  `id_client` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `data_naixement` date DEFAULT NULL,
  `adreca` varchar(50) DEFAULT NULL,
  `nacionalitat` varchar(50) DEFAULT NULL,
  `email` varchar(256) NOT NULL,
  `telefon` varchar(9) DEFAULT NULL,
  `num_tarjeta` bigint DEFAULT NULL,
  `num_compte_banc` varchar(22) DEFAULT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.clients: ~21 rows (aproximadamente)
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` (`id_client`, `nom`, `dni`, `data_naixement`, `adreca`, `nacionalitat`, `email`, `telefon`, `num_tarjeta`, `num_compte_banc`) VALUES
	(1, 'María Rodríguez', '23456789L', '2003-02-18', 'Calle Principal 789', 'España', 'mariarodriguez@gmail.com', '987654321', 1234567812345678, 'ES01234567890123456789'),
	(2, 'José García', '34567890M', '1988-07-26', 'Avenida Central 321', 'España', 'josegarcia@gmail.com', '123456789', 9876543210987654, 'ES09876543210987654321'),
	(3, 'Laura Martínez', '45678901N', '1995-04-09', 'Calle Secundaria 654', 'España', 'lauramartinez@hotmail.com', '456789012', 4567890123456789, 'ES34567890123456789012'),
	(4, 'Carlos López', '56789012O', '1991-11-22', 'Plaza Mayor 123', 'España', 'carloslopez@hotmail.com', '789012345', 7890123456789012, 'ES56789012345678901234'),
	(5, 'Sara Fernández', '67890123P', '1987-06-15', 'Avenida del Sol 987', 'España', 'sarafernandez@gmail.com', '890123456', 8901234567890123, 'ES78901234567890123456'),
	(6, 'Manuel Torres', '78901234Q', '2001-03-28', 'Calle Nueva 456', 'España', 'manueltorres@hotmail.com', '901234567', 9012345678901234, 'ES90123456789012345678'),
	(7, 'Ana Ramírez', '89012345R', '1993-10-11', 'Avenida Principal 987', 'España', 'anaramirez@hotmail.com', '345678901', 3456789012345678, 'ES34567890123456789012'),
	(8, 'Pedro Navarro', '90123456S', '1988-05-24', 'Calle Central 654', 'España', 'pedronavarro@gmail.com', '567890123', 5678901234567890, 'ES56789012345678901234'),
	(9, 'Isabel Morales', '01234567T', '1996-02-07', 'Plaza del Sol 321', 'España', 'isabelmorales@gmail.com', '678901234', 6789012345678901, 'ES67890123456789012345'),
	(10, 'Miguel Sánchez', '12345678U', '1997-09-13', 'Avenida Nueva 654', 'España', 'miguelsanchez@gmail.com', '890123456', 8901234567890123, 'ES89012345678901234567'),
	(11, 'Pedro Rodríguez', '34567890C', '1992-03-10', 'Calle Secundaria 789', 'España', 'pedrorodriguez@gmail.com', '456789012', 4567890123456789, 'ES34567890123456789012'),
	(12, 'Laura López', '45678901D', '1988-12-05', 'Plaza Mayor 987', 'España', 'lauralopez@gmail.com', '789012345', 7890123456789012, 'ES56789012345678901234'),
	(13, 'Carlos García', '56789012E', '1995-07-18', 'Avenida del Sol 654', 'España', 'carlosgarcia@gmail.com', '890123456', 8901234567890123, 'ES78901234567890123456'),
	(14, 'Ana Martínez', '67890123F', '1991-09-25', 'Calle Nueva 321', 'España', 'anamartinez@hotmail.com', '901234567', 9012345678901234, 'ES90123456789012345678'),
	(15, 'Sergio Morales', '78901234G', '1993-06-14', 'Avenida Principal 654', 'España', 'sergiomorales@gmail.com', '345678901', 3456789012345678, 'ES34567890123456789012'),
	(16, 'Elena Navarro', '89012345H', '1987-11-30', 'Calle Central 987', 'España', 'elenanavarro@example.com', '567890123', 5678901234567890, 'ES56789012345678901234'),
	(17, 'Miguel Torres', '90123456I', '1994-04-02', 'Plaza del Sol 456', 'España', 'migueltorres@gmail.com', '678901234', 6789012345678901, 'ES67890123456789012345'),
	(18, 'Isabel Ramírez', '01234567J', '1997-01-08', 'Avenida Nueva 789', 'España', 'isabelramirez@hotmail.com', '661123321', 8901234567890542, 'ES89012345678901234545'),
	(19, 'Javier Sánchez', '12345678U', '1997-09-13', 'Avenida Nueva 654', 'España', 'miguelsanchez@hotmail.com', '890123456', 8901234567890123, 'ES89012345678901234567'),
	(20, 'Javier Torres', '34567890W', '1998-01-21', 'Avenida Central 789', 'Español', 'javiertorres@hotmail.com', '456789012', 4567890123456789, 'ES45678901234567890123'),
	(21, 'Elena García', '45678901X', '1990-09-04', 'Calle Secundaria 123', 'Español', 'elenagarcia@gmail.com', '567890123', 5678901234567890, 'ES56789012345678901234');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.compte
CREATE TABLE IF NOT EXISTS `compte` (
  `id_compte` int NOT NULL AUTO_INCREMENT,
  `usuari` varchar(20) NOT NULL,
  `contrasenya` varchar(20) NOT NULL,
  `data_alta` date NOT NULL,
  `id_client` int DEFAULT NULL,
  `id_modalitat` int DEFAULT NULL,
  PRIMARY KEY (`id_compte`),
  KEY `id_client` (`id_client`),
  KEY `id_modalitat` (`id_modalitat`),
  CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `compte_ibfk_2` FOREIGN KEY (`id_modalitat`) REFERENCES `modalitat` (`id_modalitat`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.compte: ~20 rows (aproximadamente)
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` (`id_compte`, `usuari`, `contrasenya`, `data_alta`, `id_client`, `id_modalitat`) VALUES
	(1, 'user123', '1234', '2020-01-01', 1, 1),
	(2, 'cooluser', 'securepassword', '2020-02-01', 2, 2),
	(3, 'webmaster', 'p@ssw0rd', '2020-03-01', 3, 1),
	(4, 'newuser', 'welc0me2023', '2020-04-01', 4, 3),
	(5, 'techguru', '1234abcd!', '2020-01-03', 5, 1),
	(6, 'gamer123', 'gamingFTW', '2020-02-03', 6, 2),
	(7, 'moviebuff', 'cinema21!', '2020-03-03', 7, 3),
	(8, 'sportsfan', 'goTeam2023', '2020-04-03', 8, 2),
	(9, 'musiclover', 'melodies123', '2021-05-01', 9, 1),
	(10, 'bookworm', 'reading2023', '2021-05-02', 10, 1),
	(11, 'traveler', 'wanderlust!', '2021-07-04', 11, 1),
	(12, 'fitnessguru', 'fitlife2023', '2021-07-05', 12, 2),
	(13, 'foodie123', 'tastyDishes', '2021-08-01', 13, 1),
	(14, 'artlover', 'creativity!', '2021-08-04', 14, 2),
	(15, 'naturelover', 'outdoorsy23', '2022-01-02', 15, 2),
	(16, 'adventure', 'exploreNow!', '2022-01-04', 16, 2),
	(17, 'techlover', 'geekTech2023', '2022-02-01', 17, 1),
	(18, 'fashionista', 'style1234', '2022-02-04', 18, 3),
	(19, 'businesspro', 'success2023', '2023-01-01', 19, 3),
	(20, 'creativemind', 'imagination!', '2023-05-20', 20, 3);
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.director
CREATE TABLE IF NOT EXISTS `director` (
  `id_director` int NOT NULL AUTO_INCREMENT,
  `nomdirector` varchar(100) NOT NULL,
  `nacionalitat` varchar(100) NOT NULL,
  PRIMARY KEY (`id_director`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.director: ~25 rows (aproximadamente)
/*!40000 ALTER TABLE `director` DISABLE KEYS */;
INSERT INTO `director` (`id_director`, `nomdirector`, `nacionalitat`) VALUES
	(1, 'Christopher Nolan', 'Estados Unidos'),
	(2, 'Francis Ford Coppola', 'Estados Unidos'),
	(3, 'James Cameron', 'Canada'),
	(4, 'Frank Darabont', 'Francia'),
	(5, 'Quentin Tarantino', 'Estados Unidos'),
	(6, 'Martin Scorsese', 'Estados Unidos'),
	(7, 'Lana Wachowsky', 'Estados Unidos'),
	(8, 'Lilly Wachowsky', 'Estados Unidos'),
	(9, 'Marc Foster', 'Alemania'),
	(10, 'David Fincher', 'Estados Unidos'),
	(11, 'Damien Chazelle', 'Estados Unidos'),
	(12, 'Alex Graves', 'Estados Unidos'),
	(13, 'Mark Mylod', 'Reino Unido'),
	(14, 'Miguel Sapochnik', 'Argentina'),
	(15, 'Vince Gilligan', 'Estados Unidos'),
	(16, 'Adam Bernstein', 'Estados Unidos'),
	(17, 'Michelle MacLaren', 'Canada'),
	(18, 'James Burrows', 'Estados Unidos'),
	(19, 'José Padilha', 'Brasil'),
	(20, 'Steven Spielberg', 'Estados Unidos'),
	(21, 'Otto Bathurst', 'Reino Unido'),
	(22, 'Euros Lyn', 'Gales'),
	(23, 'John Krasinski', 'Estados Unidos'),
	(24, 'Steve Carrell', 'Estados Unidos'),
	(25, 'Greg Daniels', 'Estados Unidos');
/*!40000 ALTER TABLE `director` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.dirigeix_episodi
CREATE TABLE IF NOT EXISTS `dirigeix_episodi` (
  `id_director` int NOT NULL,
  `id_produccio` int NOT NULL,
  `id_episodi` int NOT NULL,
  PRIMARY KEY (`id_director`,`id_produccio`,`id_episodi`),
  KEY `id_produccio` (`id_produccio`,`id_episodi`),
  CONSTRAINT `dirigeix_episodi_ibfk_1` FOREIGN KEY (`id_director`) REFERENCES `director` (`id_director`),
  CONSTRAINT `dirigeix_episodi_ibfk_2` FOREIGN KEY (`id_produccio`, `id_episodi`) REFERENCES `episodi` (`id_produccio`, `id_episodi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.dirigeix_episodi: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `dirigeix_episodi` DISABLE KEYS */;
INSERT INTO `dirigeix_episodi` (`id_director`, `id_produccio`, `id_episodi`) VALUES
	(12, 2, 24),
	(12, 2, 25),
	(17, 2, 28),
	(12, 2, 33),
	(15, 4, 1),
	(16, 4, 2),
	(16, 4, 3),
	(16, 4, 4),
	(16, 4, 5),
	(18, 6, 1),
	(18, 6, 2),
	(18, 6, 3),
	(18, 6, 4),
	(20, 8, 1),
	(20, 8, 2),
	(20, 8, 3),
	(20, 8, 4),
	(20, 8, 5);
/*!40000 ALTER TABLE `dirigeix_episodi` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.dirigeix_pelis
CREATE TABLE IF NOT EXISTS `dirigeix_pelis` (
  `id_director` int NOT NULL,
  `id_produccio` int NOT NULL,
  PRIMARY KEY (`id_director`,`id_produccio`),
  KEY `id_produccio` (`id_produccio`),
  CONSTRAINT `dirigeix_pelis_ibfk_1` FOREIGN KEY (`id_director`) REFERENCES `director` (`id_director`),
  CONSTRAINT `dirigeix_pelis_ibfk_2` FOREIGN KEY (`id_produccio`) REFERENCES `pelis` (`id_produccio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.dirigeix_pelis: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `dirigeix_pelis` DISABLE KEYS */;
INSERT INTO `dirigeix_pelis` (`id_director`, `id_produccio`) VALUES
	(4, 1),
	(5, 3),
	(1, 5),
	(2, 7),
	(10, 9),
	(1, 11),
	(6, 13),
	(7, 15),
	(8, 15),
	(6, 18),
	(11, 20);
/*!40000 ALTER TABLE `dirigeix_pelis` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.episodi
CREATE TABLE IF NOT EXISTS `episodi` (
  `id_produccio` int NOT NULL,
  `id_episodi` int NOT NULL,
  `nom` varchar(100) NOT NULL,
  `durada` int NOT NULL,
  PRIMARY KEY (`id_produccio`,`id_episodi`),
  CONSTRAINT `FK_Series` FOREIGN KEY (`id_produccio`) REFERENCES `series` (`id_produccio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.episodi: ~19 rows (aproximadamente)
/*!40000 ALTER TABLE `episodi` DISABLE KEYS */;
INSERT INTO `episodi` (`id_produccio`, `id_episodi`, `nom`, `durada`) VALUES
	(2, 24, 'And now his watch is ended', 45),
	(2, 25, 'Kissed by fire', 45),
	(2, 28, 'Second sons', 45),
	(2, 33, 'Breaker of chains', 45),
	(4, 1, 'Pilot', 57),
	(4, 2, 'Cat\'s in the bag...', 47),
	(4, 3, '...And the Bag\'s in the River', 47),
	(4, 4, 'Cancer Man', 47),
	(4, 5, 'Gray Matter', 47),
	(6, 1, 'The Pilot', 25),
	(6, 2, 'The one with the Sonogram at the End', 22),
	(6, 3, 'The one with the Thumb', 22),
	(6, 4, 'The one with George Stephanopoulos', 23),
	(8, 1, 'Mind Blown', 50),
	(8, 2, 'Mad for Max', 52),
	(8, 3, 'Unlikely Allies', 55),
	(8, 4, 'Truth in Hawkins', 53),
	(8, 5, 'The AV Club', 55),
	(8, 6, 'The New Class', 56);
/*!40000 ALTER TABLE `episodi` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.factura
CREATE TABLE IF NOT EXISTS `factura` (
  `id_factura` int NOT NULL AUTO_INCREMENT,
  `data_factura` date NOT NULL,
  `preu_cost` double NOT NULL,
  `id_compte` int DEFAULT NULL,
  PRIMARY KEY (`id_factura`),
  KEY `id_compte` (`id_compte`),
  CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.factura: ~40 rows (aproximadamente)
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` (`id_factura`, `data_factura`, `preu_cost`, `id_compte`) VALUES
	(1, '2021-01-01', 15, 1),
	(2, '2021-02-01', 25, 2),
	(3, '2021-03-01', 15, 3),
	(4, '2021-04-01', 25, 4),
	(5, '2021-05-01', 15, 5),
	(6, '2021-06-01', 25, 6),
	(7, '2021-07-01', 15, 7),
	(8, '2021-08-01', 25, 8),
	(9, '2021-09-01', 15, 9),
	(10, '2021-10-01', 25, 10),
	(11, '2021-11-01', 15, 11),
	(12, '2021-12-01', 25, 12),
	(13, '2022-01-01', 15, 13),
	(14, '2022-02-01', 25, 14),
	(15, '2022-03-01', 15, 15),
	(16, '2022-04-01', 25, 16),
	(17, '2022-05-01', 15, 17),
	(18, '2022-06-01', 25, 18),
	(19, '2022-07-01', 15, 19),
	(20, '2022-08-01', 25, 20),
	(21, '2023-01-01', 15, 1),
	(22, '2023-02-01', 25, 2),
	(23, '2023-03-01', 15, 3),
	(24, '2023-04-01', 25, 4),
	(25, '2023-05-01', 15, 5),
	(26, '2023-06-01', 25, 6),
	(27, '2023-07-01', 15, 7),
	(28, '2023-08-01', 25, 8),
	(29, '2023-09-01', 15, 9),
	(30, '2023-10-01', 25, 10),
	(31, '2023-11-01', 15, 11),
	(32, '2023-12-01', 25, 12),
	(33, '2022-09-01', 15, 1),
	(34, '2022-10-01', 25, 2),
	(35, '2022-11-01', 15, 3),
	(36, '2022-12-01', 25, 4),
	(37, '2023-09-01', 15, 5),
	(38, '2023-10-01', 25, 6),
	(39, '2023-11-01', 15, 7),
	(40, '2023-12-01', 25, 8);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.genere
CREATE TABLE IF NOT EXISTS `genere` (
  `id_categoria` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.genere: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `genere` DISABLE KEYS */;
INSERT INTO `genere` (`id_categoria`, `nom`) VALUES
	(1, 'Acció'),
	(2, 'Aventura'),
	(3, 'Comèdia'),
	(4, 'Drama'),
	(5, 'Romàntic'),
	(6, 'Suspens'),
	(7, 'Ciència ficció'),
	(8, 'Fantasia'),
	(9, 'Animació'),
	(10, 'Documental'),
	(11, 'Misteri'),
	(12, 'Crim'),
	(13, 'Història'),
	(14, 'Western'),
	(15, 'Terror');
/*!40000 ALTER TABLE `genere` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.ha_consumit
CREATE TABLE IF NOT EXISTS `ha_consumit` (
  `id_compte` int NOT NULL,
  `id_produccio` int NOT NULL,
  `num_visualitzacio` int NOT NULL,
  `favorit` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_compte`,`id_produccio`),
  KEY `id_produccio` (`id_produccio`),
  CONSTRAINT `ha_consumit_ibfk_1` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`),
  CONSTRAINT `ha_consumit_ibfk_2` FOREIGN KEY (`id_produccio`) REFERENCES `produccions` (`id_produccio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.ha_consumit: ~26 rows (aproximadamente)
/*!40000 ALTER TABLE `ha_consumit` DISABLE KEYS */;
INSERT INTO `ha_consumit` (`id_compte`, `id_produccio`, `num_visualitzacio`, `favorit`) VALUES
	(1, 13, 2, 1),
	(2, 1, 4, 1),
	(2, 3, 1, 1),
	(2, 5, 1, 0),
	(3, 3, 3, 1),
	(3, 5, 2, 1),
	(3, 9, 3, 1),
	(4, 13, 3, 1),
	(4, 14, 2, 1),
	(4, 17, 1, 0),
	(6, 2, 2, 1),
	(6, 11, 2, 1),
	(6, 18, 3, 1),
	(7, 6, 3, 0),
	(7, 7, 2, 1),
	(7, 10, 2, 1),
	(10, 7, 4, 1),
	(10, 9, 2, 0),
	(10, 10, 2, 1),
	(14, 1, 2, 1),
	(14, 20, 5, 1),
	(17, 3, 3, 1),
	(17, 4, 2, 1),
	(17, 11, 4, 1),
	(17, 16, 1, 0),
	(20, 11, 2, 1);
/*!40000 ALTER TABLE `ha_consumit` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.ha_consumit_episodi
CREATE TABLE IF NOT EXISTS `ha_consumit_episodi` (
  `id_compte` int NOT NULL,
  `id_produccio` int NOT NULL,
  `id_episodi` int NOT NULL,
  `num_visualitzacio` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_compte`,`id_produccio`,`id_episodi`),
  KEY `id_produccio` (`id_produccio`,`id_episodi`),
  CONSTRAINT `ha_consumit_episodi_ibfk_1` FOREIGN KEY (`id_compte`) REFERENCES `compte` (`id_compte`),
  CONSTRAINT `ha_consumit_episodi_ibfk_2` FOREIGN KEY (`id_produccio`, `id_episodi`) REFERENCES `episodi` (`id_produccio`, `id_episodi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.ha_consumit_episodi: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `ha_consumit_episodi` DISABLE KEYS */;
INSERT INTO `ha_consumit_episodi` (`id_compte`, `id_produccio`, `id_episodi`, `num_visualitzacio`) VALUES
	(5, 8, 4, 15),
	(10, 8, 4, 20),
	(14, 4, 1, 30),
	(16, 2, 24, 10);
/*!40000 ALTER TABLE `ha_consumit_episodi` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.modalitat
CREATE TABLE IF NOT EXISTS `modalitat` (
  `id_modalitat` int NOT NULL AUTO_INCREMENT,
  `tipus` enum('gratuïta','bàsica','prèmium') DEFAULT NULL,
  PRIMARY KEY (`id_modalitat`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.modalitat: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `modalitat` DISABLE KEYS */;
INSERT INTO `modalitat` (`id_modalitat`, `tipus`) VALUES
	(1, 'gratuïta'),
	(2, 'bàsica'),
	(3, 'prèmium');
/*!40000 ALTER TABLE `modalitat` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.participen
CREATE TABLE IF NOT EXISTS `participen` (
  `id_actor` int NOT NULL,
  `id_produccio` int NOT NULL,
  `id_episodi` int NOT NULL,
  `protagonista` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_actor`,`id_produccio`,`id_episodi`),
  KEY `id_produccio` (`id_produccio`,`id_episodi`),
  CONSTRAINT `participen_ibfk_1` FOREIGN KEY (`id_actor`) REFERENCES `actors` (`id_actor`),
  CONSTRAINT `participen_ibfk_2` FOREIGN KEY (`id_produccio`, `id_episodi`) REFERENCES `episodi` (`id_produccio`, `id_episodi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.participen: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `participen` DISABLE KEYS */;
INSERT INTO `participen` (`id_actor`, `id_produccio`, `id_episodi`, `protagonista`) VALUES
	(11, 2, 24, 1),
	(21, 8, 4, 1),
	(28, 8, 1, 1);
/*!40000 ALTER TABLE `participen` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.pelis
CREATE TABLE IF NOT EXISTS `pelis` (
  `id_produccio` int NOT NULL AUTO_INCREMENT,
  `duracio` int NOT NULL,
  `caratula` varchar(50) NOT NULL,
  PRIMARY KEY (`id_produccio`),
  CONSTRAINT `pelis_ibfk_1` FOREIGN KEY (`id_produccio`) REFERENCES `produccions` (`id_produccio`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.pelis: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pelis` DISABLE KEYS */;
INSERT INTO `pelis` (`id_produccio`, `duracio`, `caratula`) VALUES
	(1, 142, '1.jpg'),
	(3, 154, '3.jpg'),
	(5, 152, '5.jpg'),
	(7, 177, '7.jpg'),
	(9, 139, '9.jpg'),
	(11, 148, '11.jpg'),
	(13, 146, '13.jpg'),
	(15, 136, '15.jpg'),
	(18, 151, '18.jpg'),
	(20, 128, '20.jpg');
/*!40000 ALTER TABLE `pelis` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.pertany
CREATE TABLE IF NOT EXISTS `pertany` (
  `id_produccio` int NOT NULL,
  `id_categoria` int NOT NULL,
  PRIMARY KEY (`id_produccio`,`id_categoria`),
  KEY `id_categoria` (`id_categoria`),
  CONSTRAINT `pertany_ibfk_1` FOREIGN KEY (`id_produccio`) REFERENCES `produccions` (`id_produccio`),
  CONSTRAINT `pertany_ibfk_2` FOREIGN KEY (`id_categoria`) REFERENCES `genere` (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.pertany: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pertany` DISABLE KEYS */;
INSERT INTO `pertany` (`id_produccio`, `id_categoria`) VALUES
	(3, 1),
	(5, 1),
	(7, 1),
	(11, 1),
	(14, 1),
	(15, 1),
	(2, 2),
	(8, 2),
	(3, 3),
	(4, 3),
	(6, 3),
	(9, 3),
	(12, 3),
	(16, 3),
	(20, 3),
	(1, 4),
	(4, 4),
	(5, 4),
	(7, 4),
	(16, 4),
	(17, 4),
	(18, 4),
	(19, 4),
	(20, 5),
	(1, 6),
	(9, 6),
	(10, 6),
	(13, 6),
	(18, 6),
	(19, 6),
	(8, 7),
	(10, 7),
	(11, 7),
	(15, 7),
	(2, 8),
	(16, 8),
	(14, 10),
	(17, 10),
	(8, 11),
	(5, 12),
	(7, 12),
	(13, 12),
	(14, 12),
	(18, 12),
	(7, 13),
	(17, 13);
/*!40000 ALTER TABLE `pertany` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.pot_visualitzar
CREATE TABLE IF NOT EXISTS `pot_visualitzar` (
  `id_modalitat` int NOT NULL,
  `id_Produccio` int NOT NULL,
  PRIMARY KEY (`id_modalitat`,`id_Produccio`),
  KEY `id_Produccio` (`id_Produccio`),
  CONSTRAINT `pot_visualitzar_ibfk_1` FOREIGN KEY (`id_modalitat`) REFERENCES `modalitat` (`id_modalitat`),
  CONSTRAINT `pot_visualitzar_ibfk_2` FOREIGN KEY (`id_Produccio`) REFERENCES `produccions` (`id_produccio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.pot_visualitzar: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pot_visualitzar` DISABLE KEYS */;
INSERT INTO `pot_visualitzar` (`id_modalitat`, `id_Produccio`) VALUES
	(1, 2),
	(2, 2),
	(3, 3),
	(1, 4),
	(3, 5),
	(2, 6),
	(3, 8),
	(1, 9),
	(2, 11),
	(2, 13),
	(3, 14),
	(3, 16),
	(3, 17),
	(3, 18),
	(2, 19),
	(2, 20);
/*!40000 ALTER TABLE `pot_visualitzar` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.produccions
CREATE TABLE IF NOT EXISTS `produccions` (
  `id_produccio` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `nacionalitat` varchar(50) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `any_produccio` year NOT NULL,
  `favorit` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_produccio`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.produccions: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `produccions` DISABLE KEYS */;
INSERT INTO `produccions` (`id_produccio`, `nom`, `nacionalitat`, `any_produccio`, `favorit`) VALUES
	(1, 'Sueño de fuga', 'Estados Unidos', '1994', 29),
	(2, 'Game of Thrones', 'Estados Unidos', '2011', 78),
	(3, 'Pulp Fiction', 'Estados Unidos', '1994', 6),
	(4, 'Breaking Bad', 'Estados Unidos', '2008', 93),
	(5, 'The Dark Knight', 'Estados Unidos', '2008', 50),
	(6, 'Friends', 'Estados Unidos', '1994', 68),
	(7, 'The Godfather', 'Estados Unidos', '1972', 91),
	(8, 'Stranger Things', 'Estados Unidos', '2016', 51),
	(9, 'Fight Club', 'Estados Unidos', '1999', 83),
	(10, 'Black Mirror', 'Reino Unido', '2011', 61),
	(11, 'Inception', 'Estados Unidos', '2010', 57),
	(12, 'The Office', 'Estados Unidos', '2005', 3),
	(13, 'Goodfellas', 'Estados Unidos', '1990', 41),
	(14, 'Narcos', 'Estados Unidos', '2015', 99),
	(15, 'The Matrix', 'Estados Unidos', '1999', 70),
	(16, 'Stranger Than Fiction', 'Estados Unidos', '2006', 54),
	(17, 'The Crown', 'Reino Unido', '2016', 60),
	(18, 'The Departed', 'Estados Unidos', '2006', 39),
	(19, 'House of Cards', 'Estados Unidos', '2013', 15),
	(20, 'La La Land', 'Estados Unidos', '2016', 58);
/*!40000 ALTER TABLE `produccions` ENABLE KEYS */;

-- Volcando estructura para tabla bluespace.series
CREATE TABLE IF NOT EXISTS `series` (
  `id_produccio` int NOT NULL AUTO_INCREMENT,
  `caratula` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_produccio`),
  CONSTRAINT `series_ibfk_1` FOREIGN KEY (`id_produccio`) REFERENCES `produccions` (`id_produccio`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bluespace.series: ~10 rows (aproximadamente)
/*!40000 ALTER TABLE `series` DISABLE KEYS */;
INSERT INTO `series` (`id_produccio`, `caratula`) VALUES
	(2, '2.jpg'),
	(4, '4.jpg'),
	(6, '6.jpg'),
	(8, '8.jpg'),
	(10, '10.jpg'),
	(12, '12.jpg'),
	(14, '14.jpg'),
	(16, '16.jpg'),
	(17, '17.jpg'),
	(19, '19.jpg');
/*!40000 ALTER TABLE `series` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

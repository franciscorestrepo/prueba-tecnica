CREATE DATABASE  IF NOT EXISTS `asegurados_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `asegurados_db`;
-- MySQL dump 10.13  Distrib 8.0.38, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: asegurados_db
-- ------------------------------------------------------
-- Server version	9.0.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asegurados`
--

DROP TABLE IF EXISTS `asegurados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asegurados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo_identificacion` int NOT NULL,
  `numero_identificacion` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `sexo` int NOT NULL,
  `fecha_nacimiento` datetime(6) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tipo_identificacion` (`tipo_identificacion`,`numero_identificacion`),
  UNIQUE KEY `UKd3xkvuxv38r0a1lwm2uq9dq2a` (`numero_identificacion`),
  CONSTRAINT `chk_sexo` CHECK ((`sexo` in (1,2))),
  CONSTRAINT `chk_tipo_identificacion` CHECK ((`tipo_identificacion` in (1,2)))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asegurados`
--

LOCK TABLES `asegurados` WRITE;
/*!40000 ALTER TABLE `asegurados` DISABLE KEYS */;
INSERT INTO `asegurados` VALUES (1,1,'79000001','Acosta','Javier',1,'1945-01-10 00:00:00.000000'),(2,2,'79000002','Paez','Veronica',2,'1950-01-10 00:00:00.000000'),(3,2,'79000003','Restrepo','Luz',2,'1955-01-10 00:00:00.000000'),(4,1,'51000001','Ortega','Nino',1,'1960-01-10 00:00:00.000000'),(5,2,'51000002','Vera','Maria',2,'1965-01-10 00:00:00.000000'),(6,2,'51000003','Paez','Lorena',2,'1970-01-10 00:00:00.000000');
/*!40000 ALTER TABLE `asegurados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-08 22:09:54

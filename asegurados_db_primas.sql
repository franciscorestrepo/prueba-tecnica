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
-- Table structure for table `primas`
--

DROP TABLE IF EXISTS `primas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `primas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo_amparo` int NOT NULL,
  `edad_minima` int NOT NULL,
  `edad_maxima` int NOT NULL,
  `porcentaje_prima` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgresc3lf76uuluwm4c76jvs53` (`codigo_amparo`),
  CONSTRAINT `fk_codigo_amparo` FOREIGN KEY (`codigo_amparo`) REFERENCES `Amparos` (`codigo`),
  CONSTRAINT `FKgresc3lf76uuluwm4c76jvs53` FOREIGN KEY (`codigo_amparo`) REFERENCES `amparos` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `primas`
--

LOCK TABLES `primas` WRITE;
/*!40000 ALTER TABLE `primas` DISABLE KEYS */;
INSERT INTO `primas` VALUES (1,1,18,45,0.02304),(2,1,46,75,0.02012),(3,2,18,50,0.1809),(4,2,51,70,0.16043),(5,3,18,60,0.14123),(6,3,61,70,0.1545),(7,4,18,50,0.12123),(8,4,51,70,0.1345);
/*!40000 ALTER TABLE `primas` ENABLE KEYS */;
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

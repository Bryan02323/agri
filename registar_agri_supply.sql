-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: registar
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `agri_supply`
--

DROP TABLE IF EXISTS `agri_supply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agri_supply` (
  `Agri_Supply_ID` varchar(45) NOT NULL,
  `Type_of_Stock` varchar(45) DEFAULT NULL,
  `Stock_Variety` varchar(45) DEFAULT NULL,
  `Stock_Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Agri_Supply_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agri_supply`
--

LOCK TABLES `agri_supply` WRITE;
/*!40000 ALTER TABLE `agri_supply` DISABLE KEYS */;
INSERT INTO `agri_supply` VALUES ('AgriSupply-0001','Seeds','R-534','Hybrid'),('AgriSupply-0002','Fertilizer','Abono','Organic'),('AgriSupply-0003','Seeds','RC-222','Hybrid'),('AgriSupply-0004','Seeds','R-436','Inbred'),('AgriSupply-0006','Fertilizer','Urea','Inorganic'),('AgriSupply-0007','Seeds','RC-456H','Hybrid'),('AgriSupply-0008','Seeds','RC-236','hybrid'),('AgriSupply-0009','Fertilizer','Arcosia','Organic'),('AgriSupply-0010','Seeds','RC-212','Hybrid');
/*!40000 ALTER TABLE `agri_supply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-01 13:35:59

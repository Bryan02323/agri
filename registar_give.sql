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
-- Table structure for table `give`
--

DROP TABLE IF EXISTS `give`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `give` (
  `Give_ID` varchar(45) NOT NULL,
  `Date` date DEFAULT NULL,
  `Farmer_ID` varchar(45) DEFAULT NULL,
  `Farmer_Name` varchar(45) DEFAULT NULL,
  `Type_of_Stock` varchar(45) DEFAULT NULL,
  `Stock_Name` varchar(45) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Name_of_Distributor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Give_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `give`
--

LOCK TABLES `give` WRITE;
/*!40000 ALTER TABLE `give` DISABLE KEYS */;
INSERT INTO `give` VALUES ('R-0001','2022-10-26','Farmer-0001','Bryan,Catalan,Velasquez,N/A','Seeds','RC-534',50,'Efren M Torres JR'),('R-0002','2022-10-26','Farmer-0001','Bryan,Catalan,Velasquez,N/A','Seeds','RC-534',50,'Emmanuel C Escano'),('R-0003','2022-11-02','Farmer-0003','Daniel,Olat,Emass,N/A','Seeds','RC-534',50,'Bryan C Velasquez'),('R-0004','2022-11-02','Farmer-0004','Glenda,Bautista,Gazzingan,','Fertilizer','Urea',2000,'Bryan C Velasquez'),('R-0005','2022-11-06','Farmer-0002','Efren M Torres Jr','Seeds','RC-534',50,'Bryan C Velasquez'),('R-0006','2022-11-08','Farmer-0001','Bryan C Velsquez N/A','Fertilizer','Abono',1499,'Bryan C Velasquez'),('R-0007','2022-11-08','Farmer-0004','Glenda B Gazzingan ','Seeds','R-534',200,'Bryan C Velasquez'),('R-0008','2022-11-11','Farmer-0003','Daniel O Emass N/A','Fertilizer','Abono',500,'Efren M Torres'),('R-0009','2022-11-11','Farmer-0001','Velsquez B Catalan N/A','Fertilizer','Urea',20,'Efren M Torres'),('R-0010','2022-11-13','Farmer-0003','Daniel O Emass ','Seeds','R-534',121,'Efren M Torres'),('R-0011','2022-11-13','Farmer-0003','Daniel O Emass ','Seeds','R-534',6,'Efren M Torres'),('R-0012','2022-11-15','Farmer-0002','Efren M Torres Jr','Seeds','Seeds',10,'Efren M Torres'),('R-0013','2022-11-18','Farmer-0004','Glenda B Gazzingan ','Fertilizer','Fertilizer',5,'Efren M Torres'),('R-0014','2022-11-18','Farmer-0004','Glenda B Gazzingan ','Fertilizer','Fertilizer',7000,'Efren M Torres'),('R-0015','2022-11-18','Farmer-0001','Bryan C Velasquez ','Seeds','Seeds',1000,'Efren M Torres'),('R-0016','2022-11-22','Farmer-0001','Catalan V Bryan ','R-534','R-534',100,'Efren M Torres'),('R-0017','2022-11-23','Farmer-0004','Glenda B Gazzingan ','RC-222','RC-222',1000,'Efren M Torres');
/*!40000 ALTER TABLE `give` ENABLE KEYS */;
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

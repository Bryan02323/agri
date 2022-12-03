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
-- Table structure for table `stock_delivered`
--

DROP TABLE IF EXISTS `stock_delivered`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_delivered` (
  `DeliveredID` varchar(45) NOT NULL,
  `Date_Delivered` date DEFAULT NULL,
  `Stock_ID` varchar(45) DEFAULT NULL,
  `Type_of_Stock` varchar(45) DEFAULT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Quantity_Delivered` int DEFAULT NULL,
  `Type_of_the_Stock` varchar(45) DEFAULT NULL,
  `Name_of_Delivery_Man` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`DeliveredID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_delivered`
--

LOCK TABLES `stock_delivered` WRITE;
/*!40000 ALTER TABLE `stock_delivered` DISABLE KEYS */;
INSERT INTO `stock_delivered` VALUES ('Deliver-0001','2022-11-10','AgriSupply-0003','Seeds','RC-222',3000,'Hybrid','Emman'),('Deliver-0002','2022-11-10','AgriSupply-0004','Seeds','R-436',6000,'Inbrid','Edsel'),('Deliver-0003','2022-11-10','AgriSupply-0005','Seeds','R-222',3000,'Inbrid','Dan'),('Deliver-0004','2022-11-10','AgriSupply-0006','Fertilizer','Urea',4000,'Inorganic','Nel Ivan'),('Deliver-0005','2022-11-10','AgriSupply-0007','Seeds','RC-456H',5000,'Hybrid','Nicko'),('Deliver-0006','2022-11-10','AgriSupply-0008','Seeds','RC-236',2000,'hybrid','dsds'),('Deliver-0007','2022-11-10','AgriSupply-0008','Seeds','RC-236',3000,'hybrid','dfdfd'),('Deliver-0008','2022-11-10','AgriSupply-0003','Seeds','RC-222',300,'Hybrid','dsdsd'),('Deliver-0009','2022-11-11','AgriSupply-0011','Fertilizer','sds',2121,'dsds','ssd'),('Deliver-0010','2022-11-16','AgriSupply-0009','Fertilizer','Arcosia',2000,'Organic','sasa'),('Deliver-0011','2022-11-16','AgriSupply-0001','Seeds','R-534',2000,'Hybrid','Efren'),('Deliver-0012','2022-11-16','AgriSupply-0002','Fertilizer','Abono',3000,'Organic','Marvin'),('Deliver-0013','2022-11-22','AgriSupply-0001','Seeds','R-534',5000,'Hybrid','dsa'),('Deliver-0014','2022-11-22','AgriSupply-0011','Fertilizer','Manganses',1000,'Organic','Ivan');
/*!40000 ALTER TABLE `stock_delivered` ENABLE KEYS */;
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

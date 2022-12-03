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
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `FID` varchar(45) NOT NULL,
  `LName` varchar(45) NOT NULL,
  `FName` varchar(45) NOT NULL,
  `MName` varchar(45) NOT NULL,
  `EName` varchar(45) NOT NULL,
  `House_No` varchar(45) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `Barangay` varchar(45) NOT NULL,
  `Municipality` varchar(45) NOT NULL,
  `Province` varchar(45) NOT NULL,
  `Region` varchar(45) NOT NULL,
  `Contact` bigint NOT NULL,
  `Date_of_Birth` varchar(45) NOT NULL,
  `Age` varchar(45) NOT NULL,
  `Place_of_Birth` varchar(45) NOT NULL,
  `Civil_Status` varchar(45) NOT NULL,
  `Sex` varchar(45) NOT NULL,
  `Highest_Education` varchar(45) NOT NULL,
  `Religion` varchar(45) NOT NULL,
  `Religion_Specify` varchar(45) NOT NULL,
  `PWD` varchar(45) NOT NULL,
  `4Ps_Benificiary` varchar(45) NOT NULL,
  `Members_of_Indigenous` varchar(45) NOT NULL,
  `Indigen_Specify` varchar(45) NOT NULL,
  `MoaFAC` varchar(45) NOT NULL,
  `Mofac_Specify` varchar(45) NOT NULL,
  `With_Goverment_ID` varchar(45) NOT NULL,
  `GovermentID_Specify` varchar(45) NOT NULL,
  `ID_Number` bigint NOT NULL,
  `House_Hold_Head` varchar(45) NOT NULL,
  `If_no_Name_of_House_Hold_Head` varchar(45) NOT NULL,
  `Relationship` varchar(45) NOT NULL,
  `NO_House_Hold_Member` int NOT NULL,
  `No_Male` int NOT NULL,
  `No_Female` int NOT NULL,
  `Person_to_notify_in_case_of_emergency` varchar(45) NOT NULL,
  `Contact_No` bigint NOT NULL,
  `livelihood` varchar(45) DEFAULT NULL,
  `Farmingtype` varchar(45) DEFAULT NULL,
  `Date_Register` date DEFAULT NULL,
  PRIMARY KEY (`FID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES ('Farmer-0001','Bryan','Catalan','Velasquez','','365','Ortiz St','San Josef Nabao','Jaen','Nueva Ecija','3',9668565874,'2022/01/02','','Langla Jaen','Single','Male','College','Christianity','','NO','NO','NO','','NO','','YES','National ID',212,'NO','Evangeline Velasquez','Mother',7,4,3,'Arnaldo Velasquez',9553232322,NULL,NULL,'2022-11-20'),('Farmer-0002','Montes','Torres','Efren','Jr','350','Dela Cruz','Dampulan','Jaen','Nueva Ecija','3',9324259431,'2022/01/02','','San Antonio','Single','Male','College','Christianity','','NO','NO','NO','','NO','','YES','National ID',32,'NO','dasd','Mother',4,2,2,'asfffs',9648365861,NULL,NULL,'2022-11-23'),('Farmer-0003','Daniel','Olat','Emass','a','202','Santiago','San Josef Nabao','Jaen','Nueva Ecija','3',9446482751,'2022/01/02','','San Isidro','Single','Male','College','Christianity','','NO','NO','NO','','NO','','YES','National ID',212,'NO','sdsds','dsds',3,2,1,'sdsds',9436742131,NULL,NULL,'2022-10-27'),('Farmer-0004','Gazzingan','Glenda','Bautista','','224','3','Langla','Jaen','Nueva Ecija','3',123456789,'1982-11-12','','San Antonio,N.E.','Single','Female','College','Others','INC','NO','NO','NO','','YES','','YES','PRC',32456,'NO','Kennedy','Spouse',5,3,2,'Kennedy',131242435,NULL,NULL,'2022-10-27'),('Farmer-0005','dsads','sadsa','dasd','','232','dd','Dampulan','Jaen','Nueva Ecija','3',32232323232,'1992/01/05','30','sdasas','Single','Male','Pre-School','Christianity','','NO','NO','NO','','NO','','YES','National ID',32322232332,'NO','','',4,3,1,'dasdasdas3',32323222,'Farmer','Rice','2022-11-23'),('Farmer-0006','vhuhgh','gyug','fuf','','554','ftyf','Calabasa','Jaen','Nueva Ecija','3',9999999999,'1997/01/01','25','ghhhgfkfu','Single','Male','Pre-School','Christianity','','NO','NO','NO','','NO','','YES','ghggg',566565,'NO','','',6,3,3,'ftfhgfhg',87888788787,'Farmer','Rice','2022-11-24');
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
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

CREATE DATABASE  IF NOT EXISTS `cupcakedb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `cupcakedb`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: cupcakedb
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bottoms`
--

DROP TABLE IF EXISTS `bottoms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bottoms` (
  `bottom_id` int(11) NOT NULL AUTO_INCREMENT,
  `bottom_name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`bottom_id`),
  UNIQUE KEY `bottom_id_UNIQUE` (`bottom_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bottoms`
--

LOCK TABLES `bottoms` WRITE;
/*!40000 ALTER TABLE `bottoms` DISABLE KEYS */;
INSERT INTO `bottoms` VALUES (41,'Chocolate',5),(42,'Vanilla',5),(43,'Nutmeg',5),(44,'Pistacio',6),(45,'Almond',7);
/*!40000 ALTER TABLE `bottoms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `has_lineitem`
--

DROP TABLE IF EXISTS `has_lineitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `has_lineitem` (
  `cartid` int(11) NOT NULL,
  `lineid` int(11) NOT NULL,
  PRIMARY KEY (`cartid`,`lineid`),
  KEY `lineitemid_idx` (`lineid`),
  CONSTRAINT `lineitemid` FOREIGN KEY (`lineid`) REFERENCES `lineitems` (`idlineitems`),
  CONSTRAINT `shoppingcartid` FOREIGN KEY (`cartid`) REFERENCES `shoppingcart` (`idshoppingcart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lineitems`
--

DROP TABLE IF EXISTS `lineitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `lineitems` (
  `idlineitems` int(11) NOT NULL,
  `cupcake` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlineitems`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shoppingcart` (
  `idshoppingcart` int(11) NOT NULL,
  `customer` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idshoppingcart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `toppings`
--

DROP TABLE IF EXISTS `toppings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `toppings` (
  `topping_id` int(11) NOT NULL AUTO_INCREMENT,
  `topping_name` varchar(45) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`topping_id`),
  UNIQUE KEY `topping_id_UNIQUE` (`topping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `toppings`
--

LOCK TABLES `toppings` WRITE;
/*!40000 ALTER TABLE `toppings` DISABLE KEYS */;
INSERT INTO `toppings` VALUES (51,'Chocolate',5),(52,'Blueberry',5),(53,'Rasberry',5),(54,'Crispy',6),(55,'Rum/Raisin',7),(56,'Orange',8),(57,'Lemon',8),(58,'Blue cheese',9);
/*!40000 ALTER TABLE `toppings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `username` varchar(12) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balance` double NOT NULL DEFAULT '0',
  `email` varchar(45) NOT NULL,
  `is_admin` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('pinky','66654321',506,'Redroom4hire@blackmail.onion',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-11 11:05:12

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
-- Dumping data for table `has_lineitem`
--

LOCK TABLES `has_lineitem` WRITE;
/*!40000 ALTER TABLE `has_lineitem` DISABLE KEYS */;
INSERT INTO `has_lineitem` VALUES (256,22),(46,62),(5,69),(424,114),(408,182),(219,229),(443,252),(219,255),(456,323),(205,345),(128,420);
/*!40000 ALTER TABLE `has_lineitem` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `lineitems`
--

LOCK TABLES `lineitems` WRITE;
/*!40000 ALTER TABLE `lineitems` DISABLE KEYS */;
INSERT INTO `lineitems` VALUES (22,'Blue cheese_bottom_Nutmeg_topping',70,5),(62,'Chocolate_bottom_Chocolate_topping',30,3),(69,'Blue Cheese_bottom_Chocolate_topping',69,69),(114,'Chocolate_bottom_Chocolate_topping',30,3),(182,'Chocolate_bottom_Chocolate_topping',10,1),(229,'Blue cheese_bottom_Chocolate_topping',70,5),(252,'Chocolate_bottom_Chocolate_topping',30,3),(255,'Lemon_bottom_Almond_topping',45,3),(323,'Blue cheese_bottom_Chocolate_topping',98,7),(345,'Rasberry_bottom_Pistacio_topping',99,9),(420,'Rum/Raisin_bottom_Pistacio_topping',65,5);
/*!40000 ALTER TABLE `lineitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_cupcakes`
--

DROP TABLE IF EXISTS `ordered_cupcakes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ordered_cupcakes` (
  `order_number` int(11) NOT NULL,
  `topping_id` int(11) NOT NULL,
  `bottom_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`order_number`,`topping_id`,`bottom_id`),
  KEY `order_number` (`order_number`),
  KEY `topping_id` (`topping_id`),
  KEY `bottom_id` (`bottom_id`),
  CONSTRAINT `ordered_cupcakes_ibfk_1` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ordered_cupcakes_ibfk_2` FOREIGN KEY (`topping_id`) REFERENCES `toppings` (`topping_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ordered_cupcakes_ibfk_3` FOREIGN KEY (`bottom_id`) REFERENCES `bottoms` (`bottom_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_cupcakes`
--

LOCK TABLES `ordered_cupcakes` WRITE;
/*!40000 ALTER TABLE `ordered_cupcakes` DISABLE KEYS */;
INSERT INTO `ordered_cupcakes` VALUES (1,52,45,5);
/*!40000 ALTER TABLE `ordered_cupcakes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `order_number` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(12) NOT NULL,
  PRIMARY KEY (`order_number`),
  UNIQUE KEY `order_number_UNIQUE` (`order_number`),
  KEY `username` (`username`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'aaa'),(2,'Jake'),(3,'Pinky');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `shoppingcart`
--

LOCK TABLES `shoppingcart` WRITE;
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
INSERT INTO `shoppingcart` VALUES (5,'pinky'),(46,'aaa'),(128,'pinky'),(205,'pinky'),(219,'lukas'),(256,'aaa'),(408,'aaa'),(424,'aaa'),(443,'pinky'),(456,'aaa');
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `users` VALUES ('','',0,'',NULL),('112121te','test',0,'teatas',NULL),('1234555','hsfhasihf',0,'shfiuasf',NULL),('aaa','123',312,'aaa',NULL),('ajioasjgjio','AKFASF',0,'asf',NULL),('asgas','ajksfasj',0,'aksgajks',NULL),('asjioasioj','jiasjioa',0,'jiasas',NULL),('cakeMonster','rawr',0,'nom@blackmail.onion',NULL),('ddd','123',0,'ddd',NULL),('HRsovs','666',0,'zzz@sovs.dk',NULL),('ItJust','works',0,'trustme@bethesda.gmail.com',0),('Jake','bruh',0,'bruhMail@bruh.bruh',0),('lukas','1234',385,'aklsfhl',0),('lulmonster','lulul',0,'lululul@lul.onion',0),('pinky','66654321',506,'Redroom4hire@blackmail.onion',1),('qqq','qqq',0,'qqq',NULL),('ruinedMaybe','perhaps',0,'ohno',0),('te','',0,'',NULL),('test','1234',0,'testmail',NULL),('Tobias','test',0,'test@mail.mail',0),('tryAgain','tryAgain123',0,'tryAgain@lul.onion',0);
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

-- Dump completed on 2019-03-11 11:19:15

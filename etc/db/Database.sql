-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: leasing_db
-- ------------------------------------------------------
-- Server version	5.5.59-MariaDB

create schema leasing_db CHARACTER SET utf8
    COLLATE utf8_general_ci;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

use leasing_db;

--
-- Table structure for table `brand`
--
DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
                         `id` bigint(20) NOT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`id`, `name`) VALUES (1,'BMW'),(2,'AUDI'),(3,'VW');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
                            `id` bigint(20) NOT NULL,
                            `birth_date` datetime(6) DEFAULT NULL,
                            `first_name` varchar(255) DEFAULT NULL,
                            `last_name` varchar(255) DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `birth_date`, `first_name`, `last_name`) VALUES (1,'1980-01-01 01:00:00.000000','Max','Musterman'),(2,'1990-10-14 01:00:00.000000','Maria','Musterfrau'),(3,'1980-01-01 01:00:00.000000','Ericka','Musterman');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leasing_contract`
--

DROP TABLE IF EXISTS `leasing_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leasing_contract` (
                                    `id` bigint(20) NOT NULL,
                                    `contract_number` int(11) DEFAULT NULL,
                                    `monthly_rate` double DEFAULT NULL,
                                    `customer_id` bigint(20) DEFAULT NULL,
                                    `vehicle_id` bigint(20) DEFAULT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `uk_vehicle` (`vehicle_id`),
                                    KEY `FKpxeeq63s4vh9272vr2tipsh2s` (`customer_id`),
                                    CONSTRAINT `FKqpkf9hkk4ps9mg91ifuc16qni` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`),
                                    CONSTRAINT `FKpxeeq63s4vh9272vr2tipsh2s` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leasing_contract`
--

LOCK TABLES `leasing_contract` WRITE;
/*!40000 ALTER TABLE `leasing_contract` DISABLE KEYS */;
INSERT INTO `leasing_contract` (`id`, `contract_number`, `monthly_rate`, `customer_id`, `vehicle_id`) VALUES (1,123567,350,1,1),(2,123568,365,2,2);
/*!40000 ALTER TABLE `leasing_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
                         `id` bigint(20) NOT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `brand_id` bigint(20) DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `FKhbgv4j3vpt308sepyq9q79mhu` (`brand_id`),
                         CONSTRAINT `FKhbgv4j3vpt308sepyq9q79mhu` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` (`id`, `name`, `brand_id`) VALUES (1,'320d',1),(2,'530d',1),(3,'750i',1),(4,'A4',2),(5,'A5',2),(6,'A7',2),(7,'Golf',3),(8,'Passat',3),(9,'Arteon',3);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
                           `id` bigint(20) NOT NULL,
                           `available` bit(1) DEFAULT NULL,
                           `brand` varchar(255) DEFAULT NULL,
                           `model` varchar(255) DEFAULT NULL,
                           `price` double DEFAULT NULL,
                           `vin` varchar(255) DEFAULT NULL,
                           `year` int(11) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`id`, `available`, `brand`, `model`, `price`, `vin`, `year`) VALUES (1,_binary '\0','BMW','320d',32000,'vvwsukeoe8dsh3',2018),(2,_binary '\0','AUDI','A7',27000,'ezwid74iufkci83',2022),(3,_binary '','VW','GOLF',32000,'ruewiofkw87',2021),(4,_binary '','BMW','530d',32000,'ruewiofkw87',2021),(5,_binary '','AUDI','A5',32000,'ruewiofkw87',2021);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-09 22:17:50

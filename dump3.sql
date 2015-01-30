-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: mybatis_demo
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BLOG`
--

DROP TABLE IF EXISTS `BLOG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BLOG` (
  `blog_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `blog_name` varchar(45) NOT NULL,
  `created_on` datetime NOT NULL,
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BLOG`
--

LOCK TABLES `BLOG` WRITE;
/*!40000 ALTER TABLE `BLOG` DISABLE KEYS */;
INSERT INTO `BLOG` VALUES (1,'test_blog_1422528644019','2015-01-29 12:50:44'),(2,'TestBlogName1422613635626','2015-01-29 12:51:03'),(3,'test_blog_1422528674593','2015-01-29 12:51:14'),(4,'test_blog_1422613635397','2015-01-30 12:27:15'),(5,'test_blog_1422610546242','2015-01-30 11:35:46'),(6,'test_blog_1422610975932','2015-01-30 11:42:55'),(7,'test_blog_1422611018131','2015-01-30 11:43:38'),(8,'test_blog_1422611056213','2015-01-30 11:44:16'),(9,'test_blog_1422613509589','2015-01-30 12:25:09'),(10,'test_blog_1422613510463','2015-01-30 12:25:10'),(12,'test_blog_1422613635968','2015-01-30 12:27:15');
/*!40000 ALTER TABLE `BLOG` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `POST`
--

DROP TABLE IF EXISTS `POST`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `POST` (
  `post_id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `content` varchar(1024) NOT NULL,
  `created_on` datetime NOT NULL,
  `blog_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `FK_post_blog` (`blog_id`),
  CONSTRAINT `FK_post_blog` FOREIGN KEY (`blog_id`) REFERENCES `BLOG` (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `POST`
--

LOCK TABLES `POST` WRITE;
/*!40000 ALTER TABLE `POST` DISABLE KEYS */;
/*!40000 ALTER TABLE `POST` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `email_id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `blog_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `Index_2_email_uniq` (`email_id`),
  UNIQUE KEY `blog_id_UNIQUE` (`blog_id`),
  CONSTRAINT `FK_user_blog` FOREIGN KEY (`blog_id`) REFERENCES `BLOG` (`blog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER`
--

LOCK TABLES `USER` WRITE;
/*!40000 ALTER TABLE `USER` DISABLE KEYS */;
INSERT INTO `USER` VALUES (1,'test_email_1422491077071@gmail.com','secret','TestFirstName','TestLastName',NULL),(2,'test_email_1422491327947@gmail.com','secret','TestFirstName1422613636162','TestLastName1422613636162',NULL),(3,'test_email_1422491349470@gmail.com','secret','TestFirstName','TestLastName',NULL),(4,'test_email_1422613510395@gmail.com','secret','TestFirstName','TestLastName',NULL),(7,'test_email_1422607645834@gmail.com','secret','TestFirstName','TestLastName',NULL),(8,'test_email_1422607645949@gmail.com','secret','TestFirstName','TestLastName',NULL),(9,'test_email_1422610546032@gmail.com','secret','TestFirstName','TestLastName',NULL),(10,'test_email_1422610546242@gmail.com','secret','TestFirstName','TestLastName',NULL),(11,'test_email_1422610975826@gmail.com','secret','TestFirstName','TestLastName',NULL),(12,'test_email_1422611056210@gmail.com','secret','TestFirstName','TestLastName',8),(14,'test_email_1422613510463@gmail.com','secret','TestFirstName','TestLastName',10),(15,'test_email_1422613635859@gmail.com','secret','TestFirstName','TestLastName',NULL),(16,'test_email_1422613635968@gmail.com','secret','TestFirstName','TestLastName',12);
/*!40000 ALTER TABLE `USER` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-30 12:42:08

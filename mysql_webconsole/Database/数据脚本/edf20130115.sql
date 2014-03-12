-- MySQL dump 10.13  Distrib 5.5.28, for Win64 (x86)
--
-- Host: localhost    Database: EDF
-- ------------------------------------------------------
-- Server version	5.5.28

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
-- Table structure for table `c_tab`
--

DROP TABLE IF EXISTS `c_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_tab` (
  `tab_id` int(11) NOT NULL AUTO_INCREMENT,
  `tab_name` varchar(30) NOT NULL,
  `tab_sqlname` varchar(30) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`tab_id`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tab`
--

LOCK TABLES `c_tab` WRITE;
/*!40000 ALTER TABLE `c_tab` DISABLE KEYS */;
INSERT INTO `c_tab` VALUES (24,'学生表','student_info','2012-12-23 22:54:44','2013-01-14 22:19:49'),(31,'用户表展现','portaluserinfo','2012-12-24 00:17:59','2013-01-14 23:49:25'),(33,'系统菜单','sys_menu','2012-12-24 18:36:42','2012-12-24 18:36:42'),(35,'系统菜单表','sys_menu','2013-01-06 22:42:59','2013-01-06 22:42:59'),(36,'菜单表关联导航表','sys_menu','2013-01-06 23:20:18','2013-01-14 23:52:45'),(37,'系统菜单表','sys_menu','2013-01-08 21:28:04','2013-01-15 13:39:46'),(38,'用户表','portaluserinfo','2013-01-09 13:58:46','2013-01-09 13:58:46'),(39,'sys_navigator','sys_navigator','2013-01-12 23:21:10','2013-01-13 22:19:19'),(44,'菜单测试20130115','sys_menu','2013-01-15 13:53:32','2013-01-15 13:54:20'),(43,'菜单表（测试）','sys_menu','2013-01-14 21:21:50','2013-01-14 21:33:57');
/*!40000 ALTER TABLE `c_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tab_column`
--

DROP TABLE IF EXISTS `c_tab_column`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_tab_column` (
  `tab_id` int(11) NOT NULL,
  `col_sqlname` varchar(30) NOT NULL,
  `col_sqltype` varchar(30) NOT NULL,
  `col_size` smallint(6) DEFAULT NULL,
  `col_desc` varchar(100) DEFAULT NULL,
  `isnullable` varchar(2) NOT NULL,
  `ispk` varchar(2) NOT NULL,
  `datadict` varchar(50) DEFAULT NULL,
  `sub_tab_id` int(11) DEFAULT NULL,
  `sub_tab_col_sqlname` varchar(30) DEFAULT NULL,
  `validation_type` varchar(30) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`tab_id`,`col_sqlname`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tab_column`
--

LOCK TABLES `c_tab_column` WRITE;
/*!40000 ALTER TABLE `c_tab_column` DISABLE KEYS */;
INSERT INTO `c_tab_column` VALUES (23,'userid','int',11,'','02','01','',0,'','','2012-12-23 22:40:56','2012-12-23 22:40:56'),(23,'username','varchar',50,'','02','02','',0,'','','2012-12-23 22:40:56','2012-12-23 22:40:56'),(23,'password','varchar',25,'','02','02','',0,'','','2012-12-23 22:40:56','2012-12-23 22:40:56'),(23,'email','varchar',50,'','01','02','',0,'','','2012-12-23 22:40:56','2012-12-23 22:40:56'),(23,'tel','varchar',25,'','01','02','',0,'','','2012-12-23 22:40:56','2012-12-23 22:40:56'),(23,'name','varchar',50,'','02','02','',0,'','','2012-12-23 22:40:56','2012-12-23 22:40:56'),(24,'STU_ID','int',13,'学生ID','02','01','0',0,'','','2012-12-23 22:54:44','2013-01-14 22:19:49'),(24,'STUNAME','varchar',50,'姓名','02','02','0',0,'','','2012-12-23 22:54:44','2013-01-14 22:19:49'),(24,'PASSWORD','varchar',50,'密码','01','02','0',0,'','','2012-12-23 22:54:44','2013-01-14 22:19:49'),(24,'BIRTH_DATE','datetime',19,'生日','01','02','0',0,'','','2012-12-23 22:54:44','2013-01-14 22:19:49'),(24,'SEX','int',2,'性别','01','02','0',0,'','','2012-12-23 22:54:44','2013-01-14 22:19:49'),(24,'AGE','int',3,'年龄','01','02','0',0,'','','2012-12-23 22:54:44','2013-01-14 22:19:49'),(26,'userid','int',11,'','02','01','',0,'','','2012-12-23 23:35:21','2012-12-23 23:35:21'),(26,'username','varchar',50,'','02','02','',0,'','','2012-12-23 23:35:21','2012-12-23 23:35:21'),(26,'password','varchar',25,'','02','02','',0,'','','2012-12-23 23:35:21','2012-12-23 23:35:21'),(26,'email','varchar',50,'','01','02','',0,'','','2012-12-23 23:35:21','2012-12-23 23:35:21'),(26,'tel','varchar',25,'','01','02','',0,'','','2012-12-23 23:35:21','2012-12-23 23:35:21'),(26,'name','varchar',50,'','02','02','',0,'','','2012-12-23 23:35:21','2012-12-23 23:35:21'),(31,'userid','int',11,'用户ID','02','01','0',0,'','','2012-12-24 00:17:59','2013-01-14 23:49:25'),(31,'username','varchar',50,'用户姓名','02','02','0',0,'','','2012-12-24 00:17:59','2013-01-14 23:49:25'),(31,'password','varchar',25,'密码','02','02','0',0,'','','2012-12-24 00:17:59','2013-01-14 23:49:25'),(31,'email','varchar',50,'电子邮件','01','02','0',0,'','','2012-12-24 00:17:59','2013-01-14 23:49:25'),(31,'tel','varchar',25,'电话','01','02','0',0,'','','2012-12-24 00:17:59','2013-01-14 23:49:25'),(31,'name','varchar',50,'姓名','02','02','0',0,'','','2012-12-24 00:17:59','2013-01-14 23:49:25'),(33,'MENU_ID','int',11,'','02','01','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'NAV_ID','int',11,'','02','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_TITLE','varchar',50,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_CODE','varchar',50,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_URL','varchar',500,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_SEQ','int',11,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_STATUS','int',11,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_PARENT_ID','int',11,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(33,'MENU_NOTE','varchar',255,'','01','02','',0,'','','2012-12-24 18:36:42','2012-12-24 18:36:42'),(35,'MENU_ID','int',11,'','02','01','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'NAV_ID','int',11,'','02','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_TITLE','varchar',50,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_CODE','varchar',50,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_URL','varchar',500,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_SEQ','int',11,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_STATUS','int',11,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_PARENT_ID','int',11,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(35,'MENU_NOTE','varchar',255,'','01','02','',0,'','','2013-01-06 22:42:59','2013-01-06 22:42:59'),(36,'MENU_ID','int',11,'','02','01','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'NAV_ID','int',11,'','02','02','0',39,'NAV_ID','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_TITLE','varchar',50,'','01','02','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_CODE','varchar',50,'','01','02','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_URL','varchar',500,'','01','02','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_SEQ','int',11,'','01','02','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_STATUS','int',11,'','01','02','267',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_PARENT_ID','int',11,'','01','02','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(36,'MENU_NOTE','varchar',255,'','01','02','0',0,'','','2013-01-06 23:20:18','2013-01-14 23:52:45'),(37,'MENU_ID','int',11,'','02','01','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'NAV_ID','int',11,'','02','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_TITLE','varchar',50,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_CODE','varchar',50,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_URL','varchar',500,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_SEQ','int',11,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_STATUS','int',11,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_PARENT_ID','int',11,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(37,'MENU_NOTE','varchar',255,'','01','02','0',0,'','','2013-01-08 21:28:04','2013-01-15 13:39:46'),(38,'userid','int',11,'用户ID','02','01','',0,'','','2013-01-09 13:58:46','2013-01-09 13:58:46'),(38,'username','varchar',50,'用户姓名','02','02','',0,'','','2013-01-09 13:58:46','2013-01-09 13:58:46'),(38,'password','varchar',25,'密码','02','02','',0,'','','2013-01-09 13:58:46','2013-01-09 13:58:46'),(38,'email','varchar',50,'电子邮件','01','02','',0,'','','2013-01-09 13:58:46','2013-01-09 13:58:46'),(38,'tel','varchar',25,'电话','01','02','',0,'','','2013-01-09 13:58:46','2013-01-09 13:58:46'),(38,'name','varchar',50,'姓名','02','02','',0,'','','2013-01-09 13:58:46','2013-01-09 13:58:46'),(39,'NAV_ID','int',11,'','02','01','0',0,'','','2013-01-12 23:21:10','2013-01-13 22:19:19'),(39,'NAV_NAME','varchar',50,'','01','02','0',0,'','','2013-01-12 23:21:10','2013-01-13 22:19:19'),(39,'NAV_URL','varchar',500,'','01','02','0',0,'','','2013-01-12 23:21:10','2013-01-13 22:19:19'),(39,'NAV_SEQ','int',11,'','01','02','0',0,'','','2013-01-12 23:21:10','2013-01-13 22:19:19'),(39,'NAV_NOTE','varchar',255,'','01','02','0',0,'','','2013-01-12 23:21:10','2013-01-13 22:19:19'),(39,'NAV_STATUS','int',11,'','01','02','263',0,'','','2013-01-12 23:21:10','2013-01-13 22:19:19'),(44,'MENU_STATUS','int',11,'MENU_STATUS','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_PARENT_ID','int',11,'MENU_PARENT_ID','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_NOTE','varchar',255,'MENU_NOTE','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_SEQ','int',11,'MENU_SEQ','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_ID','int',11,'MENU_ID','02','01','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'NAV_ID','int',11,'NAV_ID','02','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_TITLE','varchar',50,'MENU_TITLE','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_CODE','varchar',50,'MENU_CODE','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(44,'MENU_URL','varchar',500,'MENU_URL','01','02','0',0,'','','2013-01-15 13:53:32','2013-01-15 13:54:20'),(43,'MENU_ID','int',11,'','02','01','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'NAV_ID','int',11,'','02','02','0',39,'NAV_ID','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_TITLE','varchar',50,'','01','02','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_CODE','varchar',50,'','01','02','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_URL','varchar',500,'','01','02','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_SEQ','int',11,'','01','02','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_STATUS','int',11,'','01','02','267',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_PARENT_ID','int',11,'','01','02','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57'),(43,'MENU_NOTE','varchar',255,'','01','02','0',0,'','','2013-01-14 21:21:50','2013-01-14 21:33:57');
/*!40000 ALTER TABLE `c_tab_column` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tab_column_disp`
--

DROP TABLE IF EXISTS `c_tab_column_disp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_tab_column_disp` (
  `tab_disp_id` int(11) NOT NULL,
  `full_col_sqlname` varchar(60) NOT NULL,
  `is_in_list` varchar(2) NOT NULL,
  `list_disp_name` varchar(30) DEFAULT NULL,
  `support_sort` varchar(2) NOT NULL,
  `support_query` varchar(2) NOT NULL,
  `list_disp_order` smallint(6) DEFAULT NULL,
  `is_in_form` varchar(2) NOT NULL,
  `form_disp_name` varchar(30) DEFAULT NULL,
  `support_update` varchar(2) NOT NULL,
  `form_disp_type` varchar(2) DEFAULT NULL,
  `sub_tab_disp_cols` varchar(255) DEFAULT NULL,
  `form_disp_order` smallint(6) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`tab_disp_id`,`full_col_sqlname`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tab_column_disp`
--

LOCK TABLES `c_tab_column_disp` WRITE;
/*!40000 ALTER TABLE `c_tab_column_disp` DISABLE KEYS */;
INSERT INTO `c_tab_column_disp` VALUES (17,'MENU_NOTE','01','MENU_NOTE','01','01',0,'01','MENU_NOTE','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(4,'STU_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 00:14:40','2012-12-24 00:14:40'),(4,'STUNAME','01','','01','01',0,'01','','01','01','',0,'2012-12-24 00:14:40','2012-12-24 00:14:40'),(4,'PASSWORD','01','','01','01',0,'01','','01','01','',0,'2012-12-24 00:14:40','2012-12-24 00:14:40'),(4,'BIRTH_DATE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 00:14:40','2012-12-24 00:14:40'),(4,'SEX','01','','01','01',0,'01','','01','01','',0,'2012-12-24 00:14:40','2012-12-24 00:14:40'),(4,'AGE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 00:14:40','2012-12-24 00:14:40'),(5,'userid','01','userid','01','01',0,'01','userid','02','01','',0,'2012-12-24 00:18:14','2013-01-14 23:49:33'),(5,'username','01','username','01','01',0,'01','username','01','01','',0,'2012-12-24 00:18:14','2013-01-14 23:49:33'),(5,'password','01','password','01','01',0,'01','password','01','01','',0,'2012-12-24 00:18:14','2013-01-14 23:49:33'),(5,'email','01','email','01','01',0,'01','email','01','01','',0,'2012-12-24 00:18:14','2013-01-14 23:49:33'),(5,'tel','01','tel','01','01',0,'01','tel','01','01','',0,'2012-12-24 00:18:14','2013-01-14 23:49:33'),(5,'name','01','name','01','01',0,'01','name','01','01','',0,'2012-12-24 00:18:14','2013-01-14 23:49:33'),(6,'MENU_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'NAV_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_TITLE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_CODE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_URL','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_SEQ','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_STATUS','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_PARENT_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(6,'MENU_NOTE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 13:46:10','2012-12-24 13:46:10'),(7,'MENU_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'NAV_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_TITLE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_CODE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_URL','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_SEQ','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_STATUS','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_PARENT_ID','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(7,'MENU_NOTE','01','','01','01',0,'01','','01','01','',0,'2012-12-24 18:36:56','2012-12-24 18:36:56'),(17,'MENU_PARENT_ID','01','MENU_PARENT_ID','01','01',0,'01','MENU_PARENT_ID','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'MENU_ID','01','MENU_ID','01','01',0,'01','MENU_ID','02','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'NAV_ID','01','NAV_ID','01','01',0,'01','NAV_ID','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'MENU_TITLE','01','MENU_TITLE','01','01',0,'01','MENU_TITLE','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'MENU_CODE','01','MENU_CODE','01','01',0,'01','MENU_CODE','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'MENU_URL','01','MENU_URL','01','01',0,'01','MENU_URL','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'MENU_SEQ','01','MENU_SEQ','01','01',0,'01','MENU_SEQ','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(17,'MENU_STATUS','01','MENU_STATUS','01','01',0,'01','MENU_STATUS','01','01','',0,'2013-01-15 13:53:49','2013-01-15 13:54:31'),(9,'MENU_ID','01','菜单ID','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'NAV_ID','01','导航ID','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_TITLE','01','菜单标题','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_CODE','02','','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_URL','01','菜单url','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_SEQ','01','菜单序号','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_STATUS','01','菜单状态','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_PARENT_ID','02','','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(9,'MENU_NOTE','02','','01','01',0,'01','','01','01','',0,'2013-01-06 22:44:15','2013-01-06 22:44:15'),(10,'MENU_ID','01','菜单CODE','01','01',0,'02','菜单CODE','02','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'NAV_ID','01','导航ID','01','01',0,'01','导航ID','01','01','NAV_NAME',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_TITLE','01','菜单标题','01','01',0,'01','菜单标题','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_CODE','02','菜单CODE','01','01',0,'01','菜单CODE','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_URL','01','菜单URL','01','01',0,'01','菜单URL','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_SEQ','02','菜单SEQ','01','01',0,'01','菜单SEQ','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_STATUS','02','菜单状态','01','01',0,'01','菜单状态','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_PARENT_ID','02','菜单父ID','01','01',0,'01','菜单父ID','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(10,'MENU_NOTE','02','菜案备注','01','01',0,'01','菜案备注','01','01','',0,'2013-01-06 23:24:33','2013-01-14 23:53:06'),(11,'MENU_ID','01','菜单ID','01','01',0,'01','菜单ID','02','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'NAV_ID','01','导航ID','01','01',0,'01','导航ID','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_TITLE','01','菜单标题','01','01',0,'01','菜单标题','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_CODE','01','菜单CODE','01','01',0,'01','菜单CODE','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_URL','01','菜单URL','01','01',0,'01','菜单URL','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_SEQ','01','菜单SEQ','01','01',0,'01','菜单SEQ','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_STATUS','01','菜单状态','01','01',0,'01','菜单状态','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_PARENT_ID','01','父菜单ID','01','01',0,'01','父菜单ID','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(11,'MENU_NOTE','01','菜单备注','01','01',0,'01','菜单备注','01','01','',0,'2013-01-08 21:30:49','2013-01-15 13:39:55'),(12,'userid','01','用户ID','01','01',0,'01','用户ID','02','01','',0,'2013-01-09 14:01:07','2013-01-09 14:01:07'),(12,'username','01','用户姓名','01','01',0,'01','用户姓名','01','01','',0,'2013-01-09 14:01:07','2013-01-09 14:01:07'),(12,'password','01','密码','01','01',0,'01','密码','01','01','',0,'2013-01-09 14:01:07','2013-01-09 14:01:07'),(12,'email','01','电子邮件','01','01',0,'01','电子邮件','01','01','',0,'2013-01-09 14:01:07','2013-01-09 14:01:07'),(12,'tel','01','电话','01','01',0,'01','电话','01','01','',0,'2013-01-09 14:01:07','2013-01-09 14:01:07'),(12,'name','01','姓名','01','01',0,'01','姓名','01','01','',0,'2013-01-09 14:01:07','2013-01-09 14:01:07'),(13,'NAV_ID','01','导航ID','01','01',0,'01','导航ID','02','01','',0,'2013-01-12 23:21:32','2013-01-13 22:20:23'),(13,'NAV_NAME','01','导航名称','01','01',0,'01','导航名称','01','01','',0,'2013-01-12 23:21:32','2013-01-13 22:20:23'),(13,'NAV_URL','01','导航URL','01','01',0,'01','导航URL','01','01','',0,'2013-01-12 23:21:32','2013-01-13 22:20:23'),(13,'NAV_SEQ','01','','01','01',0,'01','','01','01','',0,'2013-01-12 23:21:32','2013-01-13 22:20:23'),(13,'NAV_NOTE','01','导航备注','01','01',0,'01','导航备注','01','01','',0,'2013-01-12 23:21:32','2013-01-13 22:20:23'),(13,'NAV_STATUS','01','导航状态','01','01',0,'01','导航备注','01','01','',0,'2013-01-12 23:21:32','2013-01-13 22:20:23'),(14,'MENU_ID','01','菜单ID','01','01',0,'01','菜单ID','02','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'NAV_ID','01','导航ID','01','01',0,'01','导航ID','01','01','NAV_ID, NAV_NAME',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_TITLE','01','菜单标题','01','01',0,'01','菜单标题','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_CODE','01','菜单CODE','01','01',0,'01','菜单CODE','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_URL','01','菜单URL','01','01',0,'01','菜单URL','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_SEQ','02','菜单SEQ','01','01',0,'01','菜单SEQ','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_STATUS','01','菜单状态','01','01',0,'01','菜单状态','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_PARENT_ID','02','父ID','01','01',0,'01','父ID','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(14,'MENU_NOTE','02','菜单备注','01','01',0,'01','菜单备注','01','01','',0,'2013-01-14 21:24:33','2013-01-14 21:24:33'),(15,'STU_ID','01','学生ID','01','01',0,'01','学生ID','01','01','',0,'2013-01-14 22:20:05','2013-01-14 22:20:05'),(15,'STUNAME','01','姓名','01','01',0,'01','姓名','01','01','',0,'2013-01-14 22:20:05','2013-01-14 22:20:05'),(15,'PASSWORD','01','密码','01','01',0,'01','密码','01','01','',0,'2013-01-14 22:20:05','2013-01-14 22:20:05'),(15,'BIRTH_DATE','01','生日','01','01',0,'01','生日','01','01','',0,'2013-01-14 22:20:05','2013-01-14 22:20:05'),(15,'SEX','01','性别','01','01',0,'01','性别','01','01','',0,'2013-01-14 22:20:05','2013-01-14 22:20:05'),(15,'AGE','01','年龄','01','01',0,'01','年龄','01','01','',0,'2013-01-14 22:20:05','2013-01-14 22:20:05');
/*!40000 ALTER TABLE `c_tab_column_disp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tab_column_verify`
--

DROP TABLE IF EXISTS `c_tab_column_verify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_tab_column_verify` (
  `validation_type` varchar(30) NOT NULL,
  `regular_exp` varchar(100) NOT NULL,
  `message` varchar(100) NOT NULL,
  `validation_desc` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`validation_type`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tab_column_verify`
--

LOCK TABLES `c_tab_column_verify` WRITE;
/*!40000 ALTER TABLE `c_tab_column_verify` DISABLE KEYS */;
/*!40000 ALTER TABLE `c_tab_column_verify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tab_disp`
--

DROP TABLE IF EXISTS `c_tab_disp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_tab_disp` (
  `tab_disp_id` int(11) NOT NULL AUTO_INCREMENT,
  `tab_id` int(11) NOT NULL,
  `page_count` smallint(6) DEFAULT NULL,
  `support_query` varchar(2) DEFAULT NULL,
  `support_new` varchar(2) DEFAULT NULL,
  `support_del` varchar(2) DEFAULT NULL,
  `support_update` varchar(2) DEFAULT NULL,
  `support_sort` varchar(2) DEFAULT NULL,
  `support_export` varchar(2) DEFAULT NULL,
  `layout_type` varchar(2) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`tab_disp_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tab_disp`
--

LOCK TABLES `c_tab_disp` WRITE;
/*!40000 ALTER TABLE `c_tab_disp` DISABLE KEYS */;
INSERT INTO `c_tab_disp` VALUES (5,31,10,'01','01','01','01','01','01','01','2012-12-24 00:18:14','2013-01-14 23:49:33'),(7,33,10,'01','01','01','01','01','01','01','2012-12-24 18:36:56','2012-12-24 18:36:56'),(17,44,15,'01','01','01','01','01','01','01','2013-01-15 13:53:49','2013-01-15 13:54:31'),(9,35,10,'01','01','01','01','01','01','01','2013-01-06 22:44:15','2013-01-06 22:44:15'),(10,36,10,'01','01','01','01','01','01','01','2013-01-06 23:24:33','2013-01-14 23:53:06'),(11,37,15,'01','01','01','01','01','01','01','2013-01-08 21:30:49','2013-01-15 13:39:55'),(12,38,10,'01','01','01','01','01','01','01','2013-01-09 14:01:07','2013-01-09 14:01:07'),(13,39,10,'01','01','01','01','01','01','01','2013-01-12 23:21:32','2013-01-13 22:20:23'),(14,43,10,'01','01','01','01','01','01','01','2013-01-14 21:24:33','2013-01-14 21:24:33'),(15,24,15,'01','01','01','01','01','01','01','2013-01-14 22:20:05','2013-01-14 22:20:05');
/*!40000 ALTER TABLE `c_tab_disp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portaluserinfo`
--

DROP TABLE IF EXISTS `portaluserinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portaluserinfo` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` varchar(25) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portaluserinfo`
--

LOCK TABLES `portaluserinfo` WRITE;
/*!40000 ALTER TABLE `portaluserinfo` DISABLE KEYS */;
INSERT INTO `portaluserinfo` VALUES (1,'testaccount','testaccount','t@t.com','13800000000','测试测试'),(126,'用户姓名sss','sdfsdf','sfd','sdf','姓名：');
/*!40000 ALTER TABLE `portaluserinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_info` (
  `STU_ID` int(13) NOT NULL AUTO_INCREMENT,
  `STUNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `BIRTH_DATE` datetime DEFAULT NULL,
  `SEX` int(2) DEFAULT NULL,
  `AGE` int(3) DEFAULT NULL,
  PRIMARY KEY (`STU_ID`),
  UNIQUE KEY `SYS_C00145842` (`STU_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (1,'饶敦','12333',NULL,12,12),(22,'爱爱爱','12333',NULL,2,1100),(83,'aaasda',NULL,NULL,NULL,NULL),(84,'sdfas',NULL,NULL,NULL,NULL),(85,'rara','gjhj',NULL,4,12),(102,'sdfas','12f',NULL,3,12),(121,'oye',NULL,NULL,NULL,NULL),(122,'oka',NULL,NULL,NULL,NULL),(124,'sd',NULL,NULL,NULL,NULL),(125,'next',NULL,NULL,NULL,NULL),(126,'fool',NULL,NULL,NULL,NULL),(141,'sfdrr',NULL,NULL,NULL,NULL),(161,'dfggfd','dfg',NULL,2,3),(181,'饶敦','1111',NULL,111,11),(182,'饶敦','111',NULL,1,1),(183,'饶敦','1',NULL,1,1),(184,'饶敦','111',NULL,1,1),(185,'饶敦','11',NULL,1,1),(186,'饶敦','1',NULL,1,1),(187,'饶敦','1',NULL,1,1),(188,'饶敦','1',NULL,1,1),(189,'饶敦','1',NULL,1,1),(190,'饶敦','1',NULL,1,1),(191,'饶敦','1',NULL,1,1);
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_base_data`
--

DROP TABLE IF EXISTS `sys_base_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_base_data` (
  `BD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BD_LVL` int(11) DEFAULT NULL,
  `BD_NAME` varchar(20) NOT NULL,
  `BD_FLAG` varchar(20) DEFAULT NULL,
  `BD_VALUE` varchar(20) DEFAULT NULL,
  `BD_VALUE_1` varchar(20) DEFAULT NULL,
  `BD_VALUE_2` varchar(20) DEFAULT NULL,
  `BD_PARENT_ID` int(11) DEFAULT NULL,
  `BD_CODE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8 COMMENT='数据字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_base_data`
--

LOCK TABLES `sys_base_data` WRITE;
/*!40000 ALTER TABLE `sys_base_data` DISABLE KEYS */;
INSERT INTO `sys_base_data` VALUES (181,1,'下拉','list','lt',NULL,NULL,0,'0001'),(182,2,'列表1',NULL,'list_1',NULL,NULL,181,'00010001'),(183,2,'列表2',NULL,'list_2',NULL,NULL,181,'00010002'),(201,2,'列表3','','list_3','','',181,'00010003'),(242,2,'列表4','','l4','','',181,'00010004'),(243,2,'列表5','','l5','','',181,'00010005'),(244,2,'列表6','','l6','','',181,'00010006'),(246,2,'列表7','','l7','','',181,'00019999'),(261,2,'下拉8','','l8','','',181,'00010007'),(263,1,'状态类型','status_type','','','',0,'____0009'),(264,2,'未启用','','01','','',263,'____00090010'),(265,2,'启用','','02','','',263,'____00090010'),(266,2,'停用','','03','','',263,'____00090010'),(267,1,'菜单状态','menu_status','00','','',0,'____0002'),(268,2,'启用','','1','','',267,'____00020003'),(269,2,'停用','','0','','',267,'____00020003');
/*!40000 ALTER TABLE `sys_base_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `NAV_ID` int(11) NOT NULL COMMENT '菜单id',
  `MENU_TITLE` varchar(50) DEFAULT NULL COMMENT '菜单标题',
  `MENU_CODE` varchar(50) DEFAULT NULL COMMENT '菜单编码',
  `MENU_URL` varchar(500) DEFAULT NULL COMMENT '菜单url',
  `MENU_SEQ` int(11) DEFAULT NULL COMMENT '菜单序号',
  `MENU_STATUS` int(11) DEFAULT NULL COMMENT '菜单状态:0-停用 1-启用',
  `MENU_PARENT_ID` int(11) DEFAULT NULL COMMENT '菜单父节点id',
  `MENU_NOTE` varchar(255) DEFAULT NULL COMMENT '菜单备注',
  PRIMARY KEY (`MENU_ID`),
  KEY `REFERENCE_1_FK` (`NAV_ID`) USING BTREE,
  CONSTRAINT `FK_SYS_MENU_R_SYS_NAVI` FOREIGN KEY (`NAV_ID`) REFERENCES `sys_navigator` (`NAV_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=799 DEFAULT CHARSET=utf8 COMMENT='树形菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (2,1,'系统管理','01',NULL,1,1,0,NULL),(3,1,'系统菜单设置','0101','/system/queryNavigatorList.action',1,1,2,NULL),(543,1,'数据字典','03','/system/manageBaseData.action',3,1,0,NULL),(741,1,'白名单','12','/pages/EmagIntfBalckWaite/list.do',20,0,0,NULL),(782,1,'操作日志','0102','/oper/log/queryOperlog',2,0,2,NULL),(791,1,'用户管理','22','/demo/queryPortalUser.action',4,0,0,NULL),(792,1,'创建资源模型','23','/datares/addTable.action',5,0,0,NULL),(793,1,'资源模型管理','24','/datares/tablePageList.action',6,1,0,NULL);
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_navigator`
--

DROP TABLE IF EXISTS `sys_navigator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_navigator` (
  `NAV_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `NAV_NAME` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `NAV_URL` varchar(500) DEFAULT NULL COMMENT '菜单url',
  `NAV_SEQ` int(11) DEFAULT NULL COMMENT '菜单序号',
  `NAV_NOTE` varchar(255) DEFAULT NULL COMMENT '菜单备注',
  `NAV_STATUS` int(11) DEFAULT NULL COMMENT '菜单状态:0-停用 1-启用',
  PRIMARY KEY (`NAV_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=244 DEFAULT CHARSET=utf8 COMMENT='导航菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_navigator`
--

LOCK TABLES `sys_navigator` WRITE;
/*!40000 ALTER TABLE `sys_navigator` DISABLE KEYS */;
INSERT INTO `sys_navigator` VALUES (1,'系统管理','/system/main.action',6,NULL,1);
/*!40000 ALTER TABLE `sys_navigator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_tableseq`
--

DROP TABLE IF EXISTS `sys_tableseq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_tableseq` (
  `SEQ_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`SEQ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='序列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_tableseq`
--

LOCK TABLES `sys_tableseq` WRITE;
/*!40000 ALTER TABLE `sys_tableseq` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_tableseq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `BIRTH_DATE` datetime DEFAULT NULL,
  `SEX` int(2) DEFAULT NULL,
  `AGE` int(3) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `SYS_C00130840` (`USER_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'rao','dun',NULL,1,2),(2,'zhangchao','1111',NULL,1,11),(3,'sdfs','sdfa',NULL,1,21),(4,'raodun','1111',NULL,1,1100),(5,'uname','pwd',NULL,1,21),(12,'raoroaroarar','rarara',NULL,12,12),(42,'hsdfjb',NULL,NULL,NULL,NULL),(44,'yjuyh',NULL,NULL,NULL,NULL),(45,'ghng','rgerf',NULL,NULL,1);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-01-15 15:04:59

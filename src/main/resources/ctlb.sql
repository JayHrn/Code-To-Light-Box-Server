-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ctlb
-- ------------------------------------------------------
-- Server version	8.0.29

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

--
-- Table structure for table `level`
--

DROP TABLE IF EXISTS `level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `difficulty` bigint DEFAULT NULL COMMENT '关卡难度',
  `pre_level` bigint DEFAULT NULL COMMENT '上一关卡',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='关卡';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level`
--

LOCK TABLES `level` WRITE;
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` VALUES (1657992799179972609,'第一关','这是第一关游戏',1657991642466406401,NULL),(1657993115954806785,'第二关','这是第二关游戏',1657991642466406401,1657992799179972609),(1657993250440884225,'第三关','这是第三关游戏',1657991642466406401,1657993115954806785);
/*!40000 ALTER TABLE `level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `level_difficulty`
--

DROP TABLE IF EXISTS `level_difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `level_difficulty` (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `grade` int DEFAULT NULL COMMENT '难度等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='关卡难度';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `level_difficulty`
--

LOCK TABLES `level_difficulty` WRITE;
/*!40000 ALTER TABLE `level_difficulty` DISABLE KEYS */;
INSERT INTO `level_difficulty` VALUES (1657991642466406401,'简单',1),(1657991733071781890,'中等',2),(1657991880254095361,'困难',3);
/*!40000 ALTER TABLE `level_difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `level_id` bigint DEFAULT NULL COMMENT '关卡id',
  `time` int DEFAULT NULL COMMENT '闯关时长',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='闯关记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1657994007751909377,1656202038948040705,1657992799179972609,30,'2023-05-15 14:19:10','2023-05-15 14:19:10'),(1657994248702115841,1656202740629934081,1657992799179972609,30,'2023-05-15 14:20:08','2023-05-20 23:19:50'),(1659918046822170625,1658381156787671041,1657992799179972609,5,'2023-05-20 21:44:37','2023-05-27 18:18:15'),(1662506129455443970,1658381156787671041,1657993115954806785,9,'2023-05-28 01:08:44','2023-05-28 01:08:44'),(1662663141949435906,1662658171577454593,1657992799179972609,6,'2023-05-28 11:32:38','2023-05-28 11:32:38');
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL COMMENT '主键',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) NOT NULL COMMENT '电子邮件',
  `unlocked_level` varchar(255) DEFAULT NULL COMMENT '解锁关卡',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1656202038948040705,'开心的洋白菜','e10adc3949ba59abbe56e057f20f883e','123@qq.com','1657992799179972609;','2023-05-10 15:38:31','2023-05-10 16:50:28'),(1656202740629934081,'欢乐豆','e10adc3949ba59abbe56e057f20f883e','123@qq.com','1657992799179972609;','2023-05-10 15:41:19','2023-05-20 23:19:51'),(1658381156787671041,'小辣椒','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','1657992799179972609;1657993115954806785;1657993250440884225;','2023-05-16 15:57:34','2023-05-31 14:35:33'),(1662658171577454593,'疯狂的玉米','e10adc3949ba59abbe56e057f20f883e','123456@qq.com','1657992799179972609;1657993115954806785;','2023-05-28 11:12:53','2023-05-28 11:32:39');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-31 23:39:00

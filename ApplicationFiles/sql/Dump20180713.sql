-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: dbminishop
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bill` (
  `idBill` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(100) DEFAULT NULL,
  `phoneNumber` char(12) DEFAULT NULL,
  `addressDelivery` varchar(200) DEFAULT NULL,
  `statuss` bit(1) DEFAULT NULL,
  `dateFounded` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idBill`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoryproducts`
--

DROP TABLE IF EXISTS `categoryproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoryproducts` (
  `idCategoryProducts` int(11) NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(50) DEFAULT NULL,
  `categoryImage` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idCategoryProducts`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoryproducts`
--

LOCK TABLES `categoryproducts` WRITE;
/*!40000 ALTER TABLE `categoryproducts` DISABLE KEYS */;
INSERT INTO `categoryproducts` VALUES (1,'Áo Sơ Mi',NULL),(2,'Áo Thun',NULL),(3,'Quần Sort',NULL),(4,'Đồ Kiểu',NULL),(5,'Áo Khoác',NULL),(6,'Áo Đôi',NULL),(7,'Áo Sơ Mi Adachi Nữ',NULL),(8,'Quần Tây',NULL),(9,'Quần Jean Adachi Nam',NULL);
/*!40000 ALTER TABLE `categoryproducts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colorproduct`
--

DROP TABLE IF EXISTS `colorproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colorproduct` (
  `idColorProduct` int(11) NOT NULL AUTO_INCREMENT,
  `colorName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idColorProduct`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colorproduct`
--

LOCK TABLES `colorproduct` WRITE;
/*!40000 ALTER TABLE `colorproduct` DISABLE KEYS */;
INSERT INTO `colorproduct` VALUES (1,'Xanh Dương'),(2,'Xám'),(3,'Trắng'),(4,'Hồng'),(5,'Xanh Dương'),(6,'Xanh Lá'),(7,'Xanh Ngọc');
/*!40000 ALTER TABLE `colorproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailbill`
--

DROP TABLE IF EXISTS `detailbill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailbill` (
  `idBill` int(11) NOT NULL,
  `idDetailProduct` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idBill`,`idDetailProduct`),
  KEY `FK_detailbill_idDetailProduct` (`idDetailProduct`),
  CONSTRAINT `FK_detailbill_bill` FOREIGN KEY (`idBill`) REFERENCES `bill` (`idBill`),
  CONSTRAINT `FK_detailbill_idDetailProduct` FOREIGN KEY (`idDetailProduct`) REFERENCES `detailproduct` (`idDetailProduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailbill`
--

LOCK TABLES `detailbill` WRITE;
/*!40000 ALTER TABLE `detailbill` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailbill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailproduct`
--

DROP TABLE IF EXISTS `detailproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailproduct` (
  `idDetailProduct` int(11) NOT NULL AUTO_INCREMENT,
  `idProduct` int(11) DEFAULT NULL,
  `idSize` int(11) DEFAULT NULL,
  `idColorProduct` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `dateAdded` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idDetailProduct`),
  KEY `FK_detailproduct_product` (`idProduct`),
  KEY `FK_detailproduct_size` (`idSize`),
  KEY `FK_detailproduct_colorproduct` (`idColorProduct`),
  CONSTRAINT `FK_detailproduct_colorproduct` FOREIGN KEY (`idColorProduct`) REFERENCES `colorproduct` (`idColorProduct`),
  CONSTRAINT `FK_detailproduct_product` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  CONSTRAINT `FK_detailproduct_size` FOREIGN KEY (`idSize`) REFERENCES `size` (`idSize`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailproduct`
--

LOCK TABLES `detailproduct` WRITE;
/*!40000 ALTER TABLE `detailproduct` DISABLE KEYS */;
INSERT INTO `detailproduct` VALUES (4,1,1,1,15,'24/11/2017'),(5,1,2,2,10,'24/11/2017'),(6,1,3,1,8,'24/11/2017'),(10,2,1,1,30,'24/11/2017'),(11,2,1,2,20,'24/11/2017'),(12,2,2,2,10,'24/11/2017'),(17,3,1,1,5,'24/11/2017'),(18,3,1,2,3,'24/11/2017'),(19,3,2,1,5,'24/11/2017'),(20,3,3,2,3,'24/11/2017'),(21,4,1,1,4,'24/11/2017'),(22,4,1,2,6,'24/11/2017'),(23,4,2,1,5,'24/11/2017'),(24,5,1,1,6,'24/11/2017'),(25,6,1,2,7,'24/11/2017'),(26,7,1,1,7,'24/11/2017'),(27,7,2,1,7,'24/11/2017'),(28,7,3,2,8,'24/11/2017'),(29,7,2,2,8,'24/11/2017'),(30,8,1,1,7,'24/11/2017'),(31,9,1,2,7,'24/11/2017'),(32,10,2,2,5,'24/11/2017'),(33,11,3,1,4,'24/11/2017'),(34,12,1,1,5,'24/11/2017'),(35,13,1,5,5,'24/11/2017'),(36,14,1,3,5,'24/11/2017'),(37,15,1,2,4,'24/11/2017'),(38,16,1,2,3,'24/11/2017'),(39,17,1,2,4,'24/11/2017'),(40,18,2,2,6,'24/11/2017'),(41,19,1,2,6,'24/11/2017'),(42,20,2,3,4,'24/11/2017'),(43,21,1,5,6,'24/11/2017');
/*!40000 ALTER TABLE `detailproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailpromotion`
--

DROP TABLE IF EXISTS `detailpromotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailpromotion` (
  `idProduct` int(11) NOT NULL,
  `idPromotion` int(11) NOT NULL,
  PRIMARY KEY (`idProduct`,`idPromotion`),
  KEY `FK_detailpromotion_promotion` (`idPromotion`),
  CONSTRAINT `FK_detailpromotion_product` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`),
  CONSTRAINT `FK_detailpromotion_promotion` FOREIGN KEY (`idPromotion`) REFERENCES `promotion` (`idPromotion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailpromotion`
--

LOCK TABLES `detailpromotion` WRITE;
/*!40000 ALTER TABLE `detailpromotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailpromotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `idemployee` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `gender` tinyint(2) DEFAULT NULL,
  `identityCard` char(14) DEFAULT NULL,
  `idRoll` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idemployee`),
  KEY `FK_employee_roll` (`idRoll`),
  CONSTRAINT `FK_employee_roll` FOREIGN KEY (`idRoll`) REFERENCES `roll` (`idRoll`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'nguyễn hoài đức','Đồng nai',1,'123456799',1,'hoaiduc000@gmail.com','hoaiduc','123'),(2,NULL,NULL,NULL,NULL,NULL,'hoaiduc111@gmail.com',NULL,'123'),(3,NULL,NULL,NULL,NULL,NULL,'hoaiduc121@gmail.com',NULL,'123');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `idCategoryProducts` int(11) DEFAULT NULL,
  `productName` varchar(100) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  `describes` text,
  `image` text,
  `gender` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`idProduct`),
  KEY `FK_product_categoryproducts` (`idCategoryProducts`),
  CONSTRAINT `FK_product_categoryproducts` FOREIGN KEY (`idCategoryProducts`) REFERENCES `categoryproducts` (`idCategoryProducts`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,1,'Sơ Mi Nam No Style TN O01','185,000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','79fb5c06-b673-9300-96da-00140b96c912.jpg','nam'),(2,1,'Sơ Mi Nam No Style TD R02','225,000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','b443d8c7-54cc-4500-4a2e-0013ff9ccb91.jpg','nam'),(3,1,'Sơ Mi Nam No Style TN O02','185,000','- Thiết kế áo sơ mi kiểu dáng basic, dễ dàng mix với nhiều trang phục khác nhau. \n- Chất liệu Kate mềm mịn, thoáng mát. \n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu.','7cb8e2db-a600-9c00-0d22-00140b981d57.jpg','nam'),(4,1,'Sơ Mi Nam No Style TN L01','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn. \n- Điểm nhấn ở túi áo và tay áo\n- Chất liệu Kate mang lại cảm giác thoáng mát.\n- Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,..\n- Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng.\n- Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','4364f967-2c49-6600-0912-0013c7dbecf6.jpg','nam'),(5,1,'Sơ Mi Nam No Style TD ST01','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d5ebdfa6-2945-2300-e7fe-0013fe31f537.jpg','nam'),(6,1,'Sơ Mi Nam No Style TN N03','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','71be5178-0fd9-3300-3f2f-001402e4a70d.jpg','nam'),(7,7,'Sơ Mi Adachi / 0012655','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d5ebdfa6-2945-2300-e7fe-0013fe31f537.jpg','nu'),(8,7,'Sơ Mi Adachi / 0012738','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','a4f67968-f23e-0100-8167-00129a10884e.jpg','nu'),(9,7,'Sơ Mi Adachi / 0012658','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','deec8c60-24e0-2400-041b-001266560db2.jpg','nu'),(10,7,'Sơ Mi Adachi / 0012658','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','c115c69d-008c-9900-eea8-00125b42fa42.jpg','nu'),(11,7,'Sơ Mi Nữ Ada / 0011510','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','235dbdd4-3e4c-0601-d255-0011b3196395.jpg','nu'),(12,7,'Sơ Mi Nữ Ada / 0011527','225,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','d0876922-7a1a-1000-d878-0011cac12000.jpg','nu'),(13,5,'Áo Khoác Nam / 0012847','350,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','dbd236b7-632a-4d00-e24c-0012c7cebae9.jpg','nam'),(14,5,'Áo Khoác Nam / 0015281','350,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','f68cced6-1260-1800-8aba-0013f7c75d9d.jpg','nam'),(15,8,'Quần Tây Nam / 0013221','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','bc9c9562-4f7b-5000-3996-00130c201f8b.jpg','nam'),(16,8,'Quần Tây Nam / 0013149','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','1a210540-fc63-4f00-8a10-00130c1f9f3e.jpg','nam'),(17,9,'Quần Kaki Na / 0013761','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','6a77c9a8-65a8-7100-099b-00132237c111.jpg','nam'),(18,9,'Quần Jean Na / 0011530','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','14980579-6ccf-4700-8f83-0011bef478d3.jpg','nam'),(19,9,'Quần Jean Na / 0012764','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','f77d145c-d029-c000-b518-0012843a733b.jpg','nam'),(20,9,'Quần Jean Na / 0013631','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','aa1bf585-0b70-6300-c372-00131679d75e1841-00131679d749.gif','nam'),(21,9,'Quần Kaki Na / 0013757','255,000','- Thiết kế đơn giản và hiện đại với sơ mi tay ngắn.  - Điểm nhấn ở túi áo và tay áo - Chất liệu Kate mang lại cảm giác thoáng mát. - Cotton chủ yếu trong thành phần sợi vải mang lại nhiều tính năng vượt trội: Thấm hút ẩm tốt, Không co rút,.. - Sử dụng công nghệ dệt may hiện đại hạn chế tối đa nhăn vải trong sử dụng. - Vải không nhuộm với chì an toàn cho sức khỏe, nhưng vẫn ít ra màu','cb3e216d-6429-0100-8fd0-00132239b82b.jpg','nam');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `idPromotion` int(11) NOT NULL AUTO_INCREMENT,
  `promotionName` varchar(200) DEFAULT NULL,
  `startTime` varchar(50) DEFAULT NULL,
  `endTime` varchar(50) DEFAULT NULL,
  `describes` text,
  `promotionImage` text,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPromotion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roll`
--

DROP TABLE IF EXISTS `roll`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roll` (
  `idRoll` int(11) NOT NULL AUTO_INCREMENT,
  `rollName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idRoll`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roll`
--

LOCK TABLES `roll` WRITE;
/*!40000 ALTER TABLE `roll` DISABLE KEYS */;
INSERT INTO `roll` VALUES (1,'Nhân Viên');
/*!40000 ALTER TABLE `roll` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `size` (
  `idSize` int(11) NOT NULL AUTO_INCREMENT,
  `sizeName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idSize`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'M'),(2,'L'),(3,'XL'),(4,'XXL');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-13 15:26:28

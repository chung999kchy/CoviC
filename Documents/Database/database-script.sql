-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: datn2
-- ------------------------------------------------------
-- Server version	8.0.22

DROP DATABASE IF EXISTS `datn`;
CREATE DATABASE `datn`;
USE `datn`;

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
-- Table structure for table `khu_cach_ly`
--

DROP TABLE IF EXISTS `khu_cach_ly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khu_cach_ly` (
  `id_khu_cach_ly` int NOT NULL AUTO_INCREMENT,
  `ten_khu_cach_ly` varchar(255) DEFAULT NULL,
  `dia_chi_khu_cach_ly` varchar(255) DEFAULT NULL,
  `lien_he` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_khu_cach_ly`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khu_cach_ly`
--

LOCK TABLES `khu_cach_ly` WRITE;
/*!40000 ALTER TABLE `khu_cach_ly` DISABLE KEYS */;
INSERT INTO `khu_cach_ly` VALUES (1,'Khu cách ly Nghĩa Hiệp','Số 25, Trần Hưng Đạo, Hà Nội','0987654321'),(2,'Khu cách ly Bình Tân','Số 12, Quận 1, Thành phố Hồ Chí Minh','0912345678'),(3,'Khu cách ly Xã Đàn','Số 1, Lê Duẩn, Hà Nội','0123459876');
/*!40000 ALTER TABLE `khu_cach_ly` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `loai_don`
--

DROP TABLE IF EXISTS `loai_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_don` (
  `id_loai_don` int NOT NULL AUTO_INCREMENT,
  `ten_loai_don` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_loai_don`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_don`
--

LOCK TABLES `loai_don` WRITE;
/*!40000 ALTER TABLE `loai_don` DISABLE KEYS */;
INSERT INTO `loai_don` VALUES (1,'đơn xin ra ngoài'),(2,'đơn xin nhận đồ từ người nhà'),(3,'đơn xin gửi đồ cho người thân'),(4,'đơn xin vào khu cách ly'),(5,'đơn xin đến thăm người nhà');
/*!40000 ALTER TABLE `loai_don` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `loai_tai_khoan`
--

DROP TABLE IF EXISTS `loai_tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_tai_khoan` (
  `id_loai_tai_khoan` int NOT NULL AUTO_INCREMENT,
  `ten_loai_tai_khoan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_loai_tai_khoan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_tai_khoan`
--

LOCK TABLES `loai_tai_khoan` WRITE;
/*!40000 ALTER TABLE `loai_tai_khoan` DISABLE KEYS */;
INSERT INTO `loai_tai_khoan` VALUES (1,'manager'),(2,'staff'),(3,'user'),(4,'admin');
/*!40000 ALTER TABLE `loai_tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;





--
-- Table structure for table `phong`
--

DROP TABLE IF EXISTS `phong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phong` (
  `id_phong` int NOT NULL AUTO_INCREMENT,
  `ten_phong` varchar(45) DEFAULT NULL,
  `so_giuong` varchar(45) DEFAULT NULL,
  `ghi_chu` varchar(255) DEFAULT NULL,
  `id_khu_cach_ly` int DEFAULT NULL,
  PRIMARY KEY (`id_phong`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phong`
--

LOCK TABLES `phong` WRITE;
/*!40000 ALTER TABLE `phong` DISABLE KEYS */;
INSERT INTO `phong` VALUES (1,'A1','9','',1),(2,'B1','8',NULL,2),(3,'C1','8',NULL,3),(4,'A2','8',NULL,1),(5,'B2','8',NULL,2),(6,'C2','8',NULL,3),(7,'A3','8',NULL,1),(8,'B3','8',NULL,2),(9,'C3','8',NULL,3),(10,'A4','8',NULL,1),(11,'B4','8',NULL,2),(12,'C4','8',NULL,3);
/*!40000 ALTER TABLE `phong` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `nguoi_cach_ly`
--

DROP TABLE IF EXISTS `nguoi_cach_ly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoi_cach_ly` (
  `id_nguoi_cach_ly` int NOT NULL AUTO_INCREMENT,
  `ten_nguoi_cach_ly` varchar(255) NOT NULL,
  `tuoi` int DEFAULT NULL,
  `gioi_tinh` varchar(45) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `cmt` varchar(45) DEFAULT NULL,
  `so_dien_thoai` int DEFAULT NULL,
  `quoc_tich` varchar(45) DEFAULT NULL,
  `muc_do_nghi_nhiem` varchar(45) NOT NULL,
  `tg_vao_cach_ly` datetime NOT NULL,
  `tg_ra_cach_ly` datetime DEFAULT NULL,
  `id_phong` int NOT NULL,
  `id_khu_cach_ly` int DEFAULT NULL,
  PRIMARY KEY (`id_nguoi_cach_ly`),
  KEY `fk_nguoi_cach_ly_phong1_idx` (`id_phong`),
  CONSTRAINT `fk_nguoi_cach_ly_phong1` FOREIGN KEY (`id_phong`) REFERENCES `phong` (`id_phong`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoi_cach_ly`
--

LOCK TABLES `nguoi_cach_ly` WRITE;
/*!40000 ALTER TABLE `nguoi_cach_ly` DISABLE KEYS */;
INSERT INTO `nguoi_cach_ly` VALUES (1,'Nguyễn Văn Chung',12,'Nữ','Số 1, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F1','2021-06-04 01:02:03',NULL,6,3),(2,'Nguyễn Văn Dũng',15,'Nữ','Số 2, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F1','2021-06-05 01:02:03',NULL,2,2),(3,'Nguyễn Văn Cương',12,'Nam','Số 3, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F2','2021-06-01 01:02:03',NULL,3,3),(4,'Nguyễn Văn Dương',19,'Nam','Số 4, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F1','2021-06-01 01:02:03',NULL,4,1),(5,'Nguyễn Văn Anh',23,'Nữ','Số 67, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F3','2021-06-04 01:02:03',NULL,6,3),(6,'Vũ Thị Ánh',22,'Nam','Số 34, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F2','2021-06-03 01:02:03',NULL,3,3),(7,'Vũ Thị Trà',25,'Nam','Số 21, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F3','2021-05-24 01:02:03',NULL,2,2),(8,'Vũ Thị Vân',26,'Nam','Số 13, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F2','2021-05-22 01:02:03',NULL,2,2),(9,'Vũ Thị Dung',26,'Nam','Số 156, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F2','2021-05-22 01:02:03',NULL,1,1),(10,'Vũ Thị Giang',28,'Nam','Số 12, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F4','2021-05-10 01:02:03','2021-05-31 01:02:03',2,2),(11,'Nguyễn Hoàng Trung',30,'Nam','Số 16, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F4','2021-05-19 01:02:03',NULL,5,2),(12,'Nguyễn Hoàng Bích',22,'Nam','Số 135, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F3','2021-06-04 01:02:03',NULL,6,3),(13,'Nguyễn Hoàng Hùng',18,'Nam','Số 154, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F4','2021-06-01 01:02:03',NULL,8,2),(14,'Nguyễn Hoàng Sơn',18,'Nam','Số 12, Trần Đại Nghĩa','145884123',987654321,'Việt Nam','F2','2021-05-15 01:02:03','2021-06-04 01:02:03',9,3),(15,'Vũ Xuân Chung',15,'Nam','Số 156 Hàm Tử','145885456',987654324,'Việt Nam','F1','2021-06-03 01:02:03',NULL,1,1),(16,'Vũ Xuân Bình',18,'Nam','Số 178 Hàm Tử','145884136',987654324,'Việt Nam','F4','2021-06-04 01:02:03',NULL,2,2),(17,'Vũ Xuân Cương',16,'Nam','Số 135 Hàm Tử','145884136',987654324,'Việt Nam','F4','2021-05-27 01:02:03',NULL,3,3),(18,'Vũ Xuân Chu',26,'Nam','Số 135 Hàm Tử','1345677889',987654324,'Việt Nam','F4','2021-05-24 01:02:03','2021-06-07 23:27:05',4,1),(20,'Lê Thị Lan',20,'Nữ','Số 139 Hàm Tử','1345677889',987654324,'Việt Nam','F1','2021-05-16 01:02:03','2021-06-07 13:30:59',2,2),(21,'Lê Thị Lan Anh',12,'Nữ','Số 12 Hàm Tử','1345677889',987654321,'Việt Nam','F2','2021-06-03 01:02:03',NULL,2,2),(22,'Lê Thị Lan Hương',12,'Nữ','Số 23 Thái Hà','1345677889',987654321,'Việt Nam','F3','2021-05-15 01:02:03','2021-06-03 10:59:27',4,1),(23,'Lê Văn Quang',14,'Nữ','Số 27 Thái Hà','1345677889',987654321,'Việt Nam','F1','2021-06-07 01:02:03',NULL,5,2),(24,'Nguyễn Văn Sơn',16,'Nam','Số 278 Thái Hà','1345677889',987654321,'Việt Nam','F4','2021-05-13 01:02:03','2021-06-02 13:50:54',5,2),(25,'Nguyễn Đức Mạnh',14,'Nam','Số 154 Hàm Tử','1345677889',987654324,'Việt Nam','F4','2021-06-06 01:02:03',NULL,1,1),(26,'Nguyễn Văn nghĩa',35,'Nam','Số 167 Hàm Tử','1345677889',987654324,'Việt Nam','F4','2021-06-04 01:02:03',NULL,5,2),(27,'Đỗ Thị Hạnh',36,'Nam','Số 178 Hàm Tử','1345677889',987654324,'Việt Nam','F4','2021-06-02 01:02:03',NULL,1,1),(28,'Nguyễn Hoàng Bích',28,'Nam','Số 132 Hàm Tử','1345677889',987654324,'Việt Nam','F4','2021-06-06 01:02:03',NULL,4,1),(29,'Đỗ Thị Hoa',27,'Nam','Số 235 Thái Hà','1345677889',987654324,'Việt Nam','F4','2021-05-12 01:02:03','2021-06-01 22:55:19',7,1),(30,'Nguyễn Hoàng Anh',26,'Nam','Số 134 Hàm Tử','1345677889',987654324,'Việt Nam','F4','2021-06-04 01:02:03',NULL,8,2),(31,'Đỗ Thị Hạ',17,'Nữ','Số 124 Hàm Tử','1345677889',987654324,'Việt Nam','F2','2021-05-13 01:02:03','2021-06-04 18:54:33',9,3),(32,'Lê Thị Thu',25,'Nữ','Số 135 Hàm Tử','1345677889',987654324,'Việt Nam','F3','2021-05-26 01:02:03','2021-06-07 23:51:30',10,1),(33,'Lê Văn Quyết',14,'Nữ','Số 178 Hàm Tử','1345677889',987654321,'Việt Nam','F3','2021-06-04 01:02:03',NULL,6,3),(34,'Vũ Thị Anh Quân',22,'Nữ','Số 12 Hàm Tử',NULL,NULL,'Việt Nam','F3','2021-06-04 01:02:03',NULL,4,1),(35,'Nguyễn Hoàng A',29,'Nam','Số 18 Hàm Tử',NULL,NULL,'Việt Nam','F3','2021-06-04 01:02:03',NULL,3,3);
/*!40000 ALTER TABLE `nguoi_cach_ly` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `kq_xet_nghiem`
--

DROP TABLE IF EXISTS `kq_xet_nghiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kq_xet_nghiem` (
  `id_kq_xet_nghiem` int NOT NULL AUTO_INCREMENT,
  `id_ng_cach_ly` int DEFAULT NULL,
  `ten_loai_xet_nghiem` varchar(45) DEFAULT NULL,
  `kq_xet_nghiem` varchar(255) DEFAULT NULL,
  `tg_xet_nghiem` datetime DEFAULT NULL,
  PRIMARY KEY (`id_kq_xet_nghiem`),
  KEY `fk_kq_xet_nghiem_nguoi_cach_ly1_idx` (`id_ng_cach_ly`),
  CONSTRAINT `fk_kq_xet_nghiem_nguoi_cach_ly1` FOREIGN KEY (`id_ng_cach_ly`) REFERENCES `nguoi_cach_ly` (`id_nguoi_cach_ly`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kq_xet_nghiem`
--

LOCK TABLES `kq_xet_nghiem` WRITE;
/*!40000 ALTER TABLE `kq_xet_nghiem` DISABLE KEYS */;
INSERT INTO `kq_xet_nghiem` VALUES (1,9,'Xét nghiệm Covid','âm tính','2021-06-03 01:02:03'),(2,9,'Xét nghiệm Covid','âm tính','2021-06-03 01:02:03'),(3,2,'Xét nghiệm Covid','âm tính','2021-06-04 01:02:03'),(4,3,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(5,4,'Xét nghiệm Covid','âm tính','2021-06-01 01:02:03'),(6,5,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(7,12,'Xét nghiệm Covid','âm tính','2021-06-03 01:02:03'),(8,1,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(9,3,'Xét nghiệm Covid','âm tính','2021-06-04 01:02:03'),(10,3,'Xét nghiệm Covid','âm tính','2021-06-05 01:02:03'),(11,2,'Xét nghiệm Covid','âm tính','2021-06-06 01:02:03'),(12,4,'Xét nghiệm Covid','âm tính','2021-06-07 01:02:03'),(13,5,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(14,6,'Xét nghiệm Covid','âm tính','2021-06-07 01:02:03'),(15,4,'Xét nghiệm Covid','âm tính','2021-06-07 01:02:03'),(16,5,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(17,7,'Xét nghiệm Covid','âm tính','2021-06-07 01:02:03'),(18,8,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(19,2,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(20,20,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(21,21,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(22,22,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(23,23,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(24,24,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(25,25,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(26,26,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(27,27,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(28,28,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(29,29,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(30,30,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(31,31,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(32,32,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(33,33,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(34,34,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(35,10,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(36,11,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(37,12,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(38,13,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(39,14,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(40,15,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(41,16,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(42,17,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(43,20,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(44,21,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(45,22,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(46,23,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(47,24,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(48,26,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(49,27,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(50,28,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(51,29,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(52,30,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(53,13,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(54,12,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(55,24,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(56,23,'Xét nghiệm Covid','âm tính','2021-06-02 01:02:03'),(57,32,'Xét nghiệm Covid','âm tính','2021-06-08 13:32:00'),(58,32,'Xét nghiệm Covid','âm tính','2021-06-08 01:47:00');
/*!40000 ALTER TABLE `kq_xet_nghiem` ENABLE KEYS */;
UNLOCK TABLES;





--
-- Table structure for table `barcode`
--

DROP TABLE IF EXISTS `barcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barcode` (
  `ng_cach_ly_id` int NOT NULL,
  `ma` varchar(45) NOT NULL,
  `time_begin` datetime NOT NULL,
  `time_end` datetime NOT NULL,
  KEY `ng_cach_ly_id_idx` (`ng_cach_ly_id`),
  CONSTRAINT `ng_cach_ly_id` FOREIGN KEY (`ng_cach_ly_id`) REFERENCES `nguoi_cach_ly` (`id_nguoi_cach_ly`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barcode`
--

LOCK TABLES `barcode` WRITE;
/*!40000 ALTER TABLE `barcode` DISABLE KEYS */;
INSERT INTO `barcode` VALUES (9,'d8f30c4b4a04d21a061fe9978f7306ff','2021-05-30 16:17:25','2021-05-30 17:17:25');
/*!40000 ALTER TABLE `barcode` ENABLE KEYS */;
UNLOCK TABLES;




--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `id_tai_khoan` int NOT NULL AUTO_INCREMENT,
  `id_loai_tai_khoan` int NOT NULL,
  `ten_dang_nhap` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ten_nguoi_dung` varchar(255) NOT NULL,
  `so_dien_thoai` int DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `id_ng_cach_ly` int DEFAULT NULL,
  `id_khu_cach_ly` int DEFAULT NULL,
  PRIMARY KEY (`id_tai_khoan`),
  KEY `fk_tai_khoan_loai_tai_khoan_idx` (`id_loai_tai_khoan`),
  KEY `fk_tai_khoan_nguoi_cach_ly1_idx` (`id_ng_cach_ly`),
  CONSTRAINT `fk_tai_khoan_loai_tai_khoan` FOREIGN KEY (`id_loai_tai_khoan`) REFERENCES `loai_tai_khoan` (`id_loai_tai_khoan`),
  CONSTRAINT `fk_tai_khoan_nguoi_cach_ly1` FOREIGN KEY (`id_ng_cach_ly`) REFERENCES `nguoi_cach_ly` (`id_nguoi_cach_ly`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,1,'admin1','192023a7bbd73250516f069df18b500','Vũ Xuân Dũng',969719415,'avatar-default.png',1,1),(2,2,'staff1','192023a7bbd73250516f069df18b500','Vũ Văn Anh',123456789,'avatar-default.png',NULL,1),(3,2,'staff2','192023a7bbd73250516f069df18b500','Nguyễn Văn Bình',987654321,'avatar-default.png',NULL,2),(4,3,'test1','192023a7bbd73250516f069df18b500','Nguyễn Lê Dương',984428732,'avatar-default.png',9,NULL),(5,3,'test2','192023a7bbd73250516f069df18b500','Nguyễn Văn Sĩ',923782373,'avatar-default.png',NULL,NULL),(10,3,'alo','192023a7bbd73250516f069df18b500','Lê Văn Quang',987654321,'avatar-default.png',NULL,NULL),(11,2,'test3','192023a7bbd73250516f069df18b500','Vũ Xuân Chiến',987654324,'avatar-default.png',NULL,2),(12,2,'test45','192023a7bbd73250516f069df18b500','Vũ Xuân Chung',987654324,'avatar-default.png',NULL,1),(13,2,'test4','192023a7bbd73250516f069df18b500','Vũ Xuân Đức',987654324,'avatar-default.png',NULL,3),(14,1,'manager1','192023a7bbd73250516f069df18b500','Vũ Văn Nghĩa',987654321,'avatar-default.png',NULL,1),(15,1,'manager2','192023a7bbd73250516f069df18b500','Nguyễn Lê Dương',987654321,'avatar-default.png',NULL,2),(16,1,'manager3','192023a7bbd73250516f069df18b500','Lê Thị Lanh',987654321,'avatar-default.png',NULL,3),(17,4,'admin','192023a7bbd73250516f069df18b500','Bùi Xuân Huấn',987654321,'avatar-default.png',NULL,NULL),(18,3,'admin23','d829b843a6550a947e82f2f38ed6b7a7','Vũ Văn Nam',987654321,'avatar-default.png',NULL,NULL),(19,3,'vipchocolate23','78157d953791786c4514a9bd585982df','Nguyen Huy',355407505,'avatar-default.png',NULL,NULL),(20,3,'vipchocolate32','70fb874a43097a25234382390c0baeb3','Abc xyz',931741699,'avatar-default.png',29,NULL);
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;





--
-- Table structure for table `don`
--

DROP TABLE IF EXISTS `don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `don` (
  `id_don` int NOT NULL AUTO_INCREMENT,
  `id_loai_don` int NOT NULL,
  `id_nguoi_tao` int NOT NULL,
  `id_nguoi_xac_nhan` int DEFAULT NULL,
  `kq_xac_nhan` varchar(255) DEFAULT NULL,
  `noi_dung` varchar(255) NOT NULL,
  `tg_tao` datetime NOT NULL,
  `tg_xac_nhan` datetime DEFAULT NULL,
  `id_khu_cach_ly` int DEFAULT NULL,
  PRIMARY KEY (`id_don`),
  KEY `fk_don_tai_khoan1_idx` (`id_nguoi_tao`),
  KEY `fk_don_loai_don1_idx` (`id_loai_don`),
  CONSTRAINT `fk_don_loai_don1` FOREIGN KEY (`id_loai_don`) REFERENCES `loai_don` (`id_loai_don`),
  CONSTRAINT `fk_don_tai_khoan1` FOREIGN KEY (`id_nguoi_tao`) REFERENCES `tai_khoan` (`id_tai_khoan`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `don`
--

LOCK TABLES `don` WRITE;
/*!40000 ALTER TABLE `don` DISABLE KEYS */;
INSERT INTO `don` VALUES (1,1,4,4,'Hủy bỏ','Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-06 12:12:12','2021-06-07 00:57:17',1),(2,2,5,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 12:12:12',NULL,2),(3,3,10,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-04 12:12:12',NULL,3),(4,1,4,1,'Chấp nhận','Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 12:12:12','2021-06-07 00:58:06',1),(5,2,5,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-06 12:12:12',NULL,2),(6,4,10,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-07 12:12:12',NULL,3),(7,5,4,1,'Từ chối','Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-06 12:12:12','2021-06-07 00:58:15',1),(8,3,5,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-07 12:12:12',NULL,2),(9,4,10,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 12:12:12',NULL,3),(10,5,4,14,'Từ chối','Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-04 12:12:12','2021-06-07 19:41:29',1),(11,2,5,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-02 12:12:12',NULL,2),(12,3,10,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 12:12:12',NULL,3),(13,1,4,NULL,NULL,'fgdf','2021-06-07 01:40:43',NULL,1),(14,2,5,NULL,NULL,'jkdsfhksdfhfdhgjkfh','2021-06-05 01:40:43',NULL,1),(55,1,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,1),(56,2,19,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,2),(57,3,20,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,3),(58,3,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,1),(59,2,19,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,2),(60,4,20,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,3),(61,5,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,1),(62,2,19,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,2),(63,4,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,3),(64,2,20,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,1),(65,4,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,2),(66,1,19,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,3),(67,3,20,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,1),(68,2,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,2),(69,3,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,3),(70,2,19,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,1),(71,1,20,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,2),(72,1,18,NULL,NULL,'Tôi là Chung. Tôi viết đơn này để xin các cán bộ cho tôi được vào thăm bệnh nhân số 105 ngày 10/6/2021. Hi vọng được đồng ý','2021-06-05 01:40:43',NULL,3);
/*!40000 ALTER TABLE `don` ENABLE KEYS */;
UNLOCK TABLES;





/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08  2:12:35

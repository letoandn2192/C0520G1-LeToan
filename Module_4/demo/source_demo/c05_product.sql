-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: c05_product
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (11);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL,
  `description` longblob,
  `discount` smallint NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,_binary 'Sau Galaxy Note 20 thì Galaxy Note 20 Ultra là phiên bản tiếp theo cao cấp hơn thuộc dòng Note 20 Series của Samsung, với nhiều thay đổi từ cụm camera hỗ trợ lấy nét laser AF cùng ống kính góc rộng mới, màn hình tràn viền lên đến 6.9 inch chắc chắn sẽ là chiếc điện thoại được săn đón của fan yêu thích công nghệ.\r\nMàn hình 2K+ Dynamic AMOLED 2X tràn viền hoàn hảo, thiết kế thời thượng',10,'/img/samsung-galaxy-note-20-400x460.png','Samsung Galaxy Note',29990990),(2,_binary 'OPPO Reno3 là một sản phẩm ở phân khúc điện thoại tầm trung nhưng vẫn sở hữu cho mình ngoại hình bắt mắt, cụm camera chất lượng và cùng nhiều đột phá về màn hình cũng như hiệu năng.\r\nNhiếp ảnh, quay phim đỉnh với cụm camera chất',10,'/img/oppo-reno3-400x460.png','OPPO Reno3',8990000),(3,_binary 'Sau bao nhiêu chờ đợi cũng như đồn đoán thì cuối cùng Apple đã chính thức giới thiệu bộ 3 siêu phẩm iPhone 11 mạnh mẽ nhất của mình vào tháng 9/2019. Có mức giá rẻ nhất nhưng vẫn được nâng cấp mạnh mẽ như chiếc iPhone Xr năm ngoái, đó chính là phiên bản iPhone 11 64GB.\r\nNâng cấp mạnh mẽ về camera',5,'/img/iphone-11-red-2-400x460-400x460.png','iPhone 11 64GB',21990000),(4,_binary 'Nhanh như một cơn gió, sức hot của Redmi Note 9 Pro chưa có dấu hiệu hạ nhiệt thì Xiaomi Redmi 9 vừa bất ngờ ra mắt sớm. Thiết bị mang một thiết kế mới, thời trang và nhỏ gọn, phần cứng được nâng cấp cùng thời lượng pin ấn tượng, đặc biệt đi kèm một mức giá bán không thể nào hấp dẫn hơn.\r\nSáng tạo với bộ 4 camera đa năng',2,'/img/xiaomi-redmi-9-114620-094649-400x460.png','Xiaomi Redmi 9',3990000),(7,_binary 'Chiếc điện thoại Samsung Galaxy S20 Plus - Siêu phẩm với thiết màn hình tràn viền, hiệu năng đỉnh cao kết hợp cùng nhiều đột phá về công nghệ dẫn đầu thế giới smartphone.\r\nThiết kế màn hình tràn viền, siêu mượt 120 Hz',15,'/img/samsung-galaxy-s20-plus-400x460-fix-400x460.png','Samsung Galaxy S20+',23990000),(8,_binary 'OnePlus 8 Pro 5G là chiếc điện thoại đánh dấu bước ngoặt của OnePlus trong năm 2020, smartphone đã và đang khẳng định lại vị trí của mình trên thị trường flagship cao cấp với kế độc đáo, cụm camera ấn tượng, hiệu năng siêu khủng tích hợp nhiều công nghệ hiện đại.\r\nMàn hình sắc nét với tần số quét 120 Hz',7,'/img/oneplus-8-pro-060020-090035-400x460.png','OnePlus 8 Pro 5G',23990000),(9,_binary 'Trong cuộc đua của các hãng điện thoại đang dần trở nên ngày càng khốc liệt, Vivo vừa mang tới một \"làn gió mới\" mang tên Vivo X50 Pro nổi bật với hệ thống camera chống rung độc đáo như trên một chiếc gimbal thực sự, lần đầu tiên được trang bị trên smartphone hiện đại.\r\nCụm 4 camera siêu ấn tượng',2,'/img/vivo-x50-pro-155920-035924-400x460.png','Vivo X50 Pro',19990000),(10,_binary 'Samsung Galaxy A21s là chiếc điện thoại tầm trung mới của Samsung, mang trong mình có thiết kế màn hình nốt ruồi thời thượng, cùng cụm 4 camera sau độ phân giải lên đến 48 MP hỗ trợ nhiều tính năng chụp ảnh hấp dẫn.\r\nThiết kế cao cấp, cảm biến vân tay ở mặt lưng',3,'/img/samsung-galaxy-a21s-055620-045627-400x460.png','Samsung Galaxy A21s',5690000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-01 19:47:08

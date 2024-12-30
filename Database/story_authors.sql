-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: story
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authors` (
  `author_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `bio` text,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Gian Hiết Tính Trá Thi','(奸詰性詐詩'),(2,'Gian Hiết Tính Trá Thi','(奸詰性詐詩'),(3,'KHÔNG CÓ','KHÔNG CÓ'),(4,'NGUYÊN HỒNG','Nguyên Hồng (1918–1982), tên thật là Nguyễn Nguyên Hồng, là nhà văn nổi bật của văn học Việt Nam hiện đại. Sinh ra tại Nam Định, ông có tuổi thơ cơ cực, thiếu thốn tình thương, điều này ảnh hưởng sâu sắc đến sáng tác của ông.'),(5,'NGUYỄN TÔ','KHÔNG CÓ'),(6,'Akatetsu','KHÔNG CÓ'),(7,'NGUYỄN TƯỜNG','KHÔNG CÓ'),(8,'THU HƯƠNG','NHÀ VĂN CHUYÊN VIẾT CÁC THỂ LOẠI TRUYỆN NGẮN '),(9,'Issac Asimov','KHÔNG CÓ'),(10,'MẠC MẶC','KHÔNG CÓ'),(11,'Keigo Higashino','白夜行'),(12,'Aoyama Gosho',' tên thật là Aoyama Yoshimasa, sinh ngày 21 tháng 6 năm 1963 tại tỉnh Tottori, Nhật Bản, là một họa sĩ manga nổi tiếng. Ông là tác giả của nhiều tác phẩm đình đám, trong đó nổi bật nhất là bộ manga \"Thám tử lừng danh Conan\" (Detective Conan), ra mắt từ năm 1994 và trở thành hiện tượng toàn cầu.'),(13,'Hoàng Ngọc Lang','黄玉郎'),(14,'WOSHIDASHENXIAN','我是大神仙'),(15,'Suzuki Yuuto','Suzuki Yuuto (鈴木 優斗) là một mangaka người Nhật Bản nổi tiếng với tác phẩm \"Welcome to the Ballroom\" (歓迎! 宮本武蔵), một bộ manga nổi bật trong thể loại thể thao, đặc biệt là khi nói đến khiêu vũ thể thao.'),(16,'Daiki Kobayashi','KHÔNG CÓ'),(17,'Hạ Ngôn','KHÔNG CÓ'),(18,'Gotou Midori','KHÔNG CÓ'),(19,'Murata Yusuke',' là một mangaka nổi tiếng người Nhật Bản, sinh ngày 3 tháng 3 năm 1978 tại tỉnh Saitama. Ông nổi bật với phong cách vẽ chi tiết, mạnh mẽ và đặc biệt là sự sáng tạo trong các tác phẩm hành động.'),(20,' Kishimoto Masashi','Kishimoto Masashi (岸本 斉史) là một mangaka nổi tiếng người Nhật Bản, sinh ngày 8 tháng 11 năm 1974 tại tỉnh Okayama, Nhật Bản. Ông được biết đến nhiều nhất với tác phẩm \"Naruto\", một trong những manga và anime nổi tiếng và thành công nhất toàn cầu.'),(21,' Trần Mưu','火鳳燎原'),(22,'Inagaki Riichiro','Inagaki Riichiro (稲垣 理一郎) là một tác giả manga người Nhật Bản, nổi tiếng với công việc sáng tác trong nhiều thể loại, đặc biệt là manga hành động và hài. Ông sinh ngày 4 tháng 6 năm 1979 tại Nhật Bản.'),(23,'Tabata Yūki','Tabata Yūki (田畑 ゆうき) là một mangaka người Nhật Bản, nổi tiếng với tác phẩm \"Black Clover\". Ông sinh ngày 22 tháng 6 năm 1987 tại Nhật Bản.');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-26 16:08:57

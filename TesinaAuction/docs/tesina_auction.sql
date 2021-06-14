-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.23 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database tesina_auction
CREATE DATABASE IF NOT EXISTS `tesina_auction` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tesina_auction`;

-- Dump della struttura di tabella tesina_auction.auction
CREATE TABLE IF NOT EXISTS `auction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_item_id` int NOT NULL,
  `winner_user_id` int DEFAULT NULL,
  `start_price` decimal(11,2) NOT NULL,
  `current_bid` decimal(11,2) DEFAULT NULL,
  `shipment_extra_price` decimal(11,2) DEFAULT NULL,
  `min_earn` decimal(11,2) DEFAULT NULL,
  `free_bid_every_time` smallint NOT NULL,
  `fixed_bid_every_time` decimal(11,2) DEFAULT NULL,
  `start_auction_at` datetime NOT NULL,
  `end_auction_at` datetime NOT NULL,
  `closed_auction_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_item_id` (`user_item_id`),
  KEY `winner_user_id` (`winner_user_id`),
  CONSTRAINT `auction_ibfk_1` FOREIGN KEY (`user_item_id`) REFERENCES `user_item` (`id`),
  CONSTRAINT `auction_ibfk_2` FOREIGN KEY (`winner_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.auction: ~17 rows (circa)
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` (`id`, `created_at`, `updated_at`, `user_item_id`, `winner_user_id`, `start_price`, `current_bid`, `shipment_extra_price`, `min_earn`, `free_bid_every_time`, `fixed_bid_every_time`, `start_auction_at`, `end_auction_at`, `closed_auction_at`) VALUES
	(1, '2021-05-28 21:11:43', '2021-05-28 21:11:44', 1, 6, 100.00, NULL, NULL, NULL, 1, 1.00, '2021-05-28 21:11:59', '2021-05-29 21:12:05', '2021-06-08 15:40:54'),
	(2, '2021-05-31 23:56:09', '2021-05-31 23:56:11', 2, NULL, 10.00, NULL, NULL, NULL, 1, 1.00, '2021-05-31 23:56:22', '2021-05-31 23:56:22', '2021-06-08 15:40:54'),
	(3, '2021-06-03 15:15:59', NULL, 1, NULL, 12312.00, NULL, NULL, NULL, 1, 1.00, '2021-06-12 17:13:00', '2021-06-09 15:15:59', NULL),
	(4, '2021-06-03 15:24:29', NULL, 1, NULL, 12312.00, NULL, NULL, NULL, 1, 1.00, '2021-06-12 17:13:00', '2021-06-18 17:13:00', NULL),
	(5, '2021-06-03 15:37:37', NULL, 1, NULL, 2312312.00, NULL, NULL, NULL, 1, 1.00, '2021-06-03 20:37:00', '2021-06-03 20:37:00', '2021-06-08 15:40:54'),
	(6, '2021-06-03 15:44:44', NULL, 1, NULL, 234234.00, NULL, NULL, NULL, 1, 1.00, '2021-06-11 17:44:00', '2021-06-11 17:44:00', NULL),
	(7, '2021-06-03 17:00:14', NULL, 1, NULL, 123123.00, NULL, NULL, NULL, 1, 125.00, '2021-06-13 19:00:00', '2021-06-21 19:00:00', NULL),
	(8, '2021-06-03 17:05:20', NULL, 1, NULL, 123123123.00, NULL, NULL, NULL, 1, 1.00, '2021-06-20 19:05:00', '2021-06-26 19:05:00', NULL),
	(9, '2021-06-03 17:05:49', NULL, 1, NULL, 123123123.00, NULL, NULL, NULL, 1, 1.00, '2021-06-20 19:05:00', '2021-06-26 19:05:00', NULL),
	(10, '2021-06-03 17:07:07', NULL, 1, NULL, 123123123.00, NULL, NULL, NULL, 1, 0.00, '2021-06-19 19:06:00', '2021-06-23 19:06:00', NULL),
	(11, '2021-06-03 17:08:37', NULL, 1, NULL, 234.00, NULL, NULL, NULL, 1, 1.00, '2021-06-19 19:08:00', '2021-06-23 19:08:00', NULL),
	(12, '2021-06-03 18:58:35', NULL, 1, NULL, 125.00, NULL, NULL, NULL, 1, 1.00, '2021-06-19 20:58:00', '2021-06-24 20:58:00', NULL),
	(13, '2021-06-03 19:05:58', NULL, 1, NULL, 125.00, NULL, NULL, NULL, 1, 1.00, '2021-06-19 20:58:00', '2021-06-24 20:58:00', NULL),
	(14, '2021-06-03 19:07:50', NULL, 1, NULL, 125.00, NULL, NULL, NULL, 0, 1.00, '2021-06-19 20:58:00', '2021-06-24 20:58:00', NULL),
	(15, '2021-06-03 19:08:15', NULL, 1, NULL, 45.00, NULL, NULL, NULL, 0, 1.00, '2021-06-19 20:58:00', '2021-06-24 20:58:00', NULL),
	(16, '2021-06-03 19:19:04', NULL, 2, NULL, 5.00, NULL, NULL, NULL, 0, 100.00, '2021-06-19 20:58:00', '2021-06-24 20:58:00', NULL),
	(17, '2021-06-03 19:19:32', NULL, 3, NULL, 5.00, NULL, NULL, NULL, 1, 100.00, '2021-06-19 20:58:00', '2021-06-24 20:58:00', NULL),
	(18, '2021-06-05 20:27:42', NULL, 3, NULL, 56.00, NULL, NULL, NULL, 1, NULL, '2021-06-20 22:20:00', '2021-06-27 22:20:00', NULL),
	(19, '2021-06-05 20:28:02', NULL, 2, NULL, 78.00, NULL, NULL, NULL, 1, NULL, '2021-06-20 22:20:00', '2021-06-27 22:20:00', NULL);
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.auction_bid
CREATE TABLE IF NOT EXISTS `auction_bid` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `auction_id` int NOT NULL,
  `user_id` int NOT NULL,
  `bid` decimal(11,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `auction_id` (`auction_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `auction_bid_ibfk_1` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`),
  CONSTRAINT `auction_bid_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.auction_bid: ~0 rows (circa)
/*!40000 ALTER TABLE `auction_bid` DISABLE KEYS */;
INSERT INTO `auction_bid` (`id`, `created_at`, `auction_id`, `user_id`, `bid`) VALUES
	(1, '2021-06-05 20:18:54', 13, 6, 456.00);
/*!40000 ALTER TABLE `auction_bid` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.auction_order
CREATE TABLE IF NOT EXISTS `auction_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `order_no` varchar(50) NOT NULL DEFAULT '',
  `auction_id` int NOT NULL,
  `amount` decimal(11,2) NOT NULL,
  `auction_order_status_id` int NOT NULL,
  `payment_verify_expires_at` datetime DEFAULT NULL,
  `paid_at` datetime DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auction_order_status_id` (`auction_order_status_id`),
  KEY `auction_id` (`auction_id`),
  CONSTRAINT `auction_order_ibfk_1` FOREIGN KEY (`auction_order_status_id`) REFERENCES `auction_order_status` (`id`),
  CONSTRAINT `auction_order_ibfk_2` FOREIGN KEY (`auction_id`) REFERENCES `auction` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.auction_order: ~0 rows (circa)
/*!40000 ALTER TABLE `auction_order` DISABLE KEYS */;
INSERT INTO `auction_order` (`id`, `created_at`, `updated_at`, `order_no`, `auction_id`, `amount`, `auction_order_status_id`, `payment_verify_expires_at`, `paid_at`, `transaction_id`) VALUES
	(1, '2021-06-10 15:05:48', '2021-06-10 15:05:49', '1', 1, 123123.00, 1, '2021-06-10 15:06:07', '2021-06-10 15:06:08', '123');
/*!40000 ALTER TABLE `auction_order` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.auction_order_status
CREATE TABLE IF NOT EXISTS `auction_order_status` (
  `id` int NOT NULL,
  `title` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.auction_order_status: ~4 rows (circa)
/*!40000 ALTER TABLE `auction_order_status` DISABLE KEYS */;
INSERT INTO `auction_order_status` (`id`, `title`) VALUES
	(1, 'Creata'),
	(2, 'Verifica pagamento in corso'),
	(3, 'Pagato'),
	(4, 'Rigettato per scadenza tempi');
/*!40000 ALTER TABLE `auction_order_status` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.auction_order_transaction_log
CREATE TABLE IF NOT EXISTS `auction_order_transaction_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `auction_order_id` int NOT NULL,
  `param_name` varchar(255) NOT NULL,
  `param_value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `auction_order_id` (`auction_order_id`),
  CONSTRAINT `auction_order_transaction_log_ibfk_1` FOREIGN KEY (`auction_order_id`) REFERENCES `auction_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.auction_order_transaction_log: ~0 rows (circa)
/*!40000 ALTER TABLE `auction_order_transaction_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction_order_transaction_log` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.help_center
CREATE TABLE IF NOT EXISTS `help_center` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `closed_at` datetime DEFAULT NULL,
  `user_id` int NOT NULL,
  `question` varchar(255) NOT NULL,
  `assigned_to_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `assigned_to_id` (`assigned_to_id`),
  CONSTRAINT `help_center_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `help_center_ibfk_2` FOREIGN KEY (`assigned_to_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.help_center: ~0 rows (circa)
/*!40000 ALTER TABLE `help_center` DISABLE KEYS */;
/*!40000 ALTER TABLE `help_center` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.help_center_thread
CREATE TABLE IF NOT EXISTS `help_center_thread` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `help_center_id` int NOT NULL,
  `question` varchar(255) NOT NULL,
  `answer` text,
  PRIMARY KEY (`id`),
  KEY `help_center_id` (`help_center_id`),
  CONSTRAINT `help_center_thread_ibfk_1` FOREIGN KEY (`help_center_id`) REFERENCES `help_center` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.help_center_thread: ~0 rows (circa)
/*!40000 ALTER TABLE `help_center_thread` DISABLE KEYS */;
/*!40000 ALTER TABLE `help_center_thread` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.invoice
CREATE TABLE IF NOT EXISTS `invoice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `invoice_no` int NOT NULL,
  `user_id` int NOT NULL,
  `auction_order_id` int NOT NULL,
  `amount` decimal(11,2) DEFAULT NULL,
  `iva` decimal(4,2) DEFAULT NULL,
  `total` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `auction_order_id` (`auction_order_id`),
  CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`auction_order_id`) REFERENCES `auction_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.invoice: ~0 rows (circa)
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` (`id`, `created_at`, `invoice_no`, `user_id`, `auction_order_id`, `amount`, `iva`, `total`) VALUES
	(1, '2021-06-10 16:06:22', 1, 6, 1, 123.00, 22.00, 150.06);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL,
  `title` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.role: ~2 rows (circa)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `title`) VALUES
	(1, 'Amministratore'),
	(2, 'Help Desk');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.staff
CREATE TABLE IF NOT EXISTS `staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `email` varchar(70) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `role_id` int NOT NULL,
  `next_otp_code_after_date` datetime NOT NULL,
  `otp_code` varchar(10) DEFAULT NULL,
  `otp_code_expires_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `otp_code` (`otp_code`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `staff_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.staff: ~0 rows (circa)
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` (`id`, `created_at`, `updated_at`, `email`, `password`, `name`, `surname`, `role_id`, `next_otp_code_after_date`, `otp_code`, `otp_code_expires_at`) VALUES
	(1, '2021-06-05 20:40:55', '2021-06-05 20:40:56', 'giggi@gmail.com', '12341234', 'giggi', 'ngongo', 1, '2021-06-05 20:42:20', NULL, '2021-06-05 20:41:47');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `enabled` smallint unsigned NOT NULL DEFAULT '0',
  `email` varchar(70) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(30) NOT NULL,
  `surname` varchar(40) NOT NULL,
  `next_otp_code_after_date` datetime DEFAULT NULL,
  `otp_code` varchar(10) DEFAULT NULL,
  `otp_code_expires_at` datetime DEFAULT NULL,
  `question` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `otp_code` (`otp_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.user: ~8 rows (circa)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `created_at`, `updated_at`, `enabled`, `email`, `password`, `name`, `surname`, `next_otp_code_after_date`, `otp_code`, `otp_code_expires_at`, `question`, `answer`) VALUES
	(1, '2021-05-28 12:24:13', '2021-05-28 12:24:11', 0, 'otototot@gmail.com', '12341234', 'tototot', 'ototototott', '2021-05-28 12:24:15', NULL, NULL, 'sdfgsdf', 'sdfgsdfg'),
	(2, NULL, NULL, 0, 'pippo@gmial.com', 'plutonio', 'pippo', 'plutonio', NULL, NULL, NULL, NULL, NULL),
	(3, NULL, NULL, 0, 'sdfasdfasdfa@gmail.com', '12341234', 'sdfasdfasd', 'asdfasdfasdfasdf', NULL, NULL, NULL, NULL, NULL),
	(4, NULL, NULL, 0, 'prova@gmail.com', 'provaprova', 'prova', 'prova', NULL, NULL, NULL, NULL, NULL),
	(5, NULL, NULL, 0, 'sdfasdfa@gmail.com', '12341234', 'giorno', 'sdfasdfasdfasd', NULL, NULL, NULL, NULL, NULL),
	(6, '2021-05-31 18:31:22', '2021-05-31 21:33:01', 0, 'giggi@gmail.com', '12341234', 'giggi', 'ngongo', '2021-05-31 21:33:06', NULL, NULL, NULL, NULL),
	(7, '2021-05-31 15:49:50', NULL, 0, 'giofuffo@gmail.com', '12345678', 'fuffo', 'giofuffo', NULL, NULL, NULL, NULL, NULL),
	(8, '2021-05-31 15:57:17', NULL, 0, 'suoeroxdcfs@gmail.com', '12345678', 'jksdfjdsfjksdf', 'sdfasdfasdfa', NULL, NULL, NULL, NULL, NULL),
	(9, '2021-05-31 17:51:16', NULL, 0, 'giorgiogiogi@gmail.com', 'giorgiogiogi', 'giorgiogiogi', 'giorgiogiogi', NULL, NULL, NULL, NULL, NULL),
	(10, '2021-05-31 18:48:44', NULL, 0, 'sosiosiso@gmail.com', 'gsdfgsdfgsdfg', 'dfgsdfgsdf', 'gsdfgsdfgsdfg', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dump della struttura di tabella tesina_auction.user_item
CREATE TABLE IF NOT EXISTS `user_item` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime DEFAULT NULL,
  `user_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `notes` text,
  `picture1` varchar(70) DEFAULT NULL,
  `picture2` varchar(70) DEFAULT NULL,
  `picture3` varchar(70) DEFAULT NULL,
  `picture4` varchar(70) DEFAULT NULL,
  `picture5` varchar(70) DEFAULT NULL,
  `sold_at` datetime DEFAULT NULL,
  `sold_to_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `sold_to_user_id` (`sold_to_user_id`),
  CONSTRAINT `user_item_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `user_item_ibfk_2` FOREIGN KEY (`sold_to_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dump dei dati della tabella tesina_auction.user_item: ~3 rows (circa)
/*!40000 ALTER TABLE `user_item` DISABLE KEYS */;
INSERT INTO `user_item` (`id`, `created_at`, `updated_at`, `user_id`, `title`, `description`, `notes`, `picture1`, `picture2`, `picture3`, `picture4`, `picture5`, `sold_at`, `sold_to_user_id`) VALUES
	(1, '2021-05-28 21:11:11', '2021-05-28 21:11:12', 1, 'calzino sporco', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '2021-05-31 23:54:53', '2021-05-31 23:54:54', 1, 'calzino pulito', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3, '2021-06-03 09:33:53', '2021-06-03 09:33:54', 6, 'maglietta', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, '2021-06-03 09:47:07', NULL, 6, 'provsqq', 'provs', 'slkdnflskdfasdf', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(5, '2021-06-05 19:51:08', NULL, 6, 'prova', '23121sadasd', '123123sdsdsad', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(6, '2021-06-08 16:35:43', NULL, 6, 'szdfsdf', 'sdfsdgfsd', 'fgsdgsdfgsd', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `user_item` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

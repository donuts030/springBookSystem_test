CREATE TABLE `author` (
  `id` int NOT NULL,
  `author_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci

CREATE TABLE `books` (
  `id` int NOT NULL,
  `price` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci

CREATE TABLE `book_author` (
  `book_id` int NOT NULL,
  `author_id` int NOT NULL,
  KEY `FKklw4jlsodeh7e7uks1d468b1j` (`author_id`),
  KEY `FK2vndhku3xyc75led6n9l8gvqe` (`book_id`),
  CONSTRAINT `FK2vndhku3xyc75led6n9l8gvqe` FOREIGN KEY (`book_id`) REFERENCES `author` (`id`),
  CONSTRAINT `FKklw4jlsodeh7e7uks1d468b1j` FOREIGN KEY (`author_id`) REFERENCES `books` (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci
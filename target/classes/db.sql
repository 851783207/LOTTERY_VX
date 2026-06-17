CREATE TABLE `card` (
                        `name` varchar(255) COLLATE utf8mb4_bin NOT NULL,
                        `status` char(1) COLLATE utf8mb4_bin NOT NULL DEFAULT '0',
                        `id` int NOT NULL AUTO_INCREMENT,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

CREATE TABLE `lottery_en` (
                              `name` char(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT '',
                              `item` char(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
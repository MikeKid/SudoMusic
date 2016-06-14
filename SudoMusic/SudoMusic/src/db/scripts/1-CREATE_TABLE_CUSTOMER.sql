CREATE TABLE `customer` (
  `id` bigint(8) NOT NULL DEFAULT '0',
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(39) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
);
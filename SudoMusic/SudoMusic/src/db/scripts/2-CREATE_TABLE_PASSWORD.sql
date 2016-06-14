CREATE TABLE `password` (
  `id` bigint(8) NOT NULL DEFAULT '0',
  `customerId` bigint(8) NOT NULL,
  `password` varchar(400) NOT NULL,
  `iterations` INTEGER NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (customerId) REFERENCES customer(id)
);

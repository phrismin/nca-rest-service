DROP DATABASE `nca_users_db`;

CREATE SCHEMA IF NOT EXISTS `nca_users_db` DEFAULT CHARACTER SET utf8;

DROP TABLE `nca_users_db`.`users`;

CREATE TABLE IF NOT EXISTS `nca_users_db`.`users`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45) NOT NULL,
    `surname`    VARCHAR(45) NULL,
    `patronymic` VARCHAR(45) NULL,
    `age`        INT         NULL,
    `email`       VARCHAR(60) NOT NULL UNIQUE,
    PRIMARY KEY (`id`)
);

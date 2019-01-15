CREATE DATABASE IF NOT EXISTS spring_boot_starter;

USE spring_boot_starter;

CREATE TABLE users (
    id INT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users(id, username, password, email) VALUES (1, 'admin', md5('admin'), 'admin@test.com');
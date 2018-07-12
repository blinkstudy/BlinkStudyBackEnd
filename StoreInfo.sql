CREATE DATABASE StoreInfo;

CREATE TABLE Store
(
  number INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  category VARCHAR(10) DEFAULT 'etc',
  price INT NOT NULL
);

CREATE TABLE Receipt
(
  type ENUM('Solve', 'Add', 'Skip') PRIMARY KEY,
  plusPoint INT NOT NULL,
  day DATE
);
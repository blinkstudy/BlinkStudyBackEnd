CREATE DATABASE Core;

CREATE TABLE UserInfo
(
  ID VARCHAR(50) PRIMARY KEY NOT NULL,
  interest INT NOT NULL,
  password VARCHAR(20) NOT NULL,
  currentPoint INT DEFAULT 0,
  wrongCount INT DEFAULT 0,
  correctCount INT DEFAULT 0
);

CREATE TABLE Problems
(
  number INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  category INT NOT NULL,
  title VARCHAR(20) NOT NULL,
  content TEXT NOT NULL,
  solution TEXT,
  answer ENUM ('1', '2', '3', '4')
);

CREATE TABLE WrongAnswerNote
(
  number INT PRIMARY KEY NOT NULL,
  userAnswer ENUM('1', '2', '3', '4'),

  FOREIGN KEY (number) REFERENCES Problems(number)
);

CREATE TABLE Review
(
  number INT PRIMARY KEY NOT NULL,
  userAnswer ENUM('1', '2', '3', '4'),

  FOREIGN KEY (number) REFERENCES Problems(number)
);
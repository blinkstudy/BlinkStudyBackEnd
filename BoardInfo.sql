CREATE DATABASE BoardInfo;

CREATE TABLE FreeBoard
(
  boardId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  author VARCHAR(50) NOT NULL,
  title VARCHAR(30) NOT NULL,
  content TEXT NOT NULL
);

CREATE TABLE QuestionBoard
(
  boardId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  author VARCHAR(50) NOT NULL,
  title VARCHAR(30) NOT NULL,
  content TEXT NOT NULL
);

CREATE TABLE FreeBoardComment
(
  boardId INT PRIMARY KEY NOT NULL ,
  author VARCHAR(50) NOT NULL,
  comment TEXT NOT NULL,

  FOREIGN KEY (boardId) REFERENCES FreeBoard(boardId)
);

CREATE TABLE QuestionBoardComment
(
  boardId INT PRIMARY KEY NOT NULL ,
  author VARCHAR(50) NOT NULL,
  comment TEXT NOT NULL,

  FOREIGN KEY (boardId) REFERENCES QuestionBoard(boardId)
);
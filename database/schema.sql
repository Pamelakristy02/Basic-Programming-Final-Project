CREATE DATABASE game_project;
   USE game_project;

   CREATE TABLE players (
       id       INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50)  NOT NULL UNIQUE,
       password VARCHAR(100) NOT NULL,
       wins     INT DEFAULT 0,
       losses   INT DEFAULT 0,
       draws    INT DEFAULT 0,
       score    INT DEFAULT 0
   );

   INSERT INTO players (username, password) VALUES ('student1', '12345');
   INSERT INTO players (username, password) VALUES ('student2', '12345');
   INSERT INTO players (username, password) VALUES ('student3', '12345');
   INSERT INTO players (username, password) VALUES ('student4', '12345');
   INSERT INTO players (username, password) VALUES ('student5', '12345');

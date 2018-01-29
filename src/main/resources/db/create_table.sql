CREATE TABLE Categories
(
id_Categories INT NOT NULL auto_increment,
categories_Name nvarchar (40) NULL,
PRIMARY KEY (id_Categories));


CREATE TABLE Article
(
id_Article INT NOT NULL auto_increment,
Article_title nvarchar(80) NULL,
Article_content nvarchar (20000),
Article_date NVARCHAR(10) NOT NULL,
Article_author NVARCHAR (80) NULL,
id_Categories INT,
Article_image NVARCHAR(200) NULL,
PRIMARY KEY (id_Article));


CREATE TABLE Comments
(
id_Comment INT NOT NULL auto_increment,
comments_Content NVARCHAR (100) NULL,
comments_Date NVARCHAR(10) NOT NULL,
id_Article INT,
comments_User NVARCHAR (80) NULL,
PRIMARY KEY (id_Comment),
FOREIGN KEY (id_Article) REFERENCES Article (id_Article));


CREATE TABLE Score
(
id_Score INT NOT NULL auto_increment,
score_Number INT,
id_Article INT,
PRIMARY KEY (id_Score));


CREATE  TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  email NVARCHAR(50),
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));


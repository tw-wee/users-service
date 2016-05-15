-- Create user table
DROP TABLE IF EXISTS USER;
CREATE TABLE TABLE_USER (
  USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(64) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  PASSWORD VARCHAR(20) NOT NULL,
  GENDER VARCHAR(20) NOT NULL,
  BIRTH DATE,
  MOBILE_NUMBER VARCHAR(50),
  DISACTIVE_FLAG CHAR
);



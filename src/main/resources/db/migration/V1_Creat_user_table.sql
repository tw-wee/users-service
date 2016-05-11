-- Create user table
DROP TABLE IF EXISTS USER;
CREATE TABLE USER (
  USER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(64) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  PASSWORD VARCHAR(20) NOT NULL,
  GENDER VARCHAR(20) NOT NULL,
  BIRTH DATE
);


INSERT INTO USER VALUES (
  1,'test1', 'test1@test.com', 'test1', 'F','1990-01-01'
);


#jsonForCreating
{
"name":"xiao test",
"email":"xiao@test.com",
"password":"xiao1",
"gender":"F",
"birth":"1990-01-06"
}
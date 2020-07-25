--------------------------------------------------- 多数据源测试 --------------------------------------------------
--创建数据库1
DROP DATABASE IF EXISTS  DATABASE1;

CREATE DATABASE IF NOT EXISTS  DATABASE1;

--选择数据库
USE  DATABASE1;

--创建表
CREATE TABLE student1(
             ID INT PRIMARY KEY AUTO_INCREMENT ,
             NAME VARCHAR(20),
             AGE SMALLINT,
             SEX BIT,
             CLASS  VARCHAR(50),
             ADDRESS  VARCHAR(100)) default charset=utf8;


--创建数据库2
DROP DATABASE IF EXISTS  DATABASE2;

CREATE DATABASE IF NOT EXISTS  DATABASE2;

--选择数据库
USE  DATABASE2;

--创建表
CREATE TABLE student2(
             ID INT PRIMARY KEY AUTO_INCREMENT ,
             NAME VARCHAR(20),
             AGE SMALLINT,
             SEX BIT,
             CLASS  VARCHAR(50),
             ADDRESS  VARCHAR(100)) default charset=utf8;

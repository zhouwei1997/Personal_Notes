# SQL

## SQL基本概念

SQL：Structured Query Language，结构化查询语言，定义了操作所有关系型数据库的规则

## SQL通用语法

1. SQL语句可以单行或多行书写，以分号结尾

2. 可以使用空格和tab键来增强语句的可读性

3. MySQL数据库的SQL语句不区分大小写，关键字建议使用大写

4. 注释方式

   1. 单行注释：-- 注释内容 或 #注释内容

   2. 多行注释：/* 注释 */

## SQL分类

|              分类               |     全称     |                        含义                        |          关键字          |
| :-----------------------------: | :----------: | :------------------------------------------------: | :----------------------: |
|  DDL(Data Definition Language)  | 数据定义语言 |        用来定义数据库对象：数据库，表，列等        |  create、drop、alter等   |
| DML(Data Manipulation Language) | 数据操作语言 |         用来对数据库中的表的数据进行增删改         | insert、delete、update等 |
|    DQL(Data Query Language)     | 数据查询语言 |          用来查询数据库中标的记录（数据）          |     select、where等      |
|   DCL(Data Control Language)    | 数据控制语言 | 用来定义数据库的访问权限和安全级别，以及创建用户等 |     GRANT，REVOKE等      |

   


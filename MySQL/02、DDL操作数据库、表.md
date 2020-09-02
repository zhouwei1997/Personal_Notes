# DDL操作数据库、表

## 操作数据库

### 创建（C Create）

1. 创建数据库	

   ```sql
   create database database_name;
   ```

2. 创建数据库，判断不存在，再创建

   ```sql
   create database if not exists database_name;
   ```

3. 创建数据库，并指定字符集

   ```sql
   create database database_name character set character_name;
   ```

   

4. 创建db4数据库，判断是否存在，并指定字符集为UTF-8

   ~~~sql
   create database if not exists db4 character set utf8;
   ~~~


###  查询（R Retrieve）

1. 查询所有的数据库名称
   ~~~sql
   show databases;
   ~~~
2. 查看单个数据库的创建语句
   ```sql
   show create database database_name;
   #查看mysql数据库的创建语句
   show create database mmysql;
   ```


### 修改（U Update）

1. 修改数据库的字符集

   ```sql
   alter database database_name character set character_name;
   
   #修改db4数据库的字符集为gbk
   alter database db4 character set gbk;
   ```

### 删除（D Delete）

1. 删除数据库

   ```sql
   drop database database_name;
   
   #删除db3数据库
   drop database db3;
   ```

2. 判断数据库存在，存在再删除

   ```sql
   drop database if exists database_name;
   ```

### 使用数据库

1. 查询当前正在使用的数据库

   ```sql
   select database();
   ```
   
2. 使用数据库

   ```sql
   use database_name;
   
   #使用db4数据库
   use db4;
   ```

## 操作数据表

### 创建（C Create）

1. 创建表语法

   ```sql
   create table table_name(
       列名1  数据类型1 ,
       列名2  数据类型2 ,
       列名3  数据类型3 ,
       ……
       列名n  数据类型n 
   );
   
   #创建一个测试表
   create table student(
   	id int,
       name varchar(32),
       age int,
       score double(4,1)
       birthday date,
       insert_time timestamp
   );
   ```

2. 复制表

   ```sql
   create table 表名 like 被复制的表名;
   ```

###  查询（R Retrieve）

1. 查询某个数据库中所有表的名称

   ```sql
   show tables;
   ```

2. 查询表结构

   ```sql
   desc table_name;
   
   #查询host表的表结构
   desc host;
   ```

### 修改（U Update）

1. 修改表名

   ```sql
   alter table table_name rename new_table_name;
   
   alter table student rename stu;
   ```

2. 修改表的字符集

   ```sql
   alter table table_name character set character_name;
   
   alter table stu character set utf8;
   ```

3. 添加一列

   ```sql
   alter table 表名 add 列名 数据类型;
   
   alter table stu add gender varchar(4);
   ```

4. 修改列名称，类型

   ```sql
   alter table 表名 change 旧列名 新列名 新数据类型;
   alter table 表名 modify 列名 数据类型;
   
   alter table stu change gender sex varchar(20);
   alter table stu modify sex varchar(20);
   ```

5. 删除列

   ```sql
   alter table 表名 drop 列名;
   alter table stu drop sex;
   ```

### 删除（D Delete）

1. 删除数据表

   ```sql
   drop table table_name;
   drop table table_name if exists;
   ```

   


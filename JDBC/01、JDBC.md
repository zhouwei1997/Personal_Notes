# JDBC

## 概念

- 概念：Java Database Connectivity   Java数据库连接
- JDBC本质：本质就是官方（SUN公司）定义的一套操作所有关心型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动的jar包。我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类

## 快速入门

1. 步骤：

   1. 导入驱动jar包
   2. 注册驱动
   3. 获取数据库连接对象Connection
   4. 定义sql
   5. 获取执行SQL语句的对象Statement
   6. 执行SQL，接收返回结果
   7. 处理结果
   8. 释放资源

```java
   package com.hengyu.jdbc;
   
   import java.sql.Connection;
   import java.sql.DriverManager;
   import java.sql.SQLException;
   import java.sql.Statement;
   
   public class JDBCDemo {
   
       public static void main(String[] args) throws SQLException, ClassNotFoundException {
           //注册驱动
           Class.forName("com.mysql.cj.jdbc.Driver");
           //获取数据库连接对象
           Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=FALSE&serverTimezone=UTC");
           //定义SQL语句
           String sql = "update account set balance = 500 where id = 1";
           //获取执行SQL的对象
           Statement statement = connection.createStatement();
           //执行SQL
           int count = statement.executeUpdate(sql);
           //处理结果
           System.out.println(count);
           //释放资源
           statement.close();
           connection.close();
       }
   }
```

## 对象详解

1. DriverManager：驱动管理对象
   1. 功能：
      1. 注册驱动：告诉程序该使用哪一个数据库驱动Jar包
      2. 管理数据库连接
         1. 方法：static Connection getConnection(String url,String user,String password);
         2. 参数：
            - url：指定连接的路径
            - user：用户名
            - password：密码
   
2. Connection：数据库连接对象
   1. 功能：
      1. 获取执行SQL的对象
         1. statement createStatement()
         2. PreparedStatement prepareStatement(String sql)
      2. 管理事务：
         1. 开启事务：setAutoCommit(boolean autoCommit)：调用该方法设置参数为false，即开启事务
         2. 提交事务：commit()
         3. 回滚事务：rollback()
   
3. Statement：执行SQL的对象
   1. 执行SQL
      1. boolean execute(String sql)：可以执行任意的SQL
      2. int executeUpdate(String sql)：执行DML和DDL语句
      3. ResultSet executeQuery(String sql)：执行DQL语句
   
4. ResultSet：结果集对象，封装查询结果

   1. boolean next()：游标向下移动一行，判断当前行是否为最后一行末尾，如果是，则返回false，如果不是返回true
   2. getXxx()：获取数据

5. PreparedStatement：预处理对象

   1. 使用PreparedStatement解决SQL注入的问题
   2. 预编译SQL，使用？作为占位符
   3. 步骤：
      1. 导入驱动jar包
      2. 注册驱动
      3. 获取数据库连接对象Connection
      4. 定义sql
         1. SQL的参数使用？作为占位符
      5. 获取执行SQL语句的对象Statement
      6. 给？赋值
      7. 执行SQL，接收返回结果
      8. 处理结果
      9. 释放资源

   

   
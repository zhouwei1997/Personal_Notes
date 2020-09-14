package com.hengyu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author:hengyu
 * @Date:2020/9/14 11:49
 * @Version:1.0
 * @Discription: jdbc项目代码
 * <p>
 * jdbc快速入门
 */
public class JDBCDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取数据库连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=FALSE" +
                "&serverTimezone = UTC", "root", "zhouwei1997");
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

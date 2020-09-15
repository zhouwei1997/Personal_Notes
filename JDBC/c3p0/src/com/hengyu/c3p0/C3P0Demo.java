package com.hengyu.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:hengyu
 * @Date:2020/9/15 13:50
 * @Version:1.0
 * @Discription: C3P0演示
 */
public class C3P0Demo {

    public static void main(String[] args) throws SQLException {

            //创建数据库连接对象
            DataSource dataSource = new ComboPooledDataSource();
            //获取连接对象
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
    }
}

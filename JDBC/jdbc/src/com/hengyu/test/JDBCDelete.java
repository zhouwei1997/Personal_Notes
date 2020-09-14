package com.hengyu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author:hengyu
 * @Date:2020/9/14 15:06
 * @Version:1.0
 * @Discription: 删除account表中的一条记录
 */
public class JDBCDelete {

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //定义SQL
            String sql = "delete from account where id = 3";
            //获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=FALSE" +
                            "&serverTimezone = UTC"
                    , "root",
                    "zhouwei1997");
            //获取执行SQL的对象
            statement = connection.createStatement();
            //执行SQL
            int count = statement.executeUpdate(sql);
            //处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

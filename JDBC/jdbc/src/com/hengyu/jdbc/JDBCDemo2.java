package com.hengyu.jdbc;

import java.sql.*;

/**
 * @Author:hengyu
 * @Date:2020/9/14 15:06
 * @Version:1.0
 * @Discription: 修改account表中的一条记录
 */
public class JDBCDemo2 {

    public static void main(String[] args) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //定义SQL
            String sql = "select * from account";
            //获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=FALSE" +
                            "&serverTimezone = UTC"
                    , "root",
                    "zhouwei1997");
            //获取执行SQL的对象
            statement = connection.createStatement();
            //处理结果
            while (resultSet.next()) {
                //循环判断结果集是否有下一行
                resultSet = statement.executeQuery(sql);
                resultSet.next();
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble(3);
            }


//            resultSet = statement.executeQuery(sql);
//            resultSet.next();
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString("name");
//            double balance = resultSet.getDouble(3);
//            System.out.println(id + "----" + name + "----");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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

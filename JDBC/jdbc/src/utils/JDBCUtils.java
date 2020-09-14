package utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Author:hengyu
 * @Date:2020/9/14 16:21
 * @Version:1.0
 * @Discription:
 */
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;

    /**
     * 文件的读取，只需要读取一次即可，使用静态代码块
     */
    static {
        try {
            //读取资源文件。获取值
            Properties pro = new Properties();
            //加载文件
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            pro.load(new FileReader(path));

            //获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
           // driver = pro.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() {
        return DriverManager.getConnection("", "", "");
    }

    /**
     * 释放资源
     *
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection) {
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

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
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

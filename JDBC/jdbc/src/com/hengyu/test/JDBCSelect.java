package com.hengyu.test;

import com.hengyu.domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:hengyu
 * @Date:2020/9/14 15:06
 * @Version:1.0
 * @Discription: 查询emp表的数据将其封装为对象，然后打印
 */
public class JDBCSelect {

    /**
     * 查询所有emp对象
     *
     * @return
     */
    public List<Emp> findAll() {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List<Emp> list = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //定义SQL
            String sql = "select * from emp";
            //获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student?useSSL=FALSE&serverTimezone = UTC", "root", "zhouwei1997");
            //获取执行SQL的对象
            statement = connection.createStatement();
            //遍历结果集
            Emp emp = null;
            list = new ArrayList<Emp>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bounds = resultSet.getDouble("bounds");
                int dept_id = resultSet.getInt("dept_id");
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBounds(bounds);
                emp.setDept_id(dept_id);
                //装载集合
                list.add(emp);
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
        return null;
    }

    public static void main(String[] args) throws SQLException {
    }
}

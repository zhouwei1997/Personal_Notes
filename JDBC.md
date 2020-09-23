# JDBC

## 概念

- 概念：Java Database Connectivity   Java数据库连接
- JDBC本质：本质就是官方（SUN公司）定义的一套操作所有关心型数据库的规则，即接口。各个数据库厂商去实现这套接口，提供数据库驱动的jar包。我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类

## 快速入门

步骤：

1. 导入驱动jar包
2. 注册驱动
3. 获取数据库连接对象Connection
4. 定义sql
5. 获取执行SQL语句的对象Statement
6. 执行SQL，接收返回结果
7. 处理结果
8. 释放资源

```java
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
## JDBC管理事务

1. 事务：一个包含多个步骤的业务操作，如果这个业务操作被事务管理，则这多个步骤要么同时成功，要么同时失败

2. 操作：

    1. 开启事务
    2. 提交事务
    3. 回滚事务

3. 使用Connection对象来管理事务

    1. 开启事务：setAutoCommit(boolean
        autoCommit)：调用该方法设置参数为false，即开启事务
      2. 在执行SQL之前开启事务
    3. 提交事务：commit()
        1. 当所有SQL都执行完后提交事务
    4. 回滚事务：rollback() 
        1. 在catch中回滚事务

##  数据库连接池

- 概念：用于存放数据库连接的容器
    - 当系统初始化好了以后，容器就被创建，容器中会申请一些连接对象，当用户访问数据库时，从容器中获取连接对象，用户访问完成后，会将连接对象归还个容器
- 好处：
    - 节约资源
    - 用户访问搞笑
- 实现
    - 标准的接口：DataSource
        - 方法：
            - 获取连接：getConnection()
            - 归还连接：如果连接对象Connection是从连接池中获取的，那么调用Connection.close()方法。则不会再关闭连接了，而是归还连接
    - 一般是用数据库产商实现

### C3P0连接池

1. 使用步骤
    1. 导入jar包，c3p0-0.9.5.2.jar     mchange-commons-java-0.2.12.jar
    2. 定义配置文件
        1. 名称：c3p0.properties或者c3p0-config.xml
        2. 路径：默认在项目的类路径下
    3. 创建核心对象：数据库连接对象  ComboPoolDataSource
    4. 获取连接：getConnection()

    ```xml
    <c3p0-config>
        <!--使用默认的配置读取连接池对象-->
        <default-config>
            <!--连接参数-->
            <property name="droverClass">com.mysql.cj.jdbc.Driver</property>
            <property name="jdbcUrl">jdbc:mysql://localhost:3306/student?useSSL=FALSE&amp;serverTimezone=UTC</property>
            <property name="user">root</property>
            <property name="password">zhouwei1997</property>
            <!--连接池参数-->
            <property name="initialPoolSIze">5</property>
            <property name="maxPoolSIze">10</property>
            <property name="checkoutTimeout">3000</property>
        </default-config>
    
        <named-config name="otherc3p0">
            <!--连接参数-->
            <property name="droverClass">com.mysql.cj.jdbc.Driver</property>
            <property name="jdbcUrl">jdbc:mysql://localhost:3306/student?useSSL=FALSE&amp;serverTimezone=UTC</property>
            <property name="user">root</property>
            <property name="password">zhouwei1997</property>
            <!--连接池参数-->
            <property name="initialPoolSIze">5</property>
            <property name="maxPoolSIze">8</property>
            <property name="checkoutTimeout">5000</property>
        </named-config>
    </c3p0-config>
    ```

    ```java
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
    ```

### Druid连接池

1. 使用步骤
    1. 导入jar包 druid-1.0.9.jar

    2. 定义配置文件

        1. 导入jar包  druid-1.0.9.jar
        2. 定义配置文件
            1. properties形式的
            2. 可以叫任意的名称，可以放在任意的目录下

    ```
    driverClassName=com.mysql.cj.jdbc.Driver
    url=jdbc:mysql://localhost:3306/student?useSSL=FALSE&amp;serverTimezone=UTC
    username=root
    password=zhouwei1997
    initialSize=5
    maxActive=20
    maxWait=3000
    ```
     3. 获取数据库连接池对象：通过工厂类来获取  DruidDataSourceFactory
     4. 获取连接：getConnection
    
    ```java
    import com.alibaba.druid.pool.DruidDataSource;
    import com.alibaba.druid.pool.DruidDataSourceFactory;
    
    import javax.sql.DataSource;
    import java.io.IOException;
    import java.io.InputStream;
    import java.sql.Connection;
    import java.util.Properties;
    
    /**
     * Created with IntelliJ IDEA.
     * PackgeName: com.hengyu
     * ClassName: DruidDemo
     * Author: hengyu
     * Date: 2020/9/20 18:21
     * project name: jdbc
     * Version:
     * Description: Druid项目演示
     */
    public class DruidDemo {
    
        public static void main(String[] args) throws Exception {
            //定义配置文件
            //加载配置文件
            Properties properties = new Properties();
            InputStream inputStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            //获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource);
            Connection connection=dataSource.getConnection();
            System.out.println(connection);
        }
    }
    ```





#### Druid工具类

~~~java
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * PackgeName: utils
 * ClassName: JDBCUtils
 * Author: hengyu
 * Date: 2020/9/22 20:29
 * project name: jdbc
 * Version:
 * Description: Druid连接池的工具类
 */
public class JDBCUtils {

    /**
     * 定义成员变量
     */
    private static DataSource dataSource;

    static {
        try {
            //加载配置文件
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DataSource
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接的方法
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement statement, Connection connection) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * 获取连接方法
     */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
~~~

## JDBCTemplate

- Spring框架对JDBC的简单封装——提供JDBCTemplate对象简化JDBC的开发

- 步骤：

    - 导入jar包
        - commons-logging-1.2.jar
        - spring-beans-5.0.0.RELEASE.jar
        - spring-core-5.0.0.RELEASE.jar
        - spring-jdbc-5.0.0.RELEASE.jar
        - spring-tx-5.0.0.RELEASE.jar
    - 创建JDBCTemplate对象。依赖于数据源DataSource
        - JdbcTemplate template = new JdbcTemplate(dataSource);
    - 调用方法完成CRUD操作
        - update()：执行DML语句
        - queryForMap()：查询结果将结果封装为map集合
        - queryForList()：查询结果将结果封装为List集合
        - query()：查询结果，将结果封装为JavaBeans对象
        - queryForObject()：查询结果，将结果封装为对象

    ~~~java
    import org.springframework.jdbc.core.JdbcTemplate;
    import utils.JDBCUtils;
    
    /**
     * Created with IntelliJ IDEA.
     * PackgeName: JDBCTemplate
     * ClassName: JdbcTemplateDome
     * Author: hengyu
     * Date: 2020/9/23 15:02
     * project name: jdbc
     * Version:
     * Description: JDBCTemplate演示
     */
    public class JdbcTemplateDome {
    
        public static void main(String[] args) {
            //创建JDBCTemplate对象
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            //调用方法
            String sql = "update account set blanace = 5000 where id = ?";
            int count = template.update(sql, 3);
            System.out.println(count);
        }
    }
    ~~~

    
package chapter25.jdbcconnect;

import com.mysql.jdbc.Driver;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/29 11:33
 * <p>
 * 分析 Java 连接 mysql 的 5 种方式
 **/
public class JdbcConnect {
    public static void main(String[] args) throws SQLException {
        // connect01();
        // connect02();
        // connect03();
        // connect04();
        connect05();
    }

    // 方式 1
    private static void connect01() throws SQLException {
        // 1.注册驱动
        Driver driver = new Driver(); // 创建 driver 对象
        // 2.得到连接
        String url = "jdbc:mysql://localhost:3306/db01";
        // 将用户名和密码放入到 Properties 对象
        Properties properties = new Properties();
        // 说明：user 和 password 是规定好，后面的值根据实际情况写
        properties.setProperty("user", "root"); // 设置用户为 root
        properties.setProperty("password", "12345"); // 设置密码为 12345
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    // 方式 2
    private static void connect02() {
        try {
            // 1.使用反射动态加载 Driver 类，更加灵活，减少依赖性
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) aClass.newInstance();
            // 2.得到连接
            String url = "jdbc:mysql://localhost:3306/db01";
            // 将用户名和密码放入到 Properties 对象
            Properties properties = new Properties();
            // 说明：user 和 password 是规定好，后面的值根据实际情况写
            properties.setProperty("user", "root"); // 设置用户为 root
            properties.setProperty("password", "12345"); // 设置密码为 12345
            Connection connect = driver.connect(url, properties);
            System.out.println(connect);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 方式 3
     * 使用 DriverManager 代替 Driver 进行统一管理
     */
    private static void connect03() {
        try {
            // 1.使用反射动态加载 Driver 类，更加灵活，减少依赖性
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) aClass.newInstance();
            // 2.创建连接
            String url = "jdbc:mysql://localhost:3306/db01";
            // 将用户名和密码放入到 Properties 对象
            Properties properties = new Properties();
            // 说明：user 和 password 是规定好，后面的值根据实际情况写
            properties.setProperty("user", "root"); // 设置用户为 root
            properties.setProperty("password", "12345"); // 设置密码为 12345
            // 3.注册驱动
            DriverManager.registerDriver(driver);
            // 4.获取连接
            Connection connection = DriverManager.getConnection(url, properties);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 推荐使用
     * 方式 4
     * 使用 Class.forName 自动完成注册驱动，简化代码
     */
    private static void connect04() {
        try {
            /**
             * 1.使用反射加载了 Driver 类
             * 在加载 Driver 类时，完成注册
             *
             * static {
             *     try {
             *         DriverManager.registerDriver(new Driver());
             *     } catch (SQLException var1) {
             *         throw new RuntimeException("Can't register driver!");
             *     }
             * }
             */
            Class.forName("com.mysql.jdbc.Driver");
            // 2.创建连接
            String url = "jdbc:mysql://localhost:3306/db01";
            // 将用户名和密码放入到 Properties 对象
            Properties properties = new Properties();
            // 说明：user 和 password 是规定好，后面的值根据实际情况写
            properties.setProperty("user", "root"); // 设置用户为 root
            properties.setProperty("password", "12345"); // 设置密码为 12345
            // 3.获取连接
            Connection connection = DriverManager.getConnection(url, properties);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 推荐使用
     * 方式 5
     * 在方式 4 的基础上加配置文件，让连接更加灵活-
     */
    private static void connect05() {
        try {
            // 1.通过 properties 获取配置信息
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");

            // 2.加载 Driver 类
            Class.forName(driver);

            // 3.获取连接
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

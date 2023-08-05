package chapter25.jdbcutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/31 23:09
 * <p>
 * 工具类：完成 mysql 的连接和关闭资源
 **/
public class JdbcUtils {
    private static String sUser;
    private static String sPassword;
    private static String sUrl;
    private static String sDriver;

    // 在静态代码块中完成初始化
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\mysql.properties"));
            // 读取相关属性值
            sUser = properties.getProperty("user");
            sPassword = properties.getProperty("password");
            sUrl = properties.getProperty("url");
            sDriver = properties.getProperty("driver");
        } catch (IOException e) {
            /**
             * 在实际开发中，可以这样处理
             * 1.将编译异常转成运行异常
             * 2.调用者可以选择捕获该异常，也可选择默认处理该异常，比较方便
             */
            throw new RuntimeException(e);
        }
    }

    // 连接数据库的方法，获取 connection
    public static Connection getConnection() {
        try {
            Class.forName(sDriver);
            return DriverManager.getConnection(sUrl, sUser, sPassword);
        } catch (Exception e) {
            /**
             * 在实际开发中，可以这样处理
             * 1.将编译异常转成运行异常
             * 2.调用者可以选择捕获该异常，也可选择默认处理该异常，比较方便
             */
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭资源
     * 1.ResultSet 结果集
     * 2.Statement 或者 PreparedStatement
     * 3.Connection
     * 4.如果需要关闭资源，就传入对象，否则传入 null
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package chapter25.statement;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/30 22:52
 *
 * 演示 Statement 的 sql 注入问题
 **/
public class Statement01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入姓名：");
        String userName = scanner.nextLine(); // 这里使用 nextLine 方法，回车才会结束，如果使用 next 方法，遇到空格就会结束
        System.out.print("请输入密码：");
        String userPwd = scanner.nextLine();
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
            String sql = "select name, pwd from admin2 where name = '" + userName + "' and pwd = '" + userPwd + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                // 4.遍历结果集
                String name = resultSet.getString(1);
                String pwd = resultSet.getString(2);
                System.out.println(name + "\t" + pwd);
            }
            // 5.关闭连接
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

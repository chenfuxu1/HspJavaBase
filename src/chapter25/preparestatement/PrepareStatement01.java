package chapter25.preparestatement;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/30 23:10
 **/
public class PrepareStatement01 {
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
            String sql = "select name, pwd from admin2 where name =? and pwd = ?";
            // 4.获取 PrepareStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 5.给 preparedStatement 的 ？号赋值
            preparedStatement.setString(1, userName); // 给第一个 ？号赋值
            preparedStatement.setString(2, userPwd); // 给第二个 ？号赋值
            /**
             * 这里执行 executeQuery 不要加 sql 了
             */
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // 4.遍历结果集
                String name = resultSet.getString(1);
                String pwd = resultSet.getString(2);
                System.out.println(name + "\t" + pwd);
            }
            // 6.关闭连接
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

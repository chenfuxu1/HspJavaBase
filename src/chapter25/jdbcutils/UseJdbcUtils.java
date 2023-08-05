package chapter25.jdbcutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/7/31 23:22
 * <p>
 * 使用 JdbcUtils 工具类
 **/
public class UseJdbcUtils {
    public static void main(String[] args) {
        testQuery();

        // testUpdate();
    }

    private static void testQuery() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1.获取连接
            connection = JdbcUtils.getConnection();
            // 2.编写 sql
            String sql = "select * from actor";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                System.out.println(id + "\t" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, preparedStatement, connection);
        }
    }

    private static void testUpdate() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 1.获取连接
            connection = JdbcUtils.getConnection();
            // 2.编写 sql
            String sql = "update actor set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "周星驰");
            preparedStatement.setInt(2, 1);
            int row = preparedStatement.executeUpdate();
            System.out.println(row > 0 ? "更新成功 row：" + row : "更新失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }
}

package chapter25.datasource;


import chapter25.jdbcutils.JdbcUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * 使用 DBUtils + 数据库连接池 (Druid) 方式，完成对表 actor 的 crud
 */
public class DBUtilsUse {
    // 使用 apache-DBUtils 工具类 + druid 完成对表的 crud 操作
    @Test
    public void testQueryMany() throws SQLException { // 返回结果是多行的情况
        // 1.得到连接
        Connection connection = JdbcUtilsByDruid.getConnection();
        // 2.使用 DBUtils 类和接口, 先引入 DBUtils 相关的 jar, 加入到本 Project
        // 3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.可以执行相关方法，返回 ArrayList 结果集
        String sql = "select * from actor where id >= ?";
        /**
         * 注意: sql 语句也可以查询部分列
         * String sql = "select id, name from actor where id >= ?";
         * 这时其他属性默认为空
         */
        List<Actor> list = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
        System.out.println("输出集合的信息：");
        for (Actor actor : list) {
            System.out.println(actor);
        }
        // 5.释放资源
        JdbcUtilsByDruid.close(null, null, connection);

        /**
         * 分析：
         * (1) query 方法就是执行 sql 语句，得到 resultSet --- 封装到 --> ArrayList 集合中
         * (2) 返回集合
         * (3) connection: 连接
         * (4) sql: 执行的 sql 语句
         * (5) new BeanListHandler<>(Actor.class): 在将 resultSet -> Actor 对象 -> 封装到 ArrayList
         * 底层使用反射机制去获取 Actor 类的属性，然后进行封装
         * (6) 1 就是给 sql 语句中的 ? 赋值，可以有多个值，因为是可变参数 Object... params
         * (7) 底层得到的 resultSet, 会在 query 关闭, 关闭 PreparedStatement
         *
         * 分析 queryRunner.query 方法:
         * 源码：
         * public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
         *     PreparedStatement stmt = null; // 定义 preparedStatement
         *     ResultSet rs = null; // 定义结果集
         *     Object result = null; // 定义要返回的 list 对象
         *
         *     try {
         *         stmt = this.prepareStatement(conn, sql); // 创建 statement
         *         this.fillStatement(stmt, params); // 对 ？进行赋值
         *         rs = this.wrap(stmt.executeQuery()); // 执行 sql，返回结果集
         *         // 将结果集封装到 list 集合中, 返回的 resultSet --> arrayList[result]
         *         // 使用到反射，对传入 class 对象处理
         *         result = rsh.handle(rs);
         *     } catch (SQLException var33) {
         *         this.rethrow(var33, sql, params);
         *     } finally {
         *         try {
         *             this.close(rs); // 关闭 resultSet
         *         } finally {
         *             this.close((Statement)stmt); // 关闭 preparedStatement 对象
         *         }
         *     }
         *     return result;
         * }
         */
    }

    // 演示 apache-dbutils + druid 完成 返回的结果是单行记录(单个对象)
    @Test
    public void testQuerySingle() throws SQLException {
        // 1.得到连接
        Connection connection = JdbcUtilsByDruid.getConnection();
        // 2.使用 DBUtils 类和接口, 先引入 DBUtils 相关的 jar , 加入到本 Project
        // 3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.可以执行相关方法，返回单个对象
        String sql = "select * from actor where id = ?";
        // 因为我们返回的单行记录 <---> 单个对象 , 使用的 Handler 是 BeanHandler
        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 4);
        System.out.println("输出查询到的信息：");
        if (actor != null) { // 查询不到返回 null
            System.out.println(actor);
        }
        // 5.释放资源
        JdbcUtilsByDruid.close(null, null, connection);
    }

    // 演示 apache-dbutils + druid 完成查询结果是单行单列-返回的就是 object
    @Test
    public void testScalar() throws SQLException {
        // 1.得到连接
        Connection connection = JdbcUtilsByDruid.getConnection();
        // 2.使用 DBUtils 类和接口, 先引入 DBUtils 相关的 jar , 加入到本 Project
        // 3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        // 4.可以执行相关方法，返回单个对象
        String sql = "select name from actor where id = ?";
        // 因为返回的是一个对象, 使用的 handler 就是 ScalarHandler
        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 1);
        System.out.println("输出查询到的信息：");
        System.out.println(obj);
        // 5.释放资源
        JdbcUtilsByDruid.close(null, null, connection);
    }

    // 演示 apache-dbutils + druid 完成 dml (update, insert ,delete)
    @Test
    public void testDML() throws SQLException {
        // 1.得到连接
        Connection connection = JdbcUtilsByDruid.getConnection();
        // 2.使用 DBUtils 类和接口, 先引入 DBUtils 相关的 jar , 加入到本 Project
        // 3.创建 QueryRunner
        QueryRunner queryRunner = new QueryRunner();

        /**
         * 4.这里组织 sql 完成 update, insert delete
         * (1) 执行 dml 操作是 queryRunner.update()
         * (2) 返回的值是受影响的行数 (affected: 受影响)
         */

        // 4.1 update
        // String sql1 = "update actor set name = ? where id = ?";
        // int affectedRow1 = queryRunner.update(connection, sql1, "海贼王", 1);
        // System.out.println(affectedRow1 > 0 ? "执行成功" : "执行没有影响到表");

        // 4.2 insert
        // String sql2 = "insert into actor values(null, ?, ?, ?, ?)";
        // int affectedRow2 = queryRunner.update(connection, sql2, "林青霞", "女", "1966-10-10", "9974123345");
        // System.out.println(affectedRow2 > 0 ? "执行成功" : "执行没有影响到表");

        // 4.3 delete
        String sql3 = "delete from actor where id = ?";
        int affectedRow = queryRunner.update(connection, sql3, 7);
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");

        // 5.释放资源
        JdbcUtilsByDruid.close(null, null, connection);
    }
}

package chapter25.jdbcconnect;


import chapter25.jdbcutils.JdbcUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * 演示 java 的批处理
 */
public class Batch_ {
    // 传统方法，添加 5000 条数据到 t31 表
    @Test
    public void noBatch() {
        // 1.得到连接
        Connection connection = null;
        // 2.组织sql
        String sql = "insert into t31 values(?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            //3.创建preparedStatement对象
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) { // 执行 5000 次
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "tom" + i);
                preparedStatement.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("消耗时间：" + (end - start) + " ms"); // 消耗时间：329 ms
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }
    }

    /**
     * 使用批量方式添加数据
     * url=jdbc:mysql://localhost:3306/db01?rewriteBatchedStatements=true
     * 注意 url 要加：rewriteBatchedStatements=true 才能生效
     */
    @Test
    public void useBatch() {
        // 1.得到连接
        Connection connection = null;
        // 2.组织sql
        String sql = "insert into t31 values(?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            // 3.创建 preparedStatement 对象
            connection = JdbcUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) { // 执行 5000 次
                preparedStatement.setInt(1, i + 1);
                preparedStatement.setString(2, "tom" + i);
                preparedStatement.addBatch();
                // 当记录满 50 条时，再批量执行
                if ((i + 1) % 1000 == 0) {
                    preparedStatement.executeBatch();
                    // 清空 batch
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("批量消耗时间：" + (end - start) + " ms"); // 批量消耗时间：311 ms

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtils.close(null, preparedStatement, connection);
        }

        /**
         * addBatch 源码
         * 将 sql 语句加入到批处理包中 -> 看源码
         * 1.第一就创建 ArrayList - elementData => Object[]
         * 2.elementData => Object[] 就会存放我们预处理的 sql 语句
         * 3.当 elementData 满后, 就按照 1.5 扩容
         * 4.当添加到指定的值后，就 executeBatch
         * 5.批量处理会减少我们发送 sql 语句的网络开销，而且减少编译次数，因此效率提高
         *
         * public void addBatch() throws SQLException {
         *     synchronized(this.checkClosed().getConnectionMutex()) {
         *         if (this.batchedArgs == null) {
         *             this.batchedArgs = new ArrayList();
         *         }
         *
         *         for(int i = 0; i < this.parameterValues.length; ++i) {
         *             this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
         *         }
         *
         *         this.batchedArgs.add(new com.mysql.jdbc.PreparedStatement.BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
         *     }
         * }
         */
    }
}

package chapter19.outstream.writer.bufferedwriter;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/30 23:02
 * <p>
 * 使用 BufferedWriter 将 "hello, 全世界"，写入到文件中
 **/
public class BufferedWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        String filePath = "d:\\a.txt";
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            /**
             * 1.new FileWriter(filePath, true) 表示以追加的方式写入
             * 2.new FileWriter(filePath) 表示以覆盖的方式写入
             */
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("张三、李四、王五");
            bufferedWriter.write('\n'); // 插入换行
            bufferedWriter.newLine(); // 插入换行
            bufferedWriter.write("hello, 全世界");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    // 关闭外层流即可，传入的 fileWriter 会在底层关闭
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

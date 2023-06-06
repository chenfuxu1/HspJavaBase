package chapter19.homework;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * 1.使用 BufferedReader 读取一个文本文件，为每行加上行号
 * 2.再连同内容一起输出到屏幕上
 * <p>
 * 开始默认 utf-8 如果将文件编码改成了 gbk 出现乱码
 * 使用转换流，将 FileInputStream -> InputStreamReader
 */
public class Homework02 {
    public static void main(String[] args) throws Exception {
        String filePath = "d:\\a.java";
        String line = null;
        int count = 0; // 记录行号
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null) {
            System.out.println(++count + " " + line);
        }
        //关闭外层流
        reader.close();
    }

    @Test
    public void test() throws Exception {
        /**
         * 开始默认 utf-8 如果将文件编码改成了 gbk 出现乱码
         * 使用转换流，将 FileInputStream -> InputStreamReader
         */
        String filePath = "d:\\a.java";
        String line = null;
        int count = 0; // 记录行号
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath), "gbk"));
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(++count + " " + line);
        }
        bufferedReader.close();
    }
}

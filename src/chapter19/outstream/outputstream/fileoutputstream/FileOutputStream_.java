package chapter19.outstream.outputstream.fileoutputstream;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/25 23:37
 *
 * 要求: 请使用 FileOutputStream 在 a.txt 文件中写入 "hello, world"
 * 如果文件不存在，会创建文件(注意：前提是目录已经存在)
 **/
public class FileOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        String filePath = "d:\\a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            /**
             * 1.先得到 FileOutputStream 对象
             * 2.new FileOutputStream(filePath) 创建方式，当写入内容时，会覆盖原来的内容
             * 3.new FileOutputStream(filePath, true) 创建方式，写入内容，是以追加的方式
             */
            fileOutputStream = new FileOutputStream(filePath, true);
            char char1 = 'H';
            fileOutputStream.write(char1); // 写入一个字节 H
            fileOutputStream.write('\n'); // 写入一个字节, 换行

            String str2 = "hello,world!";
            fileOutputStream.write(str2.getBytes()); // 可以把字符串 -> 字节数组
            fileOutputStream.write('\n');

            byte[] bytes3 = new byte[] {'c', 'f', 'x', 'h'};
            /**
             * write(byte[] b, int off, int len) 将 len 字节从位于偏移量 off 的指定字
             * 节数组写入此文件输出流
             */
            fileOutputStream.write(bytes3, 1, 3);
            System.out.println("写入文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭写入字节流
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

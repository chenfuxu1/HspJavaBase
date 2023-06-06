package chapter19.instream.inputstream.fileinputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/25 23:19
 * <p>
 * 字节输入流
 * 文件 -> Java 程序
 **/
public class FileInputStream_ {
    public static void main(String[] args) {

    }

    /**
     * 读取文件
     * 1.单个字节读取，效率低下
     */
    @Test
    public void readFile1() {
        String filePath = "d:\\hello.txt";
        int readData = -1;
        // 创建 FileInputStream 对象，用来读取文件
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            /**
             * 从该输入流读取一个字节的数据, 如果没有输入可用, 方法将阻止。
             * 如果返回 -1, 表示读取完毕
             */
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData); // 转成 char 显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件流，释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取文件
     * 2.使用 read(byte[] b) 读取文件，提高效率
     */
    @Test
    public void readFile2() {
        String filePath = "d:\\hello.txt";
        byte[] buff = new byte[8]; // 字节数组，一次读取 8 个字节
        int readData = -1;
        // 创建 FileInputStream 对象，用来读取文件
        FileInputStream fileInputStream = null;
        try {
            /**
             * 创建 FileInputStream 对象，用于读取文件
             * 从该输入流读取最多 b.length 字节的数据到字节数组。此方法将阻塞，直到某些输入可用。
             * 如果返回 -1 , 表示读取完毕
             * 如果读取正常, 返回实际读取的字节数
             */
            fileInputStream = new FileInputStream(filePath);
            while ((readData = fileInputStream.read(buff)) != -1) {
                System.out.print(new String(buff, 0, readData));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件流，释放资源
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

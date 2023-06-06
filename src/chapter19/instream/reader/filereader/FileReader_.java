package chapter19.instream.reader.filereader;


import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/26 23:44
 * <p>
 * 字符输入流：FileReader
 * 使用 FileReader 从 hello.txt 读取内容，并显示
 **/
public class FileReader_ {
    public static void main(String[] args) {

    }

    // 单个字符读取文件
    @Test
    public void readFile01() {
        String filePath = "d:\\hello.txt";
        FileReader fileReader = null;
        int len = -1;
        try {
            // 1.创建 FileReader 对象
            fileReader = new FileReader(filePath);
            while ((len = fileReader.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 字符数组读取文件
    @Test
    public void readFile02() {
        String filePath = "d:\\hello.txt";
        FileReader fileReader = null;
        int len = -1;
        char[] buff = new char[8]; // 初始化读取缓存数组，提高效率
        try {
            // 创建对象
            fileReader = new FileReader(filePath);
            /**
             * 循环读取 使用 read(buff), 返回的是实际读取到的字符数
             * 如果返回 -1, 说明到文件结束
             */
            while ((len = fileReader.read(buff)) != -1) {
                System.out.print(new String(buff, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

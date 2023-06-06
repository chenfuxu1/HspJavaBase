package chapter19.transformstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/1 23:36
 * <p>
 * 将字节流 FileInputStream 包装成字符流 InputStreamReader, 对文件进行读取
 * (按照 utf-8/gbk 格式)，进而包装成 BufferedReader
 * <p>
 * 使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转成字符流 InputStreamReader, 指定编码 gbk/utf-8
 **/
public class InputStreamReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void transformReader() {
        String filePath = "d:\\a.txt";
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        String readLine = null;
        try {
            // 1.创建文件输入字节流
            fileInputStream = new FileInputStream(filePath);
            // 2.把文件输入字节流 FileInputStream 转成转换流 InputStreamReader, 指定编码
            inputStreamReader = new InputStreamReader(fileInputStream, "gbk");
            // 3.对转换流 InputStreamReader 进行包装为 bufferedReader
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((readLine = bufferedReader.readLine()) != null) {
                System.out.println(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭外层流即可
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

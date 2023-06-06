package chapter19.outstream.writer.bufferedwriter;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/30 23:22
 * <p>
 * 综合使用 BufferedReader 和 BufferedWriter 完成文本文件的拷贝，注意文件编码
 **/
public class BufferedCopy {
    public static void main(String[] args) {

    }

    @Test
    public void copyFile() {
        String srcPath = "d:\\a.java";
        String desPath = "d:\\a_copy.java";
        /**
         * 1.BufferedReader 和 BufferedWriter 是按照字符操作
         * 2.不要去操作二进制文件 "声音、视频、doc、pdf" 可能造成文件损坏
         */
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(srcPath);
            bufferedReader = new BufferedReader(fileReader);
            fileWriter = new FileWriter(desPath);
            bufferedWriter = new BufferedWriter(fileWriter);
            String readLine = null;
            // readLine 读取一行内容，但是没有换行
            while ((readLine = bufferedReader.readLine()) != null) {
                // 每读取一行，就写入
                bufferedWriter.write(readLine);
                // 插入一个换行
                bufferedWriter.newLine();
            }
            System.out.println("copy succeed");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

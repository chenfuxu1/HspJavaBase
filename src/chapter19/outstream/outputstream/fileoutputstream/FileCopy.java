package chapter19.outstream.outputstream.fileoutputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/26 23:12
 * <p>
 * 文件拷贝
 * 将 d:\pic.jpg 拷贝 d:\pic_copy.jpg
 **/
public class FileCopy {
    public static void main(String[] args) {

    }

    @Test
    public void copyFile() {
        String srcFilePath = "d:\\pic.jpg"; // 目标文件路径
        String destFilePath = "d:\\pic_copy.jpg"; // 拷贝后的文件路径
        /**
         * 1.创建文件的输入流, 将文件读入到程序
         * 2.创建文件的输出流，将读取到的文件数据，写入到指定的文件
         */
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buff = new byte[1024]; // 指定每次读取缓存的字节数组
        int readLen = -1; // 指定读取长度
        try {
            // 1.创建文件的输入流, 将文件读入到程序
            fileInputStream = new FileInputStream(srcFilePath);
            // 2.创建文件的输出流，将读取到的文件数据，写入到指定的文件. 以追加的方式写入
            fileOutputStream = new FileOutputStream(destFilePath);
            while ((readLen = fileInputStream.read(buff)) != -1) {
                // 读取到后，就写入到文件通过 fileOutputStream 即是一边读，一边写
                fileOutputStream.write(buff, 0, readLen); // 一定要使用这个方法
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭输入输出流
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

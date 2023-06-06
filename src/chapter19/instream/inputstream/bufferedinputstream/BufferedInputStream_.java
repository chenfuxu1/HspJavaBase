package chapter19.instream.inputstream.bufferedinputstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/30 23:38
 * <p>
 * 演示使用 BufferedOutputStream 和 BufferedInputStream 使用
 * 使用他们，可以完成二进制文件拷贝
 * 思考：字节流可以操作二进制文件，可以操作文本文件吗？当然可以，文本文件最终还是按照二进制文件存储的
 **/
public class BufferedInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void copyFile() {
        String srcPath = "d:\\pic.jpg";
        String desPath = "d:\\pic_copy.jpg";
        // 创建 BufferedOutputStream 对象 BufferedInputStream 对象
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buff = new byte[1024];
        int readLen = -1;
        try {
            fileInputStream = new FileInputStream(srcPath);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(desPath);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            // 循环的读取文件，并写入到 desPath，当返回 -1 时，就表示文件读取完毕
            while ((readLen = bufferedInputStream.read(buff)) != -1) {
                bufferedOutputStream.write(buff, 0, readLen);
            }
            System.out.println("copy file succeed!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流, 关闭外层的处理流即可，底层会去关闭节点流
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

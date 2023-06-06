package chapter19.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;


/**
 * 文件创建的三种方式
 * 方式 1: new File(String pathName)
 * 方式 2: new File(File parent, String child) // 根据父目录文件 + 子路径构建
 * 方式 3: new File(String parent, String child) // 根据父目录 + 子路径构建
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    // 方式 1: new File(String pathName)
    @Test
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方式 2: new File(File parent, String child) 根据父目录文件 + 子路径构建
    @Test
    public void create02() {
        File parentFile = new File("d:\\");
        String child = "news2.txt";
        File file = new File(parentFile, child);
        try {
            file.createNewFile();
            System.out.println("文件 2 创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 方式 3: new File(String parent, String child) 根据父目录 + 子路径构建
    @Test
    public void create03() {
        String parent = "d:\\";
        String child = "news3.txt";
        File file = new File(parent, child);
        try {
            /**
             * 这里的 file 对象，在 java 程序中，只是一个对象
             * 只有执行了 createNewFile 方法，才会真正的，在磁盘创建该文件
             */
            file.createNewFile();
            System.out.println("文件 3 创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

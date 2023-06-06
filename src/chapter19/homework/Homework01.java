package chapter19.homework;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 1.判断 d 盘下是否有文件夹 mytemp 如果没有就创建 mytemp
 * 2.在 d\\mytemp 目录下，创建文件 hello.txt
 * 3.如果 hello.txt 已经存在，提示该文件存在，不重复创建
 * 4.在 hello.txt 文件中，写入 hello,world
 */
public class Homework01 {
    public static void main(String[] args) {
        // 1.判断 d 盘下是否有文件夹 mytemp 如果没有就创建 mytemp
        String filePath = "d:\\mytemp";
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("文件夹存在");
        } else {
            System.out.println("文件夹不存在");
            // 创建目录
            file.mkdir();
            System.out.println("创建目录：" + filePath +  " 成功!");
        }

        // 2.在 d\\mytemp 目录下，创建文件 hello.txt
        File file1 = new File(filePath, "hello.txt");
        if (file1.exists()) {
            // 3.如果 hello.txt 已经存在，提示该文件存在，不重复创建
            System.out.println("文件存在");
        } else {
            System.out.println("文件不存在");
            // 创建文件
            try {
                file1.createNewFile();
                System.out.println("创建文件：" + file1.getAbsolutePath() +  " 成功!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 4.在 hello.txt 文件中，写入 hello,world
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("d:\\mytemp\\hello.txt");
            fileOutputStream.write("hello,world".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

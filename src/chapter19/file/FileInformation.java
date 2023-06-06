package chapter19.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 获取文件的信息
 * 文件大小
 * 文件名
 * 路径
 * 目录
 * 是文件还是目录
 * 是否存在
 */
public class FileInformation {
    public static void main(String[] args) {
        info();
        info2();
        info3();
        info4();
    }

    // 获取文件的信息
    public static void info() {
        // 先创建文件对象
        File file = new File("d:\\news1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 调用相应的方法，得到对应信息
        System.out.println("文件名字 = " + file.getName());
        // getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径 = " + file.getAbsolutePath());
        System.out.println("文件父级目录 = " + file.getParent());
        System.out.println("文件大小（字节）= " + file.length());
        System.out.println("文件是否存在 = " + file.exists());
        System.out.println("是否为一个文件 = " + file.isFile());
        System.out.println("是否为一个目录 = " + file.isDirectory());
    }


    /**
     * 目录的操作和文件的删除
     * mkdir 创建一级目录
     * mkdirs 创建多级目录
     * delete 删除空目录或文件
     * Java中，目录也被当做文件
     */
    public static void info2() {
        // 判断 d:\\news1.txt 是否存在，如果存在就删除
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
            System.out.println("删除成功");
        } else {
            System.out.println("文件不存在");
        }
    }

    // 判断目录
    public static void info3() {
        // 判断 d:\\news2 目录是否存在，如果存在就删除
        String filePath = "d:\\news2";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) { // 只能删除空目录，有内容无法删除
                System.out.println("删除目录成功");
            } else {
                System.out.println("删除目录失败");
            }
        } else {
            System.out.println("目录不存在");
        }
    }

    // 判断 d:\demo\a\b\c 目录是否存在，如果存在表示已经存在，否则就创建
    public static void info4() {
        String directoryPath = "d:\\demo\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println("该目录存在");
        } else {
            if (file.mkdirs()) { // mkdirs 创建多级目录
                System.out.println("目录创建成功");
            } else {
                System.out.println("创建失败");
            }
        }
    }
}

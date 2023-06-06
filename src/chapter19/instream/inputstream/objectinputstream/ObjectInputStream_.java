package chapter19.instream.inputstream.objectinputstream;


import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/31 22:56
 * <p>
 * 使用 ObjectInputStream 读取 data.dat 并反序列化恢复数据
 **/
public class ObjectInputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile() {
        String filePath = "d:\\data.dat";
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            // 读取，注意顺序
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readChar());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readUTF());
            Object dog = objectInputStream.readObject();
            System.out.println("运行信息 = " + dog.getClass());
            System.out.println("Dog 信息 = " + dog); // 底层 Object -> Dog
            /**
             * 细节
             * 1.如果希望调用 Dog 的 getName 方法，需要向下转型
             * dog 是 Object 类型，运行类型是 Dog，不能直接调用方法
             * 所以需要在该目录导包，导入 Dog 的定义，否则无法识别
             */
            System.out.println("反序列化成功!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    // 关闭流，关闭外层即可，底层会关闭 FileInputStream 节点流
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

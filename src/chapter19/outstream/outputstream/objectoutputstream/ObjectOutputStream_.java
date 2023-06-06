package chapter19.outstream.outputstream.objectoutputstream;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/31 21:23
 * <p>
 * 处理流 ObjectOutputStream
 * 1.使用 ObjectOutputStream 序列化基本数据类型和一个 Dog 对象 name、age
 * 并保存到 data.dat 文件中完成数据的序列化
 **/
public class ObjectOutputStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        // 序列化后，保存的文件格式，不是存文本，而是按照他的格式来保存
        String filePath = "d:\\data.dat";
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(filePath);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            // 序列化数据到 d:\data.dat
            objectOutputStream.writeInt(100); // int -> Integer (实现了 Serializable)
            objectOutputStream.writeBoolean(true); // Boolean (实现了 Serializable)
            objectOutputStream.writeChar('a'); // Character( 实现了 Serializable)
            objectOutputStream.writeDouble(9.5); // double -> Double( 实现了 Serializable)
            objectOutputStream.writeUTF("存入字符串"); // String
            objectOutputStream.writeObject(new Dog("大黄", 3)); // 保存一个 dog 对象
            System.out.println("序列化成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Dog implements Serializable {
    private String mName;
    private int mAge;

    public Dog(String name, int age) {
        mName = name;
        mAge = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "mName='" + mName + '\'' +
                ", mAge=" + mAge +
                '}';
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}

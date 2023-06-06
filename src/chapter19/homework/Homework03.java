package chapter19.homework;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;


/**
 * 1.编写一个 dog.properties
 * name=tom
 * age=5
 * color=red
 * 2.编写 Dog 类(name, age, color)创建一个 dog 对象，读取 dog.properties
 * 用相应的内容完成属性初始化，并输出
 * 3.将创建的 Dog 对象，序列化到文件 dog.dat 文件
 */
public class Homework03 {
    public static void main(String[] args) throws IOException {
        // 1.创建 Properties 对象
        Properties properties = new Properties();
        // 2.加载指定配置文件
        properties.load(new FileReader("src\\chapter19\\dog.properties"));
        // 3.获取属性
        String name = properties.get("name") + ""; // Object -> String
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.get("color") + ""; // Object -> String
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        // 序列化存储
        String filePath = "d:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(dog); // 写入一个对象
        oos.close(); // 关闭外层流
        System.out.println("保存完毕");
    }

    // 测试反序列化恢复保存的 dog 对象
    @Test
    public void readDogFile() {
        String filePath = "d:\\dog.dat";
        ObjectInputStream objectInputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Dog dog = (Dog) objectInputStream.readObject();
            System.out.println("dog 对象：" + dog);
            System.out.println("反序列化成功!");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// Dog 类
class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
package chapter23.homework;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射和 File 完成以下功能
 * 1.利用 Class 类的 forName 方法的得到 File 类的 class 对象
 * 2.在控制台打印 File 类的所有构造器
 * 3.通过 newInstance 的方法创建 File 对象，并创建 d:\test\myNew.txt 文件
 * 提示：
 * File file = new File("d:\test\myNew.txt") // 内存
 * file.createNewFile(); // 方法，才能真正创建文件
 */
public class Homework02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.获取 File 的 class 对象
        Class<?> cls = Class.forName("java.io.File");
        // 2.获取 File 类的所有构造器
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("File 类的所有构造器：" + declaredConstructor);
        }
        // 3.创建 File 对象构造器
        Constructor<?> constructor = cls.getConstructor(String.class);
        Object o = constructor.newInstance("d:\\test\\myNew.txt");
        // 4.获取 createNewFile 方法对象
        Method createNewFile = cls.getMethod("createNewFile");
        createNewFile.invoke(o); // 调用 createNewFile 方法
    }
}

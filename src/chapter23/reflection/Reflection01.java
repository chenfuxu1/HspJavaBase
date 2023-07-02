package chapter23.reflection;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射相关类
 */
public class Reflection01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 使用 Properties 类，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\chapter23\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String method = properties.get("method").toString();
        // 使用反射机制解决
        // 1.加载类，返回 Class 类型的对象 cls
        Class cls = Class.forName(classfullpath);
        // 2.通过 cls 得到加载的对象实例
        Object o = cls.newInstance();
        System.out.println(" o 的运行类型 = " + o.getClass()); // 运行类型
        // 3.通过 cls 加载的对象实例调用 hi 方法对象，在反射中，可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(method);
        System.out.println(method1.getClass());
        // 4.通过 method1 调用方法，即通过方法对象来实现调用方法
        System.out.println("================");
        method1.invoke(o); // 传统方法：对象.方法() 反射机制：方法.invoke(对象)
        // 5.得到属性字段(不能得到私有的属性) java.lang.reflect.Field: 代表类的成员变量，Field 对象表示某个类的成员变量
        Field name = cls.getField("name");
        System.out.println(cls.getField("name").getClass()); // java.lang.reflect.Field
        System.out.println(name.get(o)); // 传统写法：对象.成员变量 反射：成员变量对象.get(对象)
        // 6.得到构造器 java.lang.reflect.Constructor 代表类的构造方法，Constructor 对象表示构造器
        Constructor constructor = cls.getConstructor(); // () 可以指定构造器的参数类型，默认返回无参构造
        System.out.println(constructor); // chapter23.Reflection.Cat()
        System.out.println(cls.getConstructor().getClass()); // java.lang.reflect.Constructor
        // 7.得到有参构造器
        Constructor constructor2 = cls.getConstructor(String.class); // 传入的 String.class 是 String 类的 Class 对象
        System.out.println(constructor2); // public chapter23.Reflection.Cat(java.lang.String)
        System.out.println(cls.getConstructor(String.class).getClass()); // class java.lang.reflect.Constructor
    }
}

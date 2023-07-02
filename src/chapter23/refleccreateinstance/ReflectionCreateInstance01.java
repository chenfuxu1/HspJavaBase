package chapter23.refleccreateinstance;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * 测试 1：通过反射创建某类的对象，要求该类中必须有 public 的无参构造
 * 测试 2：通过调用某个特定构造器的方式，实现创建某类的对象
 * 演示通过反射机制创建实例
 */
public class ReflectionCreateInstance01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1.先获取到 user 的 Class 对象
        Class<?> cls = Class.forName("chapter23.refleccreateinstance.User");
        // 2.通过 public 的无参构造器创建对象
        Object o1 = cls.newInstance();
        System.out.println(o1);
        /**
         * 3.通过 public 的有参构造器创建实例
         * constructor 对象就是
         * public User(String name){ // public 的有参构造器
         *     this.name = name;
         * }
         * 3.1 先获得对应的有参构造器
         */
        Constructor<?> constructor = cls.getConstructor(String.class);
        // 3.2 创建实例，并传入实参
        Object o2 = constructor.newInstance("路飞");
        System.out.println(o2);
        // 4.通过非 public 的有参构造器创建实例
        // 4.1 先得到 private 的构造器对象
        Constructor<?> constructor1 = cls.getDeclaredConstructor(int.class, String.class);
        // 4.2 创建实例，暴破,暴力破解
        // 使用反射可以访问 private 构造器/方法/属性, 反射面前，都是纸老虎
        constructor1.setAccessible(true);
        Object o3 = constructor1.newInstance(10, "娜美");
        System.out.println(o3);
    }
}

class User { // User 类
    private int age = 10;
    private String name = "韩顺平教育";

    public User() { // 无参 public
    }

    public User(String name) {//public 的有参构造器
        this.name = name;
    }

    private User(int age, String name) { // private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}

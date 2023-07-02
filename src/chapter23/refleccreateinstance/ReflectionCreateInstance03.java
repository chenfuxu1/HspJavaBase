package chapter23.refleccreateinstance;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射修改访问方法
 */
public class ReflectionCreateInstance03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 1.得到 Boss 类对应的 Class 对象
        Class<?> cls = Class.forName("chapter23.refleccreateinstance.Boss");
        // 2.创建对象
        Object o = cls.newInstance();
        // 3.调用 public 的 hi 方法
        // 3.1 得到 hi 方法对象
        Method hi = cls.getMethod("hi", String.class);
        // 3.2 调用
        hi.invoke(o, "海贼王");
        // 4.调用 private static 方法
        // 4.1 得到 say 方法对象
        Method say = cls.getDeclaredMethod("say", int.class, String.class, char.class);
        // 4.2 因为 say 方法是 private, 所以需要暴破，原理和前面讲的构造器和属性一样
        say.setAccessible(true);
        System.out.println(say.invoke(o, 10, "娜美", '女'));
        // 4.3 因为 say 方法是 static 的，还可以这样调用，可以传入 null
        System.out.println(say.invoke(null, 13, "娜美", '女'));
        // 5.在反射中，如果方法有返回值，统一返回 Object, 但是他运行类型和方法定义的返回类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型 = " + reVal.getClass()); // String
        // 再演示一个返回的案例
        Method m1 = cls.getDeclaredMethod("m1");
        Object invoke = m1.invoke(o);
        System.out.println("invoke 的运行类型 = " + invoke.getClass()); // chapter23.refleccreateinstance.Monster
    }
}

class Monster {
}

class Boss { // 类
    public int age;
    private static String name;

    public Boss() { // 构造器
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) { // 静态方法
        return n + " " + s + " " + c;
    }

    public void hi(String s) { // 普通 public 方法
        System.out.println("hi " + s);
    }
}
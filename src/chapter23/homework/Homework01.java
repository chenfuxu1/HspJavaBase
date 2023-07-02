package chapter23.homework;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射修改私有成员变量
 * 1.定义 PrivateTest有私有 name 属性，并且属性值为 hellokitty
 * 2.提供 getName 的公有方法
 * 3.创建 PrivateTest 类，利用 Class 类得到私有的 name 属性，修改私有的 name 属性值
 * 并调用 getName() 的方法打印 name 属性值
 */
public class Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 1.获取 Class 对象
        Class<?> cls = Class.forName("chapter23.homework.PrivateTest");
        // 2.创建对象实例
        Object o = cls.newInstance();
        // 3.拿到name对象
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true); // 私有属性，爆破
        name.set(o, "路飞"); // 修改属性
        System.out.println(o);
        // 4.获取 getName() 的对象
        Method getName = cls.getDeclaredMethod("getName");
        System.out.println(getName.invoke(o));
    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PrivateTest{" +
                "name='" + name + '\'' +
                '}';
    }
}

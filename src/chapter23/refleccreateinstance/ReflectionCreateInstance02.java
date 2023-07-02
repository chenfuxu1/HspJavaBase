package chapter23.refleccreateinstance;


import java.lang.reflect.Field;


/**
 * 通过反射访问修改属性 Field
 */
public class ReflectionCreateInstance02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 1.得到 Student 类对应的 Class 对象
        Class<?> cls = Class.forName("chapter23.refleccreateinstance.Student");
        // 2.创建对象
        Object o = cls.newInstance(); // o 的运行类型就是 Student
        System.out.println(o.getClass());
        // 3.使用反射得到 age 属性对象
        Field age = cls.getField("age");
        age.set(o, 10); // 通过反射来操作属性
        System.out.println(o);
        System.out.println(age.get(o)); // 返回 age 属性的值
        // 4.使用反射操作 name 属性
        Field name = cls.getDeclaredField("name");
        // 对 name 进行暴破, 可以操作 private 属性
        name.setAccessible(true);
        // name.set(o, "路飞");
        name.set(null, "老韩~"); // 因为 name 是 static 属性，因此 o 也可以写出 null
        System.out.println(o);
        System.out.println(name.get(o)); // 获取属性值
        System.out.println(name.get(null)); // 获取属性值, 要求 name 是 static
    }
}

class Student { // 类
    public int age;
    private static String name;

    public Student() { // 构造器
    }

    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
}
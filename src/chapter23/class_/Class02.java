package chapter23.class_;

import chapter23.reflection.Cat;

import java.lang.reflect.Field;

/**
 * 演示 Class 类的常用方法
 */
public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "chapter23.reflection.Cat";
        /**
         * 1.获取到 Cat 类对应的 Class 对象
         * <?> 表示不确定的 Java 类型
         */
        Class<?> cls = Class.forName(classAllPath);

        // 2.输出 cls
        System.out.println(cls); // 是类对象 Class 对象 chapter23.reflection.Cat
        System.out.println(cls.getClass()); // 获得是运行类型，java.lang.Class

        // 3.得到包名
        System.out.println(cls.getPackage().getName()); // chapter23.reflection

        // 4.得到全类名
        System.out.println(cls.getName()); // chapter23.reflection.Cat

        // 5.通过 cls 创建实例对象
        Cat cat = (Cat) cls.newInstance();
        System.out.println(cat); // cat.toString()

        // 6.通过反射获取属性 name
        Field name = cls.getField("name");
        System.out.println(name.get(cat)); // 旺财

        // 7.通过反射给属性赋值
        name.set(cat, "橘猫");
        System.out.println(name.get(cat)); // 橘猫

        // 8.获取所有的字段
        System.out.println("======所有的字段如下=======");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            // field.getName() 表示字段，field.get(cat) 表示字段的内容
            System.out.println(field.getName() + "=" + field.get(cat));
        }
    }
}

package chapter23.class_;

import chapter23.reflection.Cat;

/**
 * 演示得到 Class 对象的各种方式
 */
public class GetClass_ {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.Class.forName
        String classAllPath = "chapter23.reflection.Cat";
        Class<?> cls1 = Class.forName(classAllPath);
        System.out.println(cls1);

        // 2.类名.class，应用场景，用于参数传递
        Class cls2 = Cat.class;
        System.out.println(cls2);

        // 3.对象.getClass()，应用场景：有实例对象
        Cat cat = new Cat();
        Class cls3 = cat.getClass();
        System.out.println(cls3);

        // 4.通过类加载器来获取到类的 Class 对象
        // (1)先得到类加载器 cat
        ClassLoader classLoader = cat.getClass().getClassLoader();
        // (2)通过类加载器得到 Class 对象
        Class cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);

        // cls1, cls2, cls3, cls4 其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        // 5.基本数据(int, char,boolean,float,double,byte,long,short) 按如下方式得到 Class 类对象
        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        Class<Float> floatClass = float.class;
        Class<Double> doubleClass = double.class;
        Class<Byte> byteClass = byte.class;
        Class<Long> longClass = long.class;
        Class<Short> shortClass = short.class;
        System.out.println(integerClass); // int
        System.out.println(integerClass.getClass()); // java.lang.Class
        System.out.println(characterClass); // char
        System.out.println(characterClass.getClass()); // java.lang.Class

        // 6.基本数据类型对应的包装类，可以通过 .TYPE 得到 Class 类对象
        Class<Integer> type1 = Integer.TYPE;
        Class<Character> type2 = Character.TYPE;
        Class<Boolean> type3 = Boolean.TYPE;
        Class<Float> type4 = Float.TYPE;
        Class<Double> type5 = Double.TYPE;
        Class<Byte> type6 = Byte.TYPE;
        Class<Long> type7 = Long.TYPE;
        Class<Short> type8 = Short.TYPE;
        System.out.println(type1); // int
        System.out.println(type1.getClass()); // class java.lang.Class
        System.out.println(type2); // char
        System.out.println(type2.getClass()); // class java.lang.Class
    }
}

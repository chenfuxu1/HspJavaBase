package chapter23.class_;


import chapter23.reflection.Cat;

/**
 * 对 Class 类进行梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 1.Class 也是类，因此也继承 Object 类
         * 看看 Class 类图
         */

        /**
         * 2.Class 类对象不是 new 出来的，而是系统创建的
         *
         * (1)传统方法构建对象
         * Cat cat = new Cat();
         * ClassLoader 类
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *     return loadClass(name, false);
         * }
         *
         * (2)反射方法构建对象
         * ClassLoader 类, 仍然是通过 ClassLoader 类加载 Cat 类的 Class 对象
         * public Class<?> loadClass(String name) throws ClassNotFoundException {
         *     return loadClass(name, false);
         * }
         */
        Class cls1 = Class.forName("chapter23.reflection.Cat");

        // 3.对于某个类的 Class 类对象，在内存中只有一份，因为类只加载一次
        Class cls2 = Class.forName("chapter23.reflection.Cat");
        System.out.println(cls1.hashCode()); // 1554874502
        System.out.println(cls2.hashCode()); // 1554874502
    }
}

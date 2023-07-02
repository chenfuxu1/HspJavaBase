package chapter23.reflectionutils;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/30 23:04
 **/
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    // 第一组方法 API，获得 java.lang.Class 类
    @Test
    public void api01() throws ClassNotFoundException {
        // 1.得到 Class 对象
        Class<?> personCls = Class.forName("chapter23.reflectionutils.Person");
        System.out.println(personCls.getClass());
        // 2.getName: 获取全类名
        System.out.println(personCls.getName()); // chapter23.reflectionutils.Person
        // 3.getSimpleName: 获取简单类名
        System.out.println(personCls.getSimpleName()); // Person
        // 4.getFields: 获取所有 public 修饰的属性，包含本类以及父类的
        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println("本类以及父类的属性 = " + field.getName());
        }
        System.out.println("=====================");
        // 5.getDeclaredFields: 获取本类中所有属性
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性 = " + declaredField.getName());
        }
        System.out.println("=====================");
        // 6.getMethods: 获取所有 public 修饰的方法，包含本类的以及父类的
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println("本类的以及父类的方法 = " + method);
        }
        System.out.println("=====================");
        // 7.getDeclaredMethods: 获取本类中的所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中的所有方法 = " + declaredMethod);
        }
        System.out.println("=====================");
        // 8.getConstructors: 获取本类所有 public 修饰的构造器
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("本类所有 public 修饰的构造器：" + constructor);
        }
        System.out.println("=====================");
        // 9.getDeclaredConstructors：获取本类所有的构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类所有的构造器 = " + declaredConstructor);
        }
        System.out.println("=====================");
        // 10.getPackage: 以 Package 形式返回包信息
        System.out.println(personCls.getPackage()); // package chapter23.reflectionutils
        System.out.println("=====================");
        // 11.getSuperClass: 以 Class 形式返回父类信息
        Class<?> superclass = personCls.getSuperclass();
        System.out.println("父类的 class 对象：" + superclass);
        System.out.println("=====================");
        // 12.getInterfaces: 以 Class[] 形式返回接口信息
        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println("接口信息：" + anInterface);
        }
        System.out.println("=====================");
        // 13.getAnnotations: 以 Annottaion[] 形式返回注解信息
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解信息：" + annotation);
        }
    }

    // 第二组
    @Test
    public void api02() throws ClassNotFoundException {
        // 得到 Class 对象
        Class<?> personCls = Class.forName("chapter23.reflectionutils.Person");
        // 1.getDeclaredFields: 获取本类中所有属性
        // 规定说明: 默认修饰符是 0，public 是 1，private 是 2，protected 是 4, static 是 8，final 是 16
        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("本类中所有属性 = " + declaredField.getName() +
                    " 该属性的修饰符值 = " + declaredField.getModifiers()
                    + " 该属性的类型 = " + declaredField.getType());
        }
        System.out.println("=====================");
        // 2.getDeclaredMethods: 获取本类中所有方法
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("本类中所有方法 = " + declaredMethod.getName()
                    + " 该方法的访问修饰符值 = " + declaredMethod.getModifiers()
                    + " 该方法返回类型 = " + declaredMethod.getReturnType());
            // 输出当前这个方法的形参数组情况
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该方法的形参类型 = " + parameterType);
            }
        }
        System.out.println("=====================");
        // 3.getDeclaredConstructors: 获取本类中所有构造器
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("本类中所有构造器 = " + declaredConstructor.getName()); // 这里只是输出名
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型 = " + parameterType);
            }
        }
    }
}

class A {
    public String hobby;

    public void hi() {
    }

    public A() {
    }

    public A(String name) {
    }
}

interface IA {
}

interface IB {
}

@Deprecated
class Person extends A implements IA, IB {
    // 属性
    public String name;
    protected static int age; // 4 + 8 = 12
    String job;
    private double sal;

    // 构造器
    public Person() {
    }

    public Person(String name) {
    }

    // 私有的
    private Person(String name, int age) {
    }

    // 方法
    public void m1(String name, int age, double sal) {
    }

    protected String m2() {
        return null;
    }

    void m3() {
    }

    private void m4() {
    }

}

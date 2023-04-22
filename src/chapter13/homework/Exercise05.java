package chapter13.homework;

public class Exercise05 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        Animal a = new Animal(s1);
        Animal b = new Animal(s1);
        System.out.println(a == b); // 都是 new 出来的不同对象，false
        System.out.println(a.equals(b)); // 没有重写 equals 方法，false
        System.out.println(a.name == b.name); // 都是常量池的对象，true
        System.out.println("=====================");
        String s4 = new String("hspedu");
        String s5 = "haspedu";
        System.out.println(s1 == s4); // s1 在常量池，s4 在堆区，false
        System.out.println(s4 == s5); // s4 在堆区，s5 在常量池，false
        System.out.println("===============");
        String t1 = "hello" + s1; // 在堆区
        String t2 = "hellohspedu";
        System.out.println(t1.intern() == t2); // t1.intern() 不有无对象返回都是常量池地址，故为T
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
}
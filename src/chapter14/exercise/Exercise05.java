package chapter14.exercise;


import java.util.TreeSet;

/**
 * 下列代码有没有异常？
 */
public class Exercise05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person()); // 有异常，该类没有实现 Compareable 接口 ClassCastException
    }
}

class Person {
}

class Person2 implements Comparable { // 使用该对象无异常
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
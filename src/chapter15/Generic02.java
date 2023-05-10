package chapter15;

import java.util.*;

public class Generic02 {
    public static void main(String[] args) {
        // 1.使用泛型方式给 HashSet 放入 3 个学生对象
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("jack", 18));
        students.add(new Student("tom", 28));
        students.add(new Student("mary", 19));
        for (Student student : students) {
            System.out.println(student);
        }

        // 2.放入到 HashMap 中，要求 Key 是 String name, Value 就是 学生对象
        HashMap<String, Student> map = new HashMap<String, Student>();
        map.put("milan", new Student("milan", 38));
        map.put("smith", new Student("smith", 48));
        map.put("hsp", new Student("hsp", 28));

        // 3.迭代器 EntrySet
        System.out.println("======== 迭代器 ======");
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + " --- " + next.getValue());
        }

        // 4.增强 for
        System.out.println("======== 增强 for ======");
        Set<String> strings = map.keySet();
        for (String s : strings) {
            System.out.println(s + " ------ " + map.get(s));
        }

    }
}

/**
 * 创建 3 个学生对象
 * 放入到 HashSet 中学生对象, 使用
 * 放入到 HashMap 中，要求 Key 是 String name, Value 就是 学生对象
 * 使用两种方式遍历
 */
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
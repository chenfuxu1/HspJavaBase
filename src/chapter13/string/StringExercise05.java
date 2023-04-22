package chapter13.string;


public class StringExercise05 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name)); // 比较内容相同，T
        System.out.println(p1.name == p2.name); // 内容相同，T
        System.out.println(p1.name == "hspedu"); // 内容相同，T
    }
}

class Person {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
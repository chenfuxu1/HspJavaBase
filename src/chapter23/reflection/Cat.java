package chapter23.reflection;

public class Cat {
    public String name = "旺财";
    public int id = 10;
    public String address = "北京上海";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int age = 10;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void hi() {
        // System.out.println("hi hi hi hi");
        this.age += 1;
    }

    public void cry() {
        System.out.println("cry cry cry");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

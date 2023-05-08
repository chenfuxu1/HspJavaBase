package chapter14.exercise;


import java.util.HashSet;
import java.util.Objects;


/**
 * 已知 Person 类按照 id 和 name 重写了 hashCode 和 equals 方法，问下面代码输出什么
 */
public class Exercise06 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person_ p1 = new Person_(1001, "AA");
        Person_ p2 = new Person_(1002, "BB");
        set.add(p1); // 假如在 table 表索引 1 处
        set.add(p2); // 假如在 table 表索引 2 处
        p1.setName("CC"); // 改后 p1 的 hashCode 变化了，但在 table 表索引没变
        set.remove(p1); // 删不掉，找到的是新的 hash 值，假如是新的位置3，没有数据，无法删除
        System.out.println("set = " + set); // 输出两个对象
        set.add(new Person_(1001, "CC")); // 假如在 table 表索引 3 处
        System.out.println("set = " + set); // 可以输出 3 个对象
        set.add(new Person_(1001, "AA")); // hash 值会定位在 table 表索引 1 处，但内容和 p1 不相同，所以挂在 p1 节点后面
        System.out.println("set = " + set); // 可以输出 4 个对象
    }
}

class Person_ {
    private int id;
    private String name;

    public Person_(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_ person_ = (Person_) o;
        return id == person_.id &&
                Objects.equals(name, person_.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person_{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

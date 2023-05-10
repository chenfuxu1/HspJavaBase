package chapter15;


import org.junit.jupiter.api.Test;

import java.util.*;

public class Exercise01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        DAO<User> du = new DAO<>();
        du.save("001", new User(1, 10, "jack"));
        du.save("002", new User(2, 10, "King"));
        du.save("003", new User(3, 10, "smith"));

        List<User> list = du.list(); // 返回User对象
        System.out.println(list);

        System.out.println("=========== 修改 ========");
        du.update("003", new User(3, 58, "lufei"));
        List<User> list2 = du.list(); // 返回User对象
        System.out.println(list2);

        System.out.println("========= 删除 ======");
        du.delete("003");
        List<User> list3 = du.list(); // 返回User对象
        System.out.println(list3);

        System.out.println("========= 获取 001 ====");
        System.out.println(du.get("001"));
    }
}

class DAO<T> {
    private Map<String, T> m = new HashMap<>();

    public void save(String id, T entity) {
        m.put(id, entity);
    }

    public T get(String id) {
        return m.get(id);
    }

    public void update(String id, T entity) {
        m.put(id, entity);
    }

    public List<T> list() {
        List<T> list = new ArrayList<>();
        Set<Map.Entry<String, T>> entries = m.entrySet();
        Iterator<Map.Entry<String, T>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, T> next = iterator.next();
            list.add(next.getValue());
        }
        return list;

    }

    public void delete(String id) {
        m.remove(id);
    }
}

class User {
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}

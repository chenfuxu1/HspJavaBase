package chapter14.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 使用 HashMap 添加 3 个员工对象，要求
 * 键：员工 id
 * 值：员工对象
 * 并遍历显示工资 >18000 的员工(遍历方式最少两种)
 * 员工类：姓名、工资、员工 id
 */
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee("路飞", 17000, 1));
        map.put(2, new Employee("路飞", 19000, 2));
        map.put(3, new Employee("路飞", 19000, 3));

        Set set = map.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal() > 18000) {
                System.out.println(employee.getId() + " --- " + employee.getSal());
            }
        }
        System.out.println("====================");

        Set set1 = map.keySet();
        for (Object o : set1) {
            Employee employee = (Employee) map.get(o);
            if (employee.getSal() > 18000) {
                System.out.println(employee.getId() + " --- " + employee.getSal());
            }
        }
    }
}

class Employee {
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}

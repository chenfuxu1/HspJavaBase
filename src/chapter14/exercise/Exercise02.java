package chapter14.exercise;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用 ArrayList 完成对对象 Car{name，price} 的各种操作
 * 1.add 添加单个元素
 * 2.remove 删除指定元素
 * 3.contains 查找元素是否存在
 * 4.size 获取元素的个数
 * 5.isEmpty 判断是否为空
 * 6.clear 清空
 * 7.addAll 添加多个元素
 * 8.containsAll 查找多个元素是否都存在
 * 9.removeAll 删除多个元素
 * 使用增强 for 和迭代器来遍历所有的 Car，需要重写 Car 的 toString 方法
 */
public class Exercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);

        // 1.add 添加单个元素
        list.add(car1);
        list.add(car2);
        System.out.println(list);

        // 2.remove 删除指定元素
        list.remove(0);
        System.out.println(list);

        // 3.contains 查找元素是否存在
        System.out.println(list.contains(car1)); // false

        // 4.size 获取元素的个数
        System.out.println(list.size());

        // 5.isEmpty 判断是否为空
        System.out.println(list.isEmpty());

        // 6.clear 清空
        list.clear();
        System.out.println(list); // 空

        // 7.addAll 添加多个元素
        List list2 = new ArrayList();
        list2.add(car1);
        list2.add(car2);
        list.addAll(list2);
        list.addAll(list2);
        System.out.println(list);

        // 8.containsAll 查找多个元素是否都存在
        System.out.println(list.containsAll(list2));

        // 9.removeAll 删除多个元素
        list2.removeAll(list2);
        System.out.println(list2);

        // 使用增强 for 和迭代器来遍历所有的 car
        System.out.println("========== 增强 for ===========");
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("============ 迭代器 ============");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}


class Car {
    private String name;
    private double prive;

    public Car(String name, double prive) {
        this.name = name;
        this.prive = prive;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", prive=" + prive +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrive() {
        return prive;
    }

    public void setPrive(double prive) {
        this.prive = prive;
    }
}

package chapter14.exercise;


import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


/**
 * 1.使用 HashMap 类实例化一个 Map 类型的对象 m，键（String）和值（int）分别存储员工的
 * 姓名和工资，存入数据如下，jack - 650；tom - 1200；smith -2 900
 * 2.将 jack 的工资改为 2600
 * 3.所有员工加薪 100 元
 * 4.遍历集合中所有的员工
 * 5.遍历集合中所有的工资
 */
public class Exercise03 {
    public static void main(String[] args) {
        HashMap m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);
        System.out.println(m);

        // 2.将 jack 的工资改为 2600
        m.put("jack", 2600);
        System.out.println(m);

        // 3.所有员工加薪 100 元
        Set set = m.keySet();
        for (Object o : set) {
            m.put(o, (Integer) m.get(o) + 100);
        }
        System.out.println(m);

        // 4.遍历集合中所有的员工
        System.out.println("====== 员工 ======");
        for (Object o : set) {
            System.out.println(o);
        }

        //5.遍历集合中所有的工资
        System.out.println("====== 工资 ======");
        Collection values = m.values();
        for (Object o : values) {
            System.out.println(o);
        }
    }
}

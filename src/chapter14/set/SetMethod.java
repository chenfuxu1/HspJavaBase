package chapter14.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings({"all"})
public class SetMethod {
    public static void main(String[] args) {
        // 1.以 Set 接口的实现类 HashSet 来讲解 Set 接口的方法
        // 2.set 接口的实现类的对象(Set 接口对象), 不能存放重复的元素, 可以添加一个 null，一个空串
        // 3.set 接口对象存放数据是无序(即添加的顺序和取出的顺序不一致)
        // 4.注意：取出的顺序的顺序虽然不是添加的顺序， 但是他的顺序是固定的
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("john"); // 重复
        set.add("jack");
        set.add("hsp");
        set.add("mary");
        set.add(null); // null
        set.add(null); // 再次添加 null
        set.add(""); // 空串
        set.add(""); // 再次添加空串
        for (int i = 0; i < 10; i++) {
            System.out.println(" set = " + set);
        }

        // 遍历
        // 方式 1：使用迭代器
        System.out.println("======== 使用迭代器 =========");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        set.remove(null);

        // 方式 2：使用增强 for
        System.out.println("========== 使用增强 for ==========");
        for (Object o : set) {
            System.out.println(o);
        }

        // set 不能通过索引获取
    }
}

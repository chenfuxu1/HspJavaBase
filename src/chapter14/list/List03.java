package chapter14.list;

import java.util.ArrayList;
import java.util.List;

public class List03 {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 15; i++) {
            list.add("hello" + i);
        }

        // 1.遍历输出
        for (Object o : list) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println("==================");

        // 2. 2 号插入韩顺平教育
        list.add(1, "韩顺平教育");

        // 3.获得第五个元素
        System.out.println(list.get(4));

        // 4.删除第六个元素
        Object remove = list.remove(5);
        for (Object o : list) {
            System.out.print(o + "\t");
        }
        System.out.println();
        System.out.println("==================");

        // 5.修改第七个元素
        list.set(6, "cfx");
        for (Object o : list) {
            System.out.print(o + "\t");
        }
        System.out.println();
    }
}

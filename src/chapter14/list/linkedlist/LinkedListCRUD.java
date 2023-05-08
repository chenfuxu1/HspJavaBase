package chapter14.list.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/4/24 8:58
 **/
public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // 1.添加
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        // 2.删除
        linkedList.remove();
        System.out.println("linkedList = " + linkedList);

        // 3.修改
        linkedList.set(1, 999);
        System.out.println("linkedList = " + linkedList);

        // 4.获取某个节点对象
        Object o = linkedList.get(1);
        System.out.println(o);

        // 5.遍历方式 1
        Iterator iterator = linkedList.iterator();
        System.out.println("================");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        System.out.println("================");

        // 6.遍历方式 2，增强 for
        System.out.println("======== 增强 for ========");
        for (Object o1 : linkedList) {
            System.out.println(o1);
        }
        System.out.println("======= 增强 for =========");

        // 7.普通 for 循环
        System.out.println("======== 普通 for 循环 ========");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println("======== 普通 for 循环 ========");

        // 1.构造器
        // 开始初始化
        // public LinkedList() {
        // }
    }
}

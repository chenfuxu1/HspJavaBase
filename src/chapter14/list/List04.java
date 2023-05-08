package chapter14.list;

import java.util.*;

public class List04 {
    public static void main(String[] args) {
        // List 接口的实现子类 Vector LinkedList
        // List list = new ArrayList();
        // List list = new Vector();
        List list = new LinkedList();
        list.add("jack");
        list.add("tom");
        list.add("鱼香肉丝");
        list.add("北京烤鸭子");

        // 遍历 1: 迭代器 快捷键：itit
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        System.out.println("===================");

        // 方式 2: 增强 for  快捷键：I
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("===================");

        // 方式 3，普通 for 循环
        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }
    }
}

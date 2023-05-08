package chapter14.list;

import java.util.ArrayList;
import java.util.List;

public class List02 {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");

        // 在 index = 1 的位置插入一个对象
        list.add(1, "韩顺平");
        System.out.println("list = " + list);

        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list = " + list);

        // Object get(int index): 获取指定 index 位置的元素
        // int indexOf(Object obj): 返回 obj 在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));//2

        // int lastIndexOf(Object obj): 返回 obj 在当前集合中末次出现的位置
        list.add("韩顺平");
        System.out.println("list = " + list);
        System.out.println(list.lastIndexOf("韩顺平"));

        // Object remove(int index): 移除指定 index 位置的元素，并返回此元素
        list.remove(0);
        System.out.println("list = " + list);

        // Object set(int index, Object ele): 设置指定 index 位置的元素为 ele , 相当于是替换.
        list.set(1, "玛丽");
        System.out.println("list = " + list);

        // List subList(int fromIndex, int toIndex): 返回从 fromIndex 到 toIndex 位置的子集合
        // 注意返回的子集合 fromIndex <= subList < toIndex
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist = " + returnlist);
    }
}

package chapter14.set.hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    public static void main(String[] args) {
        /**
         * 1.构造器走的源码
         *
         * public HashSet() {
         *     map = new HashMap<>();
         * }
         * 2. HashSet 可以存放 null, 但是只能有一个 null, 即元素不能重复
         */
        Set hashSet = new HashSet();
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add("");
        hashSet.add("");
        System.out.println("hashSet = " + hashSet);
    }
}
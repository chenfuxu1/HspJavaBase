package chapter14.list.vector;

import java.util.LinkedList;
import java.util.Vector;

public class Vector_ {
    public static void main(String[] args) {
        // 无参构造器
        // 有参数的构造
        Vector vector = new Vector(8);
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("vector=" + vector);
        // 1.new Vector() 底层

        // public Vector() {
        //     this(10);
        // }

        // 如果是 Vector vector = new Vector(8);
        // 走的方法:
        // public Vector( int initialCapacity){
        //     this(initialCapacity, 0);
        // }

        // 2.vector.add(i)
        // 2.1 下面这个方法就添加数据到 vector 集合
        // public synchronized boolean add (E e){
        //     modCount++;
        //     ensureCapacityHelper(elementCount + 1);
        //     elementData[elementCount++] = e;
        //     return true;
        // }
        // 2.2 确定是否需要扩容条件：minCapacity - elementData.length > 0
        // private void ensureCapacityHelper (int minCapacity){
        //     // overflow-conscious code
        //     if (minCapacity - elementData.length > 0)
        //         grow(minCapacity);
        // }

        // 2.3 如果需要的数组大小不够用，就扩容, 扩容的算法
        // newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        // 就是扩容两倍.
        // private void grow(int minCapacity) {
        //     // overflow-conscious code
        //     int oldCapacity = elementData.length;
        //     int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
        //             capacityIncrement : oldCapacity);
        //     if (newCapacity - minCapacity < 0)
        //         newCapacity = minCapacity;
        //     if (newCapacity - MAX_ARRAY_SIZE > 0)
        //         newCapacity = hugeCapacity(minCapacity);
        //     elementData = Arrays.copyOf(elementData, newCapacity);
        // }
    }
}

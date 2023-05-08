package chapter14.set.hashset;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/4/30 23:04
 * <p>
 * 模拟实现 HashSet 的底层，数组 + 链表
 **/
public class HashSetStructure {
    public static void main(String[] args) {
        // 1.创建一个数组，类型为：Node[]
        Node[] table = new Node[16];
        System.out.println("table = " + table);

        // 2.在 2 的位置创建节点
        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.mNext = jack; // 将 jack 节点挂载到 john 节点后面
        Node rose = new Node("rose", null);
        jack.mNext = rose; // 将 rose 节点挂载到 jack 节点后面

        // 3.将 lucy 放到 table 表的索引为 3 的位置
        Node lucy = new Node("lucy", null);
        table[3] = lucy;
        System.out.println("table = " + table);
    }
}

// 节点，存放数据内容
class Node {
    Object mItem; // 存放元素数据
    Node mNext; // 指向下一个节点

    public Node(Object item, Node next) {
        mItem = item;
        mNext = next;
    }
}

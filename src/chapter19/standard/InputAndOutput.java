package chapter19.standard;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        /**
         * 标准输入 System.in
         * System.in 是 public final static InputStream in = null;
         * System.in 是标准输入，编译类型是 InputStream
         * 运行类型是：BufferedInputStream
         * 该流是字节流，也是处理流
         * 标准输入：键盘
         */
        System.out.println(System.in.getClass()); // class java.io.BufferedInputStream

        /**
         * 标准输出 System.out
         * System.out 是 public final static PrintStream out = null;
         * 编译类型：PrintStream
         * 运行类型：PrintStream
         * 标准输出：显示器
         */
        System.out.println(System.out.getClass()); // class java.io.PrintStream

        /**
         * 使用 out 对象将数据输出到显示器，标准输出
         */
        System.out.println("我亦无他");

        /**
         * 标准输入
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入：");
        String next = scanner.next();
        System.out.println(next);
    }
}

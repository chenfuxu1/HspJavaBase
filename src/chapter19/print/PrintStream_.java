package chapter19.print;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/4 22:40
 * <p>
 * 字节打印流
 * 打印流只有输出，没有输入
 **/
public class PrintStream_ {
    public static void main(String[] args) {

    }

    @Test
    public void printStream() throws IOException {
        PrintStream printStream = System.out;
        /**
         * 在默认情况下，PrintStream 输出数据的位置是 "标准输出", 即显示器
         * public void print(String s) {
         *     if (s == null) {
         *         s = "null";
         *     }
         *     write(s);
         * }
         */
        printStream.print("hello, world!");
        // 因为 print 底层使用的是 write 方法，所以可以直接调用 write 方法进行打印 / 输出
        printStream.write("张三、李四、王五".getBytes());
        printStream.close();

        /**
         * 修改打印流的输出位置
         * 1.输出位置修改为：d:\printStream.txt
         * 2.打印的内容会写入到该文件路径中
         * 3.源码
         * public static void setOut(PrintStream out) {
         *     checkIO();
         *     setOut0(out); // native 方法，修改了 out
         * }
         */
        System.setOut(new PrintStream("d:\\printStream.txt"));
        System.out.println("写入文件到 d:\\printStream.txt");
    }
}

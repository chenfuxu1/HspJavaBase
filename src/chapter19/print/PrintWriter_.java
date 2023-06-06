package chapter19.print;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/4 22:40
 **/
public class PrintWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void printWriter() throws IOException {
        // 默认输出到显示器
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("哈哈哈");
        printWriter.close();

        // 更改输出的路径
        PrintWriter printWriter1 = new PrintWriter(new FileWriter("d:\\printWriter.txt"));
        printWriter1.println("张三、李四、王五");
        printWriter1.close(); // 关闭流，才会写入数据
    }
}

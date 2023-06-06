package chapter19.transformstream;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/31 23:55
 * <p>
 * 先看一个文件乱码问题， 引出学习转换流必要性
 * 读取 d:\\a.txt 的文本文件到程序
 **/
public class CodeQuestion {
    public static void main(String[] args) throws Exception {
        /**
         * 1.创建一个输入流，字符流 BufferedReader（处理流）
         * 2.BufferedReader 读取 a.txt 对象
         * 3.默认情况下是按照 utf-8 编码读取的，此时文本文件也是 utf-8
         */
        String filePath = "d:\\a.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        bufferedReader.close();
        /**
         * 4.修改文本文件的编码为 ANSI 时，重复上述读取过程，将出现乱码
         * 5.根本原因是没有指定读取文件的编码，因此引出转换流的必要性
         */
    }
}

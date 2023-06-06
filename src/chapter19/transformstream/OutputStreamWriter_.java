package chapter19.transformstream;

import org.junit.jupiter.api.Test;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/1 23:46
 * <p>
 * 编程将字节流 FileOutputStream 包装成字符流 OutputStreamWriter
 * 对文件进行写入（按照 utf-8 格式）
 **/
public class OutputStreamWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void transformWriter() {
        String filePath = "d:\\a.txt";
        String charset = "utf-8";
        OutputStreamWriter outputStreamWriter = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 1.创建流对象
            fileOutputStream = new FileOutputStream(filePath);
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, charset);
            // 2.写入
            outputStreamWriter.write("张三、李四、王五、赵六");
            outputStreamWriter.write('\n');
            outputStreamWriter.write("hello, world");
            outputStreamWriter.write('\n');
            outputStreamWriter.write("编码格式为：" + charset);
            System.out.println("写入文件成功，编码格式为：" + charset);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 3.关闭流
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

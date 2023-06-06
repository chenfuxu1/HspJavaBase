package chapter19.instream.reader.bufferedreader;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/29 23:53
 *
 * 处理流
 * 使用 BufferedReader 读取文本文件，并显示在控制台
 **/
public class BufferedReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void readFile() {
        String filePath = "d:\\a.java";
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        // 读取，按行读取，效率更高
        String readData = null;
        try {
            fileReader = new FileReader(filePath);
            // 创建 bufferedReader 对象
            bufferedReader = new BufferedReader(fileReader);
            /**
             * 1.bufferedReader.readLine() 是按行读取文件
             * 2.当返回 null 时，表示文件读取完毕
             */
            while ((readData = bufferedReader.readLine()) != null) {
                System.out.println(readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    // 关闭流, 这里注意，只需要关闭 BufferedReader，因为底层会自动的去关闭内部的节点流
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * 外部处理流关闭源码
         * 实际还是已经关闭了内部的的节点流
         * public void close() throws IOException {
         *      synchronized (lock) {
         * 		    if (in == null)
         * 		    	return;
         * 		    try {
         * 		    	in.close(); // 关闭内部的节点流
         *          } finally {
         * 		    	in = null;
         * 		    	cb = null;
         *          }
         *      }
         * }
         */
    }
}

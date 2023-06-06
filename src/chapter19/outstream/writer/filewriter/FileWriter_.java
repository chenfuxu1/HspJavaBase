package chapter19.outstream.writer.filewriter;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/26 23:47
 *
 * 字符输出流：FileWriter
 * 使用 FileWriter 将 "风雨之后，定见彩虹" 写入到 note.txt 文件中
 **/
public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void writeFile() {
        String filePath = "d:\\note.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            fileWriter = new FileWriter(filePath, true);
            // 1.write(int) 写入单个字符
            fileWriter.write('H');
            // 2.write(char[]) 写入数组
            fileWriter.write(chars);
            // 3.write(char[], off, len): 写入指定数组的指定部分
            fileWriter.write("可可爱爱的陈小荣".toCharArray(), 0, 3 );
            // 4.write(String)) 写入整个字符串
            fileWriter.write("我爱路飞");
            // 5.write(string,off,len): 写入字符串的指定部分
            fileWriter.write("陈小荣的白羊", 1, 3);
            fileWriter.write("汤唯");
            fileWriter.write("刘亦菲");
            fileWriter.write("女");
            fileWriter.write("风雨之后，定见彩虹".toCharArray());
            fileWriter.write("小大老师", 1, 3);
            fileWriter.flush();
            //在数据量大的情况下，可以使用循环操作
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    /**
                     * 对应 FileWriter, 一定要关闭流，或者 flush 才能真正的把数据写入到文件
                     * fileWriter.close()源码
                     * private void writeBytes() throws IOException {
                     *     this.bb.flip();
                     *     int var1 = this.bb.limit();
                     *     int var2 = this.bb.position();
                     *
                     *     assert var2 <= var1;
                     *
                     *     int var3 = var2 <= var1 ? var1 - var2 : 0;
                     *     if (var3 > 0) {
                     *         if (this.ch != null) {
                     *             assert this.ch.write(this.bb) == var3 : var3;
                     *         } else {
                     *             this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                     *         }
                     *     }
                     *
                     *     this.bb.clear();
                     * }
                     */
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

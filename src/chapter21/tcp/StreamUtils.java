package chapter21.tcp;

import java.io.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/14 22:57
 * <p>
 * 此类用于演示关于流的读写方法
 **/
public class StreamUtils {
    /**
     * 功能：将输入流转换成 byte[]，即可以把文件的内容读入到 byte[]
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int readLen = -1;
        while ((readLen = inputStream.read(buff)) != -1) {
            byteArrayOutputStream.write(buff, 0, readLen); // 把读取到的数据，写入 byteArrayOutputStream
        }
        byte[] result = byteArrayOutputStream.toByteArray(); // 然后将 byteArrayOutputStream 转成字节数组
        byteArrayOutputStream.close();
        return result;
    }

    /**
     * 功能：将 InputStream 转换成 String
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static String streamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String readLine = "";
        while ((readLine = bufferedReader.readLine()) != null && readLine.length() > 0) {
            stringBuilder.append(readLine);
            stringBuilder.append("\r\n");
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }
}

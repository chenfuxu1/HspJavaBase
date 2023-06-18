package chapter21.homework;


import chapter21.tcp.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.编写客户端和服务端程序
 * 2.客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后
 * 可以给客户端返回这个音乐文件，如果没有，返回默认的音乐即可
 * 3.客户端收到文件后，保存到本地 d:\\test\\
 * 4.可以使用 StreamUtils.java
 */
public class HomeworkServer03 {
    public static void main(String[] args) throws Exception {
        // 1.监听 9999 端口
        ServerSocket serverSocket = new ServerSocket(9999);
        // 2.等待客户端连接
        Socket socket = serverSocket.accept();
        /**
         * 3.读取客户端要下载的文件名
         * 此处万一文件名比较长，采用循环读取，直至结束
         * 正常情况下文件名用不了 1024 个字节
         */
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        String downloadFileName = "";
        while ((len = inputStream.read(buf)) != -1) {
            downloadFileName += new String(buf, 0, len);
        }
        System.out.println("文件名：" + downloadFileName);
        /**
         * 4.服务器上有两个文件，无名.mp3 高山流水.mp3
         * 如果客户端下载的是高山流水，就返回该文件，否则一律返回无名.mp3
         */
        String resFileName = "";
        if ("高山流水".equals(downloadFileName)) {
            resFileName = "src\\chapter21\\高山流水.mp3";
        } else {
            resFileName = "src\\chapter21\\无名.mp3";
        }
        // 5.创建输入流，读取文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(resFileName));
        // 6.使用工具类读取文件到字节数组中
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        // 7.通过 Socket 的输出流将字节数组写入管道之中, 发送给客户端
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        bos.write(bytes);
        socket.shutdownOutput(); // 设置写入数据的结束标记
        // 8.关闭资源
        bos.close();
        bis.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}

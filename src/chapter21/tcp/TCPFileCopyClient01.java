package chapter21.tcp;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/14 22:50
 * <p>
 * 1.编写一个服务端，一个客户端
 * 2.服务端在 8888 端口进行监听
 * 3.客户端连接到服务端，发送一张图片 d:\test\pic.jpg
 * 4.服务端接收到客户端发送的图片，保存到 src 目录下，并向客户端发送 "已收到图片" 再退出
 * 5.客户端接收到服务端发送的 "已收到图片" 退出
 * 6.该程序要求使用 StreamUtils.java
 **/
public class TCPFileCopyClient01 {
    private static final String FILE_PATH = "d:\\test\\pic.jpg";

    public static void main(String[] args) throws IOException {
        /**
         * 1.连接服务端 (ip, 端口）
         * 解读: 连接本机的 8888 端口如果连接成功，返回 Socket 对象
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        // 2.将二进制图片文件从硬盘读入字节数组中
        FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
        System.out.println("client 端开始从读取文件到内存中...");
        // 调用工具类，可以将输入流转换成 byte[]
        byte[] fileBytes = StreamUtils.streamToByteArray(fileInputStream);

        // 3.通过 Socket 的输出流将字节数组写入管道之中, 发送给服务端
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        System.out.println("client 端开始将内存中数据打入到管道到 server 端...");
        bufferedOutputStream.write(fileBytes); // 将文件对应的字节数组的内容，写入到数据通道
        bufferedOutputStream.flush();
        socket.shutdownOutput(); // 设置写入数据的结束标记
        System.out.println("client 端开始将内存中数据打入到管道完毕!");

        // 4.接收服务端发来的信息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String readLine = "";
        System.out.println("client 端等待读取 server 端发送的消息");
        while ((readLine = bufferedReader.readLine()) != null && readLine.length() > 0) {
            System.out.println(readLine);
        }
        System.out.println("client 端读取完毕!");

        // 5.关闭资源
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        socket.close();
        System.out.println("client 端关闭流和 socket，退出...");
    }
}

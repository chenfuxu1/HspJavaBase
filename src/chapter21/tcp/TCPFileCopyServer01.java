package chapter21.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/14 22:49
 * <p>
 * 1.编写一个服务端，一个客户端
 * 2.服务端在 8888 端口进行监听
 * 3.客户端连接到服务端，发送一张图片 d:\test\pic.jpg
 * 4.服务端接收到客户端发送的图片，保存到 src 目录下，并向客户端发送 "已收到图片" 再退出
 * 5.客户端接收到服务端发送的 "已收到图片" 退出
 * 6.该程序要求使用 StreamUtils.java
 **/
public class TCPFileCopyServer01 {
    private static final String FILE_PATH = "src\\pic.jpg";

    public static void main(String[] args) throws IOException {
        // 1.服务端本机监听 8888 端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("server 端等待 client 连接");

        // 2.等待连接
        Socket socket = serverSocket.accept();

        // 3.读取管道中客户端发来的数据
        InputStream inputStream = socket.getInputStream();

        // 4.将该数据通过工具类将输入流转换成 byte[]
        byte[] fileBytes = StreamUtils.streamToByteArray(inputStream);
        System.out.println("server 端读取了 client 发送的图片信息");

        // 5.将字节数组写入磁盘中
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(FILE_PATH));
        bufferedOutputStream.write(fileBytes); // 将文件对应的字节数组的内容，写入到磁盘
        bufferedOutputStream.flush();
        System.out.println("server 端将 client 发送的图片信息写入到 src 目录下");

        // 6.向客户端回复 "收到图片" 通过 socket 获取到输出流(字符)
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        System.out.println("server 端发送消息到 client 端");
        bufferedWriter.write("server 端已经收到来自 client 发送的图片!");
        bufferedWriter.flush(); // 把内容刷新到数据通道
        socket.shutdownOutput(); // 设置写入数据的结束标记
        System.out.println("server 端发送消息到 client 端完毕");

        // 7.关闭资源
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        if (bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        socket.close();
        serverSocket.close();
        System.out.println("server 端关闭流和 socket，退出...");
    }
}

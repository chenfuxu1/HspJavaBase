package chapter21.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/14 20:56
 * <p>
 * 客户端
 **/
public class SocketTCPClient02 {
    public static void main(String[] args) throws IOException {
        /**
         * 1.连接服务端 (ip, 端口）
         * 解读: 连接本机的 9999 端口, 如果连接成功, 返回 Socket 对象
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        /**
         * 2.连接上后，生成 Socket，通过 socket.getOutputStream()
         * 得到和 socket 对象关联的输出流对象
         */
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过输出流，写入数据到数据通道
        outputStream.write("hello, server I'm client!".getBytes());
        // 4.设置结束标志
        socket.shutdownOutput();
        System.out.println("client 端发送数据完毕");
        System.out.println("client 端等待接收数据...");
        // 5.读取来自服务器端的信息
        InputStream inputStream = socket.getInputStream();
        byte[] buff = new byte[1024];
        int readLen = -1;
        while ((readLen = inputStream.read(buff)) != -1) {
            System.out.println(new String(buff, 0, readLen));
        }
        System.out.println("client 端接收数据完毕!");
        // 6.关闭流对象和 socket，必须关闭
        if (inputStream != null) {
            inputStream.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
        socket.close();
        System.out.println("client 端关闭流和 socket");
    }
}

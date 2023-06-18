package chapter21.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/14 20:56
 * <p>
 * 客户端, 使用字符流
 **/
public class SocketTCPClient03 {
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
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        // 3.通过输出流，写入数据到数据通道, 使用字符流
        bufferedWriter.write("hello, server I'm client!");
        bufferedWriter.newLine();
        bufferedWriter.flush(); // 此处必须要手动刷新，不然没法写入
        // 4.设置结束标志
        socket.shutdownOutput();
        System.out.println("client 端发送数据完毕");
        System.out.println("client 端等待接收数据...");
        // 5.读取来自服务器端的信息
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readLine = "";
        /**
         * bufferedReader 在遇到 newLine 才会为空
         * 这样永远不会结束循环，可以将条件换为
         * while ((line = bufferedReader.readLine()) != null) && line.length() != 0)
         */
        while ((readLine = bufferedReader.readLine()) != null && readLine.length() != 0) {
            System.out.println(readLine);
        }
        System.out.println("client 端接收数据完毕!");
        // 6.关闭流对象和 socket，必须关闭
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        socket.close();
        System.out.println("client 端关闭流和 socket");
    }
}

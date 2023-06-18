package chapter21.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/14 20:56
 * <p>
 * 服务端, 使用字符流方式读写
 **/
public class SocketTCPServer03 {
    public static void main(String[] args) throws IOException {
        /**
         * 1.在本机的 9999 端口监听, 等待连接
         * 细节: 要求在本机没有其它服务在监听 9999
         * 细节: 这个 ServerSocket 可以通过 accept() 返回多个 Socket (多个客户端连接服务器的并发)
         */
        ServerSocket serverSocket = new ServerSocket(9999);
        /**
         * 2.当没有客户端连接 9999 端口时，程序会进行阻塞，等待连接
         * 如果有客户端连接，则返回 Socket 对象，程序继续
         */
        System.out.println("server 等待 client 连接...");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readLine = "";
        /**
         * 3.进行读取 client 发送来的数据
         * bufferedReader 在遇到 newLine 才会为空
         * 这样永远不会结束循环，可以将条件换为
         * while ((line = bufferedReader.readLine()) != null) && line.length() != 0)
         */
        while ((readLine = bufferedReader.readLine()) != null && readLine.length() != 0) {
            System.out.println(readLine);
        }
        // 4.进行发送数据 hello client, I'm server!
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello client, I'm server!");
        bufferedWriter.newLine();
        bufferedWriter.flush(); // 此处必须要手动刷新，不然没法写入
        // 5.设置写完后的结束标志
        socket.shutdownOutput();
        System.out.println("server 端输出完毕");
        // 6.关闭流
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        socket.close();
        serverSocket.close();
        System.out.println("server 端关闭流和 socket");
    }
}

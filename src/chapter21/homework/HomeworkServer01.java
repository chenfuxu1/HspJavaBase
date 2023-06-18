package chapter21.homework;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1.使用字符流的方式，编写一个客户端程序和服务器端程序
 * 2.客户端发送 "name"，服务器端接收到，返回 "我是nova"，nova 是你自己的名字
 * 3.客户端发送 "hobby", 服务器端接收到后，返回 "编写java程序"
 * 4.不是这两个问题，回复 "你说啥呢"
 * <p>
 * 存在问题：目前，我们只能问一次，就退出了，怎么可以问多次？->while->聊天
 */
public class HomeworkServer01 {
    public static void main(String[] args) throws IOException {
        /**
         * 1.在本机的 9990 端口监听, 等待连接
         * 细节: 要求在本机没有其它服务在监听 9999
         * 细节：这个 ServerSocket 可以通过 accept() 返回多个 Socket (多个客户端连接服务器的并发)
         */
        ServerSocket serverSocket = new ServerSocket(9990);
        System.out.println("服务端 9999 端口监听，等待连接");
        /**
         * 2.当没有客户端连接 9999 端口时，程序会进行阻塞，等待连接
         * 如果有客户端连接，则返回 Socket 对象，程序继续
         */
        Socket socket = serverSocket.accept();
        System.out.println("服务端 socket = " + socket.getClass());
        // 3.进行读取, 使用字符流
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String answer = bufferedReader.readLine(); // 读取到客户端发来的信息
        // 4.根据客户端的信息进行回应
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        BufferedWriter bw = new BufferedWriter(outputStreamWriter);
        if ("name".equals(answer)) {
            bw.write("我是nova");
        } else if ("hobby".equals(answer)) {
            bw.write("编写java程序");
        } else {
            bw.write("你说啥呢");
        }
        bw.newLine();
        bw.flush();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出");
    }
}

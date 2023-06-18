package chapter21.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/13 23:55
 * <p>
 * 客户端
 **/
public class SocketTCPClient01 {
    public static void main(String[] args) throws IOException {
        /**
         * 1.连接服务端(ip, 端口）
         * 解读: 连接本机的 9999 端口如果连接成功，返回 Socket 对象
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("client socket = " + socket.getClass());
        /**
         * 2.连接上后，生成 Socket，通过 socket.getOutputStream()
         * 得到和 socket 对象关联的输出流对象
         */
        OutputStream outputStream = socket.getOutputStream();
        // 3.通过输出流，写入数据到数据通道
        outputStream.write("张三、李四、王五".getBytes());
        System.out.println("client 发送数据完毕");
        // 4.关闭流对象和 socket，必须关闭
        if (outputStream != null) {
            outputStream.close();
        }
        socket.close();
        System.out.println("client 关闭流对象和 socket");
    }
}

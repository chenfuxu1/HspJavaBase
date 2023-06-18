package chapter21.udp;


import java.io.IOException;
import java.net.*;

/**
 * 发送端 B ====> 也可以接收数据
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        // 1.创建 DatagramSocket 对象，准备在 9998 端口接收数据
        DatagramSocket socket = new DatagramSocket(9998);
        // 2.将需要发送的数据，封装到 DatagramPacket 对象
        byte[] data = "hello, 明天吃火锅".getBytes();
        // 说明: 封装的 DatagramPacket 对象 data 内容字节数组, data.length, 主机(IP), 端口
        DatagramPacket packet = new
                DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.5"), 9999);
        socket.send(packet);
        // 3.接收来自 A 端的消息
        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf, buf.length);
        /**
         * 调用接收方法, 将通过网络传输的 DatagramPacket 对象
         * 填充到 packet 对象
         * 当有数据包发送到本机的 9998 端口时，就会接收到数据
         * 如果没有数据包发送到本机的 9998 端口, 就会阻塞等待
         */
        socket.receive(packet);
        // 4.将接收的 packet1 进行拆包
        int length = packet.getLength();
        byte[] data1 = packet.getData();
        String s = new String(data1, 0, data1.length);
        System.out.println(s);
        // 5.关闭资源
        socket.close();
        System.out.println("B 端退出");
    }
}

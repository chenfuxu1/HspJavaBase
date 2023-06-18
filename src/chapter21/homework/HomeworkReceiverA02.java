package chapter21.homework;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 1.编写一个接收端 A，和一个发送端 B，使用 UDP 协议完成
 * 2.接收端在 8888 端口等待接收数据(receive)
 * 3.发送端向接收端发送数据 "四大名著是哪些"
 * 4.接收端接收到 发送端发送的问题后，返回 "四大名著是《红楼梦》《西游记》《水浒传》《三国演义》"
 * 否则返回 what?
 * 5.接收端和发送端程序退出
 */
public class HomeworkReceiverA02 {
    public static void main(String[] args) throws IOException {
        // 1.创建一个 DatagramSocket 对象，准备在 8888 接收数据
        DatagramSocket socket = new DatagramSocket(8888);
        /**
         * 2.构建一个 DatagramPacket 对象，准备接收数据
         * 一个数据包最大 64k
         */
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        /**
         * 3.调用接收方法, 将通过网络传输的 DatagramPacket 对象
         * 当有数据包发送到本机的 8888 端口时，就会接收到数据，没有数据时，就阻塞等待
         */
        System.out.println("接收端 A 等待接收数据");
        socket.receive(packet);
        // 4.把 packet 数据包进行拆包，并显示
        int length = packet.getLength();
        byte[] data = packet.getData();
        System.out.println(new String(data, 0, length));
        // 5.向 B 端发送回复数据
        byte[] answer = "四大名著是《红楼梦》《西游记》《水浒传》《三国演义》".getBytes();
        packet = new
                DatagramPacket(answer, answer.length, InetAddress.getByName("192.168.1.5"), 8889);
        socket.send(packet);
        // 6.关闭资源
        socket.close();
        System.out.println("接收端 A 端退出");
    }
}

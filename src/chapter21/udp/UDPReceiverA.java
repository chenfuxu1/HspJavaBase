package chapter21.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


/**
 * UDP 接收端 A
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        // 1.创建一个 DatagramSocket 对象，准备在 9999 接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        /**
         * 2.构建一个 DatagramPacket 对象，准备接收数据
         * 一个数据包最大 64k
         */
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        /**
         * 3.调用接收方法, 将通过网络传输的 DatagramPacket 对象
         * 当有数据包发送到本机的9999端口时，就会接收到数据，没有数据时，就阻塞等待
         */
        System.out.println("接收端 A 等待接收数据");
        socket.receive(packet);
        // 4.把 packet 数据包进行拆包，并显示
        int len = packet.getLength();
        byte[] bytes = packet.getData();
        String s = new String(bytes, 0, len);
        System.out.println(s);
        // 5.向 B 端回复收到的消息
        byte[] bytes1 = "好的，一定赴约~".getBytes();
        packet = new
                DatagramPacket(bytes1, bytes1.length, InetAddress.getByName("192.168.1.5"), 9998);
        socket.send(packet);
        // 6.关闭资源
        socket.close();
        System.out.println("A 端退出");
    }
}

package chapter21.homework;


import java.io.IOException;
import java.net.*;

/**
 * 1.编写一个接收端 A，和一个发送端 B，使用 UDP 协议完成
 * 2.接收端在 8888 端口等待接收数据(receive)
 * 3.发送端向接收端发送数据 "四大名著是哪些"
 * 4.接收端接收到 发送端发送的问题后，返回 "四大名著是《红楼梦》《西游记》《水浒传》《三国演义》"
 * 否则返回 what?
 * 5.接收端和发送端程序退出
 */
public class HomeworkSenderB02 {
	public static void main(String[] args) throws IOException {
		// 1.创建DatagramSocket对象，准备在 8889 端口接收数据
		DatagramSocket socket = new DatagramSocket(8889);
		// 2.将需要发送的数据，封装到 DatagramPacket 对象
		byte[] data = "四大名著是哪些".getBytes();
		//说明: 封装的 DatagramPacket 对象 data 内容字节数组 , data.length , 主机(IP) , 端口
		DatagramPacket packet = new
			DatagramPacket(data, data.length, InetAddress.getByName("192.168.1.5"), 8888);
		socket.send(packet);
		/**
		 * 3.对接收端 A 发来的消息进行读取
		 * 构建一个 DatagramPacket 对象，准备接收数据
		 * 一个数据包最大 64k
		 */
		byte[] buf = new byte[1024];
		packet = new DatagramPacket(buf, buf.length);
		/**
		 * 4.调用接收方法, 将通过网络传输的 DatagramPacket 对象
		 * 当有数据包发送到本机的 8889 端口时，就会接收到数据，没有数据时，就阻塞等待
		 */
		System.out.println("发送端 B 等待接收数据");
		socket.receive(packet);
		int length = packet.getLength();
		byte[] answer = packet.getData();
		System.out.println(new String(answer, 0, length));
		//5.关闭资源
		socket.close();
		System.out.println("发送 B 端退出");
	}
}

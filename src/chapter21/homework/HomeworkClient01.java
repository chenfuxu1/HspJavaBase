package chapter21.homework;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 1.使用字符流的方式，编写一个客户端程序和服务器端程序
 * 2.客户端发送 name，服务器端接收到，返回 "我是nova"，nova 是你自己的名字
 * 3.客户端发送 "hobby", 服务器端接收到后，返回 "编写java程序"
 * 4.不是这两个问题，回复 "你说啥呢"
 *
 * 存在问题：目前，我们只能问一次，就退出了，怎么可以问多次？->while->聊天
 */
public class HomeworkClient01 {
	public static void main(String[] args) throws IOException {
		/**
		 * 1.连接服务端(ip, 端口）
		 * 解读: 连接本机的 9990 端口, 如果连接成功，返回 Socket 对象
		 */
		Socket socket = new Socket(InetAddress.getLocalHost(), 9990);
		System.out.println("客户端 socket 返回 = " + socket.getClass());
		/**
		 * 2.连接上后，生成 Socket，通过 socket.getOutputStream()
		 * 得到和 socket 对象关联的输出流对象
		 */
		OutputStream outputStream = socket.getOutputStream();
		// 3.通过键盘获取输入信息
		Scanner scanner = new Scanner(System.in);
		System.out.print("输入问题：");
		String question = scanner.next();
		// 4.通过输出流，写入数据到数据通道, 用转换流转为字符流
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		bufferedWriter.write(question);
		// 5.设置结束标志
		bufferedWriter.newLine(); // 插入一个换行符，表示写入的内容结束, 注意，要求对方使用 readLine()
		bufferedWriter.flush(); // 如果使用的字符流，需要手动刷新，否则数据不会写入数据通道
		// 6.对服务器端发来的信息进行读取
		InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(inputStreamReader);
		String s = br.readLine();
		System.out.println(s);
		// 7.关闭流对象和 socket，必须关闭
		br.close();
		bufferedWriter.close();
		socket.close();
		System.out.println("客户端退出");
	}
}

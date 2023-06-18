package chapter21.homework;


import chapter21.tcp.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1.编写客户端和服务端程序
 * 2.客户端可以输入一个音乐文件名，比如高山流水，服务端收到音乐名后
 * 可以给客户端返回这个音乐文件，如果没有，返回默认的音乐即可
 * 3.客户端收到文件后，保存到本地 d:\\test\\
 * 4.可以使用 StreamUtils.java
 */
public class HomeworkClient03 {
    public static void main(String[] args) throws Exception {
        /**
         * 1. 连接服务端(ip , 端口）
         * 解读: 连接本机的 9999 端口, 如果连接成功，返回 Socket 对象
         */
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket 返回 = " + socket.getClass());
        // 2.开始从键盘输入要下载文件名
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要下载文件名：");
        String fileName = sc.next();
        // 3.将文件名发送给服务器
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(fileName.getBytes());
        socket.shutdownOutput(); // 设置写入数据的结束标记
        // 4.创建输入流，接收服务器发来在管道中的数据
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        // 5.直接使用工具类将输入流转为字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        // 6.创建字节输出流，将数据写入 d 盘
        String desPath = "d:\\test\\" + fileName + ".mp3"; // 拼接文件名
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desPath));
        bos.write(bytes);
        // 7.关闭流
        bos.close();
        bis.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}

package chapter22.qqchat.qqclient.service;

import chapter22.qqchat.common.StreamUtils;
import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/19 23:13
 * <p>
 * 客户端和服务端建立连接的类
 **/
public class ClientConnectServerThread extends Thread {
    private Socket mSocket;

    public ClientConnectServerThread(Socket socket) {
        this.mSocket = socket;
    }

    public Socket getSocket() {
        return mSocket;
    }

    public void setSocket(Socket socket) {
        mSocket = socket;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("客户端线程，等待读取从服务端发送的消息");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(mSocket.getInputStream());
                // 如果服务端没有发送消息，那么一直阻塞在此
                Message message = (Message) objectInputStream.readObject();
                // 根据 message 的类型进行相应的业务处理
                if (MessageType.MESSAGE_RETURN_ONLINE_FRIEND.equals(message.getMessageType())) {
                    // 取出在线用户列表
                    String[] users = message.getContent().split(",");
                    System.out.println("\n===========当前用户列表==============");
                    for (int i = 0; i < users.length; i++) {
                        System.out.println("用户：" + users[i]);
                    }
                } else if (MessageType.MESSAGE_COMMON.equals(message.getMessageType())) {
                    // 普通的聊天消息，直接展示即可
                    System.out.println("\n" + message.getSender() + " 对您说：" + message.getContent());
                } else if (MessageType.MESSAGE_TO_ALL.equals(message.getMessageType())) {
                    // 对所有人发送的消息，直接展示即可
                    System.out.println("\n" + message.getSender() + " 对大家说：" + message.getContent());
                } else if (MessageType.MESSAGE_SEND_FILE.equals(message.getMessageType())) {
                    // 其他用户发送来的文件
                    StreamUtils.storeFileToDisk(message.getFileBytes(), message.getFileDest());
                    System.out.println("\n" + message.getSender() + " 给您发送文件，从 " + message.getFileSrc() + " 到您的 " + message.getFileDest() + " 路径下成功发送完成...");
                } else if (MessageType.MESSAGE_POST_NEWS.equals(message.getMessageType())) {
                    // 服务端推送的消息，直接展示即可
                    System.out.println("\n" + message.getSender() + " 对您推送一条消息：" + message.getContent());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}

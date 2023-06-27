package chapter22.qqchat.qqserver.service;

import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;
import chapter22.qqchat.qqserver.QQServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/20 0:05
 * <p>
 * 该类用户服务端和某个客户端保持通信
 **/
public class ServerConnectClientThread extends Thread {
    private Socket mSocket;
    private String mUserId; // 连接服务端的用户 id

    public ServerConnectClientThread(Socket socket, String userId) {
        mSocket = socket;
        mUserId = userId;
    }

    public Socket getSocket() {
        return mSocket;
    }

    public void setSocket(Socket socket) {
        mSocket = socket;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

    @Override
    public void run() { // 接收 / 发送消息
        while (true) {
            System.out.println("服务端和客户端 " + mUserId + " 保持通信，读取数据...");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(mSocket.getInputStream());
                Message message = (Message) objectInputStream.readObject();

                // 根据 message 类型做相应的业务处理
                if (MessageType.MESSAGE_GET_ONLINE_FRIEND.equals(message.getMessageType())) {
                    // 客户端要在线用户列表数据
                    String onlineUser = ManageServerConnectClientThread.getOnlineUser();
                    Message returnMessage = new Message();
                    returnMessage.setContent(onlineUser);
                    returnMessage.setMessageType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
                    returnMessage.setGetter(message.getSender());
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(mSocket.getOutputStream());
                    // 服务端返回客户端请求的在线用户列表信息
                    System.out.println("服务端返回客户端: " + message.getSender() + " 请求的在线用户列表信息...");
                    objectOutputStream.writeObject(returnMessage);
                } else if (MessageType.MESSAGE_CLIENT_EXIT.equals(message.getMessageType())) {
                    // 客户端退出
                    System.out.println(message.getSender() + " 退出...");
                    ManageServerConnectClientThread.removeServerConnectClientThread(message.getSender());
                    mSocket.close();
                    // 退出循环
                    break;
                } else if (MessageType.MESSAGE_COMMON.equals(message.getMessageType())) {
                    ServerConnectClientThread serverConnectClientThread = ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter());
                    if (serverConnectClientThread == null) {
                        // 表明用户是离线的，将消息存到集合中，等用户上线时，再遍历取出进行发送
                        ArrayList<Message> messages;
                        if (!QQServer.sOfflineMessage.containsKey(message.getGetter())) {
                            messages = new ArrayList<>();
                        } else {
                            messages = QQServer.sOfflineMessage.get(message.getGetter());
                        }
                        messages.add(message);
                        QQServer.sOfflineMessage.put(message.getGetter(), messages);
                        System.out.println("离线消息缓存");
                    } else {
                        // 发送普通消息，服务器只起到转发的作用
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                        objectOutputStream.writeObject(message);
                        System.out.println("服务端转发消息：" + message.getSender() + " ---> " + message.getGetter());
                    }
                } else if (MessageType.MESSAGE_TO_ALL.equals(message.getMessageType())) {
                    // 发送消息给所有人，服务器只起到转发的作用
                    ConcurrentMap<String, ServerConnectClientThread> connectClientThreadHashMap = ManageServerConnectClientThread.getConnectClientThreadHashMap();
                    for (String key : connectClientThreadHashMap.keySet()) {
                        if (key.equals(message.getSender())) {
                            // 自己除外，不用转发
                            continue;
                        }
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(key).getSocket().getOutputStream());
                        objectOutputStream.writeObject(message);
                        System.out.println("服务端转发消息：" + message.getSender() + " ---> 对大家说");
                    }
                } else if (MessageType.MESSAGE_SEND_FILE.equals(message.getMessageType())) {
                    // 服务端只负责转发文件
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                    System.out.println("服务端转发文件：" + message.getSender() + " ---> " + message.getGetter() + " 路径从 " + message.getFileSrc() + " ---> " + message.getFileDest());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}

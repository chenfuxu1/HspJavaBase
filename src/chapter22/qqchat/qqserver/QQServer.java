package chapter22.qqchat.qqserver;

import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;
import chapter22.qqchat.common.user.User;
import chapter22.qqchat.qqserver.service.ManageServerConnectClientThread;
import chapter22.qqchat.qqserver.service.PostNewsToAllClientService;
import chapter22.qqchat.qqserver.service.ServerConnectClientThread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/19 23:53
 *
 * QQ 服务端
 **/
public class QQServer {
    private ServerSocket mServerSocket = null;
    // 存储用户，表明这些用户是合法的
    private static ConcurrentMap<String, User> sValidUsers = new ConcurrentHashMap<>();
    // 存储离线的消息
    public static ConcurrentHashMap<String, ArrayList<Message>> sOfflineMessage = new ConcurrentHashMap<>();

    static {
        sValidUsers.put("天角蚁", new User("天角蚁", "12345"));
        sValidUsers.put("石昊", new User("石昊", "12345"));
        sValidUsers.put("柳神", new User("柳神", "12345"));
        sValidUsers.put("火灵儿", new User("火灵儿", "12345"));
        sValidUsers.put("云曦", new User("云曦", "12345"));
        sValidUsers.put("清漪", new User("清漪", "12345"));
    }

    public QQServer() {
        System.out.println("服务端在 8888 端口监听");
        try {
            mServerSocket = new ServerSocket(8888);
            new Thread(new PostNewsToAllClientService()).start();
            while (true) { // 当和某个客户端连接后，会继续监听，因此在 while 循环中
                Socket socket = mServerSocket.accept();
                // 1.得到 socket 的对象输入流
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                // 2.读取客户端发送的 user 对象
                User user = (User) objectInputStream.readObject();
                // 3.获取输出流
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                // 4.开始验证
                if (user != null) {
                    if (checkUser(user.getUserId(), user.getPasswd())) {
                        // 验证通过
                        System.out.println("验证成功");
                        message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCEED);
                        // 将 message 回复到客户端
                        objectOutputStream.writeObject(message);
                        // 创建线程与客户端保持通信
                        ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, user.getUserId());
                        serverConnectClientThread.start();
                        // 将线程放入集合中进行管理
                        ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(), serverConnectClientThread);
                        // 判断是否集合中是否存在发给该用户的离线消息，如果有就进行发送
                        sendOffLineMessage(user.getUserId(), serverConnectClientThread);
                    } else {
                        // 验证失败
                        System.out.println("ID: " + user.getUserId() + " 密码: " + user.getPasswd() + " 验证失败");
                        message.setMessageType(MessageType.MESSAGE_LOGIN_FAILED);
                        objectOutputStream.writeObject(message);
                        socket.close();
                    }
                } else {
                    // 验证失败
                    System.out.println("验证失败");
                    message.setMessageType(MessageType.MESSAGE_LOGIN_FAILED);
                    objectOutputStream.writeObject(message);
                    socket.close();
                }

            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (mServerSocket != null) {
                try {
                    mServerSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 验证用户是否有效
    private boolean checkUser(String userId, String passwd) {
        if (passwd == null) {
            return false;
        }
        User user = sValidUsers.get(userId);
        if (user == null) {
            // 用户不存在
            return false;
        }
        if (!passwd.equals(user.getPasswd())) {
            // 密码不正确
            return false;
        }
        return true;
    }

    // 发送离线消息
    private void sendOffLineMessage(String userId, ServerConnectClientThread serverConnectClientThread) {
        if (!sOfflineMessage.containsKey(userId)) {
            // 无离线消息，直接返回
            return;
        }
        ArrayList<Message> messages = sOfflineMessage.get(userId);
        if (messages == null || messages.size() == 0) {
            // 消息个数为 0，直接返回
            return;
        }
        try {
            System.out.println("开始给 " + userId + " 发送离线消息");
            for (int i = 0; i < messages.size(); i++) {
                // 遍历发送消息
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                objectOutputStream.writeObject(messages.get(i));
            }
            // 清空集合
            messages.clear();
            sOfflineMessage.remove(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

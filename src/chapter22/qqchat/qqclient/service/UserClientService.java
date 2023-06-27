package chapter22.qqchat.qqclient.service;

import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;
import chapter22.qqchat.common.user.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/19 22:58
 * <p>
 * 该类完成用户登录验证和用户注册等功能
 **/
public class UserClientService {
    private User mUser = new User();

    /**
     * 根据 userId 和 passwd 到服务端验证该用户是否合法
     *
     * @param userId
     * @param passwd
     * @return
     */
    public boolean checkUser(String userId, String passwd) {
        boolean loginSuccess = false;
        mUser.setUserId(userId);
        mUser.setPasswd(passwd);
        // 1.连接服务端，发送 user 对象
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(mUser); // 发送 user 对象

            // 2.等待接收服务端返回的 message 消息对象
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) objectInputStream.readObject();
            if (message != null) {
                if (MessageType.MESSAGE_LOGIN_SUCCEED.equals(message.getMessageType())) {
                    /**
                     * 登录成功
                     * 创建一个和服务端保持通信的线程
                     * 创建一个类 ClientConnectServerThread
                     */
                    ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                    // 3.启动线程
                    clientConnectServerThread.start();
                    // 4.为了后续扩展，将线程放入到集合中管理
                    ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);
                    loginSuccess = true;
                } else if (MessageType.MESSAGE_LOGIN_FAILED.equals(message.getMessageType())) {
                    // 登录失败, 不能启动线程，关闭 socket
                    loginSuccess = false;
                    socket.close();
                }
            } else {
                // 登录失败, 不能启动线程，关闭 socket
                loginSuccess = false;
                socket.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
        return loginSuccess;
    }

    /**
     * 向服务端请求在线用户列表
     */
    public void requestOnlineFriendList() {
        // 发送一个 Message，类型为 MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(mUser.getUserId());
        try {
            // 根据 user 对象的当前线程，拿到对应的 socket，拿到对应的输出流
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(mUser.getUserId()).getSocket().getOutputStream());
            System.out.println("客户端：" + mUser.getUserId() + " 请求在线用户列表信息...");
            objectOutputStream.writeObject(message); // 发送 message 对象，向服务端请求在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 客户端退出，给服务端发送一个消息
    public void logout() {
        Message message = new Message();
        message.setMessageType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(mUser.getUserId()); // 一定要指明是哪个用户退出
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(mUser.getUserId()).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
            System.out.println(mUser.getUserId() + " 退出系统...");
            System.exit(0); // 结束进程
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

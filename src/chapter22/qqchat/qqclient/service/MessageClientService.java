package chapter22.qqchat.qqclient.service;

import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/25 23:39
 * <p>
 * 该类用于提供和服务端发送消息的服务
 **/
public class MessageClientService {
    /**
     * 发送消息
     *
     * @param setterId 消息的发送者
     * @param getterId 消息的接受者
     * @param content  消息内容
     */
    public void sendMessage(String setterId, String getterId, String content) {
        Message message = new Message();
        message.setSender(setterId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setMessageType(MessageType.MESSAGE_COMMON);
        message.setSendTime(new Date().toString()); // 发送时间
        System.out.println(setterId + " 发送消息：" + content + " 给 " + getterId);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(setterId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送消息给所有人
     *
     * @param setterId 消息的发送者
     * @param content  消息内容
     */
    public void sendMessageToAll(String setterId, String content) {
        Message message = new Message();
        message.setSender(setterId);
        message.setContent(content);
        message.setMessageType(MessageType.MESSAGE_TO_ALL);
        message.setSendTime(new Date().toString()); // 发送时间
        System.out.println(setterId + " 发送消息：" + content + " 给大家");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(setterId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

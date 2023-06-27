package chapter22.qqchat.qqclient.service;

import chapter22.qqchat.common.StreamUtils;
import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/26 23:07
 * <p>
 * 该类完成文件的传输
 **/
public class FileClientService {
    /**
     * 发送单个文件给某个用户
     *
     * @param src      文件源路径
     * @param dest     文件目标路径
     * @param senderId 发送者 id
     * @param getterId 接收者 id
     */
    public void sendFile(String src, String dest, String senderId, String getterId) {
        // 1.构建 message
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setMessageType(MessageType.MESSAGE_SEND_FILE);
        message.setFileSrc(src);
        message.setFileDest(dest);
        // 2.从磁盘中读取文件到内存中
        try {
            byte[] byteArray = StreamUtils.streamToByteArray(new FileInputStream(src));
            message.setFileBytes(byteArray);
            // 3.开始发送 message 到服务端
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            objectOutputStream.writeObject(message);
            System.out.println("\n您给 " + getterId + " 发送文件，从 " + src + " 到对方 " + dest + " 路径下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

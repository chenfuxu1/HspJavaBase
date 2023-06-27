package chapter22.qqchat.qqserver.service;

import chapter22.qqchat.common.Utility;
import chapter22.qqchat.common.message.Message;
import chapter22.qqchat.common.message.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/26 23:55
 * <p>
 * 服务端推送新闻到所有的客户端
 **/
public class PostNewsToAllClientService implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("请输入要推送给客户端的消息(输入0退出当前推送)：");
            String news = Utility.readString(100);
            if ("0".equals(news)) {
                break;
            }
            // 构建消息，进行群发
            Message message = new Message();
            message.setContent(news);
            message.setSender("服务器");
            message.setSendTime(new Date().toString());
            message.setMessageType(MessageType.MESSAGE_POST_NEWS);
            System.out.println("服务器发送消息给所有用户：" + news);
            // 遍历所有的线程进行发送
            for (String key : ManageServerConnectClientThread.getConnectClientThreadHashMap().keySet()) {
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(ManageServerConnectClientThread.getServerConnectClientThread(key).getSocket().getOutputStream());
                    objectOutputStream.writeObject(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

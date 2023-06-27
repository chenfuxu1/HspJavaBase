package chapter22.qqchat.qqserver.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/19 23:30
 * <p>
 * 该类用于管理服务端连接到客户端线程的类
 **/
public class ManageServerConnectClientThread {
    // key: 用户 id, value: 线程
    private static ConcurrentMap<String, ServerConnectClientThread> sConnectClientThreadHashMap = new ConcurrentHashMap<>();

    // 加入线程到线程集合
    public static void addServerConnectClientThread(String userId, ServerConnectClientThread thread) {
        sConnectClientThreadHashMap.put(userId, thread);
    }

    // 根据 userId 获取当前线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId) {
        return sConnectClientThreadHashMap.get(userId);
    }

    public static void removeServerConnectClientThread(String userId) {
        sConnectClientThreadHashMap.remove(userId);
    }

    // 返回在线用户里列表
    public static String getOnlineUser() {
        StringBuffer userList = new StringBuffer();
        for (String key : sConnectClientThreadHashMap.keySet()) {
            userList.append(key);
            userList.append(",");
        }
        userList.deleteCharAt(userList.length() - 1);
        return userList.toString();
    }

    public static ConcurrentMap<String, ServerConnectClientThread> getConnectClientThreadHashMap() {
        return sConnectClientThreadHashMap;
    }
}

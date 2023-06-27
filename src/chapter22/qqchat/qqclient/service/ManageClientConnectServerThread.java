package chapter22.qqchat.qqclient.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/19 23:30
 *
 * 该类用于管理客户端连接到服务端线程的类
 **/
public class ManageClientConnectServerThread {
    // key: 用户 id, value: 线程
    private static ConcurrentMap<String, ClientConnectServerThread> sConnectServerThreadHashMap = new ConcurrentHashMap<>();

    // 加入线程到线程集合
    public static void addClientConnectServerThread(String userId, ClientConnectServerThread thread) {
        sConnectServerThreadHashMap.put(userId, thread);
    }

    // 根据 userId 获取当前线程
    public static ClientConnectServerThread getClientConnectServerThread(String userId) {
        return sConnectServerThreadHashMap.get(userId);
    }
}

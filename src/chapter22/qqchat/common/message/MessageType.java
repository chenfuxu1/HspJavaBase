package chapter22.qqchat.common.message;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/18 23:08
 **/
public interface MessageType {
    public static final String MESSAGE_LOGIN_SUCCEED = "1"; // 登录成功
    public static final String MESSAGE_LOGIN_FAILED = "2"; // 登录失败
    public static final String MESSAGE_COMMON = "3"; // 普通消息
    public static final String MESSAGE_GET_ONLINE_FRIEND = "4"; // 请求返回在线用户列表
    public static final String MESSAGE_RETURN_ONLINE_FRIEND = "5"; // 返回在线用户列表
    public static final String MESSAGE_CLIENT_EXIT = "6"; // 客户端请求退出
    public static final String MESSAGE_TO_ALL = "7"; // 发送消息给所有人
    public static final String MESSAGE_SEND_FILE = "8"; // 发送文件
    public static final String MESSAGE_POST_NEWS = "9"; // 服务端推送的消息
    public static final String MESSAGE_OFF_LINE = "10"; // 离线消息
}

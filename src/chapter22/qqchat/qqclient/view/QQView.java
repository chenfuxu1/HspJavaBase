package chapter22.qqchat.qqclient.view;

import chapter22.qqchat.common.Utility;
import chapter22.qqchat.qqclient.service.FileClientService;
import chapter22.qqchat.qqclient.service.MessageClientService;
import chapter22.qqchat.qqclient.service.UserClientService;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/18 23:40
 *
 * 聊天显示界面
 **/
public class QQView {
    private boolean mIsShowView = true; // 控制是否显示界面
    private String mUserInputStr = ""; // 接收用户的输入内容
    // 用于登录服务或者注册用户
    private UserClientService mUserClientService = new UserClientService();
    // 用于消息的发送
    private MessageClientService mMessageClientService = new MessageClientService();
    // 用于文件的发送
    private FileClientService mFileClientService = new FileClientService();

    public static void main(String[] args) {
        new QQView().showMenu();
        System.out.println("客户端退出系统");
    }

    /**
     * 显示主菜单
     */
    private void showMenu() {
        while (mIsShowView) {
            System.out.println("====================欢迎登录 QQ 系统====================");
            System.out.println("\t\t\t\t\t 1 登录系统");
            System.out.println("\t\t\t\t\t 9 退出系统");
            System.out.print("请输入你的选择：");
            mUserInputStr = Utility.readString(1);
            switch (mUserInputStr) {
                case "1":
                    System.out.println("登录系统");
                    System.out.print("请输入用户名：");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码：");
                    String passwd = Utility.readString(50);
                    if (mUserClientService.checkUser(userId, passwd)) { // 验证是否登录成功
                        System.out.println("=====================欢迎 (用户 " + userId + ")=====================");
                        // 进入二级菜单
                        while (mIsShowView) {
                            System.out.println("=============欢迎 (" + userId + ") 进入 QQ 系统二级界面=============");
                            System.out.println("\t\t\t\t\t 1 显示在线用户列表");
                            System.out.println("\t\t\t\t\t 2 群发消息");
                            System.out.println("\t\t\t\t\t 3 私聊消息");
                            System.out.println("\t\t\t\t\t 4 发送文件");
                            System.out.println("\t\t\t\t\t 9 退出系统");
                            System.out.print("请输入你的选择：");
                            mUserInputStr = Utility.readString(1);
                            switch (mUserInputStr) {
                                case "1":
                                    System.out.println("显示在线用户列表");
                                    mUserClientService.requestOnlineFriendList();
                                    break;
                                case "2":
                                    System.out.print("请输入发送的内容：");
                                    String contentToAll = Utility.readString(100);
                                    // 将消息发送给服务端
                                    mMessageClientService.sendMessageToAll(userId, contentToAll);
                                    break;
                                case "3":
                                    System.out.println("私聊消息");
                                    System.out.print("请输入想聊天的用户号(在线)：");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入发送的内容：");
                                    String content = Utility.readString(100);
                                    // 将消息发送给服务端
                                    mMessageClientService.sendMessage(userId, getterId, content);
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    System.out.print("请输入想发送文件的用户号(在线)：");
                                    String fileGetterId = Utility.readString(50);
                                    System.out.print("请输入想文件源路径：");
                                    String fileSrc = Utility.readString(50);
                                    System.out.print("请输入想文件目标路径：");
                                    String fileDest = Utility.readString(50);
                                    mFileClientService.sendFile(fileSrc, fileDest, userId, fileGetterId);
                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    // 客户端退出
                                    mUserClientService.logout();
                                    mIsShowView = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("=============登录失败!=============");
                    }
                    break;
                case "9":
                    System.out.println("退出系统");
                    mIsShowView = false;
                    break;
                default:
                    System.out.println("输入有误，重新输入！");
                    break;
            }
        }
    }
}

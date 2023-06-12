package chapter20.tankgame3_4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.增加播放音乐
 * 2.修改记录文件路径为 src\myRecord.txt
 * 3.健壮性处理，如果用户选择是继续上局游戏，但记录文件不存在
 * 这时强制设置默认初始化
 *
 * 思路：
 * 1.增加 AePlayWave 类用来播放音乐
 **/
public class TankGame3_4 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame3_4();
    }

    public TankGame3_4() {
        System.out.print("1: 开启新游戏 2：继续上局游戏 请输入：");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        while (true) {
            if ("1".equals(choose) || "2".equals(choose)) {
                break;
            }
            System.out.println("输出有误，请重新输入！");
            System.out.print("1: 开启新游戏 2：继续上局游戏 请输入：");
            choose = scanner.next();
        }
        mDrawPanel = new DrawPanel(choose);
        this.add(mDrawPanel);
        // 设置窗口的大小
        this.setSize(Constants.WHOLE_GAME_WIDTH + 310, Constants.WHOLE_GAME_HEIGHT);
        // 设置可以显示
        this.setVisible(true);
        // 当点击窗口的小 ×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mDrawPanel); // 窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        // 启动画板绘制的线程
        new Thread(mDrawPanel).start();
        // 对关闭窗口的 x 号进行监听
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.getInstance().writeRecordToFile();
            }
        });
    }
}

package chapter20.tankgame3_1;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.记录玩家击毁敌方坦克的成绩
 *
 * 思路：
 * 1.绘制出玩家成绩的显示区域
 * 2.增加 Recorder 类，用来记录玩家的成绩
 * 3.Recorder 类中提供属性 mDeadTankNum，记录击中敌人坦克的数量
 * 每击中一个坦克，该值加 1
 * 4.点击退出时，将该值写入到 d:\test\myRecord.txt 路径下面即可
 **/
public class TankGame3_1 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame3_1();
    }

    public TankGame3_1() {
        mDrawPanel = new DrawPanel();
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

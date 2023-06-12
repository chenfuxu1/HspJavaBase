package chapter20.tankgame3_2;

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
 * 1.保存敌方坦克的信息(坐标、方向)
 *
 * 思路：
 * 1.让 Recorder 持有当前敌方坦克集合对象
 * 2.遍历当前敌方坦克集合，判断坦克是否存活
 * 如果存活，在退出游戏中记录所有坦克的 x、y 坐标以及坦克的方向
 * 3.记录格式：
 * 第一行：记录击中敌方坦克的数量
 * 后续的每一行表示存活的敌方坦克的 x 坐标、y 坐标、方向，分别用 "," 隔开
 **/
public class TankGame3_2 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame3_2();
    }

    public TankGame3_2() {
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

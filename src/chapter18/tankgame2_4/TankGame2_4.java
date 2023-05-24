package chapter18.tankgame2_4;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.敌人坦克自由移动
 *
 * 思路：
 * 1.要想实现敌人坦克自由移动，需要将 EnemyTank 做成一个线程
 * 2.在坦克线程中，如果坦克是存活的状态，那么就不断移动坦克的坐标
 * 3.移动一段时间后，随机改变一次坦克的方向，再重复进行移动，直到坦克销毁
 * 4.在初始化敌方坦克时，启动坦克线程即可
 **/
public class TankGame2_4 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_4();
    }

    public TankGame2_4() {
        mDrawPanel = new DrawPanel();
        this.add(mDrawPanel);
        // 设置窗口的大小
        this.setSize(Constants.WHOLE_GAME_WIDTH, Constants.WHOLE_GAME_HEIGHT);
        // 设置可以显示
        this.setVisible(true);
        // 当点击窗口的小 ×，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mDrawPanel); // 窗口 JFrame 对象可以监听键盘事件, 即可以监听到面板发生的键盘事件
        // 启动画板绘制的线程
        new Thread(mDrawPanel).start();
    }
}

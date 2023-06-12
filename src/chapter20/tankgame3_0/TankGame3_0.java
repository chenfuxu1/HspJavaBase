package chapter20.tankgame3_0;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.防止敌人坦克重叠
 *
 * 思路：
 * 1.每个敌方坦克需要持有所有的敌方坦克集合
 * 2.每个敌方坦克循环比较坦克集合中的其余坦克与自身是否有重叠
 * 3.如果发生了重叠那么就不让坦克继续移动即可，同时 1.5s 后改变坦克的方向
 * 4.根据敌方坦克上/下/左/右的移动位置，共有 8 中情况需要检测坐标
 **/
public class TankGame3_0 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame3_0();
    }

    public TankGame3_0() {
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

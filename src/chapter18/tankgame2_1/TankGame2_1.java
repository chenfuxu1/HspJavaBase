package chapter18.tankgame2_1;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.敌方坦克也能发射子弹，并且可能有多颗子弹
 *
 * 思路：
 * 1.在敌人坦克类，使用 Vector 保存多个 EnemyShot
 * 2.当每创建一个敌人坦克对象，给该敌人坦克对象初始化一个 EnemyShot 对象，同时启动线程
 * 3.在绘制敌人坦克时，遍历所有的敌人坦克对象里面的 Vector，绘制子弹对象
 * 如果子弹对象已经销毁，那么就从集合中移除
 *
 **/
public class TankGame2_1 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_1();
    }

    public TankGame2_1() {
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

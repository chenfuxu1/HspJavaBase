package chapter18.tankgame2_3;

import javax.swing.*;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:57
 * <p>
 * 整个游戏的窗口
 *
 * 新增功能点：
 * 1.击中坦克实现爆炸效果
 *
 * 思路：
 * 1.新增 Bomb 爆炸类，拥有属性：x 坐标，y 坐标以及爆炸的生命周期
 * 2.在爆炸的生命周期中，随着生命值减少，切换不同的图片显示
 * 3.在碰撞的检测方法中，如果检测到发生了碰撞，就创建一个爆炸类对象，放在 Vector 集合中
 * 4.在绘制过程中，如果爆炸类集合中有爆炸对象并且是存活的状态，就绘制，否则就从集合中移除
 *
 **/
public class TankGame2_3 extends JFrame {
    // 定义绘制的画板
    private DrawPanel mDrawPanel;

    public static void main(String[] args) {
        new TankGame2_3();
    }

    public TankGame2_3() {
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

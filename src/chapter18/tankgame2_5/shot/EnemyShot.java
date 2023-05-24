package chapter18.tankgame2_5.shot;

import chapter18.tankgame2_5.Constants;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/20 11:05
 *
 * 敌方坦克射击类
 **/
public class EnemyShot extends ShotParent {
    public EnemyShot(int x, int y, int direction) {
        super(x, y, direction);
    }

    @Override
    protected void initType() {
        mType = Constants.TYPE_ENEMY_BULLET;
    }

    @Override
    protected void initSpeed() {
        mSpeed = Constants.SPEED_DEFAULT_SHOT;
    }

    @Override
    public void run() {
        while (mIsLive) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (mDirection) {
                case Constants.TOP_DIRECTION: // 子弹向上移动
                    moveTop();
                    break;
                case Constants.BOTTOM_DIRECTION: // 子弹向下移动
                    moveBottom();
                    break;
                case Constants.LEFT_DIRECTION: // 子弹向左移动
                    moveLeft();
                    break;
                case Constants.RIGHT_DIRECTION: // 子弹向右移动
                    moveRight();
                    break;
            }
            // System.out.println("子弹 x 坐标：" + getX() + "子弹 y 坐标：" + getY());
            // 当子弹坐标超出屏幕边界或者子弹不是存活状态，结束该线程
            if (!(getX() > 0 && getX() < Constants.WHOLE_GAME_WIDTH && getY() > 0 && getY() < Constants.WHOLE_GAME_HEIGHT && isLive())) {
                mIsLive = false;
                System.out.println("敌方射击子弹线程退出...");
            }
        }
    }
}

package chapter18.tankgame2_4.shot;

import chapter18.tankgame2_4.Constants;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/17 23:06
 *
 * 子弹射击父类
 **/
public abstract class ShotParent implements Runnable {
    private int mX; // 子弹 x 坐标
    private int mY; // 子弹 y 坐标
    protected boolean mIsLive = true; // 子弹当前是否存活, 默认存活
    protected int mDirection = -1; // 子弹射击的方向
    protected int mSpeed = Constants.SPEED_DEFAULT_SHOT; // 子弹的速度
    protected int mType; // 子弹类型

    public ShotParent(int x, int y, int direction) {
        mX = x;
        mY = y;
        mDirection = direction;
        initType();
        initSpeed();
    }

    protected abstract void initType();

    protected abstract void initSpeed();

    public int getX() {
        return mX;
    }

    public void setX(int x) {
        mX = x;
    }

    public int getY() {
        return mY;
    }

    public void setY(int y) {
        mY = y;
    }

    public boolean isLive() {
        return mIsLive;
    }

    public void setLive(boolean live) {
        mIsLive = live;
    }

    public int getDirection() {
        return mDirection;
    }

    public void setDirection(int direction) {
        mDirection = direction;
    }

    public int getType() {
        return mType;
    }

    public void setType(int type) {
        mType = type;
    }

    // 子弹向上移动
    public void moveTop() {
        mY -= mSpeed;
    }

    // 子弹向下移动
    public void moveBottom() {
        mY += mSpeed;
    }

    // 子弹向左移动
    public void moveLeft() {
        mX -= mSpeed;
    }

    // 子弹向右移动
    public void moveRight() {
        mX += mSpeed;
    }
}

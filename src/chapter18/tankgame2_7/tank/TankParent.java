package chapter18.tankgame2_7.tank;

import chapter18.tankgame2_7.Constants;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:48
 * <p>
 * 坦克父类
 **/
public abstract class TankParent {
    private int mX; // 坦克的 x 坐标
    private int mY; // 坦克的 y 坐标
    private int mDirection; // 坦克的炮筒方向
    protected int mType; // 坦克的类型
    protected int mSpeed = Constants.SPEED_DEFAULT_TANK; // 坦克移动的速度
    private boolean mIsLived = true; // 坦克是否存活，默认 true

    public TankParent(int x, int y) {
        mX = x;
        mY = y;
        initType();
        initSpeed();
    }

    public TankParent(int x, int y, int direction) {
        mX = x;
        mY = y;
        mDirection = direction;
        initType();
        initSpeed();
    }

    public abstract void initType();

    public abstract void initSpeed();

    public int getType() {
        return mType;
    }

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

    public int getDirection() {
        return mDirection;
    }

    public void setDirection(int direction) {
        mDirection = direction;
    }

    public boolean isLived() {
        return mIsLived;
    }

    public void setLived(boolean lived) {
        mIsLived = lived;
    }

    // 坦克向上移动
    public void moveUp() {
        if (mY > 0) {
            mY -= mSpeed;
        } else {
            mY = 0;
        }
    }

    // 坦克向下移动
    public void moveDown() {
        if (mY < Constants.WHOLE_GAME_HEIGHT - 60 - 40) {
            mY += mSpeed;
        } else {
            // 减去坦克的高度
            mY = Constants.WHOLE_GAME_HEIGHT - 60 - 40;
        }
    }

    // 坦克向左移动
    public void moveLeft() {
        if (mX > 0) {
            mX -= mSpeed;
        } else {
            mX = 0;
        }
    }

    // 坦克向右移动
    public void moveRight() {
        if (mX < Constants.WHOLE_GAME_WIDTH - 60 - 15) {
            mX += mSpeed;
        } else {
            // 减去当前方向坦克的长度
            mX = Constants.WHOLE_GAME_WIDTH - 60 - 15;
        }
    }
}

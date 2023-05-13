package chapter16.tankgame;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/11 23:48
 *
 * 坦克父类
 **/
public class TankParent {
    private int mX; // 坦克的 x 坐标
    private int mY; // 坦克的 y 坐标

    public TankParent(int x, int y) {
        mX = x;
        mY = y;
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
}

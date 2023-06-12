package chapter20.tankgame3_1;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/5/20 18:30
 *
 * 爆炸效果类
 **/
public class Bomb {
    private int mX; // 炸弹的 x 坐标
    private int mY; // 炸弹的 y 坐标
    private int mLife = 18; // 炸弹的生命周期，默认为 18，当为 0 时，炸弹不显示
    private boolean mIsLive = true; // 炸弹是否存活, 默认存活

    public Bomb(int x, int y) {
        mX = x;
        mY = y;
    }

    // 炸弹生命周期缩减方法
    public void bombLifeDown() {
        if (mLife > 0) {
            mLife--;
        } else {
            // 生命值为 0 时，炸弹消亡
            mIsLive = false;
        }
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

    public int getLife() {
        return mLife;
    }

    public void setLife(int life) {
        mLife = life;
    }

    public boolean isLive() {
        return mIsLive;
    }

    public void setLive(boolean live) {
        mIsLive = live;
    }
}

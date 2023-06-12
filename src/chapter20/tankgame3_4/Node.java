package chapter20.tankgame3_4;

import java.io.Serializable;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/12 8:52
 *
 * 记录恢复数据的敌方坦克信息：x 坐标、y 坐标、方向
 **/
public class Node implements Serializable {
    private String mX;
    private String mY;
    private String mDirection;

    public Node(String x, String y, String direction) {
        mX = x;
        mY = y;
        mDirection = direction;
    }

    public String getX() {
        return mX;
    }

    public void setX(String x) {
        mX = x;
    }

    public String getY() {
        return mY;
    }

    public void setY(String y) {
        mY = y;
    }

    public String getDirection() {
        return mDirection;
    }

    public void setDirection(String direction) {
        mDirection = direction;
    }
}

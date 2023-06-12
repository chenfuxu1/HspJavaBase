package chapter20.tankgame3_2;

import chapter20.tankgame3_2.tank.EnemyTank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/11 22:28
 * <p>
 * 记录玩家的成绩信息
 **/
public class Recorder {
    private static volatile Recorder sRecorder = null;
    private static final String FILE_PATH = "d:\\test\\myRecord.txt";
    private int mDeadTankNum = 0; // 记录击中敌方坦克的数量
    private Vector<EnemyTank> mEnemyTanks = new Vector<>();

    public static Recorder getInstance() {
        if (sRecorder == null) {
            synchronized (Recorder.class) {
                if (sRecorder == null) {
                    sRecorder = new Recorder();
                }
            }
        }
        return sRecorder;
    }

    public int getDeadTankNum() {
        return mDeadTankNum;
    }

    public void setDeadTankNum() {
        this.mDeadTankNum++;
    }

    public Vector<EnemyTank> getEnemyTanks() {
        return mEnemyTanks;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.mEnemyTanks.clear();
        this.mEnemyTanks.addAll(enemyTanks);
    }

    /**
     * 写入成绩到文件中
     */
    public void writeRecordToFile() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            // 1.先记录击中的敌方坦克数量
            bufferedWriter.write(mDeadTankNum + "");
            bufferedWriter.newLine();
            // 2.再循环记录当前存活的敌方坦克的坐标、方向
            for (EnemyTank enemyTank : mEnemyTanks) {
                if (enemyTank != null && enemyTank.isLived()) {
                    bufferedWriter.write(enemyTank.getX() + "," + enemyTank.getY() + "," + enemyTank.getDirection());
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

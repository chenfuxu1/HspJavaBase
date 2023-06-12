package chapter20.tankgame3_3;

import chapter20.tankgame3_3.tank.EnemyTank;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Vector;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/11 22:28
 * <p>
 * 记录玩家的成绩信息
 **/
public class Recorder implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void setDeadTankNum(int deadTankNum) {
        mDeadTankNum = deadTankNum;
    }

    public void addDeadTankNum() {
        mDeadTankNum++;
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

    /**
     * 恢复记录的文件对象信息
     */
    public Vector<Node> readFileToRecord() {
        Vector<Node> nodes = new Vector<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String readLine = null;
        try {
            fileReader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            readLine = bufferedReader.readLine();
            if (readLine != null) {
                // 1.将击毁的敌方坦克数量恢复
                mDeadTankNum = Integer.parseInt(readLine);
            }
            // 2.将所有存活的敌方坦克坐标、方向恢复到 Node 节点中
            while ((readLine = bufferedReader.readLine()) != null ) {
                // 数组顺序 0、1、2 分别表示 x、y 坐标、方向
                String[] xyd = readLine.split(",");
                Node node = new Node(xyd[0], xyd[1], xyd[2]);
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return nodes;
    }

}

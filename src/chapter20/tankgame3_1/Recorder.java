package chapter20.tankgame3_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

    /**
     * 写入成绩到文件中
     */
    public void writeRecordToFile() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(mDeadTankNum + "");
            bufferedWriter.newLine();
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

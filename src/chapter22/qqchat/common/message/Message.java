package chapter22.qqchat.common.message;

import java.io.Serializable;

/**
 * Project: HspBase
 * Create By: ChenFuXu
 * DateTime: 2023/6/18 23:01
 *
 * 表示客户端 / 服务端通信时的消息对象
 **/
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    private String mSender; // 消息的发送者
    private String mGetter; // 消息的接收者
    private String mContent; // 消息内容
    private String mSendTime; // 消息的发送时间
    private String mMessageType; // 消息的类型
    private byte[] mFileBytes;
    private int mFileLen = 0; // 文件大小
    private String mFileDest; // 文件目标路径
    private String mFileSrc; // 文件源路径

    public Message() {
    }

    public Message(String sender, String getter, String content, String sendTime, String messageType) {
        mSender = sender;
        mGetter = getter;
        mContent = content;
        mSendTime = sendTime;
        mMessageType = messageType;
    }

    public String getSender() {
        return mSender;
    }

    public void setSender(String sender) {
        mSender = sender;
    }

    public String getGetter() {
        return mGetter;
    }

    public void setGetter(String getter) {
        mGetter = getter;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public String getSendTime() {
        return mSendTime;
    }

    public void setSendTime(String sendTime) {
        mSendTime = sendTime;
    }

    public String getMessageType() {
        return mMessageType;
    }

    public void setMessageType(String messageType) {
        mMessageType = messageType;
    }

    public byte[] getFileBytes() {
        return mFileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        mFileBytes = fileBytes;
    }

    public int getFileLen() {
        return mFileLen;
    }

    public void setFileLen(int fileLen) {
        mFileLen = fileLen;
    }

    public String getFileDest() {
        return mFileDest;
    }

    public void setFileDest(String fileDest) {
        mFileDest = fileDest;
    }

    public String getFileSrc() {
        return mFileSrc;
    }

    public void setFileSrc(String fileSrc) {
        mFileSrc = fileSrc;
    }
}

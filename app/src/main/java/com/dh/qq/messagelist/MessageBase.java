package com.dh.qq.messagelist;

public class MessageBase {

    private int friendHead;
    private String friendNickname;
    private String friendSimple;
    private String messageTime;
    private String messageSum;

    public MessageBase() {
    }

    public MessageBase(int friendHead, String friendNickname, String friendSimple, String messageTime, String messageSum) {
        this.friendHead = friendHead;
        this.friendNickname = friendNickname;
        this.friendSimple = friendSimple;
        this.messageTime = messageTime;
        this.messageSum = messageSum;
    }

    public int getFriendHead() {
        return friendHead;
    }

    public void setFriendHead(int friendHead) {
        this.friendHead = friendHead;
    }

    public String getFriendNickname() {
        return friendNickname;
    }

    public void setFriendNickname(String friendNickname) {
        this.friendNickname = friendNickname;
    }

    public String getFriendSimple() {
        return friendSimple;
    }

    public void setFriendSimple(String friendSimple) {
        this.friendSimple = friendSimple;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageSum() {
        return messageSum;
    }

    public void setMessageSum(String messageSum) {
        this.messageSum = messageSum;
    }

    @Override
    public String toString() {
        return "MessageBase{" +
                "friendHead=" + friendHead +
                ", friendNickname='" + friendNickname + '\'' +
                ", friendSimple='" + friendSimple + '\'' +
                ", messageTime='" + messageTime + '\'' +
                ", messageSum='" + messageSum + '\'' +
                '}';
    }
}

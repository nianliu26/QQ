package com.dh.qq.friendgroup;

public class FriendInformation {

    private int head;
    private String nickname;
    private String online;
    private String count;

    public FriendInformation() {
    }

    public FriendInformation(int head, String nickname, String online, String count) {
        this.head = head;
        this.nickname = nickname;
        this.online = online;
        this.count = count;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FriendInformation{" +
                "head=" + head +
                ", nickname='" + nickname + '\'' +
                ", online='" + online + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}

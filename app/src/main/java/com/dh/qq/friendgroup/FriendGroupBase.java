package com.dh.qq.friendgroup;

import java.util.List;

public class FriendGroupBase {
    private String groupName,onlineParson,tatolPerson;
    private List<FriendInformation> friendInformations;

    public FriendGroupBase() {
    }

    public FriendGroupBase(String groupName, String onlineParson, String tatolPerson, List<FriendInformation> friendInformations) {
        this.groupName = groupName;
        this.onlineParson = onlineParson;
        this.tatolPerson = tatolPerson;
        this.friendInformations = friendInformations;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOnlineParson() {
        return onlineParson;
    }

    public void setOnlineParson(String onlineParson) {
        this.onlineParson = onlineParson;
    }

    public String getTatolPerson() {
        return tatolPerson;
    }

    public void setTatolPerson(String tatolPerson) {
        this.tatolPerson = tatolPerson;
    }

    public List<FriendInformation> getFriendInformations() {
        return friendInformations;
    }

    public void setFriendInformations(List<FriendInformation> friendInformations) {
        this.friendInformations = friendInformations;
    }

    @Override
    public String toString() {
        return "FriendGroupBase{" +
                "groupName='" + groupName + '\'' +
                ", onlineParson='" + onlineParson + '\'' +
                ", tatolPerson='" + tatolPerson + '\'' +
                ", friendInformations=" + friendInformations +
                '}';
    }
}

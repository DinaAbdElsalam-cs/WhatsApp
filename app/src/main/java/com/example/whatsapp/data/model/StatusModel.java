package com.example.whatsapp.data.model;

public class StatusModel {

    private int statusImage;
    private String userStatusName;

    public StatusModel(int statusImage, String userStatusName) {
        this.statusImage = statusImage;
        this.userStatusName = userStatusName;
    }

    public int getStatusImage() {
        return statusImage;
    }

    public void setStatusImage(int statusImage) {
        this.statusImage = statusImage;
    }

    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }
}

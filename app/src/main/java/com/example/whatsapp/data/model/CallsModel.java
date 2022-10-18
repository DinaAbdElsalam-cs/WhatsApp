package com.example.whatsapp.data.model;

public class CallsModel {
    private int userCallImage;
    private String userCallName;

    public CallsModel(int userCallImage, String userCallName) {
        this.userCallImage = userCallImage;
        this.userCallName = userCallName;
    }

    public int getUserCallImage() {
        return userCallImage;
    }

    public void setUserCallImage(int userCallImage) {
        this.userCallImage = userCallImage;
    }

    public String getUserCallName() {
        return userCallName;
    }

    public void setUserCallName(String userCallName) {
        this.userCallName = userCallName;
    }
}

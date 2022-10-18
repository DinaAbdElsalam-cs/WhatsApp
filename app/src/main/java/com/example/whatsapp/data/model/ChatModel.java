package com.example.whatsapp.data.model;

public class ChatModel {
    private int profileImage;
    private String userName,chatText;

    public ChatModel(int profileImage, String userName, String chatText) {
        this.profileImage = profileImage;
        this.userName = userName;
        this.chatText = chatText;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }
}

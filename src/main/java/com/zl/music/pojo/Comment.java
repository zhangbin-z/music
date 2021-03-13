package com.zl.music.pojo;

public class Comment {
    private int comId;
    private int mId;
    private int id;
    private User user;
    private String comText;
    private String comDate;

    public int getComId() {
        return comId;
    }

    public void setComId(int comId) {
        this.comId = comId;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComText() {
        return comText;
    }

    public void setComText(String comText) {
        this.comText = comText;
    }

    public String getComDate() {
        return comDate;
    }

    public void setComDate(String comDate) {
        this.comDate = comDate;
    }
}

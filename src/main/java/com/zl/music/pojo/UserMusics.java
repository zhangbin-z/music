package com.zl.music.pojo;

import java.util.List;

public class UserMusics {
//    用户歌单id
    private Integer umId;
//    用户id
    private Integer id;
//    歌曲id
    private Integer mId;
//    级联对象用户
    private User user;
//    级联对象歌曲
    private List<Music> musics;

    public Integer getUmId() {
        return umId;
    }

    public void setUmId(Integer umId) {
        this.umId = umId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }
}

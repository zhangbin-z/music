package com.zl.music.pojo;

import java.util.List;

public class Singer {
//    歌手id
    private int sinId;
//    歌手名字
    private String sinName;
//    歌手性别
    private String sinSex;
//    歌手地区
    private String sinRegion;
//    歌手图片
    private String sinPicture;
//    一对多级联对象
    private List<Music> musics;

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }

    public int getSinId() {
        return sinId;
    }

    public void setSinId(int sinId) {
        this.sinId = sinId;
    }

    public String getSinName() {
        return sinName;
    }

    public void setSinName(String sinName) {
        this.sinName = sinName;
    }

    public String getSinSex() {
        return sinSex;
    }

    public void setSinSex(String sinSex) {
        this.sinSex = sinSex;
    }

    public String getSinRegion() {
        return sinRegion;
    }

    public void setSinRegion(String sinRegion) {
        this.sinRegion = sinRegion;
    }

    public String getSinPicture() {
        return sinPicture;
    }

    public void setSinPicture(String sinPicture) {
        this.sinPicture = sinPicture;
    }

    public Singer() {
    }

    public Singer(int sinId, String sinName, String sinSex, String sinRegion, String sinPicture) {
        this.sinId = sinId;
        this.sinName = sinName;
        this.sinSex = sinSex;
        this.sinRegion = sinRegion;
        this.sinPicture = sinPicture;
    }
}

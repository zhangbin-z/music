package com.zl.music.util;

public enum FlagEnum {
    HOME("主页"),
    MUSIC_LIST("歌单"),
    RANK_LIST("榜单");
    private FlagEnum(String flag){
        this.flag = flag;
    }
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}

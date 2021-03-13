package com.zl.music.service;

import com.zl.music.pojo.Singer;

import java.util.List;
import java.util.Map;

public interface SingerService {

    //    分页查询歌手的通用方法
    public List<Singer> singerList(Singer singer,int nowPage);
    //    查询歌手的通用方法
    public Singer get(Singer singer);
    //	根据不同条件得到歌手总页数
    public int getSingerTotal(Singer singer);
    //    根据歌手名字查询歌手
    public Singer getByName(String sinName);
    //    查询所有歌手
    public List<Singer> getAll();
}

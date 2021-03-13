package com.zl.music.service;

import com.zl.music.pojo.UserMusics;

import java.util.List;

public interface UserMusicsService {
//    通过用户id查询歌单
    public List<UserMusics> listById(int nowPage,int id);
//    批量删除歌单
    public boolean delete(Integer[] umIdList);
//    添加歌单
    public boolean add(UserMusics userMusics);
    //    通过用户id得到分页总页数
    public int totalById(int id);
}

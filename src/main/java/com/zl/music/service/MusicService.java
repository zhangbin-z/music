package com.zl.music.service;

import com.zl.music.pojo.Music;

import java.util.List;


public interface MusicService {

    //    批量删除音乐的方法
    public boolean delete(Integer[] list);
    //    通过id查询单个音乐
    public Music get(Music music);
    //    添加音乐的方法
    public boolean add(Music music);
//    根据不同条件得到对应的音乐条数
    public int getMusicTotal(Music music,String flag);
//    查询所有老歌（80年代以前的歌）
    public List<Music> oldMusicList();
    //    分页查询热门歌手
    public List<Music> hotSinger(int nowPage,int pageSize);
    //    分页查询音乐的通用方法(集合中应放入一个music对象和当前页面和标志 以完成==========)
    public List<Music> musicsByPage(Music music, int nowPage,String flag);
    //    通过歌曲id修改歌曲的点击率
    public boolean updateSanNum(int mId);
}

package com.zl.music.dao;

import com.zl.music.pojo.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface SingerMapper {

//    分页查询歌手的通用方法
    public List<Singer> singerList(Map<String,Object> map);
//    通过id查询歌手的方法
    public Singer get(Singer singer);
    //	根据不同条件得到歌手总数
    public int getSingerTotal(Singer singer);
//    根据歌手名字查询歌手
    public Singer getByName(String sinName);
//    查询所有歌手
    public List<Singer> getAll();

}

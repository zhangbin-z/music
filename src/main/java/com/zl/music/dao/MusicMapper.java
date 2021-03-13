package com.zl.music.dao;

import com.zl.music.pojo.Music;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MusicMapper {

//    删除音乐的方法
    public void delete(int mId);
//    分页查询音乐的通用方法(集合中应放入一个music对象和分页开始和结束三个元素)
    public List<Music> musicListByPage(Map<String,Object> map);
//    通过id查询单个音乐
    public Music get(Music music);
//    添加音乐的方法
    public void add(Music music);
    //	根据不同条件得到对应的音乐条数
    public int getMusicTotal(Music music);
//    根据歌手id查询音乐
    public List<Music> musicListBySinId(int sinId);
    /**
     * @param 无参数
     * @return 返回一个music类型的集合
     * 查询所有老歌（80年代以前的歌）
     * */
    public List<Music> oldMusicList();

//    分页查询热门歌手
    public List<Music> hotSinger(Map<String,Object> map);
//    通过歌曲id修改歌曲的点击率
    public void updateSanNum(int mId);
    public Music getByMid(int mId);
}

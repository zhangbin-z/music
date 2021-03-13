package com.zl.music.service.impl;

import com.zl.music.dao.MusicMapper;
import com.zl.music.pojo.Music;
import com.zl.music.service.MusicService;
import com.zl.music.util.FlagEnum;
import com.zl.music.util.PageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper mm;

    public void setMm(MusicMapper mm) {
        this.mm = mm;
    }

    //    批量删除音乐的方法（管理员的方法）
    public boolean delete(Integer[] list) {
        try {
            for(Integer integer:list){
                mm.delete(integer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //    分页查询音乐的通用方法(集合中应放入一个music对象和当前页面和标志 以完成==========)
    public List<Music> musicsByPage(Music music, int nowPage,String flag) {
//        得到主页标志
        String home = FlagEnum.HOME.getFlag();
//        得到歌单标志
        String musciList = FlagEnum.MUSIC_LIST.getFlag();
//        得到榜单标志
        String rankList = FlagEnum.RANK_LIST.getFlag();
        int pageSize = 0;
//        判断传过来的标志分别对应不同的页面容量
        if(home.equals(flag)){
            pageSize = PageEnum.PAGE_SIZE_HOME.getPageSize();
        }else if(musciList.equals(flag)){
            pageSize = PageEnum.PAGE_SIZE_LIST.getPageSize();
        }else if(rankList.equals(flag)){
            pageSize = PageEnum.PAGE_SIZE_RANK.getPageSize();
        }else {
            pageSize = PageEnum.PAGE_SIZE_HOME.getPageSize();
        }
//        分页开始
        int start = (nowPage-1)*pageSize;
//        分页结束
        int end = pageSize;
        Map<String,Object> maps = new HashMap<String, Object>();
        maps.put("start", start);
        maps.put("end", end);
        maps.put("music",music);
//        调用通用分页查询方法
        List<Music> list = mm.musicListByPage(maps);
        return list;
    }

//    通过歌曲id修改歌曲的点击率
    public boolean updateSanNum(int mId) {
        try {
            mm.updateSanNum(mId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //    通过id查询单个音乐
    public Music get(Music music) {
        return mm.get(music);
    }

    //    添加音乐的方法
    public boolean add(Music music) {
        try {
            if(null==mm.get(music)){
                mm.add(music);
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //    根据不同条件得到对应的音乐条数
    public int getMusicTotal(Music music,String flag) {
        //		1.得到总记录数
        int Total = mm.getMusicTotal(music);
//		2.得到页面容量
        int pageSize = 0;
        if((FlagEnum.HOME.getFlag()).equals(flag)){
            pageSize = PageEnum.PAGE_SIZE_HOME.getPageSize();
        }else if(FlagEnum.MUSIC_LIST.getFlag().equals(flag)){
            pageSize = PageEnum.PAGE_SIZE_LIST.getPageSize();
        }else if (FlagEnum.RANK_LIST.getFlag().equals(flag)){
            pageSize = PageEnum.PAGE_SIZE_RANK.getPageSize();
        }
        int pageTotal = 0;
        if(Total%pageSize==0) {
            pageTotal = Total/pageSize;
        }else {
            pageTotal = Total/pageSize + 1;
        }
        return pageTotal;
    }

    //    查询所有老歌（80年代以前的歌）
    public List<Music> oldMusicList() {
        return mm.oldMusicList();
    }

    //    分页查询热门歌手
    public List<Music> hotSinger(int nowPage, int pageSize) {
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        Map<String,Object> maps = new HashMap<String, Object>();
        maps.put("start", start);
        maps.put("end", end);
        List<Music> list = mm.hotSinger(maps);
        return list;
    }
}

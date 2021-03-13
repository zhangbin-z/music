package com.zl.music.service.impl;

import com.zl.music.dao.SingerMapper;
import com.zl.music.pojo.Singer;
import com.zl.music.service.SingerService;
import com.zl.music.util.PageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper sm;

    public void setSm(SingerMapper sm) {
        this.sm = sm;
    }

    //    分页查询歌手的通用方法
    public List<Singer> singerList(Singer singer, int nowPage) {
        int pageSize = PageEnum.PAGE_SIZE_SINGER.getPageSize();
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        Map<String,Object> maps = new HashMap<String, Object>();
        maps.put("start", start);
        maps.put("end", end);
        maps.put("singer",singer);
        List<Singer> list = sm.singerList(maps);
        return list;
    }

    //    查询歌手的通用方法
    public Singer get(Singer singer) {
        return sm.get(singer);
    }

    //	根据不同条件得到歌手总页数
    public int getSingerTotal(Singer singer) {
//        得到歌手总数
        int total = sm.getSingerTotal(singer);
        int pageSize = PageEnum.PAGE_SIZE_SINGER.getPageSize();
//        定义歌手总页数
        int singerTotal = 0;
//        判断
        if(total%pageSize==0){
            singerTotal = total/pageSize;
        }else {
            singerTotal = total/pageSize + 1;
        }
        return singerTotal;
    }

    //    根据歌手名字查询歌手
    public Singer getByName(String sinName) {
        return sm.getByName(sinName);
    }

    @Override
    public List<Singer> getAll() {
        return sm.getAll();
    }


}

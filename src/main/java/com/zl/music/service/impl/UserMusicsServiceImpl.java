package com.zl.music.service.impl;

import com.zl.music.dao.UserMusicsMapper;
import com.zl.music.pojo.UserMusics;
import com.zl.music.service.UserMusicsService;
import com.zl.music.util.PageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserMusicsServiceImpl implements UserMusicsService {
    @Autowired
    private UserMusicsMapper umm;

    public void setUmm(UserMusicsMapper umm) {
        this.umm = umm;
    }

    //    通过用户id分页查询歌单
    public List<UserMusics> listById(int nowPage, int id) {
        int pageSize = PageEnum.PAGE_SIZE_LIST.getPageSize();
        int start = (nowPage-1)*pageSize;
        int end = pageSize;
        Map<String,Object> maps = new HashMap<String, Object>();
        maps.put("id",id);
        maps.put("start", start);
        maps.put("end", end);
        return umm.listById(maps);
    }

    //    批量删除歌单
    public boolean delete(Integer[] umIdList) {
        try {
            for (Integer integer:umIdList) {
                umm.delete(integer.intValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //    添加歌单
    public boolean add(UserMusics userMusics) {
        try {
            if(null!=umm.get(userMusics)){
                return false;
            }else {
                umm.add(userMusics);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //    通过用户id得到分页总页数
    public int totalById(int id) {
        //		1.得到总记录数
        int Total = umm.countById(id);
        int pageSize = PageEnum.PAGE_SIZE_LIST.getPageSize();
        int pageTotal = 0;
        if(Total%pageSize==0) {
            pageTotal = Total/pageSize;
        }else {
            pageTotal = Total/pageSize + 1;
        }
        return pageTotal;
    }
}

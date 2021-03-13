package com.zl.music.dao;

import com.zl.music.pojo.UserMusics;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface UserMusicsMapper {
    /**
     * @param 参数类型为map集合 包括用户id 分页开始和分页结束
     * 通过用户id分页查询歌单
     * */
    public List<UserMusics> listById(Map<String,Object> map);

    /**
     * @param 参数为歌单表id 类型为int
     * 通过歌单id删除歌单
     * */
    public void delete(int umId);

//    判断歌单是否存在
    public UserMusics get(UserMusics userMusics);

//    添加歌单
    public void add(UserMusics userMusics);

//    通过用户id查询歌单的总数
    public int countById(int id);
}

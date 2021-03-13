package com.zl.music.dao;

import com.zl.music.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
//    通过id查询用户
    public User getUser(User user);
}

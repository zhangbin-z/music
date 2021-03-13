package com.zl.music.dao;

import com.zl.music.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
//    通过歌曲id查询所有评论
    public List<Comment> listBymId(int mId);
//    添加评论
    public void add(Comment comment);
//    通过歌曲id查询评论数量
    public int count(int mId);
}

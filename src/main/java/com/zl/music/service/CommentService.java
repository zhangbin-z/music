package com.zl.music.service;

import com.zl.music.pojo.Comment;

import java.util.List;

public interface CommentService {
    //    通过歌曲id查询所有评论
    public List<Comment> listBymId(int mId);
    //    添加评论
    public boolean add(Comment comment);
    //    通过歌曲id查询评论数量
    public int count(int mId);
}

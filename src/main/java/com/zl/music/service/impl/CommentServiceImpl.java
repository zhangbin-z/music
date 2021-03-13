package com.zl.music.service.impl;

import com.zl.music.dao.CommentMapper;
import com.zl.music.pojo.Comment;
import com.zl.music.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper cm;

    public void setCm(CommentMapper cm) {
        this.cm = cm;
    }

    //    通过歌曲id查询所有评论
    public List<Comment> listBymId(int mId) {
        return cm.listBymId(mId);
    }

    //    添加评论
    public boolean add(Comment comment) {
        try {
            cm.add(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //    通过歌曲id查询评论数量
    public int count(int mId) {
        return cm.count(mId);
    }
}

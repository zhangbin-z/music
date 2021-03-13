package com.zl.music;

import com.zl.music.pojo.Comment;
import com.zl.music.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommenServiceTest {
    @Autowired
    private CommentService cs;

    public void setCs(CommentService cs) {
        this.cs = cs;
    }
    @Test
    public void listBymIdTest(){
        List<Comment> list = cs.listBymId(1);
        for (Comment comment:list) {
            System.out.println(comment.getUser().getuName());
        }
    }
    @Test
    public void addTest(){
        Comment comment = new Comment();
        comment.setmId(1);
        comment.setId(1);
        comment.setComDate("2018-11-17");
        comment.setComText("这首歌真的太好听了");
        boolean flag = cs.add(comment);
        System.out.println(flag);
    }
    @Test
    public void countTest(){
        System.out.println(cs.count(1));
    }
}

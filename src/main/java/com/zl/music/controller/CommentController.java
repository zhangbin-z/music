package com.zl.music.controller;

import com.zl.music.pojo.Comment;
import com.zl.music.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService cs;

    public void setCs(CommentService cs) {
        this.cs = cs;
    }
    /*
    * 根据歌曲ID查询评论
    * */
    @RequestMapping(value = "/{mId}/commentsBymId",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String commentsBymId(HttpServletResponse res, @PathVariable int mId){
        res.setHeader("Access-Control-Allow-Origin", "*");
        List<Comment> list = cs.listBymId(mId);
        Map<String,Object> results = new HashMap<String,Object>();
        if(list.size()!=0){
            results.put("comments",list);
        }
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
    /*
    * 添加评论
    * */
    @RequestMapping(value = "/addComment",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addComment(HttpServletResponse res,Comment comment){
        res.setHeader("Access-Control-Allow-Origin", "*");
        boolean flag = cs.add(comment);
        Map<String,Object> results = new HashMap<String,Object>();
        String msg = "";
        if(flag){
            msg = "评论成功！";
        }else {
            msg = "评论失败！";
        }
        results.put("msg",msg);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /*
     * 根据歌曲ID查询评论数量
     * */
    @RequestMapping(value = "/{mId}/commentsCount",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String commentsCount(HttpServletResponse res, @PathVariable int mId ){
        res.setHeader("Access-Control-Allow-Origin", "*");
        int comNum = cs.count(mId);
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("comNum",comNum);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
}

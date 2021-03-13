package com.zl.music.controller;


import com.zl.music.pojo.Singer;
import com.zl.music.service.SingerService;
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
@RequestMapping(value = "/singer",produces = "text/html;charset=UTF-8")
public class SingerController {
    @Autowired
    private SingerService ss;

    public void setSs(SingerService ss) {
        this.ss = ss;
    }

//    查询所有歌手的方法
    @RequestMapping(value = "/{nowPage}/allSinger",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String singerList(HttpServletResponse res,@PathVariable int nowPage){
        res.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> results = new HashMap<String,Object>();
//        创建一个空的singer对象
        Singer singer = new Singer();
        List<Singer> list = ss.singerList(singer,nowPage);
        results.put("singers",list);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
//    得到歌手总页数
    @RequestMapping(value = "/singerTotal",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getSingerTotal(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*");
        //        创建一个空的singer对象
        Singer singer = new Singer();
        Map<String,Object> results = new HashMap<String,Object>();
        int singerTotal = ss.getSingerTotal(singer);
        results.put("singerTotal",singerTotal);
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
//    根据不同条件查询所有歌手对应的歌曲的方法
    @RequestMapping(value = "/musicsBySinId",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String musicsBySinId(HttpServletResponse res,String singer,String nowPage){
        res.setHeader("Access-Control-Allow-Origin", "*");
        //       1.将获取到的当前页字符串转为int类型
        int nowPage1 = 0;
        try {
            nowPage1 = Integer.valueOf(nowPage);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            nowPage1 = 1;
        }
        //        2.将获取到的json字符串格式的对象转为music类的对象（传对象是为了匹配不同的查询条件）
        JSONObject jsonobject = JSONObject.fromObject(singer);
        Singer singer1= (Singer)JSONObject.toBean(jsonobject,Singer.class);
        //        3.调用分页查询的通用方法
        List<Singer> list = ss.singerList(singer1,nowPage1);
        Map<String,Object> results = new HashMap<String,Object>();
        if(list.size()!=0){
            results.put("musicsBySinId",list);
        }
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
/*
*得到所有歌手
* */
    @RequestMapping(value = "/getAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAll(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*");
        List<Singer> list =ss.getAll();
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("allSinger",list);
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }






}

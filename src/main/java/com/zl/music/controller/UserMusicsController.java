package com.zl.music.controller;

import com.zl.music.pojo.UserMusics;
import com.zl.music.service.UserMusicsService;
import net.sf.json.JSONArray;
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
@RequestMapping("/userMusics")
public class UserMusicsController {
    @Autowired
    private UserMusicsService ums;

    public void setUms(UserMusicsService ums) {
        this.ums = ums;
    }

    /**
     * 通过用户id分页查询歌单
     * */
    @RequestMapping(value = "/userMusicsById",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String userMusicsByPage(HttpServletResponse res,String nowPage,String userMusics){
        res.setHeader("Access-Control-Allow-Origin", "*");
        int nowPage1 = Integer.valueOf(nowPage);
        //        2.将获取到的json字符串格式的对象转为music类的对象（传对象是为了匹配不同的查询条件）
        JSONObject jsonobject = JSONObject.fromObject(userMusics);
        UserMusics userMusics1= (UserMusics)JSONObject.toBean(jsonobject,UserMusics.class);
        List<UserMusics> list = ums.listById(nowPage1,userMusics1.getId());
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("userMusics",list);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /**
     * 批量删除歌单 待测试==================
     * */
    @RequestMapping(value = "/delUserMusics",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String delUserMusics(HttpServletResponse res, Integer[] umIdList){
        res.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> results = new HashMap<String,Object>();
        boolean flag = ums.delete(umIdList);
        if (flag){
            results.put("msg","批量删除成功！");
        }else {
            results.put("msg","批量删除失败！");
        }
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /**
     *     添加歌单（已完成========）
     * */
    @RequestMapping(value = "/addUserMusics",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addUserMusics(HttpServletResponse res,UserMusics userMusics){
        res.setHeader("Access-Control-Allow-Origin", "*");
        boolean flag = ums.add(userMusics);
        Map<String,Object> results = new HashMap<String,Object>();
        if (flag){
            results.put("msg","添加成功！");
        }else {
            results.put("msg","您的歌单中已有该歌曲！");
        }
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /**
     * 通过用户id得到分页总页数
     * */
    @RequestMapping(value = "/{id}/userMusics",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getTotalById(HttpServletResponse res, @PathVariable int id){
        res.setHeader("Access-Control-Allow-Origin", "*");
        int total = ums.totalById(id);
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("total",total);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }


}

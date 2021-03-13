package com.zl.music.controller;


import com.zl.music.pojo.User;
import com.zl.music.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService us;

    public void setUs(UserService us) {
        this.us = us;
    }
    //    登陆方法
    @RequestMapping(value = "/login",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(HttpServletResponse res, User user){
        res.setHeader("Access-Control-Allow-Origin", "*");
        Map<String,Object> results = new HashMap<String,Object>();
        User user1 = us.login(user);
        results.put("user",user1);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
}

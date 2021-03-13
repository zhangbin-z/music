package com.zl.music.controller;



import com.zl.music.pojo.Music;
import com.zl.music.pojo.Singer;
import com.zl.music.service.MusicService;
import com.zl.music.service.SingerService;
import com.zl.music.util.FileUpload;
import com.zl.music.util.PageEnum;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private MusicService ms;
    @Autowired
    private SingerService ss;

    public void setSs(SingerService ss) {
        this.ss = ss;
    }

    public void setMs(MusicService ms) {
        this.ms = ms;
    }

    /**
     *根据不同条件得到分页总页数
     * */
    @RequestMapping(value = "/{flag}/musicTotal",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getPageTotal(HttpServletResponse res,@PathVariable String flag){
        res.setHeader("Access-Control-Allow-Origin", "*");
        Music music = new Music();
        Map<String,Object> results = new HashMap<String,Object>();
        int musicTotal = ms.getMusicTotal(music,flag);
        results.put("musicTotal",musicTotal);
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /**
     * 查询老歌（80年代以前的歌曲  榜单页面）
     * */
    @RequestMapping(value = "/rankOldMusic",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String oldMusic(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*");
        List<Music> list = ms.oldMusicList();
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("rankOldMusics",list);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /**
     * 查询最热歌手（榜单页面）
     * */
    @RequestMapping(value = "/{nowPage}/rankHotSinger",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String rankHotSinger(HttpServletResponse res,@PathVariable int nowPage){
        res.setHeader("Access-Control-Allow-Origin", "*");
        int pageSize = PageEnum.PAGE_SIZE_HOME.getPageSize();
        List<Music> list = ms.hotSinger(nowPage,pageSize);
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("rankHotSingers",list);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
    /**
     * 分页查询歌曲的通用方法(以实现待改进 参数为music对象和一个标志（主页还是别的页面）和当前页===============)
     * */
    @RequestMapping(value = "/musicsByPage",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String musicsByPage(HttpServletResponse res, String music,String flag,String nowPage){
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
        JSONObject jsonobject = JSONObject.fromObject(music);
        Music music1= (Music)JSONObject.toBean(jsonobject,Music.class);
//        3.调用分页查询的通用方法
        List<Music> list = ms.musicsByPage(music1,nowPage1,flag);
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("musicsByPage",list);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
    /**
     * 添加歌曲(文件上传)
     * */
    @RequestMapping(value = "/addMusic",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addMusic(HttpServletResponse res,String mName,String sinName,String mLanguage,String mMood,
                           String mStyle, String issueDate,String mDuration, MultipartFile[] mul){
        res.setHeader("Access-Control-Allow-Origin", "*");
//        封装music对象
        Music music = new Music();
        music.setmName(mName);
        Singer singer = ss.getByName(sinName);
        music.setSinId(singer.getSinId());
        music.setmLanguage(mLanguage);
        music.setmMood(mMood);
        music.setmStyle(mStyle);
        music.setIssueDate(issueDate);
        music.setmDuration(mDuration);
//        调用文件上传的方法得到mURL,mPicture
        Map<String,String> map = FileUpload.upLoad(mul);
        music.setmURL(map.get("mURL"));
        music.setmPicture(map.get("mPicture"));
//        得到上传是否成功
        String flag = map.get("flag");
//        定义一个添加成功与否的信息
        String msg = "";
        if(ms.add(music)){
            msg = "成功";
        }else {
            msg = "失败";
        }
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("msg",msg);
        results.put("flag",flag);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }

    /**
     * 批量删除歌曲 待测试==================
     * */
    @RequestMapping(value = "/delMusics",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String delMusics(HttpServletResponse res, Integer[] list){
        res.setHeader("Access-Control-Allow-Origin", "*");
        boolean flag = ms.delete(list);
        Map<String,Object> results = new HashMap<String,Object>();
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
     * 通过歌曲id修改歌曲的点击率
     * */
    @RequestMapping(value = "/updateScanNum",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateScanNum(HttpServletResponse res,Music music){
        res.setHeader("Access-Control-Allow-Origin", "*");
        boolean flag = ms.updateSanNum(music.getmId());
        Map<String,Object> results = new HashMap<String,Object>();
        if (flag){
            results.put("msg","增加点击率成功！");
        }else {
            results.put("msg","增加点击率失败！");
        }
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
    /*
    * 通过id查询歌曲
    * */
    @RequestMapping(value = "/{mId}/getOneMusic",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getOneMusic(HttpServletResponse res,@PathVariable int mId){
        res.setHeader("Access-Control-Allow-Origin", "*");
        Music music1 = new Music();
        music1.setmId(mId);
        Music music = ms.get(music1);
        Map<String,Object> results = new HashMap<String,Object>();
        results.put("oneMusic",music);
        //		3.转化为json字符串
        JSONObject jb = JSONObject.fromObject(results);
        String result = jb.toString();
        return result;
    }
}

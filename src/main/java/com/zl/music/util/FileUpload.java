package com.zl.music.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUpload {
    public static Map<String,String> upLoad(MultipartFile[] mul){
        //        循环得到的文件数组
        Map<String,String> maps = new HashMap<String,String>();
        //        定义一个文件上传是否成功的标志
        String flag = "";
        for (MultipartFile mu :mul){
            if (mu.isEmpty()) {
            flag = "文件不能空";
        }
        // 获取文件名
        String fileName = mu.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath ="G:\\06--java相关工具\\09-TomCat服务器\\apache-tomcat-8.5.34\\webapps\\musics\\";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();

            }
        //输出路径
        System.out.println(dest.getPath());
        System.out.println(dest.getAbsolutePath());
        if(".mp3".equals(suffixName)){
            maps.put("mURL",fileName);
        }else {
            maps.put("mPicture",fileName);
        }
        try {
            mu.transferTo(dest);
            flag = "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            flag = "上传失败";
        } catch (IOException e) {
            e.printStackTrace();
            flag = "上传失败";
        }
    }
        maps.put("flag",flag);
        return maps;
    }
    public static String date(String issueDate){
        String[] str = issueDate.split("/");
        String issueDate1 = "";
        for (int i = str.length-1;i>=0;i--) {
            if(i == 0){
                issueDate1 += str[i];
            }else {
                issueDate1 += str[i] +"-";
            }
        }
        return issueDate1;
    }
}
